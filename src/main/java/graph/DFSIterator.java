/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author yoannlathuiliere
 */
public class DFSIterator extends GraphIterator {

    public DFSIterator(IGraph g, Node sn) {
        super(g, sn);
    }

    @Override
    public void addNode(Node n) {
        this.waitingLine.add(0, n);
    }

    @Override
    public Node delNode() {
        Node removed = this.waitingLine.remove(this.waitingLine.size()-1);
        return removed;
    }
    
}