import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;

public class Graph {
    int count;
    private LinkedList<LinkedList<Edge>> Adj;

    private static class Edge {
        private int dest;
        private int cost;

        public Edge(int dst, int cst) {
            dest = dst;
            cost = cst;
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
        Edge edge = new Edge(dest, cost);
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
            System.out.print("\n Vertex " + i + " is connected to : ");
            for (Edge adn : ad) {
                System.out.print("(" + adn.dest + ", " + adn.cost + ") ");
            }
        }
    }

    public static boolean dfsStack(Graph gph, int source, int target) {
        int count = gph.count;
        boolean[] visited = new boolean[count];

        Stack<Integer> stk = new Stack<Integer>();
        stk.push(source);
        visited[source] = true;

        while (stk.isEmpty() == false) {
            int curr = stk.pop();
            LinkedList<Edge> adl = gph.Adj.get(curr);
            for (Edge adn : adl) {
                if (visited[adn.dest] == false) {
                    visited[adn.dest] = true;
                    stk.push(adn.dest);
                }
            }
        }
        return visited[target];
    }

    public static boolean dfs(Graph gph, int source, int target) {
        int count = gph.count;
        boolean[] visited = new boolean[count];
        dfsUtil(gph, source, visited);
        return visited[target];
    }

    public static void dfsUtil(Graph gph, int index, boolean[] visited) {
        visited[index] = true;
        LinkedList<Edge> adl = gph.Adj.get(index);
        for (Edge adn : adl) {
            if (visited[adn.dest] == false)
                dfsUtil(gph, adn.dest, visited);
        }
    }

    public static void dfsUtil2(Graph gph, int index, boolean[] visited, Stack<Integer> stk) {
        visited[index] = true;
        LinkedList<Edge> adl = gph.Adj.get(index);
        for (Edge adn : adl) {
            if (visited[adn.dest] == false) {
                dfsUtil2(gph, adn.dest, visited, stk);
            }
        }
        stk.push(index);
    }

    public static boolean bfs(Graph gph, int source, int target) {
        int count = gph.count;
        boolean[] visited = new boolean[count];
        LinkedList<Integer> que = new LinkedList<Integer>();
        que.add(source);
        visited[source] = true;

        while (que.isEmpty() == false) {
            int curr = que.remove();
            LinkedList<Edge> adl = gph.Adj.get(curr);
            for (Edge adn : adl) {
                if (visited[adn.dest] == false) {
                    visited[adn.dest] = true;
                    que.add(adn.dest);
                }
            }
        }
        return visited[target];
    }

    public static void main() {
        Graph gph = new Graph(5);
        gph.addDirectedEdge(0, 1, 3);
        gph.addDirectedEdge(0, 4, 2);
        gph.addDirectedEdge(1, 2, 1);
        gph.addDirectedEdge(2, 3, 1);
        gph.addDirectedEdge(4, 1, -2);
        gph.addDirectedEdge(4, 3, 1);
        gph.print();
        System.out.println(Graph.dfs(gph, 0, 2));
        System.out.println(Graph.bfs(gph, 0, 2));
        System.out.println(Graph.dfsStack(gph, 0, 2));
    }

    public static void topologicalSort(Graph gph) {
        Stack<Integer> stk = new Stack<Integer>();
        int count = gph.count;
        boolean[] visited = new boolean[count];

        for (int i = 0; i < count; i++) {
            if (visited[i] == false) {
                dfsUtil2(gph, i, visited, stk);
            }
        }
        System.out.print("topologicalSort :: ");
        while (stk.isEmpty() != true) {
            System.out.print(" " + stk.pop());
        }
    }

    public static void main5() {
        Graph gph = new Graph(6);
        gph.addDirectedEdge(5, 2, 1);
        gph.addDirectedEdge(5, 0, 1);
        gph.addDirectedEdge(4, 0, 1);
        gph.addDirectedEdge(4, 1, 1);
        gph.addDirectedEdge(2, 3, 1);
        gph.addDirectedEdge(3, 1, 1);
        gph.print();
        topologicalSort(gph);
    }

    public static boolean pathExist(Graph gph, int source, int dest) {
        int count = gph.count;
        boolean[] visited = new boolean[count];

        dfsUtil(gph, source, visited);
        return visited[dest];
    }

