import java.util.*;
public class Graph{

	// Adjacency List Implementation of Graph
	// Note: Obviously, implementing nodes as integers
	// within a certain range is dumb. However, the concept
	// is still relevant and you could easily adjust this to 
	// take self-defined node objects rather than integers. 


	Map<Integer, ArrayList<Integer>> graph;
	int vertices = 0;
	Graph(int vertices){
		
		this.graph = new HashMap<Integer, ArrayList<Integer>>();
		this.vertices = vertices; 
		for(int i = 0; i < vertices; i++){
			ArrayList<Integer> neighbours = new ArrayList<Integer>();
			graph.put(i, neighbours);
		}
	}

	// Add a new vertex
	public void addVertex(){
		
		graph.put(this.vertices, new ArrayList<Integer>());
		this.vertices++; // Since zero-based indexing, we increment afterwards.

	}

	// Add an edge between two nodes. 
	public void addEdge(int v, int w){

		if(v > graph.size() || w > graph.size()){
			return; 
		}

		// Undirected Graph - Otherwise comment out second line. 
		graph.get(v).add(w);
		graph.get(w).add(v);;

	}

	public ArrayList<Integer> getNeighbours(int v){

		if(v > graph.size()){
			return null; 
		}

		return graph.get(v);
	}
 
	public static void main(String[] args){

		int count = 0, source, dest; 
		int numVertices = 5;

		Graph graph = new Graph(numVertices);
		graph.addEdge(1,2);
		graph.addEdge(1,4);
		graph.addEdge(2,3);

		System.out.println(graph.getNeighbours(2));
		System.out.println(graph.getNeighbours(1));

		graph.addVertex();
		graph.addEdge(2,5);

		System.out.println(graph.getNeighbours(2));


	}

	//  Graph: 
	// Data structure containing: 
	// A set of vertices V (e.g. nodes)
	// A set of Edges E, where an edge represents a connection between two vertices. 

	// Graph G = (V,E)
	// Edge is a pair (v,w) where v,w are in V

	//Ex.
	// V = {a,b,c,d}
	// E = {(a,c), (b,c), (b,d), (c,d)}

	// Degree: number of edges touching a given vertex
	// Ex. for vertex 'b', degree(b) = 2, degree(c) = 3, ...

	// Paths: 
	// Path: A path from vertex a to b is a sequence of edges that can be followed starting from a to reach b.
	// Can be represented as vertices visited, or edges taken.
	// Path Length: Number of vertices or edges contained in the path. 
	// Neighbor or Adjacent: Two vertices connected directly by an edge (e.g. a and c).

	// Reachability: Vertex a is reachable from b if a path exists from a to b. 
	
	// Connected: A graph is connected if every vertex is reachable from any other. 

	// Strongly Connected: A graph is strongly connected if every vertex has an edge to every other vertex

	// Cycle: A Path that begins and ends at the same vertex

	// Acyclic Graph: One that does not contain any cycles

	// Loop: An edge directly from a node to itself - many graphs disallow loops. 

	// Weighted Graphs: 
	// Costs are associated with given edge.
	// Edges in an unweighted graph can be thought of as having equal weight (e.g. all 0/1, etc.)
	// Most Graphs do not allow negative weights. 

	// Ex. Graph of airline flights, weighted by miles between cities.

	// Directed Graphs: One where edges are one-way connections between vertices. 
	// If graph is directed, a vertex has two different degrees: in-degree and out-degree
	// Can be weighted or unweighted.

	// A binary tree is a graph with some restrictions
	// - Tree is an unweighted, directed, acyclic graph
	// Each node's in-degree is at most 1, and out-degree is at most 2.
	// There is exactly one path from the root to every node. 
	
	// A linked list is also a graph
	// Unweighted DAG
	// In/out degree at most 1 for all nodes.

	// Searching:
	// Searching for a path from one vertex to another. 
	// Sometimes we want any path (or to at least know one exists)
	// Sometimes we want to minimize path length (# of edges)
	// Sometimes we want to minimize path cost (sum of edge weights)

	// Implementation: 
	// If we want to program an actual data structure to represent a graph, what information would we need to store?
	// For each vertex and for each edge?

