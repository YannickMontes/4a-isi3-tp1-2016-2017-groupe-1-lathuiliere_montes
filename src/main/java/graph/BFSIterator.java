/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author yoannlathuiliere
 */
public class BFSIterator extends GraphIterator {

    Queue<Node> waitingLine;

    public BFSIterator(IGraph g, Node sn) {
        super(g, sn);

        this.waitingLine = new LinkedList();

        this.waitingLine.add(sn);
        this.markedNodes.add(sn);
    }

    @Override
    public void addNode(Node n) {
        this.waitingLine.add(n);
    }

    @Override
    public Node delNode() {
        Node removed = this.waitingLine.remove();
        return removed;
    }

    @Override
    public boolean hasNext() {
        return !this.waitingLine.isEmpty();
    }

}
