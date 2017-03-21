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
public class BFSIterator extends GraphIterator {

    public BFSIterator(IGraph g, Node sn) {
        super(g, sn);
        
        this.waitingLine.add(sn);
    }

    @Override
    public void addNode(Node n) {
        
    }

    @Override
    public Node delNode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