	// What kind of questions do we want to be able to answer quickly? 
	// About a vertex, edges/neighbours, paths, etc?

	// Three common implementations: 
	// Edge List, Adjacency List, Adjacency Matrix

	// Edge List: An unordered list of all edges in the graph. 
	// an array, arraylist, or linked list

	// Advantages: easy to loop/iterate over

	// Disadvantages: hard to quickly tell if an edge exists from vertex A to B
	// hard to quickly find the degree of a vertex (how many edges touch it)

	// Using an edge list, how would you find: 
	// 1. All neighbors of a given vertex?
	// Ans: Loop through list, count number of times vertex x appears in array (e.g. (x,y) means y is a neighbour to x)
	// 2. Degree of given vertex? 
	// Ans: Same as previous - the degree of a vertex is how many neighbours it has (for undirected graphs)
	// 3. Whether there is an edge from A to B
	// Ans: Loop through graph, if pair (A,B) is found, there is an edge between those two vertices.
	// 4. Whether there are any loops (self-edges)
	// Ans: Loop through graph, if pair (A,A) is found, there is a loop at that vertex A.
	// All these operations are O(n) for an unsorted Edge List. 

	// Adjacency Matrix:
	// An NxN Matrix where
	// - non-diagonal entry a[i,j] (e.g. i != j) is the number of edges joining vertex i and vertex j (or the weight of the e dge joining vertex i and j)
	// - diagonal entry a[i,i] corresponds to the number of loops (self-connecting edges) at vertex i (often disallowed)
	// - in an undirected graph, a[i,j] = a[j,i] for all i,j (diagonally symmetric) 

	// Using an adjacency matrix, how would you find:
	// 1. all neighbors of a given vertex?
	// Ans: Sum arr[A][i] for i..N
	// 2. the degree of a given vertex?
	// Ans: Same as above
	// 3. whether there is an edge from A to B?
	// Ans: return arr[A][B] > 0 (Edge exists if this is true)
	// 4. whether there are any loops (self-edges)?
	// Ans: return arr[A][A] > 0 (Self-edge exists if this is true)

	// Advanatges: Fast to tell whether an edge exists between any two vertices i and j (and to get its weight) -> O(1)
	// Disadvantages: Consumes a lot of memory on spare graphs (ones with few edges)

	// Adjacency List: List of all vertices that are adjacent (neighbors) to eachother.
	// If graph is not dense (e.g. it's sparse), a better solution is an adjacency list.
	// Because most entries in adjacency matrix will be zero. This is bad; we want out data structures to represent that data that's there and not data that isn't present. 

	// In an adjacency list, for each vertex, we keep a list of all adjacent vertices. Space requirement is O(|E| + |V|), which is linear in the size of the graph. (Adj. Matrix is O(|V|^2))

	// Note: When we speak of linear-time graph algorithms, O(|E| + |V|) is the running time we require. 

	//  Adjacency lists are the standard way to represent graphs
	// In undirected graphs, each edge (u,v) appears in two lists, so the space usage essentially doubles. (since (u,v) and (v,u) will both appear)

	// A common requirement in graph algorithms is to find all vertices adjacent to some vertex v, and this can be done, in the time proportional to the number of such vertices found,
	// by a simple scan down the appropriate adjacency list. 

	// Which data structure?
	// Because it is important to be able to quickly obtain the list of adjacent vertices for any vertex, we can use a hash map in which keys are vertices and values are adjacency lists. 

	// Adjacency List: Stores edges as individual linked lists of references to each vertex's neighbors
	// In unweighted graphs, the lists can simply be references to other vertices and thus use little memory. 
	// in undirected graphs, edge(i,j) is stored in both i's and j's lists. 

	// Using an adjacency list, how would you find:
	// 1. all neighbors of a given vertex?
	// Ans: HashMap(A) -> linked list of A's neighbors
	// 2. the degree of a given vertex?
	// Ans: HashMap(A) -> linked list of A's neighbors -> Length of linked list is degree
	// 3. whether there is an edge from A to B?
	// Ans: HashMap(A) -> linked list of A's neighbors -> Check if B is in linked list
	// 4. whether there are any loops (self-edges)?
	// Ans: HashMap(A) -> linked list of A's neighbors -> Check if A is in linked list

