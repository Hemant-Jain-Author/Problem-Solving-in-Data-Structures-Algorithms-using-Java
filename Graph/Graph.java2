import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;

public class Graph {

	private static class AdjNode {
		private int source;
		private int destination;
		private int cost;
		private AdjNode next;

		public AdjNode(int src, int dst, int cst) {
			source = src;
			destination = dst;
			cost = cst;
			next = null;
		}

		public AdjNode(int src, int dst) {
			this(src, dst, 1);
		}
	}

	private static class AdjList {
		private AdjNode head;
	}

	int count;
	AdjList[] array;

	public Graph(int cnt) {
		count = cnt;
		array = new AdjList[cnt];
		for (int i = 0; i < cnt; i++) {
			array[i] = new AdjList();
			array[i].head = null;
		}
	}

	public void AddEdge(int source, int destination, int cost) {
		AdjNode node = new AdjNode(source, destination, cost);
		node.next = array[source].head;
		array[source].head = node;
	}

	public void AddEdge(int source, int destination) {
		AddEdge(source, destination, 1);
	}

	public void AddBiEdge(int source, int destination, int cost)// bi
																// directional
																// edge
	{
		AddEdge(source, destination, cost);
		AddEdge(destination, source, cost);
	}

	public void AddBiEdge(int source, int destination)// bi directional edge
	{
		AddBiEdge(source, destination, 1);
	}

