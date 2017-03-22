/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iterator;

import Graph.IGraph;
import Graph.Node.Node;
import java.util.Stack;

/**
 *
 * @author yoannlathuiliere
 */
public class DFSIterator extends GraphIterator {

    Stack<Node> stack;

    public DFSIterator(IGraph g, Node sn) {
        super(g, sn);

        this.stack = new Stack<Node>();
        this.stack.push(sn);
    }

    @Override
    public void addToQueue(Node n) {
        this.stack.push(n);
    }

    @Override
    public Node deleteFromQueue() {
        Node removed = this.stack.pop();
        return removed;
    }

    @Override
    public boolean hasNext() {
        return !this.stack.isEmpty();
    }

}
