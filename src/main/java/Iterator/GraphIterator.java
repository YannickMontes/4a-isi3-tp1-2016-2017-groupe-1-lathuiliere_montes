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

    public GraphIterator(IGraph graph, Node sourceNode) {
        super();

        // Init attributes
        this.graph = graph;
        this.sourceNode = sourceNode;
        this.markedNodes = new ArrayList<Node>();
    }

    @Override
    public Node next() {
        Node next = deleteFromQueue();  // Take a node from the list

        List<Node> adjacentNodes = graph.getAdjNodes(next);

        adjacentNodes.stream()
                .filter(node -> !markedNodes.contains(node))
                .forEach(node -> {
                   markedNodes.add(node);
                   addToQueue(node);
                });
        
        return next;
    }

    public abstract void addToQueue(Node node);
    public abstract Node deleteFromQueue();
}