	// Advantages: 
	// new vertices can be added to the graph easily, and they can be connected with existing nodes simply by adding elements to the appropriate linked lists. 
	// easy to find all neighbours of a given vertex and its degree.

	// Disadvantages: 
	// Determining whether an edge exists between two vertices requires O(N) time, where N is the average number of edges per node (degree(V))

	// Graph Traversals: 
	// Generally Two Types: Breadth First (BFS) and Depth-First (DFS)

	// BFS behaves like level-order traversal
	// DFS behaves like preorder traversal

	// One difference is that there is no root node present in a graph, thus our traversal may start at any index. 

	// Key Concept: Main difference between DFS and BFS is use of a stack instead of a queue to manage traversal. 

	// DFS: Starting at some vertex v, we process v and the recursively traverse all vertices adjacent to v.
	// A DFS starting at vertex v first visits v, then some neighbor w of v, then some neighbor x of w that has not been visited before.
	// When it gets stuck, DFS backtracks until it finds the first vertex that still has a neighbor which hasn't been visited. 
	// It continues with this neighbor until it has to backtrack again. Eventually, it will visit all vertices reachable from v. 

	/*	
		DFS(G)
			Initialize boolean array visited by setting all entries to False
			Initialize Stack S
			for all v in V
				if not visited[v]
					dfsFromVertex(G, v)

		dfsFromVertex(G, v)
			S.push(v)
			while not s.isEmpty()
				v = S.pop()
				if not visited[v] then
					visited[v] = true
					for all w adjacent to v
						S.push(w) 

	*/

	// BFS: 
	// Starting at a vertex v, first visits v, then it visits all neighbors of v (i.e. vertices w such that there is an edge from v to w)
	// Then all neighbors of the neighbors that have not been visited before
	// Then all neighbors of the neighbors of the neighbors which have not been visited. 

	// During BFS, we have to store vertices that have been discovered so far and also the vertices that have been visited completely (all their neighbors have been visited)
	// We maintain a boolean array visited with one entry for each vertex, which is set to TRUE when the vertex is visited. 
	// The vertices that have been rediscovered, but have not been completely visited, are stored in a QUEUE
	// This guarantees that vertices are visited in the right order - vertices that are discovered first will be processed first. 

	/*
		BFS(G)
			Initialize boolean array visited by setting all entries to false
			Initialize Queue q
			for all v in V
				if visited[v] = false
					bfsFromVertex(G, v)
	

		bfsFromVertex(G, v)
			visited[v] = true
			Q.enqueue(v)
			while not Q.isEmpty()
				v = Q.dequeue()
				for all w adjacent to v
					if visited[w] = False
						visited[w] = true
						Q.enqueue(w)


	*/ 

	// Directed Graph: 
	// DFS for a graph is similar to Depth First Traversal of a tree. The only catch here is that unluke trees, graphs may contain cycles, so we may come 
	// to the same node again. To aovid processing a node more than once, we use a boolean visited array.

	// Graph Traversals: 
	// For each vertex, the data member visited is initialized to false. By recursively calling the procedures only on nodes that have not been visited, we guarantee 
	// we do not loop infinitely. 

	// If  graph is undirected and not connected, or directed and not strongly connected, this strategy might fail to visit some nodes. 
	// We then search for an unmarked node, apply DFS there, and continue this process until there are no unmarked nodes. 

	// If there are vertices that remain unvisited, that is, if there are vertices that are not reachable from v, then the only way they can be listed is if the search
	// chooses a new unvisited vertex v0 and visit all vertices reachable from v0. 
	// This process would have to be repeated until all vertices are visited.

	// A connected component of an undirected graph is a subgraph in which every two vertices are connected to 
	// each other by a path(s), and which is connected to no other vertices outside the subgraph. For example, the 
	// graph shown below has three connected components.

	// A graph where all vertices are connected with eachother has exactly one connected component, consisting of the whole graph;
	// such graph with only one connected component is called a strongly connected graph. 

