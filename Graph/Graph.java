import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;

public class Graph {
	int count;
	private LinkedList<LinkedList<Edge>> Adj;
	int INF = 9999;

	private static class Edge implements Comparable<Edge> {
		int src, dest, cost;

		public Edge(int s, int d, int c) {
			src = s;
			dest = d;
			cost = c;
		}

		public int compareTo(Edge compareEdge) {
			return this.cost - compareEdge.cost;
		}
	}

	public Graph(int cnt) {
		count = cnt;
		Adj = new LinkedList<LinkedList<Edge>>();
		for (int i = 0; i < cnt; i++) {
			Adj.add(new LinkedList<Edge>());
		}
	}

	private void addDirectedEdge(int source, int dest, int cost) {
		Edge edge = new Edge(source, dest, cost);
		Adj.get(source).add(edge);
	}

	public void addDirectedEdge(int source, int dest) {
		addDirectedEdge(source, dest, 1);
	}

	public void addUndirectedEdge(int source, int dest, int cost) {
		addDirectedEdge(source, dest, cost);
		addDirectedEdge(dest, source, cost);
	}

	public void addUndirectedEdge(int source, int dest) {
		addUndirectedEdge(source, dest, 1);
	}

	public void print() {
		for (int i = 0; i < count; i++) {
			LinkedList<Edge> ad = Adj.get(i);
			System.out.print("Vertex " + i + " is connected to : ");
			for (Edge adn : ad) {
				System.out.print(adn.dest + "(cost: " + adn.cost + ") ");
			}
			System.out.println();
		}
	}

	public boolean dfsStack(int source, int target) {
		boolean[] visited = new boolean[count];
		Stack<Integer> stk = new Stack<Integer>();
		stk.push(source);
		visited[source] = true;

		while (stk.isEmpty() == false) {
			int curr = stk.pop();
			LinkedList<Edge> adl = Adj.get(curr);
			for (Edge adn : adl) {
				if (visited[adn.dest] == false) {
					visited[adn.dest] = true;
					stk.push(adn.dest);
				}
			}
		}
		return visited[target];
	}

	public boolean dfs(int source, int target) {
		boolean[] visited = new boolean[count];
		dfsUtil(source, visited);
		return visited[target];
	}

	public void dfsUtil(int index, boolean[] visited) {
		visited[index] = true;
		LinkedList<Edge> adl = Adj.get(index);
		for (Edge adn : adl) {
			if (visited[adn.dest] == false)
				dfsUtil(adn.dest, visited);
		}
	}

	public void dfsUtil2(int index, boolean[] visited, Stack<Integer> stk) {
		visited[index] = true;
		LinkedList<Edge> adl = Adj.get(index);
		for (Edge adn : adl) {
			if (visited[adn.dest] == false)
				dfsUtil2(adn.dest, visited, stk);
		}
		stk.push(index);
	}

	public boolean bfs(int source, int target) {
		boolean[] visited = new boolean[count];
		LinkedList<Integer> que = new LinkedList<Integer>();
		que.add(source);
		visited[source] = true;

		while (que.isEmpty() == false) {
			int curr = que.remove();
			LinkedList<Edge> adl = Adj.get(curr);
			for (Edge adn : adl) {
				if (visited[adn.dest] == false) {
					visited[adn.dest] = true;
					que.add(adn.dest);
				}
			}
		}
		return visited[target];
	}

	public static void main0() {
		Graph gph = new Graph(4);
		gph.addUndirectedEdge(0, 1);
		gph.addUndirectedEdge(0, 2);
		gph.addUndirectedEdge(1, 2);
		gph.addUndirectedEdge(2, 3);
		gph.print();
	}

	// Testing Code
	public static void main1() {
		Graph gph = new Graph(8);
		gph.addUndirectedEdge(0, 3);
		gph.addUndirectedEdge(0, 2);
		gph.addUndirectedEdge(0, 1);
		gph.addUndirectedEdge(1, 4);
		gph.addUndirectedEdge(2, 5);
		gph.addUndirectedEdge(3, 6);
		gph.addUndirectedEdge(6, 7);
		gph.addUndirectedEdge(5, 7);
		gph.addUndirectedEdge(4, 7);

		System.out.println("Path between 0 & 6 : " + gph.dfs(0, 6));
		System.out.println("Path between 0 & 6 : " + gph.bfs(0, 6));
		System.out.println("Path between 0 & 6 : " + gph.dfsStack(0, 6));
	}

	/*
	Path between 0 & 6 : true
	Path between 0 & 6 : true
	Path between 0 & 6 : true
	*/

	public void topologicalSort() {
		Stack<Integer> stk = new Stack<Integer>();
		boolean[] visited = new boolean[count];

		for (int i = 0; i < count; i++) {
			if (visited[i] == false) {
				dfsUtil2(i, visited, stk);
			}
		}
		System.out.print("Topological Sort::");
		while (stk.isEmpty() != true) {
			System.out.print(" " + stk.pop());
		}
	}

	// Testing Code
	public static void main2() {
		Graph gph = new Graph(9);
		gph.addDirectedEdge(0, 2);
		gph.addDirectedEdge(1, 2);
		gph.addDirectedEdge(1, 3);
		gph.addDirectedEdge(1, 4);
		gph.addDirectedEdge(3, 2);
		gph.addDirectedEdge(3, 5);
		gph.addDirectedEdge(4, 5);
		gph.addDirectedEdge(4, 6);
		gph.addDirectedEdge(5, 7);
		gph.addDirectedEdge(6, 7);
		gph.addDirectedEdge(7, 8);
		gph.topologicalSort();
	}

