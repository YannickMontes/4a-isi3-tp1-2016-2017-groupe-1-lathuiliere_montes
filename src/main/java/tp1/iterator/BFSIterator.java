/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.iterator;

import tp1.graph.IGraph;
import tp1.graph.node.Node;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author yoannlathuiliere
 */
public class BFSIterator extends GraphIterator {

    Queue<Node> waitingLine;

    public BFSIterator(IGraph graph, Node sourceNode) {
        super(graph, sourceNode);

        this.waitingLine = new LinkedList();

        this.waitingLine.add(sourceNode);
        this.markedNodes.add(sourceNode);
    }

    @Override
    public void addToQueue(Node node) {
        this.waitingLine.add(node);
    }

    @Override
    public Node deleteFromQueue() {
        Node removed = this.waitingLine.remove();
        return removed;
    }

    @Override
    public boolean hasNext() {
        return !this.waitingLine.isEmpty();
    }

}
