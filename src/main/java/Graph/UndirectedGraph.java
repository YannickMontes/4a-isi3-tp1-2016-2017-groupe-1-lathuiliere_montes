/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import Graph.Edge.Arc;
import Graph.Node.Node;
import Iterator.DFSIterator;
import Iterator.BFSIterator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author yoannlathuiliere
 */
public class UndirectedGraph implements IUndirectedGraph {

    private Graph graph;

    public UndirectedGraph(Graph g) {
        this.graph = g;
    }

    public UndirectedGraph() {
        this.graph = new Graph();
    }

    public void addEdge(Node _node1, Node _node2) {
        this.graph.addArc(new Arc(_node1, _node2, null));
        this.graph.addArc(new Arc(_node2, _node1, null));
    }

    public boolean hasEdge(Node _node1, Node _node2) {
        return this.graph.hasArc(_node1, _node2);
    }

    public void addNode(Node _node) {
        this.graph.addNode(_node);
    }

    public Set<Node> getAllNodes() {
        return this.graph.getAllNodes();
    }

    public int getNbNodes() {
        return this.graph.getNbNodes();
    }

    public List<Node> getAdjNodes(Node _n) {
        return this.graph.getAdjNodes(_n);
    }

    @Override
    public Iterator<Node> creerBFSIterator(Node sn) {
        return new BFSIterator(this, sn);
    }

    @Override
    public Iterator<Node> creerDFSIterator(Node sn) {
        return new DFSIterator(this, sn);
    }

}