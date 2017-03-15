package graph;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;




public class Graph implements IDirectedGraph {

	/**
	 * A chaque cle=noeud est associe la liste des arcs sortants de ce noeud
	 */
	private Map<Node,List<Arc>> adjacence; 
	
	public Graph(){
		
		adjacence = new HashMap<Node,List<Arc>>();
		
		
	
	}
	/**
	 * 
	 * @param _n1
	 * @param _n2
	 * @return vrai si graph possede arc de src _n1 et destination _n2
	 */
	public boolean hasArc(Node _n1, Node _n2){
		List<Arc> arretesAdj = adjacence.get(_n1);
		for (Arc _a : arretesAdj){
			if (_n1.equals(_a.getSource()) && _n2.equals(_a.getDestination()))
				return true;
		}
		return false;
	}
	
	public void addNode(Node _node)
        {
		adjacence.put(_node, new ArrayList<Arc>());

	}
	
	public void addArc(Arc _edge)
        {
	
		if (!hasArc(_edge.getSource(),_edge.getDestination()))
			adjacence.get(_edge.getSource()).add(_edge);
	
	}
	
	public Set<Node> getAllNodes()
        {
		return adjacence.keySet();
	}
	
	public int getNbNodes()
        {	
		return this.getAllNodes().size();
	}
	
	/**
	 * 
	 * @param _n
	 * @return tous les arcs de source _n
	 */
	public List<Arc> getArcs(Node _n)
        {
		
		return adjacence.get(_n);
	}
	/**
	 * renvoie tous les noeuds qui sont destination d'un arc dont la source est _n
	 */
	public List<Node> getAdjNodes(Node _n)
        {
            /*return getArcs(_n)
                    .stream()
                    .map()
                    .collect(Collectors.toList());*/
            List<Node> adj_nodes = new ArrayList();
            
            for(Arc arc : adjacence.get(_n))
            {
                adj_nodes.add(arc.getDestination());
            }
            
            return adj_nodes;
	}
	
	

	@Override
	public String toString() 
        {
            StringBuilder stb = new StringBuilder();
            
            stb.append("Graph \n");

            for(Node n : this.getAllNodes())
            {
                stb.append("[");
                stb.append(n.toString());
                
                stb.append(this.getArcs(n).toString());
                
                stb.append("]\n");
            }

            return stb.toString();
	}


	
}