	public void Print() {
		AdjNode ad;
		for (int i = 0; i < count; i++) {
			ad = array[i].head;
			if (ad != null) {
				System.out.print("Vertex " + i + " is connected to : ");
				while (ad != null) {
					System.out.print(ad.destination + " ");
					ad = ad.next;
				}
				System.out.println("");
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

		for (int i = 0; i < gph.count; i++) {
			previous[i] = -1;
			dist[i] = Integer.MAX_VALUE; // infinite
		}

		dist[source] = 0;
		previous[source] = -1;

		AdjNodeComparator comp = new AdjNodeComparator();
		PriorityQueue<AdjNode> queue = new PriorityQueue<AdjNode>(100, comp);

		AdjNode node = new AdjNode(source, source, 0);
		queue.add(node);

		while (queue.isEmpty() != true) {
			node = queue.peek();
			queue.remove();

			AdjList adl = gph.array[node.destination];
			AdjNode adn = adl.head;
			while (adn != null) {
				int alt = adn.cost + dist[adn.source];
				if (alt < dist[adn.destination]) {
					dist[adn.destination] = alt;
					previous[adn.destination] = adn.source;
					node = new AdjNode(adn.source, adn.destination, alt);
					queue.add(node);
				}
				adn = adn.next;
			}
		}

		int count = gph.count;
		for (int i = 0; i < count; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.println(" node id " + i + "  prev " + previous[i] + " distance : Unreachable");
			} else {
				System.out.println(" node id " + i + "  prev " + previous[i] + " distance : " + dist[i]);

			}
		}
	}

	public static void Prims(Graph gph) {
		int[] previous = new int[gph.count];
		int[] dist = new int[gph.count];
		int source = 1;

		for (int i = 0; i < gph.count; i++) {
			previous[i] = -1;
			dist[i] = Integer.MAX_VALUE;
		}

		dist[source] = 0;
		previous[source] = -1;

		AdjNodeComparator comp = new AdjNodeComparator();
		PriorityQueue<AdjNode> queue = new PriorityQueue<AdjNode>(100, comp);

		AdjNode node = new AdjNode(source, source, 0);
		queue.add(node);

		while (queue.isEmpty() != true) {
			node = queue.peek();
			queue.remove();

			if(dist[node.destination] < node.cost)
                continue;
            
            dist[node.destination] = node.cost;
            previous[node.destination] = node.source;
            
			
			AdjList adl = gph.array[node.destination];
			AdjNode adn = adl.head;

			while (adn != null) {
                if (previous[adn.destination]==-1)
                {
                	node = new AdjNode(adn.source, adn.destination, adn.cost);
                	queue.add(node);
                }
				adn = adn.next;
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

	private static void TopologicalSortDFS(Graph gph, int index, int[] visited, Stack<Integer> stk) {
		AdjNode head = gph.array[index].head;
		while (head != null) {
			if (visited[head.destination] == 0) {
				visited[head.destination] = 1;
				TopologicalSortDFS(gph, head.destination, visited, stk);
			}
			head = head.next;
		}
		stk.push(index);
	}

	public static void TopologicalSort(Graph gph) {
		Stack<Integer> stk = new Stack<Integer>();
		int count = gph.count;
		int[] visited = new int[count];
		for (int i = 0; i < count; i++) {
			visited[i] = 0;
		}
		for (int i = 0; i < count; i++) {
			if (visited[i] == 0) {
				visited[i] = 1;
				TopologicalSortDFS(gph, i, visited, stk);
			}
		}
		while (stk.isEmpty() != true) {
			System.out.print(" " + stk.pop());
		}
	}

	public static int PathExist(Graph gph, int source, int destination) {
		int count = gph.count;
		int[] visited = new int[count];
		for (int i = 0; i < count; i++) {
			visited[i] = 0;
		}
		visited[source] = 1;
		DFSRec(gph, source, visited);
		return visited[destination];
	}

	public static void DFSRec(Graph gph, int index, int[] visited) {
		AdjNode head = gph.array[index].head;
		while (head != null) {
			if (visited[head.destination] == 0) {
				visited[head.destination] = 1;
				DFSRec(gph, head.destination, visited);
			}
			head = head.next;
		}
	}

	public void DFSStack(Graph gph) {
		int count = gph.count;
		int[] visited = new int[count];
		int curr;
		Stack<Integer> stk = new Stack<Integer>();
		for (int i = 0; i < count; i++) {
			visited[i] = 0;
		}

		visited[0] = 1;
		stk.push(0);

		while (stk.isEmpty() == false) {
			curr = stk.pop();
			AdjNode head = gph.array[curr].head;
			while (head != null) {
				if (visited[head.destination] == 0) {
					visited[head.destination] = 1;
					stk.push(head.destination);
				}
				head = head.next;
			}
		}
	}

	public void DFS(Graph gph) {
		int count = gph.count;
		int[] visited = new int[count];
		for (int i = 0; i < count; i++) {
			visited[i] = 0;
		}
		for (int i = 0; i < count; i++) {
			if (visited[i] == 0) {
				visited[i] = 1;
				DFSRec(gph, i, visited);
			}
		}
	}

	public void BFSQueue(Graph gph, int index, int[] visited) {
		int curr;
		LinkedList<Integer> que = new LinkedList<Integer>();

		visited[index] = 1;
		que.add(index);

		while (que.isEmpty() == false) {
			curr = que.remove();
			AdjNode head = gph.array[curr].head;
			while (head != null) {
				if (visited[head.destination] == 0) {
					visited[head.destination] = 1;
					que.add(head.destination);
				}
				head = head.next;
			}
		}
	}

	public void BFS(Graph gph) {
		int count = gph.count;
		int[] visited = new int[count];
		for (int i = 0; i < count; i++) {
			visited[i] = 0;
		}
		for (int i = 0; i < count; i++) {
			if (visited[i] == 0) {
				BFSQueue(gph, i, visited);
			}
		}
	}

	public boolean isConnected(Graph gph) {
		int count = gph.count;
		int[] visited = new int[count];
		for (int i = 0; i < count; i++) {
			visited[i] = 0;
		}
		visited[0] = 1;
		DFSRec(gph, 0, visited);
		for (int i = 0; i < count; i++) {
			if (visited[i] == 0) {
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

		Queue<Integer> que = new LinkedList<Integer>();

		for (int i = 0; i < count; i++) {
			distance[i] = -1;
		}
		que.add(source);
		distance[source] = 0;
		while (que.isEmpty() == false) {
			curr = que.remove();
			AdjNode head = gph.array[curr].head;
			while (head != null) {
				if (distance[head.destination] == -1) {
					distance[head.destination] = distance[curr] + 1;
					path[head.destination] = curr;
					que.add(head.destination);
				}
				head = head.next;
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
		}
		distance[source] = 0;
		for (int i = 0; i < count - 1; i++) {
			for (int j = 0; j < count; j++) {
				AdjNode head = gph.array[j].head;
				while (head != null) {
					int newDistance = distance[j] + head.cost;
					if (distance[head.destination] > newDistance) {
						distance[head.destination] = newDistance;
						path[head.destination] = j;
					}
					head = head.next;
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

		//Dijkstra(gph, 1);
	 Prims(gph);
	}
}