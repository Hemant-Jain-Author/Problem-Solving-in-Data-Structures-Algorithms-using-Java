import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;

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

    public void addUndirectedEdge(int src, int dst, int cost) {
        addDirectedEdge(src, dst, cost);
        addDirectedEdge(dst, src, cost);
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.print("Node index [ " + i + " ] is connected with : ");
            for (int j = 0; j < count; j++) {
                if (adj[i][j] != 0)
                    System.out.print(j + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        GraphAM graph = new GraphAM(4);
        graph.addUndirectedEdge(0, 1, 1);
        graph.addUndirectedEdge(0, 2, 1);
        graph.addUndirectedEdge(1, 2, 1);
        graph.addUndirectedEdge(2, 3, 1);
        graph.print();
    }

    private static class Edge {
        private int dest;
        private int cost;

        public Edge(int dst, int cst) {
            dest = dst;
            cost = cst;
        }
    }

    static class EdgeComparator implements Comparator<Edge> {
        public int compare(Edge x, Edge y) {
            if (x.cost < y.cost) {
                return -1;
            }
            if (x.cost > y.cost) {
                return 1;
            }
            return 0;
        }
    }

    public static void dijkstra(GraphAM gph, int source) {
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

        EdgeComparator comp = new EdgeComparator();
        PriorityQueue<Edge> queue = new PriorityQueue<Edge>(100, comp);

        Edge node = new Edge(source, 0);
        queue.add(node);

        while (queue.isEmpty() != true) {
            node = queue.peek();
            queue.remove();
            source = node.dest;
            visited[source] = true;
            for (int dest = 0; dest < gph.count; dest++) {
                int cost = gph.adj[source][dest];
                if (cost != 0) {
                    int alt = cost + dist[source];
                    if (dist[dest] > alt && visited[dest] == false) {

                        dist[dest] = alt;
                        previous[dest] = source;
                        node = new Edge(dest, alt);
                        queue.add(node);
                    }
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

    public static void prims(GraphAM gph) {
        int[] previous = new int[gph.count];
        int[] dist = new int[gph.count];
        int source = 0;
        boolean[] visited = new boolean[gph.count];

        for (int i = 0; i < gph.count; i++) {
            previous[i] = -1;
            dist[i] = Integer.MAX_VALUE; // infinite
            visited[i] = false;
        }

        dist[source] = 0;
        previous[source] = -1;

        EdgeComparator comp = new EdgeComparator();
        PriorityQueue<Edge> queue = new PriorityQueue<Edge>(100, comp);

        Edge node = new Edge(source, 0);
        queue.add(node);

        while (queue.isEmpty() != true) {
            node = queue.peek();
            queue.remove();
            source = node.dest;
            visited[source] = true;
            for (int dest = 0; dest < gph.count; dest++) {
                int cost = gph.adj[source][dest];
                if (cost != 0) {
                    int alt = cost;
                    if (dist[dest] > alt && visited[dest] == false) {

                        dist[dest] = alt;
                        previous[dest] = source;
                        node = new Edge(dest, alt);
                        queue.add(node);
                    }
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

    public static void main40(String[] args) {
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
        gph.print();
        prims(gph);
        dijkstra(gph, 0);
    }

    public static void main41(String[] args) {
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
        gph.print();
        prims(gph);
        dijkstra(gph, 1);
    }

    public static boolean hamiltonianPathUtil(GraphAM graph, int path[], int pSize, int added[]) {
        // Base case full length path is found
        if (pSize == graph.count) {
            return true;
        }
        for (int vertex = 0; vertex < graph.count; vertex++) {
            // there is a path from last element and next vertex
            // and next vertex is not already included in path.
            if (pSize == 0 || (graph.adj[path[pSize - 1]][vertex] == 1 && added[vertex] == 0)) {
                path[pSize++] = vertex;
                added[vertex] = 1;
                if (hamiltonianPathUtil(graph, path, pSize, added))
                    return true;
                // backtracking
                pSize--;
                added[vertex] = 0;
            }
        }
        return false;
    }

    public static boolean hamiltonianPath(GraphAM graph) {
        int[] path = new int[graph.count];
        int[] added = new int[graph.count];

        if (hamiltonianPathUtil(graph, path, 0, added)) {
            System.out.println("Hamiltonian Path found :: ");
            for (int i = 0; i < graph.count; i++)
                System.out.println(" " + path[i]);

            return true;
        }

        System.out.println("Hamiltonian Path not found");
        return false;
    }

    public static boolean hamiltonianCycleUtil(GraphAM graph, int path[], int pSize, int added[]) {
        // Base case full length path is found
        // this last check can be modified to make it a path.
        if (pSize == graph.count) {
            if (graph.adj[path[pSize - 1]][path[0]] == 1) {
                path[pSize] = path[0];
                return true;
            } else
                return false;
        }
        for (int vertex = 0; vertex < graph.count; vertex++) {
            // there is a path from last element and next vertex
            if (pSize == 0 || (graph.adj[path[pSize - 1]][vertex] == 1 && added[vertex] == 0)) {
                path[pSize++] = vertex;
                added[vertex] = 1;
                if (hamiltonianCycleUtil(graph, path, pSize, added))
                    return true;
                // backtracking
                pSize--;
                added[vertex] = 0;
            }
        }
        return false;
    }

    public static boolean hamiltonianCycle(GraphAM graph) {
        int[] path = new int[graph.count + 1];
        int[] added = new int[graph.count];
        if (hamiltonianCycleUtil(graph, path, 0, added)) {
            System.out.println("Hamiltonian Cycle found :: ");
            for (int i = 0; i <= graph.count; i++)
                System.out.print(" " + path[i]);
            return true;
        }
        System.out.println("Hamiltonian Cycle not found");
        return false;
    }

    public static void main2(String[] args) {
        int count = 5;
        GraphAM graph = new GraphAM(count);
        int[][] adj = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 1 }, { 0, 1, 1, 1, 0 } };

        for (int i = 0; i < count; i++)
            for (int j = 0; j < count; j++)
                if (adj[i][j] == 1)
                    graph.addDirectedEdge(i, j, 1);
        System.out.println("hamiltonianPath : " + hamiltonianPath(graph));
        System.out.println("hamiltonianCycle : " + hamiltonianCycle(graph));

        GraphAM graph2 = new GraphAM(count);
        int[][] adj2 = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 0 },
                { 0, 1, 1, 0, 0 } };
        for (int i = 0; i < count; i++)
            for (int j = 0; j < count; j++)
                if (adj2[i][j] == 1)
                    graph2.addDirectedEdge(i, j, 1);

        System.out.println("hamiltonianPath :  " + hamiltonianPath(graph2));
        System.out.println("hamiltonianCycle :  " + hamiltonianCycle(graph2));
    }

}