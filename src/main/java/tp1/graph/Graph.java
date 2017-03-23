package tp1.graph;

import tp1.graph.edge.Arc;
import tp1.graph.node.Node;
import tp1.iterator.DFSIterator;
import tp1.iterator.BFSIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph implements IDirectedGraph {

    /**
     * A chaque cle=noeud est associe la liste des arcs sortants de ce noeud
     */
    private Map<Node, List<Arc>> adjacence;

    public Graph() {

        adjacence = new HashMap<Node, List<Arc>>();

    }

    /**
     *
     * @param _n1
     * @param _n2
     * @return vrai si graph possede arc de src _n1 et destination _n2
     */
    public boolean hasArc(Node _n1, Node _n2) {
        List<Arc> arretesAdj = adjacence.get(_n1);
        
        for (Arc _a : arretesAdj) {
            if (_n1.equals(_a.getSource()) && _n2.equals(_a.getDestination())) {
                return true;
            }
        }
        return false;
    }

    public void addNode(Node _node) {
        adjacence.put(_node, new ArrayList<Arc>());

    }

    public void addArc(Arc _edge) {

        if (!hasArc(_edge.getSource(), _edge.getDestination())) {
            adjacence.get(_edge.getSource()).add(_edge);
        }

    }

    public Set<Node> getAllNodes() {
        return adjacence.keySet();
    }

    public int getNbNodes() {
        return this.getAllNodes().size();
    }

    /**
     *
     * @param _n
     * @return tous les arcs de source _n
     */
    public List<Arc> getArcs(Node _node) {

        return adjacence.get(_node);
    }

    /**
     * renvoie tous les noeuds qui sont destination d'un arc dont la source est
     * _n
     */
    public List<Node> getAdjNodes(Node _node) {
        List<Node> adj_nodes = new ArrayList();
        
        adjacence.get(_node)
                .stream()
                .forEach(arc -> {
                    adj_nodes.add(arc.getDestination());
                });

        return adj_nodes;
    }

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();

        stb.append("Graph \n");

        this.getAllNodes().stream()
                .forEach(node -> {
                    stb.append(String.format("[%s : [", node));
                    List<Arc> arcs = this.getArcs(node);
                    for (int i = 0; i < arcs.size(); i++) {
                        stb.append(arcs.get(i));
                        if (i < arcs.size() - 1) {
                            stb.append(" , ");
                        }
                    }
                    stb.append("]]\n");
                });

        return stb.toString();
    }

    @Override
    public Iterator<Node> creerDFSIterator(Node sourceNode) {
        return new DFSIterator(this, sourceNode);
    }

    @Override
    public Iterator<Node> creerBFSIterator(Node node) {
        return new BFSIterator(this, node);
    }

}
