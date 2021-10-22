import java.util.*; 

// Adjacency List Implementation of Graph

@SuppressWarnings("Unchecked")
public class Graphs{ 

	int numVertices; 
	java.util.LinkedList<Edge>[] adj; // Array of LinkedLists

	Graphs(int n){
		this.numVertices = n; 

		adj = new java.util.LinkedList[this.numVertices];

		// Initialize Adjacency List for all vertices
		for(int i = 0; i < this.numVertices; i++){
			adj[i] = new java.util.LinkedList<>();
		}
	}

	public void addEdge(Vertex v, Vertex w, int weight){
		Edge edge = new Edge(v, w, weight);
		adj[v.data].push(edge); // addFirst

	}

	public List<Integer> bfs(int r){
		Queue<Integer> q = new java.util.LinkedList<Integer>();
		boolean[] visited = new boolean[this.numVertices];
		List<Integer> res = new ArrayList<Integer>();

		int temp; 

		q.add(r);
		visited[r] = true; 

		while(!q.isEmpty()){
			temp = q.remove();
			res.add(temp);

			for(Edge e : this.adj[temp]){
				if(!visited[e.dest.data]){
					visited[e.dest.data] = true; 
					q.add(e.dest.data);
				}
			}
		}

		return res; 
	}

	public List<Integer> dfs(int r){
		Stack<Integer> st = new Stack<Integer>();
		boolean[] visited = new boolean[this.numVertices];
		List<Integer> res = new ArrayList<Integer>();

		for(int i =0; i < this.numVertices; i++){
			if(!visited[i]){
				dfsFromVertex(i, visited, res, st);
			}
		}

		return res; 
	}

	public void dfsFromVertex(int r, boolean[] visited, List<Integer> res, Stack<Integer> st){
		st.push(r);

		int temp; 

		while(!st.empty()){
			temp = st.pop();

			if(!visited[temp]){
				visited[temp] = true; 
				res.add(temp);

				for(Edge e: this.adj[temp]){
					if(!visited[e.dest.data]){
						st.push(e.dest.data);
					}
				}
			}
		}
	}

	public int[] dijkstra(int r){
		boolean[] visited = new boolean[this.numVertices];
		int[] distances = initializeSingleSource(r);
		List<int[]> prev = new ArrayList<int[]>();
		PriorityQueue<int[]> pq = new PriorityQueue(2, (a, b) -> ((int[])a)[1] - ((int[])b)[1]);
		Set<Integer> check = new HashSet<Integer>(); 


		for(int i = 0; i < this.numVertices; i++){
			int[] arr = {i, distances[i]};
			pq.add(arr);
		}

		while(!pq.isEmpty()){
			int[] u = pq.poll();
			check.add(u[0]);

			for(Edge e: this.adj[u[0]]){
				relax(e.source.data, e.dest.data, e.weight,distances, pq, check, prev);
			}
		}

		System.out.println("Previous Pointers: "); 
		for(int[] i: prev){
			System.out.print("{ " + i[0] + ": " + i[1] + "}");
		}
		System.out.println();
		return distances; 
	}

	public int[] initializeSingleSource(int r){
		int[] distances = new int[this.numVertices];

		for(int i = 0; i < this.numVertices; i++){
			distances[i] = Integer.MAX_VALUE; 
		}
		distances[r] = 0; 
		return distances; 
	}

	public void relax(int u, int v, int weight, int[] distances, PriorityQueue<int[]> pq, Set<Integer> check, List<int[]> prev){
		if(distances[v] > distances[u] + weight){
			distances[v] = distances[u] + weight; 
			int[] arr = {u, v};
			prev.add(arr);
		}

		pq.clear();

		for(int i = 0; i < this.numVertices; i++){
			
			if(!check.contains(i)){
				int[] arr = {i, distances[i]};
				pq.add(arr);
			}
		}


	}

	public static void main(String[] args){
		int vertices = 6;
		Graphs graph = new Graphs(vertices);
		
		Vertex v0 = new Vertex(0);
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);

		graph.addEdge(v0, v1, 4);
		graph.addEdge(v0, v2, 3);
		graph.addEdge(v1, v3, 2);
		graph.addEdge(v1, v2, 5);
		graph.addEdge(v2, v3, 7);
		graph.addEdge(v3, v4, 2);
		graph.addEdge(v4, v0, 4);
		graph.addEdge(v4, v1, 4);
		graph.addEdge(v4, v5, 6);

		for(int i: graph.bfs(v0.data)){
			System.out.print(i + ", ");
		}
		System.out.println();

		for(int i: graph.dfs(v0.data)){
			System.out.print(i + ", ");
		}
		System.out.println();

		int[] dijk = graph.dijkstra(0);

		for(int i = 0; i < dijk.length; i++){
			System.out.print("{ " + i + ": " + dijk[i] + "}");
		}
		System.out.println();

	}
}