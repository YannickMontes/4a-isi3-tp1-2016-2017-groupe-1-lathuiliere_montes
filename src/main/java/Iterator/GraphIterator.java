/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iterator;

import Graph.IGraph;
import Graph.Node.Node;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author yoannlathuiliere
 */
public abstract class GraphIterator implements Iterator<Node> {

    protected IGraph graph; // Graph reference to an intefarce (in order to support both Graph and UndirectedGraph)
    protected Node sourceNode; // Node where to start traitments
    protected List<Node> markedNodes;

    public GraphIterator(IGraph g, Node sn) {
        super();

        // Init attributes
        this.graph = g;
        this.sourceNode = sn;
        this.markedNodes = new ArrayList<Node>();
    }

    @Override
    public Node next() {
        Node next = deleteFromQueue();  // Take a node from the list

        List<Node> adjNodes = graph.getAdjNodes(next);

        adjNodes.stream()
                .filter(n -> !markedNodes.contains(n))
                .collect(Collectors.toList())
                .forEach(n -> {
                   markedNodes.add(n);
                   addToQueue(n);
                });
        
        /*adjNodes.forEach(n -> {
            if (!markedNodes.contains(n)) {
                markedNodes.add(n);
                addToQueue(n);
            }
        });*/

        return next;
    }

    public abstract void addToQueue(Node n);
    public abstract Node deleteFromQueue();
}