	/*
	Topological Sort:: 1 4 6 3 5 7 8 0 2
		*/

	public boolean pathExist(int source, int dest) {
		boolean[] visited = new boolean[count];
		dfsUtil(source, visited);
		return visited[dest];
	}

	public int countAllPathDFS(boolean[] visited, int source, int dest) {
		if (source == dest) {
			return 1;
		}
		int count = 0;
		visited[source] = true;
		LinkedList<Edge> adl = Adj.get(source);
		for (Edge adn : adl) {
			if (visited[adn.dest] == false) {
				count += countAllPathDFS(visited, adn.dest, dest);
			}
		}
		visited[source] = false;
		return count;
	}

	public int countAllPath(int src, int dest) {
		boolean[] visited = new boolean[count];
		return countAllPathDFS(visited, src, dest);
	}

	public void printAllPathDFS(boolean[] visited, int source, int dest, Stack<Integer> path) {
		path.push(source);
		if (source == dest) {
			System.out.println(path);
			path.pop();
			return;
		}
		visited[source] = true;
		LinkedList<Edge> adl = Adj.get(source);
		for (Edge adn : adl) {
			if (visited[adn.dest] == false)
				printAllPathDFS(visited, adn.dest, dest, path);
		}
		visited[source] = false;
		path.pop();
	}

	public void printAllPath(int src, int dest) {
		boolean[] visited = new boolean[count];
		Stack<Integer> path = new Stack<Integer>();
		printAllPathDFS(visited, src, dest, path);
	}

	// Testing Code
	public static void main3() {
		Graph gph = new Graph(5);
		gph.addDirectedEdge(0, 1);
		gph.addDirectedEdge(0, 2);
		gph.addDirectedEdge(2, 3);
		gph.addDirectedEdge(1, 3);
		gph.addDirectedEdge(3, 4);
		gph.addDirectedEdge(1, 4);
		gph.print();
		System.out.println("PathExist :: " + gph.pathExist(0, 4));
		System.out.println("Path Count :: " + gph.countAllPath(0, 4));
		gph.printAllPath(0, 4);
	}

	/*
	Vertex 0 is connected to : 1(cost: 1) 2(cost: 1) 
	Vertex 1 is connected to : 3(cost: 1) 4(cost: 1) 
	Vertex 2 is connected to : 3(cost: 1) 
	Vertex 3 is connected to : 4(cost: 1) 
	Vertex 4 is connected to : 
	
	PathExist :: true
	
	Path Count :: 3
	
	[0, 1, 3, 4]
	[0, 1, 4]
	[0, 2, 3, 4]
		*/

	public int rootVertex() {
		boolean[] visited = new boolean[count];
		int retVal = -1;
		for (int i = 0; i < count; i++) {
			if (visited[i] == false) {
				dfsUtil(i, visited);
				retVal = i;
			}
		}
		System.out.print("Root vertex is :: " + retVal);
		return retVal;
	}

	// Testing Code
	public static void main4() {
		Graph gph = new Graph(7);
		gph.addDirectedEdge(0, 1);
		gph.addDirectedEdge(0, 2);
		gph.addDirectedEdge(1, 3);
		gph.addDirectedEdge(4, 1);
		gph.addDirectedEdge(6, 4);
		gph.addDirectedEdge(5, 6);
		gph.addDirectedEdge(5, 2);
		gph.addDirectedEdge(6, 0);
		gph.rootVertex();
	}

	/*
	
	Root vertex is :: 5
		*/

	public void transitiveClosureUtil(int source, int dest, int[][] tc) {
		tc[source][dest] = 1;
		LinkedList<Edge> adl = Adj.get(dest);
		for (Edge adn : adl) {
			if (tc[source][adn.dest] == 0)
				transitiveClosureUtil(source, adn.dest, tc);
		}
	}

	public int[][] transitiveClosure() {
		int tc[][] = new int[count][count];
		for (int i = 0; i < count; i++) {
			transitiveClosureUtil(i, i, tc);
		}
		return tc;
	}