	// DFS Observations: 
	// Discovery: DFS is guaranteed to find a path if one exists. 
	// Retrieval: It is easy to retrieve exactly what the path is (sequence of edges taken) if we find it. 
	// Optimality: Not optimal; DFS is guaranteed to find a path, not necessarily the best/shortest path. 

	// BFS Observations
 	// Optimaltiy: Always finds shortest path (fewewest edges)
	// In weighted graphs, not always optimal cost.

	// Retrieval: Harder to reconstruct actual sequence of vertices or edges in the path once you find it.
	// Conceptually: BFS is exploring many possible paths in parallel, so it's not easy to store a path array/list in progress

	// DFS uses less memory than BFS, easier to reconstruct path once found, but does not always find shortest path. BFS does. 

	// Both have a run time of O(|V| + |E|) (essentially O(N))
	// Must potentially visit every node and/or examine every edge once. 

	// DFS/BFS and Weight
	// The minimum-weight path is not necessarily the shortest path
	// DFS and BFS do not consider edge weight
	// Sometimes, weight is more important e.g. plane flight costs

	// Shortest Path Variants
	// Which Vertices? 
	// - Single Source: From one vertex s to every other vertex
	// - Single Sink: From every vertex to one vertex t
	// - Source-SInk: Fron one vertex s to another t
	// - All Pairs: Between all pairs of vertices

	// Restrictions on edge weights?
	// - Non-negative weights
	// Euclidean Weights
	// Arbitrary weights

	// Cycles?
	// No directed cycles
	// no "negative cycles" (net negative meaning cost is effectively negative infinity and we loop forever)

	// Single Source
	// Given a weighted graph and node v, find the minimum-cost path from v to every node
	// Assume no negative weights
	// Problem is ill-defined if there are negative cost cycles
	// Djikstra's algorithm is wrong if edges can be negative. 
	// There are other slower (but not terrible) algorithms for negative weight case

	// Djikstra's Algorithm: Finds the minimum-weight path starting from a vertex to all other vertices in a weighted directed graph. 
	// Basic Concept: Find currently known best way to reach each vertex (cost, previous vertex), and improve on it until it reaches best solution. 

	// Ex. 
	// In a graph where vertices are cities and weighted edges are roads between cities 
	// Dijkstra's algorithm can be used to find the shortest route from one city to any other.

	// Initially, start node has cost 0 and all other nodes have cost infinity
	// Find the vertices which have a direct path for start node,and update their distances. 
	
	// At each step:
	// 1. Pick closesnt unknown vertex to v
	// 2. Add it to the "cloud" of known vertices
	// 3. Update distances for nodes

	// The Algorithm
	// 1. For each node v, set v.cost = inf and v.known = false
	// 2. Set source.cost = 0
	// 3. while there are unknown nodes in the graph: 
	// - Select the unknown node v with lowest cost
	// - Mark v as known
	// - For each edge (v,u) with weight w: 
	// c1 = v.cost + w // cost of best path from v to u
	// c2 = u.cost  // cost of best path to u previously known 
	// if (c1 < c2) // if the new path is a lower cost, we update the best path cost
	// u.cost = c1
	// u.path = v

	/*
		function djikstra(v1, v2)
			for each vertex v: 
				v.cost = inf
				v.previous = none
			v1.cost = 0
			pqueue = {all vertices ordered by distance}

			while pqueue is not empty:
				v = remove vertex from pqueue with minimum cost
				mark v as visited

				for each unvisited neighbor n of v: 
					cost = v.cost + weight of edge(v,n)

					if cost < n.cost: 
						n.cost = cost
						n.previous = v

			reconstruct path from v2 back to v1, following previous pointers. 
	*/

	// Dijkstra's algorithm is a greedy algorithm: 
	// Makes locally optimal choices that currently seem the best. 
	// Locally optimal does not always mean globally optimal. 

	// It is correct, because it maintains the following two properties: 
	// 1. For every marked vertex, the current recorded cost is the lowest cost to that vertex from the source node. 
	// 2. For every unmarked vertex v, its recorded distance is shortest path distance to v from source vertex (considering only currently known vertices and v)

	
}