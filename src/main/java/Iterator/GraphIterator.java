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
        Node next = delNode();  // Take a node from the list

        List<Node> adjNodes = graph.getAdjNodes(next);

        adjNodes.forEach(n -> {
            if (!markedNodes.contains(n)) {
                markedNodes.add(n);
                addNode(n);
            }
        });

        return next;
    }

    public abstract void addNode(Node n);

    public abstract Node delNode();
}