    public static int countAllPathDFS(Graph gph, boolean[] visited, int source, int dest) {
        if (source == dest) {
            return 1;
        }
        int count = 0;
        visited[source] = true;
        LinkedList<Edge> adl = gph.Adj.get(source);
        for (Edge adn : adl) {
            if (visited[adn.dest] == false) {
                count += countAllPathDFS(gph, visited, adn.dest, dest);
            }
            visited[source] = false;
        }
        return count;
    }

    public static int countAllPath(Graph gph, int src, int dest) {
        int count = gph.count;
        boolean[] visited = new boolean[count];
        return countAllPathDFS(gph, visited, src, dest);
    }

    public static void printAllPathDFS(Graph gph, boolean[] visited, int source, int dest, Stack<Integer> path) {
        path.push(source);

        if (source == dest) {
            System.out.println(path);
            path.pop();
            return;
        }
        visited[source] = true;
        LinkedList<Edge> adl = gph.Adj.get(source);
        for (Edge adn : adl) {
            if (visited[adn.dest] == false) {
                printAllPathDFS(gph, visited, adn.dest, dest, path);
            }
        }
        visited[source] = false;
        path.pop();
    }

    public static void printAllPath(Graph gph, int src, int dest) {
        boolean[] visited = new boolean[gph.count];
        Stack<Integer> path = new Stack<Integer>();
        printAllPathDFS(gph, visited, src, dest, path);
    }

    public static void main11() {
        Graph gph = new Graph(5);
        gph.addDirectedEdge(0, 1, 1);
        gph.addDirectedEdge(0, 2, 1);
        gph.addDirectedEdge(2, 3, 1);
        gph.addDirectedEdge(1, 3, 1);
        gph.addDirectedEdge(3, 4, 1);
        gph.addDirectedEdge(1, 4, 1);
        gph.print();
        System.out.println("PathExist :: " + pathExist(gph, 0, 4));

        System.out.println();
        System.out.println(countAllPath(gph, 0, 4));
        printAllPath(gph, 0, 4);
    }

    public static int rootVertex(Graph gph) {
        int count = gph.count;
        boolean[] visited = new boolean[count];
        int retVal = -1;
        for (int i = 0; i < count; i++) {
            if (visited[i] == false) {
                dfsUtil(gph, i, visited);
                retVal = i;
            }
        }
        System.out.print("Root vertex is :: " + retVal);
        return retVal;
    }

    public static void main4() {
        Graph gph = new Graph(7);
        gph.addDirectedEdge(0, 1, 1);
        gph.addDirectedEdge(0, 2, 1);
        gph.addDirectedEdge(1, 3, 1);
        gph.addDirectedEdge(4, 1, 1);
        gph.addDirectedEdge(6, 4, 1);
        gph.addDirectedEdge(5, 6, 1);
        gph.addDirectedEdge(5, 2, 1);
        gph.addDirectedEdge(6, 0, 1);
        gph.print();
        rootVertex(gph);
    }

    /*
     * Given a directed graph, find transitive closure matrix or reach ability
     * matrix vertex v is reachable form vertex u if their is a path from u to v.
     */

    public static void transitiveClosureUtil(Graph gph, int source, int dest, int[][] tc) {
        tc[source][dest] = 1;
        LinkedList<Edge> adl = gph.Adj.get(dest);
        for (Edge adn : adl) {
            if (tc[source][adn.dest] == 0)
                transitiveClosureUtil(gph, source, adn.dest, tc);
        }
    }

    public static int[][] transitiveClosure(Graph gph) {
        int count = gph.count;
        int tc[][] = new int[count][count];
        for (int i = 0; i < count; i++) {
            transitiveClosureUtil(gph, i, i, tc);
        }
        return tc;
    }

