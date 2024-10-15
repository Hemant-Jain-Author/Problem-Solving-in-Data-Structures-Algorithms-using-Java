import java.util.Arrays;
import java.util.PriorityQueue;

public class GraphAM {
	int count;
	int[][] adj;

	GraphAM(int cnt) {
		count = cnt;
		adj = new int[count][count];
	}

	public void addDirectedEdge(int src, int dst, int cost) {
		adj[src][dst] = cost;
	}
	
	public void addDirectedEdge(int src, int dst) {
		addDirectedEdge(src, dst, 1);
	}

	public void addUndirectedEdge(int src, int dst, int cost) {
		addDirectedEdge(src, dst, cost);
		addDirectedEdge(dst, src, cost);
	}
	
	public void addUndirectedEdge(int src, int dst) {
		addDirectedEdge(src, dst, 1);
		addDirectedEdge(dst, src, 1);
	}
	
	public void print() {
		for (int i = 0; i < count; i++) {
			System.out.print("Vertex " + i + " is connected to : ");
		for (int j = 0; j < count; j++) {
			if (adj[i][j] != 0)
				System.out.print( j + "(cost: " + adj[i][j] + ") ");
		}
		System.out.println();
	}
}

// Testing code.
public static void main1() {
	GraphAM gph = new GraphAM(4);
	gph.addUndirectedEdge(0, 1);
	gph.addUndirectedEdge(0, 2);
	gph.addUndirectedEdge(1, 2);
	gph.addUndirectedEdge(2, 3);
	gph.print();
}

/*
Vertex 0 is connected to : 1(cost: 1) 2(cost: 1) 
Vertex 1 is connected to : 0(cost: 1) 2(cost: 1) 
Vertex 2 is connected to : 0(cost: 1) 1(cost: 1) 3(cost: 1) 
Vertex 3 is connected to : 2(cost: 1) 
*/

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

public void dijkstra(int source) {
	int[] previous = new int[count];
	int[] dist = new int[count];
	boolean[] visited = new boolean[count];

	Arrays.fill(previous, -1);
	Arrays.fill(dist, Integer.MAX_VALUE); // infinite

	dist[source] = 0;
	previous[source] = source;

	PriorityQueue<Edge> queue = new PriorityQueue<Edge>(100);
	Edge node = new Edge(source, source, 0);
	queue.add(node);

	while (queue.isEmpty() != true) {
		node = queue.peek();
		queue.remove();
		int src = node.dest;
		visited[src] = true;
		for (int dest = 0; dest < count; dest++) {
			int cost = adj[src][dest];
			if (cost != 0) {
				int alt = cost + dist[src];
				if (dist[dest] > alt && visited[dest] == false) {

					dist[dest] = alt;
					previous[dest] = src;
					node = new Edge(src, dest, alt);
					queue.add(node);
				}
			}
		}
	}
	printPath(previous, dist, count, source);
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

public void primsMST() {
	int[] previous = new int[count];
	int[] dist = new int[count];
	
	boolean[] visited = new boolean[count];
	Arrays.fill(previous, -1);
	Arrays.fill(dist, Integer.MAX_VALUE); // infinite

	int source = 0;
	dist[source] = 0;
	previous[source] = source;

	PriorityQueue<Edge> queue = new PriorityQueue<Edge>(100);
	Edge node = new Edge(source, source, 0);
	queue.add(node);

	while (queue.isEmpty() != true) {
		node = queue.peek();
		queue.remove();
		source = node.dest;
		visited[source] = true;
		for (int dest = 0; dest < count; dest++) {
			int cost = adj[source][dest];
			if (cost != 0) {
				if (dist[dest] > cost && visited[dest] == false) {
					dist[dest] = cost;
					previous[dest] = source;
					node = new Edge(source, dest, cost);
					queue.add(node);
				}
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

// Testing code.
public static void main2() {
	GraphAM gph = new GraphAM(9);
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
	gph.primsMST();
}
/*
Edges are (0->1 @ 4) (5->2 @ 4) (2->3 @ 7) (3->4 @ 9) (6->5 @ 2) (7->6 @ 1) (0->7 @ 8) (2->8 @ 2) 
Total MST cost: 37
*/

// Testing code.
public static void main3() {
	GraphAM gph = new GraphAM(9);
	gph.addUndirectedEdge(0, 2, 1);
	gph.addUndirectedEdge(1, 2, 5);
	gph.addUndirectedEdge(1, 3, 7);
	gph.addUndirectedEdge(1, 4, 9);
	gph.addUndirectedEdge(3, 2, 2);
	gph.addUndirectedEdge(3, 5, 4);
	gph.addUndirectedEdge(4, 5, 6);
	gph.addUndirectedEdge(4, 6, 3);
	gph.addUndirectedEdge(5, 7, 1);
	gph.addUndirectedEdge(6, 7, 7);
	gph.addUndirectedEdge(7, 8, 17);
	gph.dijkstra(0);
}

/*
Shortest Paths: (0->2->1 @ 6) (0->2 @ 1) (0->2->3 @ 3) (0->2->3->5->4 @ 13) (0->2->3->5 @ 7) (0->2->3->5->7->6 @ 15) (0->2->3->5->7 @ 8) (0->2->3->5->7->8 @ 25) 
*/

public boolean hamiltonianPathUtil(int path[], int pSize, int added[]) {
	// Base case full length path is found
	if (pSize == count) {
		return true;
	}
	for (int vertex = 0; vertex < count; vertex++) {
		// There is an edge from last element of path and next vertex
		// and the next vertex is not already included in the path.
		if (pSize == 0 || (adj[path[pSize - 1]][vertex] == 1 && added[vertex] == 0)) {
			path[pSize++] = vertex;
			added[vertex] = 1;
			if (hamiltonianPathUtil(path, pSize, added))
				return true;
			// backtracking
			pSize--;
			added[vertex] = 0;
		}
	}
	return false;
}

public boolean hamiltonianPath() {
	int[] path = new int[count];
	int[] added = new int[count];

	if (hamiltonianPathUtil(path, 0, added)) {
		System.out.print("Hamiltonian Path found :: ");
		for (int i = 0; i < count; i++)
			System.out.print(" " + path[i]);
		System.out.println("");
		return true;
	}

	System.out.println("Hamiltonian Path not found");
	return false;
}

// Testing code.
public static void main4() {
	int count = 5;
	GraphAM gph = new GraphAM(count);
	int[][] adj = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 1 }, { 0, 1, 1, 1, 0 } };

	for (int i = 0; i < count; i++)
		for (int j = 0; j < count; j++)
			if (adj[i][j] == 1)
				gph.addDirectedEdge(i, j, 1);
	System.out.println("hamiltonianPath : " + gph.hamiltonianPath());

	GraphAM gph2 = new GraphAM(count);
	int[][] adj2 = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 0 },
			{ 0, 1, 1, 0, 0 } };
	for (int i = 0; i < count; i++)
		for (int j = 0; j < count; j++)
			if (adj2[i][j] == 1)
				gph2.addDirectedEdge(i, j, 1);

	System.out.println("hamiltonianPath :  " + gph2.hamiltonianPath());
}

/*
Hamiltonian Path found ::  0 1 2 4 3
hamiltonianPath : true

Hamiltonian Path found ::  0 3 1 2 4
hamiltonianPath :  true
*/

public boolean hamiltonianCycleUtil(int path[], int pSize, int added[]) {
	// Base case full length path is found
	// this last check can be modified to make it a path.
	if (pSize == count) {
		if (adj[path[pSize - 1]][path[0]] == 1) {
			path[pSize] = path[0];
			return true;
		} else
			return false;
	}
	for (int vertex = 0; vertex < count; vertex++) {
		// there is a path from last element and next vertex
		if (pSize == 0 || (adj[path[pSize - 1]][vertex] == 1 && added[vertex] == 0)) {
			path[pSize++] = vertex;
			added[vertex] = 1;
			if (hamiltonianCycleUtil(path, pSize, added))
				return true;
			// backtracking
			pSize--;
			added[vertex] = 0;
		}
	}
	return false;
}

public boolean hamiltonianCycle() {
	int[] path = new int[count + 1];
	int[] added = new int[count];
	if (hamiltonianCycleUtil(path, 0, added)) {
		System.out.print("Hamiltonian Cycle found :: ");
		for (int i = 0; i <= count; i++)
			System.out.print(" " + path[i]);
		System.out.println("");
		return true;
	}
	System.out.println("Hamiltonian Cycle not found");
	return false;
}

// Testing code.
public static void main5() {
	int count = 5;
	GraphAM gph = new GraphAM(count);
	int[][] adj = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 1 }, { 0, 1, 1, 1, 0 } };

	for (int i = 0; i < count; i++)
		for (int j = 0; j < count; j++)
			if (adj[i][j] == 1)
				gph.addDirectedEdge(i, j, 1);
	System.out.println("hamiltonianCycle : " + gph.hamiltonianCycle());

	GraphAM gph2 = new GraphAM(count);
	int[][] adj2 = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 0 },
			{ 0, 1, 1, 0, 0 } };
	for (int i = 0; i < count; i++)
		for (int j = 0; j < count; j++)
			if (adj2[i][j] == 1)
				gph2.addDirectedEdge(i, j, 1);

	System.out.println("hamiltonianCycle :  " + gph2.hamiltonianCycle());
}

/*
Hamiltonian Cycle found ::  0 1 2 4 3 0
hamiltonianCycle : true

Hamiltonian Cycle not found
hamiltonianCycle :  false
*/
	public static void main(String[] args) {
		main1();
		main2();
		main3(); 
		main4(); 
		main5();
	}
}