	// Testing Code
	public static void main5() {
		Graph gph = new Graph(4);
		gph.addDirectedEdge(0, 1);
		gph.addDirectedEdge(0, 2);
		gph.addDirectedEdge(1, 2);
		gph.addDirectedEdge(2, 0);
		gph.addDirectedEdge(2, 3);
		gph.addDirectedEdge(3, 3);
		int[][] tc = gph.transitiveClosure();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(tc[i][j] + " ");
			}
			System.out.println();
		}
	}

	/*
	1 1 1 1 
	1 1 1 1 
	1 1 1 1 
	0 0 0 1 
		*/

	public void bfsLevelNode(int source) {
		boolean[] visited = new boolean[count];
		int[] level = new int[count];
		visited[source] = true;
		LinkedList<Integer> que = new LinkedList<Integer>();
		que.add(source);
		level[source] = 0;
		System.out.println("Node  - Level");

		while (que.isEmpty() == false) {
			int curr = que.remove();
			int depth = level[curr];
			LinkedList<Edge> adl = Adj.get(curr);
			System.out.println(curr + " - " + depth);
			for (Edge adn : adl) {
				if (visited[adn.dest] == false) {
					visited[adn.dest] = true;
					que.add(adn.dest);
					level[adn.dest] = depth + 1;
				}
			}
		}
	}

	public int bfsDistance(int source, int dest) {
		boolean[] visited = new boolean[count];
		LinkedList<Integer> que = new LinkedList<Integer>();
		que.add(source);
		visited[source] = true;
		int[] level = new int[count];
		level[source] = 0;

		while (que.isEmpty() == false) {
			int curr = que.remove();
			int depth = level[curr];
			LinkedList<Edge> adl = Adj.get(curr);
			for (Edge adn : adl) {
				if (adn.dest == dest) {
					return depth + 1;
				}
				if (visited[adn.dest] == false) {
					visited[adn.dest] = true;
					que.add(adn.dest);
					level[adn.dest] = depth + 1;
				}
			}
		}
		return -1;
	}

	// Testing Code
	public static void main6() {
		Graph gph = new Graph(7);
		gph.addUndirectedEdge(0, 1);
		gph.addUndirectedEdge(0, 2);
		gph.addUndirectedEdge(0, 4);
		gph.addUndirectedEdge(1, 2);
		gph.addUndirectedEdge(2, 5);
		gph.addUndirectedEdge(3, 4);
		gph.addUndirectedEdge(4, 5);
		gph.addUndirectedEdge(4, 6);
		gph.bfsLevelNode(1);
		System.out.println("BfsDistance(1, 6) : " + gph.bfsDistance(1, 6));
	}
	/*
	
	Node  - Level
	1 - 0
	0 - 1
	2 - 1
	4 - 2
	5 - 2
	3 - 3
	6 - 3
	
	BfsDistance :: 3
		*/

	public boolean isCyclePresentUndirectedDFS(int index, int parentIndex, boolean[] visited) {
		visited[index] = true;
		int dest;
		LinkedList<Edge> adl = Adj.get(index);
		for (Edge adn : adl) {
			dest = adn.dest;
			if (visited[dest] == false) {
				if (isCyclePresentUndirectedDFS(dest, index, visited))
					return true;
			} else if (parentIndex != dest)
				return true;
		}
		return false;
	}

	public boolean isCyclePresentUndirected() {
		boolean[] visited = new boolean[count];
		for (int i = 0; i < count; i++) {
			if (visited[i] == false && isCyclePresentUndirectedDFS(i, -1, visited))
				return true;
		}
		return false;
	}

	public int find(int[] parent, int index) {
		int p = parent[index];
		while (p != -1) {
			index = p;
			p = parent[index];
		}
		return index;
	}

	public void union(int[] parent, int x, int y) {
		parent[y] = x;
	}

	public boolean isCyclePresentUndirected2() {
		int[] parent = new int[count];
		Arrays.fill(parent, -1);
		LinkedList<Edge> edge = new LinkedList<Edge>();

		boolean[][] flags = new boolean[count][count];
		for (int i = 0; i < count; i++) {
			LinkedList<Edge> ad = Adj.get(i);
			for (Edge adn : ad) {
				// Using flags[][] array, if considered edge x to y, 
				// then ignore edge y to x.
				if (flags[adn.dest][adn.src] == false) {
					edge.add(adn);
					flags[adn.src][adn.dest] = true;
				}
			}
		}

		for (Edge e : edge) {
			int x = find(parent, e.src);
			int y = find(parent, e.dest);
			if (x == y) {
				return true;
			}
			union(parent, x, y);
		}
		return false;
	}

	public boolean isCyclePresentUndirected3() {
		//Different subsets are created.
		Sets[] sets = new Sets[count];
		for (int i = 0; i < count; i++)
			sets[i] = new Sets(i, 0);

		LinkedList<Edge> edge = new LinkedList<Edge>();
		boolean[][] flags = new boolean[count][count];
		for (int i = 0; i < count; i++) {
			LinkedList<Edge> ad = Adj.get(i);
			for (Edge adn : ad) {
				// Using flags[][] array, if considered edge x to y, 
				// then ignore edge y to x.
				if (flags[adn.dest][adn.src] == false) {
					edge.add(adn);
					flags[adn.src][adn.dest] = true;
				}
			}
		}

		for (Edge e : edge) {
			int x = find(sets, e.src);
			int y = find(sets, e.dest);
			if (x == y) {
				return true;
			}
			union(sets, x, y);
		}
		return false;
	}

	// Testing Code
	public static void main7() {
		Graph gph = new Graph(6);
		gph.addUndirectedEdge(0, 1);
		gph.addUndirectedEdge(1, 2);
		gph.addUndirectedEdge(3, 4);
		gph.addUndirectedEdge(4, 2);
		gph.addUndirectedEdge(2, 5);
		System.out.println("Cycle Presen : " + gph.isCyclePresentUndirected());
		System.out.println("Cycle Presen : " + gph.isCyclePresentUndirected2());
		System.out.println("Cycle Presen : " + gph.isCyclePresentUndirected3());
		gph.addUndirectedEdge(4, 1);
		System.out.println("Cycle Presen : " + gph.isCyclePresentUndirected());
		System.out.println("Cycle Presen : " + gph.isCyclePresentUndirected2());
		System.out.println("Cycle Presen : " + gph.isCyclePresentUndirected3());

	}

	/*
	Cycle Presen : false
	Cycle Presen : false
	Cycle Presen : false
	Cycle Presen : true
	Cycle Presen : true
	Cycle Presen : true
		*/

	public boolean isCyclePresentDFS(int index, boolean[] visited, int[] marked) {
		visited[index] = true;
		marked[index] = 1;
		LinkedList<Edge> adl = Adj.get(index);
		for (Edge adn : adl) {
			int dest = adn.dest;
			if (marked[dest] == 1)
				return true;

			if (visited[dest] == false)
				if (isCyclePresentDFS(dest, visited, marked))
					return true;
		}
		marked[index] = 0;
		return false;
	}

	public boolean isCyclePresent() {
		boolean[] visited = new boolean[count];
		int[] marked = new int[count];
		for (int index = 0; index < count; index++) {
			if (!visited[index])
				if (isCyclePresentDFS(index, visited, marked))
					return true;
		}
		return false;
	}

	public boolean isCyclePresentDFSColour(int index, int[] visited) {
		visited[index] = 1; // 1 = grey
		int dest;
		LinkedList<Edge> adl = Adj.get(index);
		for (Edge adn : adl) {
			dest = adn.dest;
			if (visited[dest] == 1) // "Grey":
				return true;

			if (visited[dest] == 0) // "White":
				if (isCyclePresentDFSColour(dest, visited))
					return true;
		}
		visited[index] = 2; // "Black"
		return false;
	}

	public boolean isCyclePresentColour() {
		int[] visited = new int[count];
		for (int i = 0; i < count; i++) {
			if (visited[i] == 0) // "White"
				if (isCyclePresentDFSColour(i, visited))
					return true;
		}
		return false;
	}

	// Testing Code
	public static void main8() {
		Graph gph = new Graph(5);
		gph.addDirectedEdge(0, 1);
		gph.addDirectedEdge(0, 2);
		gph.addDirectedEdge(2, 3);
		gph.addDirectedEdge(1, 3);
		gph.addDirectedEdge(3, 4);
		System.out.println("isCyclePresent : " + gph.isCyclePresent());
		System.out.println("isCyclePresent : " + gph.isCyclePresentColour());
		gph.addDirectedEdge(4, 1);
		System.out.println("isCyclePresent : " + gph.isCyclePresent());
		System.out.println("isCyclePresent : " + gph.isCyclePresentColour());
	}

	/*
	isCyclePresent : false
	isCyclePresent : false
	isCyclePresent : true
	isCyclePresent : true
	*/

	public Graph transposeGraph() {
		Graph g = new Graph(count);
		for (int i = 0; i < count; i++) {
			LinkedList<Edge> adl = Adj.get(i);
			for (Edge adn : adl) {
				int dest = adn.dest;
				g.addDirectedEdge(dest, i);
			}
		}
		return g;
	}

	// Testing Code
	public static void main9() {
		Graph gph = new Graph(5);
		gph.addDirectedEdge(0, 1);
		gph.addDirectedEdge(0, 2);
		gph.addDirectedEdge(2, 3);
		gph.addDirectedEdge(1, 3);
		gph.addDirectedEdge(3, 4);
		gph.addDirectedEdge(4, 1);
		Graph gReversed = gph.transposeGraph();
		gReversed.print();
	}
	/*
	Vertex 0 is connected to : 
	Vertex 1 is connected to : 0(cost: 1) 4(cost: 1) 
	Vertex 2 is connected to : 0(cost: 1) 
	Vertex 3 is connected to : 1(cost: 1) 2(cost: 1) 
	Vertex 4 is connected to : 3(cost: 1) 
	*/

	public boolean isConnectedUndirected() {
		boolean[] visited = new boolean[count];

		dfsUtil(0, visited);
		for (int i = 0; i < count; i++) {
			if (visited[i] == false) {
				return false;
			}
		}
		return true;
	}

	//Testing Code
	public static void main10A() {
		Graph gph = new Graph(6);
		gph.addUndirectedEdge(0, 1);
		gph.addUndirectedEdge(1, 2);
		gph.addUndirectedEdge(3, 4);
		gph.addUndirectedEdge(4, 2);
		gph.addUndirectedEdge(2, 5);
		System.out.println("isConnectedUndirected:: " + gph.isConnectedUndirected());
	}

	/*
	isConnectedUndirected:: true
	*/

	public boolean isStronglyConnected() {
		boolean visited[] = new boolean[count];
		dfsUtil(0, visited);
		for (int i = 0; i < count; i++) {
			if (visited[i] == false) {
				return false;
			}
		}
		Graph gReversed = transposeGraph();
		for (int i = 0; i < count; i++) {
			visited[i] = false;
		}
		gReversed.dfsUtil(0, visited);
		for (int i = 0; i < count; i++) {
			if (visited[i] == false) {
				return false;
			}
		}
		return true;
	}

	// Testing Code
	public static void main10() {
		Graph gph = new Graph(5);
		gph.addDirectedEdge(0, 1);
		gph.addDirectedEdge(1, 2);
		gph.addDirectedEdge(2, 3);
		gph.addDirectedEdge(3, 0);
		gph.addDirectedEdge(2, 4);
		gph.addDirectedEdge(4, 2);
		System.out.println("IsStronglyConnected:: " + gph.isStronglyConnected());
	}

	/*
	IsStronglyConnected:: true
		*/

	public void stronglyConnectedComponent() {
		boolean[] visited = new boolean[count];
		Stack<Integer> stk = new Stack<Integer>();
		for (int i = 0; i < count; i++) {
			if (visited[i] == false)
				dfsUtil2(i, visited, stk);
		}

		Graph gReversed = transposeGraph();
		Arrays.fill(visited, false);

		Stack<Integer> stk2 = new Stack<Integer>();
		while (stk.isEmpty() == false) {
			int index = stk.pop();
			if (visited[index] == false) {
				stk2.clear();
				gReversed.dfsUtil2(index, visited, stk2);
				System.out.println(stk2);
			}
		}
	}

	// Testing Code
	public static void main11() {
		Graph gph = new Graph(7);
		gph.addDirectedEdge(0, 1);
		gph.addDirectedEdge(1, 2);
		gph.addDirectedEdge(2, 0);
		gph.addDirectedEdge(2, 3);
		gph.addDirectedEdge(3, 4);
		gph.addDirectedEdge(4, 5);
		gph.addDirectedEdge(5, 3);
		gph.addDirectedEdge(5, 6);
		gph.stronglyConnectedComponent();

	}

	/*
	[1, 2, 0]
	[4, 5, 3]
	[6]

		*/

	public void primsMST() {
		int[] previous = new int[count];
		int[] dist = new int[count];
		boolean[] visited = new boolean[count];

		Arrays.fill(previous, -1);
		Arrays.fill(dist, Integer.MAX_VALUE);// infinite

		int source = 0;
		dist[source] = 0;
		previous[source] = source;

		PriorityQueue<Edge> queue = new PriorityQueue<Edge>(100);
		Edge node = new Edge(source, source, 0);
		queue.add(node);

		while (queue.isEmpty() != true) {
			node = queue.peek();
			queue.remove();
			visited[source] = true;
			source = node.dest;
			LinkedList<Edge> adl = Adj.get(source);
			for (Edge adn : adl) {
				int dest = adn.dest;
				int alt = adn.cost;
				if (dist[dest] > alt && visited[dest] == false) {
					dist[dest] = alt;
					previous[dest] = source;
					node = new Edge(source, dest, alt);
					queue.add(node);
				}
			}
		}

		// printing result.
		int sum = 0;
		boolean isMst = true;
		String output = "Edges are ";
		for (int i = 0; i < count; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				output += ("(" + i + ", Unreachable) ");
				isMst = false;
			} else if (previous[i] != i) {
				output += ("(" + previous[i] + "->" + i + " @ " + dist[i] + ") ");
				sum += dist[i];
			}
		}

		if (isMst) {
			System.out.println(output);
			System.out.println("Total MST cost: " + sum);
		} else
			System.out.println("Can't get a Spanning Tree");

	}

	public static class Sets {
		int parent;
		int rank;

		Sets(int p, int r) {
			parent = p;
			rank = r;
		}
	}

	// root element of set
	public int find(Sets[] sets, int index) {
		int p = sets[index].parent;
		while (p != index) {
			index = p;
			p = sets[index].parent;
		}
		return index;
	}

	// consider x and y are roots of sets.
	public void union(Sets[] sets, int x, int y) {
		if (sets[x].rank < sets[y].rank)
			sets[x].parent = y;
		else if (sets[y].rank < sets[x].rank)
			sets[y].parent = x;
		else {
			sets[x].parent = y;
			sets[y].rank++;
		}
	}

	public void kruskalMST() {
		//Different subsets are created.
		Sets[] sets = new Sets[count];
		for (int i = 0; i < count; i++)
			sets[i] = new Sets(i, 0);

		// Edges are added to array and sorted.
		int E = 0;
		Edge edge[] = new Edge[100];
		for (int i = 0; i < count; i++) {
			LinkedList<Edge> ad = Adj.get(i);
			for (Edge adn : ad) {
				edge[E++] = adn;
			}
		}
		Arrays.sort(edge, 0, E - 1);

		int sum = 0;
		String output = "Edges are ";
		for (int i = 0; i < E; i++) {
			int x = find(sets, edge[i].src);
			int y = find(sets, edge[i].dest);
			if (x != y) {
				output += ("(" + edge[i].src + "->" + edge[i].dest + " @ " + edge[i].cost + ") ");
				sum += edge[i].cost;
				union(sets, x, y);
			}
		}
		System.out.println(output);
		System.out.println("Total MST cost: " + sum);
	}

	// Testing Code
	public static void main12() {
		Graph gph = new Graph(9);
		gph.addUndirectedEdge(0, 1, 4);
		gph.addUndirectedEdge(0, 7, 8);
		gph.addUndirectedEdge(1, 2, 8);
		gph.addUndirectedEdge(1, 7, 11);
		gph.addUndirectedEdge(2, 3, 7);
		gph.addUndirectedEdge(2, 8, 2);
		gph.addUndirectedEdge(2, 5, 4);
		gph.addUndirectedEdge(3, 4, 9);
		gph.addUndirectedEdge(3, 5, 14);
		gph.addUndirectedEdge(4, 5, 10);
		gph.addUndirectedEdge(5, 6, 2);
		gph.addUndirectedEdge(6, 7, 1);
		gph.addUndirectedEdge(6, 8, 6);
		gph.addUndirectedEdge(7, 8, 7);
		System.out.println();
		gph.primsMST();
		System.out.println();
		gph.kruskalMST();
		System.out.println();
		gph.dijkstra(0);
	}

	/*
	
	Edges are (0->1 @ 4) (5->2 @ 4) (2->3 @ 7) (3->4 @ 9) (6->5 @ 2) (7->6 @ 1) (0->7 @ 8) (2->8 @ 2) 
	Total MST cost: 37
	
	Edges are (6->7 @ 1) (2->8 @ 2) (5->6 @ 2) (0->1 @ 4) (2->5 @ 4) (2->3 @ 7) (0->7 @ 8) (3->4 @ 9) 
	Total MST cost: 37
	
	Shortest Paths: (0->1 @ 4) (0->1->2 @ 12) (0->1->2->3 @ 19) (0->7->6->5->4 @ 21) (0->7->6->5 @ 11) (0->7->6 @ 9) (0->7 @ 8) (0->1->2->8 @ 14) 
	
	*/

	// Unweighed graph
	public void shortestPath(int source) {
		int curr;
		int[] distance = new int[count];
		int[] path = new int[count];
		for (int i = 0; i < count; i++) {
			distance[i] = -1;
			path[i] = -1;
		}

		Queue<Integer> que = new LinkedList<Integer>();
		que.add(source);
		distance[source] = 0;
		path[source] = source;

		while (que.isEmpty() == false) {
			curr = que.remove();
			LinkedList<Edge> adl = Adj.get(curr);
			for (Edge adn : adl) {
				if (distance[adn.dest] == -1) {
					distance[adn.dest] = distance[curr] + 1;
					path[adn.dest] = curr;
					que.add(adn.dest);
				}
			}
		}
		printPath(path, distance, count, source);
	}

	String printPathUtil(int[] previous, int source, int dest) {
		String path = "";
		if (dest == source)
			path += source;
		else {
			path += printPathUtil(previous, source, previous[dest]);
			path += ("->" + dest);
		}
		return path;
	}

	public void printPath(int[] previous, int[] dist, int count, int source) {
		String output = "Shortest Paths: ";
		for (int i = 0; i < count; i++) {
			if (dist[i] == 99999)
				output += ("(" + source + "->" + i + " @ Unreachable) ");
			else if (i != previous[i]) {
				output += "(";
				output += printPathUtil(previous, source, i);
				output += (" @ " + dist[i] + ") ");
			}
		}
		System.out.println(output);
	}

	public void dijkstra(int source) {
		int[] previous = new int[count];
		int[] dist = new int[count];
		boolean[] visited = new boolean[count];

		Arrays.fill(previous, -1);
		Arrays.fill(dist, 99999); // infinite

		dist[source] = 0;
		previous[source] = source;

		PriorityQueue<Edge> queue = new PriorityQueue<Edge>(100);
		Edge edge = new Edge(source, source, 0);
		queue.add(edge);
		int curr;

		while (queue.isEmpty() != true) {
			edge = queue.peek();
			queue.remove();
			curr = edge.dest;
			visited[curr] = true;
			LinkedList<Edge> adl = Adj.get(curr);

			for (Edge adn : adl) {
				int dest = adn.dest;
				int alt = adn.cost + dist[curr];

				if (alt < dist[dest] && visited[dest] == false) {
					dist[dest] = alt;
					previous[dest] = curr;
					edge = new Edge(curr, dest, alt);
					queue.add(edge);
				}
			}
		}
		printPath(previous, dist, count, source);
	}

	public void bellmanFordShortestPath(int source) {
		int[] distance = new int[count];
		Arrays.fill(distance, 99999); // infinite
		int[] path = new int[count];
		Arrays.fill(path, -1);

		distance[source] = 0;
		path[source] = source;
		// Outer loop will run (V-1) number of times.
		// Inner for loop and while loop runs combined will
		// run for Edges number of times.
		// Which make the total complexity as O(V*E)

		for (int i = 0; i < count - 1; i++) {
			for (int j = 0; j < count; j++) {
				LinkedList<Edge> adl = Adj.get(j);
				for (Edge adn : adl) {
					int newDistance = distance[j] + adn.cost;
					if (distance[adn.dest] > newDistance) {
						distance[adn.dest] = newDistance;
						path[adn.dest] = j;
					}

				}
			}
		}
		printPath(path, distance, count, source);
	}

	// Testing Code
	public static void main13() {
		Graph gph = new Graph(5);
		gph.addDirectedEdge(0, 1, 3);
		gph.addDirectedEdge(0, 4, 2);
		gph.addDirectedEdge(1, 2, 1);
		gph.addDirectedEdge(2, 3, 1);
		gph.addDirectedEdge(4, 1, -2);
		gph.addDirectedEdge(4, 3, 1);
		gph.bellmanFordShortestPath(0);
	}

	/*
	Shortest Paths: (0->4->1 @ 0) (0->4->1->2 @ 1) (0->4->1->2->3 @ 2) (0->4 @ 2) 
	*/

	public static int heightTreeParentArr(int[] arr) {
		int count = arr.length;
		int[] heightArr = new int[count];
		Graph gph = new Graph(count);
		int source = 0;
		for (int i = 0; i < count; i++) {
			if (arr[i] != -1) {
				gph.addDirectedEdge(arr[i], i);
			} else {
				source = i;
			}
		}
		boolean[] visited = new boolean[count];
		visited[source] = true;
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(source);
		heightArr[source] = 0;
		int maxHight = 0;
		while (que.isEmpty() == false) {
			int curr = que.remove();
			int height = heightArr[curr];
			if (height > maxHight) {
				maxHight = height;
			}
			LinkedList<Edge> adl = gph.Adj.get(curr);
			for (Edge adn : adl) {
				if (visited[adn.dest] == false) {
					visited[adn.dest] = true;
					que.add(adn.dest);
					heightArr[adn.dest] = height + 1;
				}
			}
		}
		return maxHight;
	}

	public static int getHeight(int[] arr, int[] height, int index) {
		if (arr[index] == -1) {
			return 0;
		} else {
			return getHeight(arr, height, arr[index]) + 1;
		}
	}

	public static int heightTreeParentArr2(int[] arr) {
		int count = arr.length;
		int[] height = new int[count];
		int maxHeight = -1;
		for (int i = 0; i < count; i++) {
			height[i] = getHeight(arr, height, i);
			maxHeight = Math.max(maxHeight, height[i]);
		}
		return maxHeight;
	}

	// Testing Code
	public static void main14() {
		int parentArray[] = { -1, 0, 1, 2, 3 };
		System.out.println(heightTreeParentArr(parentArray));
		System.out.println(heightTreeParentArr2(parentArray));
	}

	/*
	4
	4
		*/

	public boolean isConnected() {
		boolean[] visited = new boolean[count];

		// Find a vertex with non - zero degree
		// DFS traversal of graph from a vertex with non - zero degree
		LinkedList<Edge> adl;
		for (int i = 0; i < count; i++) {
			adl = Adj.get(i);
			if (adl.size() > 0) {
				dfsUtil(i, visited);
				break;
			}
		}
		// Check if all non - zero degree count are visited
		for (int i = 0; i < count; i++) {
			adl = Adj.get(i);
			if (adl.size() > 0)
				if (visited[i] == false)
					return false;
		}
		return true;
	}

	public int isEulerian() {
		// Check if all non - zero degree nodes are connected
		if (isConnected() == false) {
			System.out.println("graph is not Eulerian");
			return 0;
		}

		// Count odd degree
		int odd = 0;
		int[] inDegree = new int[count];
		int[] outDegree = new int[count];
		LinkedList<Edge> adl;

		for (int i = 0; i < count; i++) {
			adl = Adj.get(i);
			for (Edge adn : adl) {
				outDegree[i] += 1;
				inDegree[adn.dest] += 1;
			}
		}
		for (int i = 0; i < count; i++) {
			if ((inDegree[i] + outDegree[i]) % 2 != 0) {
				odd += 1;
			}
		}

		if (odd == 0) {
			System.out.println("graph is Eulerian");
			return 2;
		} else if (odd == 2) {
			System.out.println("graph is Semi-Eulerian");
			return 1;
		} else {
			System.out.println("graph is not Eulerian");
			return 0;
		}
	}

	// Testing Code
	public static void main15() {
		Graph gph = new Graph(5);
		gph.addDirectedEdge(1, 0);
		gph.addDirectedEdge(0, 2);
		gph.addDirectedEdge(2, 1);
		gph.addDirectedEdge(0, 3);
		gph.addDirectedEdge(3, 4);
		gph.isEulerian();
		gph.addDirectedEdge(4, 0);
		gph.isEulerian();
	}

	/*
	graph is Semi-Eulerian
	graph is Eulerian
		*/

	public boolean isStronglyConnected2() {
		boolean[] visited = new boolean[count];
		int index;
		// Find a vertex with non - zero degree
		LinkedList<Edge> adl;
		for (index = 0; index < count; index++) {
			adl = Adj.get(index);
			if (adl.size() > 0)
				break;
		}
		// DFS traversal of graph from a vertex with non - zero degree
		dfsUtil(index, visited);
		for (int i = 0; i < count; i++) {
			adl = Adj.get(i);
			if (visited[i] == false && adl.size() > 0)
				return false;
		}

		Graph gReversed = transposeGraph();
		for (int i = 0; i < count; i++)
			visited[i] = false;
		gReversed.dfsUtil(index, visited);

		for (int i = 0; i < count; i++) {
			adl = Adj.get(i);
			if (visited[i] == false && adl.size() > 0)
				return false;
		}
		return true;
	}

	public boolean isEulerianCycle() {
		// Check if all non - zero degree count are connected
		int[] inDegree = new int[count];
		int[] outDegree = new int[count];
		if (!isStronglyConnected2())
			return false;

		// Check if in degree and out degree of every vertex is same
		for (int i = 0; i < count; i++) {
			LinkedList<Edge> adl = Adj.get(i);
			for (Edge adn : adl) {
				outDegree[i] += 1;
				inDegree[adn.dest] += 1;
			}
		}
		for (int i = 0; i < count; i++)
			if (inDegree[i] != outDegree[i])
				return false;
		return true;
	}

	// Testing Code
	public static void main16() {
		Graph gph = new Graph(5);
		gph.addDirectedEdge(0, 1);
		gph.addDirectedEdge(1, 2);
		gph.addDirectedEdge(2, 0);
		gph.addDirectedEdge(0, 4);
		gph.addDirectedEdge(4, 3);
		gph.addDirectedEdge(3, 0);
		System.out.println(gph.isEulerianCycle());
	}

	/*
	true
	*/

	// Testing Code
	public static void main17() {
		Graph gph = new Graph(7);
		gph.addDirectedEdge(0, 1);
		gph.addDirectedEdge(1, 2);
		gph.addDirectedEdge(2, 0);
		gph.addDirectedEdge(2, 3);
		gph.addDirectedEdge(3, 4);
		gph.addDirectedEdge(4, 5);
		gph.addDirectedEdge(5, 3);
		gph.addDirectedEdge(5, 6);

		Graph gReversed = gph.transposeGraph();
		gReversed.print();
	}

	/*
	Vertex 0 is connected to : 2(cost: 1) 
	Vertex 1 is connected to : 0(cost: 1) 
	Vertex 2 is connected to : 1(cost: 1) 
	Vertex 3 is connected to : 2(cost: 1) 5(cost: 1) 
	Vertex 4 is connected to : 3(cost: 1) 
	Vertex 5 is connected to : 4(cost: 1) 
	Vertex 6 is connected to : 5(cost: 1) 
	*/

	// Testing Code
	public static void main18() {
		Graph gph = new Graph(9);
		gph.addUndirectedEdge(0, 1);
		gph.addUndirectedEdge(0, 7);
		gph.addUndirectedEdge(1, 2);
		gph.addUndirectedEdge(1, 7);
		gph.addUndirectedEdge(2, 3);
		gph.addUndirectedEdge(2, 8);
		gph.addUndirectedEdge(2, 5);
		gph.addUndirectedEdge(3, 4);
		gph.addUndirectedEdge(3, 5);
		gph.addUndirectedEdge(4, 5);
		gph.addUndirectedEdge(5, 6);
		gph.addUndirectedEdge(6, 7);
		gph.addUndirectedEdge(6, 8);
		gph.addUndirectedEdge(7, 8);
		gph.shortestPath(0);
	}

	/*
	Shortest Paths: (0->1 @ 1)(0->1->2 @ 2)(0->1->2->3 @ 3)(0->1->2->3->4 @ 4)(0->1->2->5 @ 3)(0->7->6 @ 2)(0->7 @ 1)(0->7->8 @ 2)
	*/

	void floydWarshall() {
		int V = count;
		int dist[][] = new int[V][V];
		int path[][] = new int[V][V];
		final int INF = 99999;

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				dist[i][j] = INF;
				if (i == j)
					path[i][j] = 0;
				else
					path[i][j] = -1;
			}
		}

		for (int i = 0; i < V; i++) {
			LinkedList<Edge> adl = Adj.get(i);
			for (Edge adn : adl) {
				path[adn.src][adn.dest] = adn.src;
				dist[adn.src][adn.dest] = adn.cost;
			}
		}

		// Pick intermediate vertices.
		for (int k = 0; k < V; k++) {
			// Pick source vertices one by one.
			for (int i = 0; i < V; i++) {
				// Pick destination vertices.
				for (int j = 0; j < V; j++) {
					// If we have a shorter path from i to j via k.
					// then update dist[i][j] and  and path[i][j]
					if (dist[i][k] + dist[k][j] < dist[i][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
						path[i][j] = path[k][j];
					}
				}
				// dist[i][i] is 0 in the start.
				// If there is a better path from i to i and is better path then we have -ve cycle.                //
				if (dist[i][i] < 0) {
					System.out.println("Negative-weight cycle found.");
					return;
				}
			}
		}
		printSolution(dist, path, V);
	}

	private void printSolution(int[][] cost, int[][] path, int V) {
		System.out.print("Shortest Paths : ");
		for (int u = 0; u < V; u++) {
			for (int v = 0; v < V; v++) {
				if (u != v && path[u][v] != -1) {
					System.out.print("(");
					printPath2(path, u, v);
					System.out.print(" @ " + cost[u][v] + ") ");
				}
			}
		}
		System.out.println();
	}

	private void printPath2(int[][] path, int u, int v) {
		if (path[u][v] == u) {
			System.out.print(u + "->" + v);
			return;
		}
		printPath2(path, u, path[u][v]);
		System.out.print("->" + v);
	}

	// Testing code.
	public static void main19() {
		Graph gph = new Graph(4);
		gph.addDirectedEdge(0, 0, 0);
		gph.addDirectedEdge(1, 1, 0);
		gph.addDirectedEdge(2, 2, 0);
		gph.addDirectedEdge(3, 3, 0);
		gph.addDirectedEdge(0, 1, 5);
		gph.addDirectedEdge(0, 3, 10);
		gph.addDirectedEdge(1, 2, 3);
		gph.addDirectedEdge(2, 3, 1);
		gph.floydWarshall();
	}

	/*
	Shortest Paths : (0->1 @ 5) (0->1->2 @ 8) (0->1->2->3 @ 9) (1->2 @ 3) (1->2->3 @ 4) (2->3 @ 1) 
	*/

	public static void main(String[] args) {
		/*main0();
		main1();
		main2(); 
		main3(); 
		main4(); 
		main5(); 
		main6(); 
		main7(); 
		main8();
		main9();
		*/
		main10A();
		main10();
		main11();
		main12();
		main13();
		main14();
		main15();
		main16();
		main17();
		main18();
		main19();
	}
}