    public static void main10() {
        Graph gph = new Graph(4);
        gph.addDirectedEdge(0, 1, 1);
        gph.addDirectedEdge(0, 2, 1);
        gph.addDirectedEdge(1, 2, 1);
        gph.addDirectedEdge(2, 0, 1);
        gph.addDirectedEdge(2, 3, 1);
        gph.addDirectedEdge(3, 3, 1);
        int[][] tc = transitiveClosure(gph);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(tc[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfsLevelNode(Graph gph, int source) {
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
            LinkedList<Edge> adl = gph.Adj.get(curr);
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

    public static int bfsDistance(Graph gph, int source, int dest) {
        int count = gph.count;
        boolean[] visited = new boolean[count];
        LinkedList<Integer> que = new LinkedList<Integer>();
        que.add(source);
        visited[source] = true;
        int[] level = new int[count];
        level[source] = 0;

        while (que.isEmpty() == false) {
            int curr = que.remove();
            int depth = level[curr];
            LinkedList<Edge> adl = gph.Adj.get(curr);
            for (Edge adn : adl) {
                if (adn.dest == dest) {
                    return depth+1;
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

    public static void main1() {
        Graph gph = new Graph(7);
        gph.addUndirectedEdge(0, 1, 1);
        gph.addUndirectedEdge(0, 2, 1);
        gph.addUndirectedEdge(0, 4, 1);
        gph.addUndirectedEdge(1, 2, 1);
        gph.addUndirectedEdge(2, 5, 1);
        gph.addUndirectedEdge(3, 4, 1);
        gph.addUndirectedEdge(4, 5, 1);
        gph.addUndirectedEdge(4, 6, 1);
        gph.print();
        bfsLevelNode(gph, 1);
        System.out.println(bfsDistance(gph, 1, 6));
    }

    public static boolean isCyclePresentUndirectedDFS(Graph graph, int index, int parentIndex, boolean[] visited) {
        visited[index] = true;
        int dest;
        LinkedList<Edge> adl = graph.Adj.get(index);
        for (Edge adn : adl) {
            dest = adn.dest;
            if (visited[dest] == false) {
                if (isCyclePresentUndirectedDFS(graph, dest, index, visited))
                    return true;
            } else if (parentIndex != dest)
                return true;
        }
        return false;
    }

    public static boolean isCyclePresentUndirected(Graph graph) {
        int count = graph.count;
        boolean[] visited = new boolean[count];
        for (int i = 0; i < count; i++)
            if (visited[i] == false)
                if (isCyclePresentUndirectedDFS(graph, i, -1, visited))
                    return true;
        return false;
    }

    public static void main14() {
        Graph gph = new Graph(6);
        gph.addUndirectedEdge(0, 1, 1);
        gph.addUndirectedEdge(1, 2, 1);
        gph.addUndirectedEdge(3, 4, 1);
        gph.addUndirectedEdge(4, 2, 1);
        gph.addUndirectedEdge(2, 5, 1);
        // gph.addUndirectedEdge(4, 1, 1);
        System.out.println(isCyclePresentUndirected(gph));
    }

    /*
     * Given a directed graph find if there is a cycle in it.
     */
    public static boolean isCyclePresentDFS(Graph graph, int index, boolean[] visited, int[] marked) {
        visited[index] = true;
        marked[index] = 1;
        LinkedList<Edge> adl = graph.Adj.get(index);
        for (Edge adn : adl) {
            int dest = adn.dest;
            if (marked[dest] == 1)
                return true;

            if (visited[dest] == false)
                if (isCyclePresentDFS(graph, dest, visited, marked))
                    return true;
        }
        marked[index] = 0;
        return false;
    }

    public static boolean isCyclePresent(Graph graph) {
        int count = graph.count;
        boolean[] visited = new boolean[count];
        int[] marked = new int[count];
        for (int index = 0; index < count; index++) {
            if (visited[index] == false)
                if (isCyclePresentDFS(graph, index, visited, marked))
                    return true;
        }
        return false;
    }

    public static boolean isCyclePresentDFSColor(Graph graph, int index, int[] visited) {
        visited[index] = 1; // 1 = grey
        int dest;
        LinkedList<Edge> adl = graph.Adj.get(index);
        for (Edge adn : adl) {
            dest = adn.dest;
            if (visited[dest] == 1) // "Grey":
                return true;

            if (visited[dest] == 0) // "White":
                if (isCyclePresentDFSColor(graph, dest, visited))
                    return true;
        }
        visited[index] = 2; // "Black"
        return false;
    }

    public static boolean isCyclePresentColor(Graph graph) {
        int count = graph.count;
        int[] visited = new int[count];
        for (int i = 0; i < count; i++) {
            if (visited[i] == 0) // "White"
                if (isCyclePresentDFSColor(graph, i, visited))
                    return true;
        }
        return false;
    }

    public static void main13() {
        Graph gph = new Graph(5);
        gph.addDirectedEdge(0, 1, 1);
        gph.addDirectedEdge(0, 2, 1);
        gph.addDirectedEdge(2, 3, 1);
        gph.addDirectedEdge(1, 3, 1);
        gph.addDirectedEdge(3, 4, 1);
        gph.addDirectedEdge(4, 1, 1);
        System.out.println(isCyclePresentColor(gph));
    }

    public static Graph transposeGraph(Graph gph) {
        int count = gph.count;
        Graph g = new Graph(count);
        for (int i = 0; i < count; i++) {
            LinkedList<Edge> adl = gph.Adj.get(i);
            for (Edge adn : adl) {
                int dest = adn.dest;
                g.addDirectedEdge(dest, i);
            }
        }
        return g;
    }

    public static boolean isConnectedUndirected(Graph gph) {
        int count = gph.count;
        boolean[] visited = new boolean[count];

        dfsUtil(gph, 0, visited);
        for (int i = 0; i < count; i++) {
            if (visited[i] == false) {
                return false;
            }
        }
        return true;
    }

    /*
     * Kosaraju Algorithm
     * 
     * Kosaraju’s Algorithm to find strongly connected directed graph based on DFS :
     * 1) Create a visited array of size V, and Initialize all count in visited
     * array as 0. 2) Choose any vertex and perform a DFS traversal of graph. For
     * all visited count mark them visited as 1. 3) If DFS traversal does not mark
     * all count as 1, then return 0. 4) Find transpose or reverse of graph 5)
     * Repeat step 1, 2 and 3 for the reversed graph. 6) If DFS traversal mark all
     * the count as 1, then return 1.
     */
    public static boolean isStronglyConnected(Graph gph) {
        int count = gph.count;
        boolean visited[] = new boolean[count];

        dfsUtil(gph, 0, visited);
        for (int i = 0; i < count; i++) {
            if (visited[i] == false) {
                return false;
            }
        }
        Graph gReversed = transposeGraph(gph);
        for (int i = 0; i < count; i++) {
            visited[i] = false;
        }
        dfsUtil(gReversed, 0, visited);
        for (int i = 0; i < count; i++) {
            if (visited[i] == false) {
                return false;
            }
        }
        return true;
    }

    public static void main6() {
        Graph gph = new Graph(5);
        gph.addDirectedEdge(0, 1, 1);
        gph.addDirectedEdge(1, 2, 1);
        gph.addDirectedEdge(2, 3, 1);
        gph.addDirectedEdge(3, 0, 1);
        gph.addDirectedEdge(2, 4, 1);
        gph.addDirectedEdge(4, 2, 1);
        System.out.println(" IsStronglyConnected:: " + isStronglyConnected(gph));
    }

    public static void stronglyConnectedComponent(Graph gph) {
        int count = gph.count;
        boolean[] visited = new boolean[count];

        Stack<Integer> stk = new Stack<Integer>();
        for (int i = 0; i < count; i++) {
            if (visited[i] == false) {
                dfsUtil2(gph, i, visited, stk);
            }
        }
        Graph gReversed = transposeGraph(gph);
        for (int i = 0; i < count; i++) {
            visited[i] = false;
        }

        Stack<Integer> stk2 = new Stack<Integer>();
        while (stk.isEmpty() == false) {
            int index = stk.pop();
            if (visited[index] == false) {
                stk2.clear();
                dfsUtil2(gReversed, index, visited, stk2);
                System.out.println(stk2);
            }
        }
    }

    public static void main7() {
        Graph gph = new Graph(7);
        gph.addDirectedEdge(0, 1, 1);
        gph.addDirectedEdge(1, 2, 1);
        gph.addDirectedEdge(2, 0, 1);
        gph.addDirectedEdge(2, 3, 1);
        gph.addDirectedEdge(3, 4, 1);
        gph.addDirectedEdge(4, 5, 1);
        gph.addDirectedEdge(5, 3, 1);
        gph.addDirectedEdge(5, 6, 1);
        stronglyConnectedComponent(gph);
    }

    public static void prims(Graph gph) {
        int[] previous = new int[gph.count];
        int[] dist = new int[gph.count];
        boolean[] visited = new boolean[gph.count];
        int source = 1;

        for (int i = 0; i < gph.count; i++) {
            previous[i] = -1;
            dist[i] = 999999; // infinite
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
            visited[source] = true;
            source = node.dest;
            LinkedList<Edge> adl = gph.Adj.get(source);
            for (Edge adn : adl) {
                int dest = adn.dest;
                int alt = adn.cost;
                if (dist[dest] > alt && visited[dest] == false) {
                    dist[dest] = alt;
                    previous[dest] = source;
                    node = new Edge(dest, alt);
                    queue.add(node);
                }
            }
        }
        // printing result.
        int count = gph.count;
        for (int i = 0; i < count; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println(" node id " + i + "  prev " + previous[i] + " distance : Unreachable");
            } else {
                System.out.println(" node id " + i + "  prev " + previous[i] + " distance : " + dist[i]);

            }
        }
    }

    public static void main3() {
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
        gph.print();
        System.out.println();
        prims(gph);
        System.out.println();
        dijkstra(gph, 0);
    }

    public static void shortestPath(Graph gph, int source)// unweighted graph
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
            LinkedList<Edge> adl = gph.Adj.get(curr);
            for (Edge adn : adl) {
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

    public static void main9() {
        Graph gph = new Graph(9);
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
        bellmanFordshortestPath(gph, 1);
        // dijkstra(gph, 1);
        // prims(gph);
        System.out.println("isConnectedUndirected :: " + isConnectedUndirected(gph));
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

    public static void dijkstra(Graph gph, int source) {
        int[] previous = new int[gph.count];
        int[] dist = new int[gph.count];
        boolean[] visited = new boolean[gph.count];

        for (int i = 0; i < gph.count; i++) {
            previous[i] = -1;
            dist[i] = 999999; // infinite
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
            LinkedList<Edge> adl = gph.Adj.get(source);
            for (Edge adn : adl) {
                int dest = adn.dest;
                int alt = adn.cost + dist[source];
                if (dist[dest] > alt && visited[dest] == false) {

                    dist[dest] = alt;
                    previous[dest] = source;
                    node = new Edge(dest, alt);
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

    public static void bellmanFordshortestPath(Graph gph, int source) {
        int count = gph.count;
        int[] distance = new int[count];
        int[] path = new int[count];

        for (int i = 0; i < count; i++) {
            distance[i] = 999999; // infinite
            path[i] = -1;
        }
        distance[source] = 0;
        // Outer loop will run (V-1) number of times.
        // Inner for loop and while loop runs combined will
        // run for Edges number of times.
        // Which make the total complexity as O(V*E)

        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count; j++) {
                LinkedList<Edge> adl = gph.Adj.get(j);
                for (Edge adn : adl) {
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

    public static void main2() {
        Graph gph = new Graph(5);
        gph.addDirectedEdge(0, 1, 3);
        gph.addDirectedEdge(0, 4, 2);
        gph.addDirectedEdge(1, 2, 1);
        gph.addDirectedEdge(2, 3, 1);
        gph.addDirectedEdge(4, 1, -2);
        gph.addDirectedEdge(4, 3, 1);
        gph.print();
        System.out.println();
        bellmanFordshortestPath(gph, 0);
    }

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

    public static void main12() {
        int parentArray[] = { -1, 0, 1, 2, 3 };
        System.out.println(heightTreeParentArr(parentArray));
        System.out.println(heightTreeParentArr2(parentArray));
    }

    public static int bestFirstSearchPQ(Graph gph, int source, int dest) {
        int[] previous = new int[gph.count];
        int[] dist = new int[gph.count];
        boolean[] visited = new boolean[gph.count];
        for (int i = 0; i < gph.count; i++) {
            previous[i] = -1;
            dist[i] = 999999; // infinite
        }
        EdgeComparator comp = new EdgeComparator();
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(100, comp);
        dist[source] = 0;
        previous[source] = -1;
        Edge node = new Edge(source, 0);
        pq.add(node);

        while (pq.isEmpty() != true) {
            node = pq.peek();
            pq.remove();
            source = node.dest;
            if (source == dest) {
                return node.cost;
            }
            visited[source] = true;

            LinkedList<Edge> adl = gph.Adj.get(source);
            for (Edge adn : adl) {
                int curr = adn.dest;
                int cost = adn.cost;
                int alt = cost + dist[source];
                if (dist[curr] > alt && visited[curr] == false) {
                    dist[curr] = alt;
                    previous[curr] = source;
                    node = new Edge(curr, alt);
                    pq.add(node);
                }
            }
        }
        return -1;
    }

    public static boolean isConnected(Graph graph) {
        int count = graph.count;
        boolean[] visited = new boolean[count];

        // Find a vertex with non - zero degree
        // DFS traversal of graph from a vertex with non - zero degree
        LinkedList<Edge> adl;
        for (int i = 0; i < count; i++) {
            adl = graph.Adj.get(i);
            if (adl.size() > 0) {
                dfsUtil(graph, i, visited);
                break;
            }
        }
        // Check if all non - zero degree count are visited
        for (int i = 0; i < count; i++) {
            adl = graph.Adj.get(i);
            if (adl.size() > 0)
                if (visited[i] == false)
                    return false;
        }
        return true;
    }

    /*
     * The function returns one of the following values Return 0 if graph is not
     * Eulerian Return 1 if graph has an Euler path (Semi-Eulerian) Return 2 if
     * graph has an Euler Circuit (Eulerian)
     */
    public static int isEulerian(Graph graph) {
        int count = graph.count;
        int odd;
        int[] inDegree;
        int[] outDegree;
        LinkedList<Edge> adl;
        // Check if all non - zero degree nodes are connected
        if (isConnected(graph) == false) {
            System.out.println("graph is not Eulerian");
            return 0;
        } else {
            // Count odd degree
            odd = 0;
            inDegree = new int[count];
            outDegree = new int[count];

            for (int i = 0; i < count; i++) {
                adl = graph.Adj.get(i);
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

    public static void main15() {
        Graph gph = new Graph(5);
        gph.addDirectedEdge(1, 0, 1);
        gph.addDirectedEdge(0, 2, 1);
        gph.addDirectedEdge(2, 1, 1);
        gph.addDirectedEdge(0, 3, 1);
        gph.addDirectedEdge(3, 4, 1);
        System.out.println(isEulerian(gph));
    }

    public static boolean isStronglyConnected2(Graph graph) {
        int count = graph.count;
        boolean[] visited = new boolean[count];
        Graph gReversed;
        int index;
        // Find a vertex with non - zero degree
        LinkedList<Edge> adl;
        for (index = 0; index < count; index++) {
            adl = graph.Adj.get(index);
            if (adl.size() > 0)
                break;
        }
        // DFS traversal of graph from a vertex with non - zero degree
        dfsUtil(graph, index, visited);
        for (int i = 0; i < count; i++) {
            adl = graph.Adj.get(i);
            if (visited[i] == false && adl.size() > 0)
                return false;
        }

        gReversed = transposeGraph(graph);
        for (int i = 0; i < count; i++)
            visited[i] = false;
        dfsUtil(gReversed, index, visited);

        for (int i = 0; i < count; i++) {
            adl = graph.Adj.get(i);
            if (visited[i] == false && adl.size() > 0)
                return false;
        }
        return true;
    }

    public static boolean isEulerianCycle(Graph graph) {
        // Check if all non - zero degree count are connected
        int count = graph.count;
        int[] inDegree = new int[count];
        int[] outDegree = new int[count];
        if (!isStronglyConnected2(graph))
            return false;

        // Check if in degree and out degree of every vertex is same
        for (int i = 0; i < count; i++) {
            LinkedList<Edge> adl = graph.Adj.get(i);
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

    public static void main16() {
        Graph gph = new Graph(5);
        gph.addDirectedEdge(0, 1, 1);
        gph.addDirectedEdge(1, 2, 1);
        gph.addDirectedEdge(2, 0, 1);
        gph.addDirectedEdge(0, 4, 1);
        gph.addDirectedEdge(4, 3, 1);
        gph.addDirectedEdge(3, 0, 1);
        System.out.println(isEulerianCycle(gph));
    }

    public static void main(String[] args) {
        main();
        main10();
        /*
         * main2(); main3(); main4(); main5(); main6(); main7(); main8(); main9();
         * main10(); main11(); main12(); main13(); main14(); main15(); main16();
         */ }
}