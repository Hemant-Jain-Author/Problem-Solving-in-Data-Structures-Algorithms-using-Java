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

    public static void main1() {
        GraphAM graph = new GraphAM(4);
        graph.addUndirectedEdge(0, 1, 1);
        graph.addUndirectedEdge(0, 2, 1);
        graph.addUndirectedEdge(1, 2, 1);
        graph.addUndirectedEdge(2, 3, 1);
        graph.print();
    }
/*
Node index [ 0 ] is connected with : 1 2 
Node index [ 1 ] is connected with : 0 2 
Node index [ 2 ] is connected with : 0 1 3 
Node index [ 3 ] is connected with : 2 
*/
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
                System.out.println("node id " + i + "  prev " + previous[i] + " distance : Unreachable");
            } else {
                System.out.println("node id " + i + "  prev " + previous[i] + " distance : " + dist[i]);

            }
        }
    }

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
        gph.print();
        prims(gph);
        dijkstra(gph, 0);
    }
/*
Node index [ 0 ] is connected with : 1 7 
Node index [ 1 ] is connected with : 0 2 7 
Node index [ 2 ] is connected with : 1 3 5 8 
Node index [ 3 ] is connected with : 2 4 5 
Node index [ 4 ] is connected with : 3 5 
Node index [ 5 ] is connected with : 2 3 4 6 
Node index [ 6 ] is connected with : 5 7 8 
Node index [ 7 ] is connected with : 0 1 6 8 
Node index [ 8 ] is connected with : 2 6 7 


node id 0  prev -1 distance : 0
node id 1  prev 0 distance : 4
node id 2  prev 5 distance : 4
node id 3  prev 2 distance : 7
node id 4  prev 3 distance : 9
node id 5  prev 6 distance : 2
node id 6  prev 7 distance : 1
node id 7  prev 0 distance : 8
node id 8  prev 2 distance : 2

node id 0  prev -1 distance : 0
node id 1  prev 0 distance : 4
node id 2  prev 1 distance : 12
node id 3  prev 2 distance : 19
node id 4  prev 5 distance : 21
node id 5  prev 6 distance : 11
node id 6  prev 7 distance : 9
node id 7  prev 0 distance : 8
node id 8  prev 2 distance : 14

*/

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
        gph.print();
        prims(gph);
        dijkstra(gph, 1);
    }
/*
Node index [ 0 ] is connected with : 2 
Node index [ 1 ] is connected with : 2 3 4 
Node index [ 2 ] is connected with : 0 1 3 
Node index [ 3 ] is connected with : 1 2 5 
Node index [ 4 ] is connected with : 1 5 6 
Node index [ 5 ] is connected with : 3 4 7 
Node index [ 6 ] is connected with : 4 7 
Node index [ 7 ] is connected with : 5 6 8 
Node index [ 8 ] is connected with : 7 

node id 0  prev -1 distance : 0
node id 1  prev 2 distance : 5
node id 2  prev 0 distance : 1
node id 3  prev 2 distance : 2
node id 4  prev 5 distance : 6
node id 5  prev 3 distance : 4
node id 6  prev 4 distance : 3
node id 7  prev 5 distance : 1
node id 8  prev 7 distance : 17

node id 0  prev 2 distance : 6
node id 1  prev -1 distance : 0
node id 2  prev 1 distance : 5
node id 3  prev 1 distance : 7
node id 4  prev 1 distance : 9
node id 5  prev 3 distance : 11
node id 6  prev 4 distance : 12
node id 7  prev 5 distance : 12
node id 8  prev 7 distance : 29
*/
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
            System.out.print("Hamiltonian Path found :: ");
            for (int i = 0; i < graph.count; i++)
                System.out.print(" " + path[i]);
            System.out.println("");
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
            System.out.print("Hamiltonian Cycle found :: ");
            for (int i = 0; i <= graph.count; i++)
                System.out.print(" " + path[i]);
            System.out.println("");
            return true;
        }
        System.out.println("Hamiltonian Cycle not found");
        return false;
    }

    public static void main4() {
        int count = 5;
        GraphAM graph = new GraphAM(count);
        int[][] adj = { 
            { 0, 1, 0, 1, 0 }, 
            { 1, 0, 1, 1, 0 }, 
            { 0, 1, 0, 0, 1 }, 
            { 1, 1, 0, 0, 1 }, 
            { 0, 1, 1, 1, 0 } };

        for (int i = 0; i < count; i++)
            for (int j = 0; j < count; j++)
                if (adj[i][j] == 1)
                    graph.addDirectedEdge(i, j, 1);
        System.out.println("hamiltonianPath : " + hamiltonianPath(graph));
        System.out.println("hamiltonianCycle : " + hamiltonianCycle(graph));

        GraphAM graph2 = new GraphAM(count);
        int[][] adj2 = { 
            { 0, 1, 0, 1, 0 }, 
            { 1, 0, 1, 1, 0 }, 
            { 0, 1, 0, 0, 1 }, 
            { 1, 1, 0, 0, 0 },
            { 0, 1, 1, 0, 0 } };
        for (int i = 0; i < count; i++)
            for (int j = 0; j < count; j++)
                if (adj2[i][j] == 1)
                    graph2.addDirectedEdge(i, j, 1);

        System.out.println("hamiltonianPath :  " + hamiltonianPath(graph2));
        System.out.println("hamiltonianCycle :  " + hamiltonianCycle(graph2));
    }
/*
Hamiltonian Path found ::  0 1 2 4 3
hamiltonianPath : true

Hamiltonian Cycle found ::  0 1 2 4 3 0
hamiltonianCycle : true

Hamiltonian Path found ::  0 3 1 2 4
hamiltonianPath :  true

Hamiltonian Cycle not found
hamiltonianCycle :  false
*/
    public static void main(String[] args) {
            //main1();
            //main2(); 
            //main3(); 
            main4(); 
    }
}