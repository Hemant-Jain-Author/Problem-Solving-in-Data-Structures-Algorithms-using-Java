import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;
import java.util.ArrayList;

public class Graph {

	private static class AdjNode {
		private int dest;
		private int cost;

		public AdjNode(int dst, int cst) {
			dest = dst;
			cost = cst;
		}

		public AdjNode(int dst) {
			this(dst, 1);
		}
	}

	int count;
	private final List<List<AdjNode>> array;

	public Graph(int cnt) {
		count = cnt;
		array = new ArrayList<>(cnt);
		for (int i = 0; i < cnt; i++) {
			array.add(new ArrayList<AdjNode>());
		}
	}

	private void AddDirectedEdge(int source, int dest, int cost) {
		AdjNode node = new AdjNode(dest, cost);
		array.get(source).add(node);
	}

	public void AddDirectedEdge(int source, int dest) {
		AddDirectedEdge(source, dest, 1);
	}

	public void AddBiEdge(int source, int dest, int cost) {
		AddDirectedEdge(source, dest, cost);
		AddDirectedEdge(dest, source, cost);
	}

	public void AddBiEdge(int source, int dest) {
		AddBiEdge(source, dest, 1);
	}

	public void Print() {
		for (int i = 0; i < count; i++) {
			List<AdjNode> ad = array.get(i);
			System.out.print("\n Vertex " + i + " is connected to : ");
			for (AdjNode adn : ad) {
				System.out.print("(" + adn.dest + ", " + adn.cost + ") ");
			}
		}
	}

	static class AdjNodeComparator implements Comparator<AdjNode> {
		public int compare(AdjNode x, AdjNode y) {
			if (x.cost < y.cost) {
				return -1;
			}
			if (x.cost > y.cost) {
				return 1;
			}
			return 0;
		}
	}

