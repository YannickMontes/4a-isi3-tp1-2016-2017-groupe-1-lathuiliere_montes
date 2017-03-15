**Nom/Prénom Etudiant 1 : LATHUILIERE Yoann**

**Nom/Prénom Etudiant 2 : MONTES Yannick**

# Rapport TP1

## Question 1

**Fonction getAdjNodes(Node n) dans Graph.java:**

On récupère dans la liste d'adjacence tous les arcs du noeud concerné. On boucle sur ceux-ci en ajoutant tout les noeuds destination de chaque arc à une liste, que l'on retourne a la fin.

```java
public List<Node> getAdjNodes(Node _n)
{
	List<Node> adj_nodes = new ArrayList();

	for(Arc arc : adjacence.get(_n))
	{
    	adj_nodes.add(arc.getDestination());
	}
 
	return adj_nodes;
}
```

**Fonction getNbNodes() dans Graph.java:**

Rien de bien sorcier, on utilise la fonction getAllNodes(), en comptant le nombre d'éléments de la liste retournée.

```java
public int getNbNodes()
{	
	return this.getAllNodes().size();
}
```

**Fonction toString() dans Graph.java:**

Ici, on se sert des fonctions de toutes les classes. A la fois dans Node, puis dans Arc.
On parcourt les nodes d'un graph en appellant tout string. Pour chaque Node, on récupère tout ses arcs, puis on apelle toString pour chaque Arc.

*Graph.java:*
```java
public String toString() 
{
    StringBuilder stb = new StringBuilder();
    
    stb.append("Graph \n");
    
    for(Node n : this.getAllNodes())
    {
        stb.append(String.format("[%s %s]\n", n.toString(), this.getArcs(n).toString()));
    }
    
    return stb.toString();
}
```

*Node.java:*
```java
public String toString() 
{
    StringBuilder stb = new StringBuilder();
    
    stb.append(String.format("Node=%d : ", this.label));
    
    return stb.toString();
}
```

*Arc.java:*
```java
public String toString() 
{
    StringBuilder stb = new StringBuilder(); 
    
    stb.append(String.format("[%s ==> %s (%s)]", source.getLabel().toString(), destination.getLabel().toString(), valuation.toString()));
    
    return stb.toString();
}
```

## Question 2
*Expliquer le code ajouté et insérer un schéma du patron de conception mis en place*

## Question 3
*Expliquer le code ajouté et insérer un schéma du patron de conception mis en place*

## Question 4
*Expliquer le code ajouté et insérer un schéma du patron de conception mis en place*
