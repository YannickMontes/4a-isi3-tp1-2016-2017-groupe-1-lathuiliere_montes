/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author yoannlathuiliere
 */
public abstract class GraphIterator implements Iterator<Node> {
    private IGraph graph; // Graph reference to an intefarce (in order to support both Graph and UndirectedGraph)
    private Node sourceNode; // Node where to start traitments
    private List<Node> waitingLine; 
    private List<Node> markedNodes;
    
    public GraphIterator(IGraph g, Node sn) {
        super();
        
        // Init attributes
        this.graph = g;
        this.sourceNode = sn;
        this.markedNodes = new ArrayList<Node>();
        this.waitingLine = new ArrayList<Node>();
    }
    
    @Override
    public boolean hasNext() {
        return false;
    }
    
    @Override
    public Node next() {
        return null;
    }
    
    @Override
    public void remove() {
        // Do nothing because remove treatment depends on used algorithm (BFS or DFS)
    }

    public abstract void addNode(Node n);
    public abstract void delNode();
}