	public static void Dijkstra(Graph gph, int source) {
		int[] previous = new int[gph.count];
		int[] dist = new int[gph.count];
		boolean[] visited = new boolean[gph.count];

		for (int i = 0; i < gph.count; i++) {
			previous[i] = -1;
			dist[i] = Integer.MAX_VALUE; // infinite
			visited[i] = false;
		}

		dist[source] = 0;
		previous[source] = -1;

		AdjNodeComparator comp = new AdjNodeComparator();
		PriorityQueue<AdjNode> queue = new PriorityQueue<AdjNode>(100, comp);

		AdjNode node = new AdjNode(source, 0);
		queue.add(node);

		while (queue.isEmpty() != true) {
			node = queue.peek();
			queue.remove();
			source = node.dest;
			visited[source] = true;
			List<AdjNode> adl = gph.array.get(source);
			for (AdjNode adn : adl) {
				int dest = adn.dest;
				int alt = adn.cost + dist[source];
				if (dist[dest] > alt && visited[dest] == false) {
					dist[dest] = alt;
					previous[dest] = source;
					node = new AdjNode(dest, alt);
					queue.add(node);
				}
			}
		}

		int count = gph.count;
		for (int i = 0; i < count; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.println(" \n node id " + i + "  prev " + previous[i] + " distance : Unreachable");
			} else {
				System.out.println(" node id " + i + "  prev " + previous[i] + " distance : " + dist[i]);

			}
		}
	}

	public static void Prims(Graph gph) {
		int[] previous = new int[gph.count];
		int[] dist = new int[gph.count];
		boolean[] visited = new boolean[gph.count];

		int source = 1;

		for (int i = 0; i < gph.count; i++) {
			previous[i] = -1;
			dist[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}

		dist[source] = 0;
		previous[source] = -1;

		AdjNodeComparator comp = new AdjNodeComparator();
		PriorityQueue<AdjNode> queue = new PriorityQueue<AdjNode>(100, comp);

		AdjNode node = new AdjNode(source, 0);
		queue.add(node);

		while (queue.isEmpty() != true) {
			node = queue.peek();
			queue.remove();
			visited[source] = true;
			source = node.dest;
			List<AdjNode> adl = gph.array.get(source);
			for (AdjNode adn : adl) {
				int dest = adn.dest;
				int alt = adn.cost;
				if (dist[dest] > alt && visited[dest] == false) {
					dist[dest] = alt;
					previous[dest] = source;
					node = new AdjNode(dest, alt);
					queue.add(node);
				}
			}
		}
		// Printing result.
		int count = gph.count;
		for (int i = 0; i < count; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.println(" node id " + i + "  prev " + previous[i] + " distance : Unreachable");
			} else {
				System.out.println(" node id " + i + "  prev " + previous[i] + " distance : " + dist[i]);

			}
		}
	}

	private static void TopologicalSortDFS(Graph gph, int index, boolean[] visited, Stack<Integer> stk) {
		List<AdjNode> adl = gph.array.get(index);
		visited[index] = true;
		for (AdjNode adn : adl) {
			if (visited[adn.dest] == false) {
				TopologicalSortDFS(gph, adn.dest, visited, stk);
			}
		}
		stk.push(index);
	}

	public static void TopologicalSort(Graph gph) {
		Stack<Integer> stk = new Stack<Integer>();
		int count = gph.count;
		boolean[] visited = new boolean[count];
		for (int i = 0; i < count; i++) {
			visited[i] = false;
		}
		for (int i = 0; i < count; i++) {
			if (visited[i] == false) {
				TopologicalSortDFS(gph, i, visited, stk);
			}
		}
		System.out.print("TopologicalSort :: ");
		while (stk.isEmpty() != true) {
			System.out.print(" " + stk.pop());
		}
	}

	public static boolean PathExist(Graph gph, int source, int dest) {
		int count = gph.count;
		boolean[] visited = new boolean[count];
		for (int i = 0; i < count; i++) {
			visited[i] = false;
		}
		DFSRec(gph, source, visited);
		return visited[dest];
	}

	public static void DFSRec(Graph gph, int index, boolean[] visited) {
		visited[index] = true;
		List<AdjNode> adl = gph.array.get(index);
		for (AdjNode adn : adl) {
			if (visited[adn.dest] == false) {
				DFSRec(gph, adn.dest, visited);
			}
		}
	}

	public boolean DFSStack(Graph gph, int source, int target) {
		int count = gph.count;
		boolean[] visited = new boolean[count];
		for (int i = 0; i < count; i++) {
			visited[i] = false;
		}
		Stack<Integer> stk = new Stack<Integer>();
		stk.push(source);
		visited[source] = true;

		while (stk.isEmpty() == false) {
			int curr = stk.pop();
			List<AdjNode> adl = gph.array.get(curr);
			for (AdjNode adn : adl) {
				if (visited[adn.dest] == false) {
					visited[adn.dest] = true;
					stk.push(adn.dest);
				}
			}
		}
		return visited[target];
	}

	public boolean DFS(Graph gph, int source, int target) {
		int count = gph.count;
		boolean[] visited = new boolean[count];
		for (int i = 0; i < count; i++) {
			visited[i] = false;
		}
		DFSRec(gph, source, visited);
		return visited[target];
	}

	public boolean BFS(Graph gph, int source, int target) {
		int count = gph.count;
		boolean[] visited = new boolean[count];
		for (int i = 0; i < count; i++) {
			visited[i] = false;
		}

		LinkedList<Integer> que = new LinkedList<Integer>();
		que.add(source);
		visited[source] = true;

		while (que.isEmpty() == false) {
			int curr = que.remove();
			List<AdjNode> adl = gph.array.get(curr);
			for (AdjNode adn : adl) {
				if (visited[adn.dest] == false) {
					visited[adn.dest] = true;
					que.add(adn.dest);
				}
			}
		}
		return visited[target];
	}

	public void BFSLevelNode(Graph gph, int source) {
		int count = gph.count;
		boolean[] visited = new boolean[count];
		int[] level = new int[count];
		visited[source] = true;

		LinkedList<Integer> que = new LinkedList<Integer>();
		que.add(source);
		level[source] = 0;
		System.out.println("\nNode  - Level");

		while (que.isEmpty() == false) {
			int curr = que.remove();
			int depth = level[curr];
			List<AdjNode> adl = gph.array.get(curr);
			System.out.println(curr + " - " + depth);
			for (AdjNode adn : adl) {
				if (visited[adn.dest] == false) {
					visited[adn.dest] = true;
					que.add(adn.dest);
					level[adn.dest] = depth + 1;
				}
			}
		}
	}

	public int BFSDistance(Graph gph, int source, int dest) {
		int count = gph.count;
		boolean[] visited = new boolean[count];
		for (int i = 0; i < count; i++) {
			visited[i] = false;
		}
		LinkedList<Integer> que = new LinkedList<Integer>();
		que.add(source);
		visited[source] = true;
		int[] level = new int[count];
		level[source] = 0;

		while (que.isEmpty() == false) {
			int curr = que.remove();
			int depth = level[curr];
			List<AdjNode> adl = gph.array.get(curr);
			for (AdjNode adn : adl) {
				if (adn.dest == dest) {
					return depth;
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
	/*
	 * g = Graph(7) g.AddUndirectedEdge(0, 1) g.AddUndirectedEdge(0, 2)
	 * g.AddUndirectedEdge(0, 4) g.AddUndirectedEdge(1, 2)
	 * g.AddUndirectedEdge(2, 5) g.AddUndirectedEdge(3, 4)
	 * g.AddUndirectedEdge(4, 5) g.AddUndirectedEdge(4, 6)
	 * 
	 * print BFSDistance(g, 1, 3)
	 */

	public boolean isConnectedUndirected(Graph gph) {
		int count = gph.count;
		boolean[] visited = new boolean[count];
		for (int i = 0; i < count; i++) {
			visited[i] = false;
		}
		DFSRec(gph, 0, visited);
		for (int i = 0; i < count; i++) {
			if (visited[i] == false) {
				return false;
			}
		}
		return true;
	}

	public void ShortestPath(Graph gph, int source)// unweighted graph
	{
		int curr;
		int count = gph.count;
		int[] distance = new int[count];
		int[] path = new int[count];
		for (int i = 0; i < count; i++) {
			distance[i] = -1;
		}
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(source);
		distance[source] = 0;
		while (que.isEmpty() == false) {
			curr = que.remove();
			List<AdjNode> adl = gph.array.get(curr);
			for (AdjNode adn : adl) {
				if (distance[adn.dest] == -1) {
					distance[adn.dest] = distance[curr] + 1;
					path[adn.dest] = curr;
					que.add(adn.dest);
				}

			}
		}
		for (int i = 0; i < count; i++) {
			System.out.println(path[i] + " to " + i + " weight " + distance[i]);
		}
	}

	public void BellmanFordShortestPath(Graph gph, int source) {
		int count = gph.count;
		int[] distance = new int[count];
		int[] path = new int[count];

		for (int i = 0; i < count; i++) {
			distance[i] = Integer.MAX_VALUE;
			path[i] = -1;
		}
		distance[source] = 0;
		// Outer loop will run (V-1) number of times.
		// Inner for loop and while loop runs combined will
		// run for Edges number of times.
		// Which make the total complexity as O(V*E)

		for (int i = 0; i < count - 1; i++) {
			for (int j = 0; j < count; j++) {
				List<AdjNode> adl = gph.array.get(j);
				for (AdjNode adn : adl) {
					int newDistance = distance[j] + adn.cost;
					if (distance[adn.dest] > newDistance) {
						distance[adn.dest] = newDistance;
						path[adn.dest] = j;
					}

				}
			}
		}
		for (int i = 0; i < count; i++) {
			System.out.println(path[i] + " to " + i + " weight " + distance[i]);
		}
	}

	public static void main(String[] args) {
		Graph gph = new Graph(9);
		gph.AddBiEdge(0, 2, 1);
		gph.AddBiEdge(1, 2, 5);
		gph.AddBiEdge(1, 3, 7);
		gph.AddBiEdge(1, 4, 9);
		gph.AddBiEdge(3, 2, 2);
		gph.AddBiEdge(3, 5, 4);
		gph.AddBiEdge(4, 5, 6);
		gph.AddBiEdge(4, 6, 3);
		gph.AddBiEdge(5, 7, 1);
		gph.AddBiEdge(6, 7, 7);
		gph.AddBiEdge(7, 8, 17);
		gph.Print();
		Dijkstra(gph, 1);
		Prims(gph);
	}

	public int RootVertex(Graph gph) {
		int count = gph.count;
		boolean[] visited = new boolean[count];
		for (int i = 0; i < count; i++) {
			visited[i] = false;
		}
		int retVal = -1;
		for (int i = 0; i < count; i++) {
			if (visited[i] == false) {
				DFSRec(gph, i, visited);
				retVal = i;
			}
		}
		System.out.print("Root vertex is :: " + retVal);
		return retVal;
	}

	public static Graph TransposeGraph(Graph gph) {
		int count = gph.count;
		Graph g = new Graph(count);
		for (int i = 0; i < count; i++) {
			List<AdjNode> adl = gph.array.get(i);
			for (AdjNode adn : adl) {
				int dest = adn.dest;
				g.AddDirectedEdge(dest, i);
			}
		}
		return g;
	}

	public static void DFSRec2(Graph gph, int index, boolean[] visited, Stack<Integer> stk) {
		visited[index] = true;
		List<AdjNode> adl = gph.array.get(index);
		for (AdjNode adn : adl) {
			if (visited[adn.dest] == false) {
				DFSRec(gph, adn.dest, visited);
			}
		}
		stk.add(index);
	}

	/*
	 * Kosaraju Algorithm
	 * 
	 * Kosaraju’s Algorithm to find strongly connected directed graph based on
	 * DFS : 1) Create a visited array of size V, and Initialize all vertices in
	 * visited array as false. 2) Choose any vertice and perform a DFS traversal
	 * of graph. For all visited vertices mark them visited as true. 3) If DFS
	 * traversal does not mark all vertices as true, then return false. 4) Find
	 * transpose or reverse of graph 5) Repeat step 1, 2 and 3 for the reversed
	 * graph. 6) If DFS traversal mark all the vertices as true, then return
	 * true.
	 * 
	 */

	public boolean isStronglyConnected(Graph gph) {
		int count = gph.count;
		boolean visited[] = new boolean[count];
		for (int i = 0; i < count; i++) {
			visited[i] = false;
		}
		DFSRec(gph, 0, visited);
		for (int i = 0; i < count; i++) {
			if (visited[i] == false) {
				return false;
			}
		}
		Graph gReversed = TransposeGraph(gph);
		for (int i = 0; i < count; i++) {
			visited[i] = false;
		}
		DFSRec(gReversed, 0, visited);
		for (int i = 0; i < count; i++) {
			if (visited[i] == false) {
				return false;
			}
		}
		return true;
	}

	/*
	 * # Create a graph given in the above diagram g1 = Graph(5)
	 * g1.AddDirectedEdge(0, 1) g1.AddDirectedEdge(1, 2) g1.AddDirectedEdge(2,
	 * 3) g1.AddDirectedEdge(3, 0) g1.AddDirectedEdge(2, 4)
	 * g1.AddDirectedEdge(4, 2)
	 * 
	 * print isStronglyConnected(g1)
	 * 
	 * g2 = Graph(4) g2.AddDirectedEdge(0, 1) g2.AddDirectedEdge(1, 2)
	 * g2.AddDirectedEdge(2, 3)
	 * 
	 * print isStronglyConnected(g2)
	 */

	public void stronglyConnectedComponent(Graph gph) {
		int count = gph.count;
		boolean[] visited = new boolean[count];
		for (int i = 0; i < count; i++) {
			visited[i] = false;
		}
		Stack<Integer> stk = new Stack<Integer>();

		for (int i = 0; i < count; i++) {
			if (visited[i] == false) {
				DFSRec2(gph, i, visited, stk);
			}
		}
		Graph gReversed = TransposeGraph(gph);
		for (int i = 0; i < count; i++) {
			visited[i] = false;
		}
		Stack<Integer> stk2 = new Stack<Integer>();
		while (stk.isEmpty() == false) {
			int index = stk.pop();
			if (visited[index] == false) {
				DFSRec2(gReversed, index, visited, stk2);
				System.out.println(stk2.toString());
				stk2.removeAllElements();
			}
		}
	}

	/*
	 * graph = Graph(7) graph.AddDirectedEdge(0, 1) graph.AddDirectedEdge(1, 2)
	 * graph.AddDirectedEdge(2, 0) graph.AddDirectedEdge(2, 3)
	 * graph.AddDirectedEdge(3, 4) graph.AddDirectedEdge(4, 5)
	 * graph.AddDirectedEdge(5, 3) graph.AddDirectedEdge(5, 6)
	 * stronglyConnectedComponent(graph)
	 */

	/*
	 * Given a directed graph, find transitive closure matrix or reach ability
	 * matrix vertex v is reachable form vertex u if their is a path from u to
	 * v.
	 */
	public void TransitiveClosureUtil(Graph gph, int source, int index, int[][] tc) {
		if (tc[source][index] == 1) {
			return;
		}
		tc[source][index] = 1;
		List<AdjNode> adl = gph.array.get(index);
		for (AdjNode adn : adl) {
			TransitiveClosureUtil(gph, source, adn.dest, tc);
		}
	}

	public void TransitiveClosure(Graph gph) {
		int count = gph.count;
		int tc[][] = new int[count][count];
		for (int i = 0; i < count; i++) {
			TransitiveClosureUtil(gph, i, i, tc);
		}
		System.out.println(tc.toString());
	}

	/*
	 * g = Graph(4) g.AddDirectedEdge(0, 1)d g.AddDirectedEdge(0, 2)
	 * g.AddDirectedEdge(1, 2) g.AddDirectedEdge(2, 0) g.AddDirectedEdge(2, 3)
	 * g.AddDirectedEdge(3, 3) g.Print() TransitiveClosure(g)
	 */

	public int countAllPathDFS(Graph gph, boolean[] visited, int source, int dest) {
		if (source == dest) {
			return 1;
		}

		int count = 0;
		visited[source] = true;
		List<AdjNode> adl = gph.array.get(source);
		for (AdjNode adn : adl) {
			if (visited[adn.dest] == false) {
				count += countAllPathDFS(gph, visited, adn.dest, dest);
			}
			visited[source] = false;
		}
		return count;
	}

	public int countAllPath(Graph gph, int src, int dest) {
		int count = gph.count;
		boolean[] visited = new boolean[count];
		for (int i = 0; i < count; i++) {
			visited[i] = false;
		}
		return countAllPathDFS(gph, visited, src, dest);
	}

	public void printAllPathDFS(Graph gph, boolean[] visited, int source, int dest, Stack<Integer> path) {
		path.push(source);
		if (source == dest) {
			System.out.println(path);
			return;
		}

		visited[source] = true;
		List<AdjNode> adl = gph.array.get(source);
		for (AdjNode adn : adl) {
			if (visited[adn.dest] == false) {
				printAllPathDFS(gph, visited, adn.dest, dest, path);
			}
		}
		visited[source] = false;
		path.pop();
	}

	public void printAllPath(Graph gph, int src, int dest) {
		boolean[] visited = new boolean[gph.count];
		Stack<Integer> path = new Stack<Integer>();
		printAllPathDFS(gph, visited, src, dest, path);
	}
	/*
	 * g = Graph(5) g.AddDirectedEdge(0, 1) g.AddDirectedEdge(0, 2)
	 * g.AddDirectedEdge(2, 3) g.AddDirectedEdge(1, 3) g.AddDirectedEdge(3, 4)
	 * g.AddDirectedEdge(1, 4) print countAllPath(g, 0, 4) printAllPath(g, 0, 4)
	 */

	public int HightTreeParentArr(int[] arr) {
		int count = arr.length;
		int[] heightArr = new int[count];
		Graph gph = new Graph(count);
		int source = 0;
		for (int i = 0; i < count; i++) {
			if (arr[i] != -1) {
				gph.AddDirectedEdge(arr[i], i);
			} else {
				source = i;
			}
		}
		boolean[] visited = new boolean[count];
		for (int i = 0; i < count; i++) {
			visited[i] = false;
		}

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
			List<AdjNode> adl = gph.array.get(curr);
			for (AdjNode adn : adl) {
				if (visited[adn.dest] == false) {
					visited[adn.dest] = true;
					que.add(adn.dest);
					heightArr[adn.dest] = height + 1;
				}
			}
		}
		return maxHight;
	}

	public int getHeight(int[] arr, int[] height, int index) {
		if (arr[index] == -1) {
			return 0;
		} else {
			return getHeight(arr, height, arr[index]) + 1;
		}
	}

	public int HightTreeParentArr2(int[] arr) {
		int count = arr.length;
		int[] height = new int[count];
		int maxHeight = -1;
		for (int i = 0; i < count; i++) {
			height[i] = getHeight(arr, height, i);
			maxHeight = max(maxHeight, height[i]);
		}
		return maxHeight;
	}

	/*
	 * parentArray = [-1, 0, 1, 2, 3] print HightTreeParentArr(parentArray)
	 * print HightTreeParentArr2(parentArray) parentArray = [-1, 0, 0, 0, 3, 1,
	 * 1, 2] print HightTreeParentArr(parentArray) print
	 * HightTreeParentArr2(parentArray)
	 */

	private int max(int i, int j) {
		if (i > j) {
			return i;
		}
		return j;
	}

	public int BestFirstSearchPQ(Graph gph, int source, int dest) {

		int[] previous = new int[gph.count];
		int[] dist = new int[gph.count];
		boolean[] visited = new boolean[gph.count];

		for (int i = 0; i < gph.count; i++) {
			previous[i] = -1;
			dist[i] = Integer.MAX_VALUE; // infinite
			visited[i] = false;
		}
		AdjNodeComparator comp = new AdjNodeComparator();
		PriorityQueue<AdjNode> pq = new PriorityQueue<AdjNode>(100, comp);
		dist[source] = 0;
		previous[source] = -1;
		AdjNode node = new AdjNode(source, 0);
		pq.add(node);

		while (pq.isEmpty() != true) {
			node = pq.peek();
			pq.remove();
			source = node.dest;
			if (source == dest) {
				return node.cost;
			}
			visited[source] = true;

			List<AdjNode> adl = gph.array.get(source);
			for (AdjNode adn : adl) {
				int curr = adn.dest;
				int cost = adn.cost;
				int alt = cost + dist[source];
				if (dist[curr] > alt && visited[curr] == false) {
					dist[curr] = alt;
					previous[curr] = source;
					node = new AdjNode(curr, alt);
					pq.add(node);
				}
			}
		}
		return -1;
	}
}
/*
 * Graph gph = new Graph(5) g.AddDirectedEdge(0, 1, 3) g.AddDirectedEdge(0, 4,
 * 2) g.AddDirectedEdge(1, 2, 1) g.AddDirectedEdge(2, 3, 1) g.AddDirectedEdge(4,
 * 1, -2) g.AddDirectedEdge(4, 3, 1) g.Print() BellmanFordShortestPath(g, 0)
 * 
 * graph = Graph(9) graph.AddUndirectedEdge(0, 1, 4) graph.AddUndirectedEdge(0,
 * 7, 8) graph.AddUndirectedEdge(1, 2, 8) graph.AddUndirectedEdge(1, 7, 11)
 * graph.AddUndirectedEdge(2, 3, 7) graph.AddUndirectedEdge(2, 8, 2)
 * graph.AddUndirectedEdge(2, 5, 4) graph.AddUndirectedEdge(3, 4, 9)
 * graph.AddUndirectedEdge(3, 5, 14) graph.AddUndirectedEdge(4, 5, 10)
 * graph.AddUndirectedEdge(5, 6, 2) graph.AddUndirectedEdge(6, 7, 1)
 * graph.AddUndirectedEdge(6, 8, 6) graph.AddUndirectedEdge(7, 8, 7)
 * Prims(graph) Dijkstra(graph, 0)
 * 
 * g = Graph(7) g.AddDirectedEdge(0, 1) g.AddDirectedEdge(0, 2)
 * g.AddDirectedEdge(1, 3) g.AddDirectedEdge(4, 1) g.AddDirectedEdge(6, 4)
 * g.AddDirectedEdge(5, 6) g.AddDirectedEdge(5, 2) g.AddDirectedEdge(6, 0)
 * g.Print() RootVertex(g)
 * 
 * g = Graph(6) g.AddDirectedEdge(5, 2) g.AddDirectedEdge(5, 0)
 * g.AddDirectedEdge(4, 0) g.AddDirectedEdge(4, 1) g.AddDirectedEdge(2, 3)
 * g.AddDirectedEdge(3, 1) TopologicalSort(g)
 * 
 */