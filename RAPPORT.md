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
        stb.append(String.format("[%s : [", n));
        List<Arc> arcs = this.getArcs(n);
        for(int i=0; i<arcs.size(); i++)
        {
            stb.append(arcs.get(i));
            if(i<arcs.size()-1)
                stb.append(" , ");
        }
        stb.append("]]\n");
    }

    return stb.toString();
}
```

*Node.java:*
```java
public String toString() 
{
    StringBuilder stb = new StringBuilder();

    stb.append(String.format("Node=%s", this.label.toString()));

    return stb.toString();
}
```

*Arc.java:*
```java
public String toString() 
{
    StringBuilder stb = new StringBuilder(); 
    
    stb.append(String.format("%s ==> %s", source.getLabel().toString(), destination.getLabel().toString()));
    stb.append("(");
    stb.append(valuation);
    stb.append(")");
    
    return stb.toString();
}
```

## Question 2
*Expliquer le code ajouté et insérer un schéma du patron de conception mis en place*

Voici le schéma de notre implémentation concernant les graphes non orientés.
:-----------------------------------------:
![](/images/UnidrectedDirected.png?raw=true)

Etant donné qu'un graph non orienté possède beaucoup de fonction similaires à un graph normal, nous avons décidé de mettre un attribut graph au sein de la classe UndirectedGraph.
C'est une solution rapide et efficace, ne demandant aucun changement aux classes actuelles.

La classe UndirectGraph possède donc des fonctions qui découlent directement de la classe Graph. Un exemple est disponible ci-dessous:

```java
public Set<Node> getAllNodes() 
{
    return this.graph.getAllNodes();
}
```



## Question 3
*Expliquer le code ajouté et insérer un schéma du patron de conception mis en place*

#### Schéma
*PLACE HERE*

#### Classe GraphIterator
*Nous avons commencé par créer une classe abstraire GraphIterator, implémentant la classe Java "Iterator".*

- Propriétés
`````
protected IGraph graph; // Instance de type IGraph, pour ainsi être compatible avec les différentes types de graphes
protected Node sourceNode; // Noeud source, point de départ pour le traitement
protected List<Node> markedNodes; // liste de noeuds "visités", même principe pour BFS et DFS
`````

- Fonctions
`````
    //seul la fonction next() est commune aux classes filles, 
    
    @Override
    public Node next() {
        Node next = delNode(); // Prend le premier noeud de la liste

        List<Node> adjNodes = graph.getAdjNodes(next); // Prend tout les noeuds adjacents du noeud "next"

        // Pour tout les noeuds adjacents
        adjNodes.forEach(n -> {
            // Si ils ne sont pas marqués
            if (!markedNodes.contains(n)) {
                markedNodes.add(n); // on les ajoutes à la liste des noeuds marqués
                addNode(n); // on ajoute les noeuds à la pile ou la file (avec la méthode addNode qui est abstraite)
            }
        });

        return next;
    }

    public abstract void addNode(Node n); // fonction pour ajouter un noeud dans la structure de noeuds à traiter (pile ou file)
    public abstract Node delNode(); // fonction pour enlever un noeud dans la structure (pile ou file)
`````

#### Classe BFSIterator
*Ensuite, nous avons créé une classe fille BFSIterator, héritant de la classe "GraphIterator", spécifique au traitement du parcours en largeur.*

- Propriétés
````
    Queue<Node> waitingLine; // Utilisation d'une Queue pour gérer la file
`````

- Fonctions
`````
    public BFSIterator(IGraph g, Node sn) {
        super(g, sn);

        this.waitingLine = new LinkedList(); // Après une rapide recherche sur stack, LinkedList est cité comme la méthode la plus adapté pour une file FIFO

        this.waitingLine.add(sn); // Ajout dans la file du noeud source
        this.markedNodes.add(sn); // Ajout du noeud source dans la liste des noeuds marqués
    }

    @Override
    public void addNode(Node n) {
        this.waitingLine.add(n); // Insère un élément dans la file d'attente
    }

    @Override
    public Node delNode() {
        Node removed = this.waitingLine.remove(); // Supprime la tête de file
        return removed;
    }

    @Override
    public boolean hasNext() {
        return !this.waitingLine.isEmpty(); // Retourne true si il reste des elements dans la file. False sinon
    }
``````


## Question 4
*Expliquer le code ajouté et insérer un schéma du patron de conception mis en place*
