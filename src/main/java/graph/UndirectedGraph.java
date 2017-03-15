/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.List;
import java.util.Set;

/**
 *
 * @author yoannlathuiliere
 */
public class UndirectedGraph implements IUndirectedGraph
{
    private Graph graph;
    
    public UndirectedGraph(Graph g)
    {
        this.graph = g;
    }
    public void addEdge(Node _node1, Node _node2) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean hasEdge(Node _node1, Node _node2) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addNode(Node _node) 
    {
        this.graph.addNode(_node);
    }

    public Set<Node> getAllNodes() 
    {
        return this.graph.getAllNodes();
    }

    public int getNbNodes() 
    {
        return this.graph.getNbNodes();
    }

    public List<Node> getAdjNodes(Node _n) 
    {
        return this.graph.getAdjNodes(_n);
    }
    
}
