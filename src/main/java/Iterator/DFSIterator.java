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

    public DFSIterator(IGraph graph, Node sourceNode) {
        super(graph, sourceNode);

        this.stack = new Stack<Node>();
        this.stack.push(sourceNode);
    }

    @Override
    public void addToQueue(Node node) {
        this.stack.push(node);
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
