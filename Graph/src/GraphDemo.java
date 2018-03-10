
public class GraphDemo {
	public static void main(String[] args) {
		Graph g = new Graph(6);
		g.AddEdge(5, 2);
		g.AddEdge(5, 0);
		g.AddEdge(4, 0);
		g.AddEdge(4, 1);
		g.AddEdge(2, 3);
		g.AddEdge(3, 1);

		System.out.println("Following is a Topological Sort of the given graph.");
		Graph.TopologicalSort(g);
	}
}
