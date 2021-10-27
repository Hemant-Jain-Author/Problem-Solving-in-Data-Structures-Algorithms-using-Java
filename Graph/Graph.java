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
                System.out.print("(" + adn.dest + ", " + adn.cost + ") ");
            }
            System.out.println();
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
                if (visited[adn.dest] == false)
                    dfsUtil2(gph, adn.dest, visited, stk);
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

    // Testing Code
    public static void main1() {
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

    /*
    Vertex 0 is connected to : (1, 3) (4, 2) 
    Vertex 1 is connected to : (2, 1) 
    Vertex 2 is connected to : (3, 1) 
    Vertex 3 is connected to : 
    Vertex 4 is connected to : (1, -2) (3, 1) 
    true
    true
    true
    */
    
    public static void topologicalSort(Graph gph) {
        Stack<Integer> stk = new Stack<Integer>();
        int count = gph.count;
        boolean[] visited = new boolean[count];

        for (int i = 0; i < count; i++) {
            if (visited[i] == false) {
                dfsUtil2(gph, i, visited, stk);
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
        topologicalSort(gph);
    }

    /*
        topologicalSort ::  1 4 6 3 5 7 8 0 2
    */
    
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
        }
        visited[source] = false;
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
            if (visited[adn.dest] == false)
                printAllPathDFS(gph, visited, adn.dest, dest, path);
        }
        visited[source] = false;
        path.pop();
    }

    public static void printAllPath(Graph gph, int src, int dest) {
        boolean[] visited = new boolean[gph.count];
        Stack<Integer> path = new Stack<Integer>();
        printAllPathDFS(gph, visited, src, dest, path);
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
        System.out.println("PathExist :: " + pathExist(gph, 0, 4));

        System.out.println();
        System.out.println(countAllPath(gph, 0, 4));
        printAllPath(gph, 0, 4);
    }

    /*
    Vertex 0 is connected to : (1, 1) (2, 1) 
    Vertex 1 is connected to : (3, 1) (4, 1) 
    Vertex 2 is connected to : (3, 1) 
    Vertex 3 is connected to : (4, 1) 
    Vertex 4 is connected to : 
    PathExist :: true

    3
    [0, 1, 3, 4]
    [0, 1, 4]
    [0, 2, 3, 4]
    */
    
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
        gph.print();
        rootVertex(gph);
    }
    
    /*
    Vertex 0 is connected to : (1, 1) (2, 1) 
    Vertex 1 is connected to : (3, 1) 
    Vertex 2 is connected to : 
    Vertex 3 is connected to : 
    Vertex 4 is connected to : (1, 1) 
    Vertex 5 is connected to : (6, 1) (2, 1) 
    Vertex 6 is connected to : (4, 1) (0, 1) 
    Root vertex is :: 5
    */
    
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

    // Testing Code
    public static void main5() {
        Graph gph = new Graph(4);
        gph.addDirectedEdge(0, 1);
        gph.addDirectedEdge(0, 2);
        gph.addDirectedEdge(1, 2);
        gph.addDirectedEdge(2, 0);
        gph.addDirectedEdge(2, 3);
        gph.addDirectedEdge(3, 3);
        int[][] tc = transitiveClosure(gph);
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

    public static void bfsLevelNode(Graph gph, int source) {
        int count = gph.count;
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
        gph.print();
        bfsLevelNode(gph, 1);
        System.out.println(bfsDistance(gph, 1, 6));
    }
    /*
    Vertex 0 is connected to : (1, 1) (2, 1) (4, 1) 
    Vertex 1 is connected to : (0, 1) (2, 1) 
    Vertex 2 is connected to : (0, 1) (1, 1) (5, 1) 
    Vertex 3 is connected to : (4, 1) 
    Vertex 4 is connected to : (0, 1) (3, 1) (5, 1) (6, 1) 
    Vertex 5 is connected to : (2, 1) (4, 1) 
    Vertex 6 is connected to : (4, 1) 

    Node  - Level
    1 - 0
    0 - 1
    2 - 1
    4 - 2
    5 - 2
    3 - 3
    6 - 3
    3
    */
    
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
        for (int i = 0; i < count; i++) {
            if (visited[i] == false && isCyclePresentUndirectedDFS(graph, i, -1, visited))
                    return true;
        }
        return false;
    }

    public static int find(int[] parent, int index) {
        int p = parent[index]; 
        while(p != -1) {
            index = p;
            p = parent[index];
        }
        return index;
    }

    public static void union(int[] parent, int x, int y) {
        parent[y] = x;
    }
        
    public static boolean isCyclePresentUndirected2(Graph gph) {
        int count = gph.count;
        int[] parent = new int[count];
        Arrays.fill(parent, -1);
        LinkedList<Edge> edge = new LinkedList<Edge>();
        
        boolean[][] flags = new boolean[count][count]; 
        for (int i = 0; i < count; i++) {
            LinkedList<Edge> ad = gph.Adj.get(i);
            for (Edge adn : ad) {
                // Using flags[][] array, if considered edge x to y, 
                // then ignore edge y to x.
                if(flags[adn.dest][adn.src] == false) {
                    edge.add(adn);
                    flags[adn.src][adn.dest] = true;
                }
            }
        }
        
        for (Edge e : edge) {
            int x = find(parent, e.src);
            int y = find(parent, e.dest);
            if(x == y) {
                return true;
            }
            union(parent, x, y);
        }
        return false;
    }

    public static boolean isCyclePresentUndirected3(Graph gph) {
        int count = gph.count;
        //Different subsets are created.
        Sets[] sets = new Sets[count];
        for (int i = 0; i < count; i++)
            sets[i] = new Sets(-1, 0);

        LinkedList<Edge> edge = new LinkedList<Edge>();
        boolean[][] flags = new boolean[count][count]; 
        for (int i = 0; i < count; i++) {
            LinkedList<Edge> ad = gph.Adj.get(i);
            for (Edge adn : ad) {
                // Using flags[][] array, if considered edge x to y, 
                // then ignore edge y to x.
                if(flags[adn.dest][adn.src] == false) {
                    edge.add(adn);
                    flags[adn.src][adn.dest] = true;
                }
            }
        }
        
        for (Edge e : edge) {
            int x = find(sets, e.src);
            int y = find(sets, e.dest);
            if(x == y) {
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
        gph.addUndirectedEdge(4, 1);
        System.out.println(isCyclePresentUndirected(gph));
        System.out.println(isCyclePresentUndirected2(gph));
        System.out.println(isCyclePresentUndirected3(gph));
    }

    /*
    false
    */
    
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
            if (!visited[index])
                if (isCyclePresentDFS(graph, index, visited, marked))
                    return true;
        }
        return false;
    }

    public static boolean isCyclePresentDFSColour(Graph graph, int index, int[] visited) {
        visited[index] = 1; // 1 = grey
        int dest;
        LinkedList<Edge> adl = graph.Adj.get(index);
        for (Edge adn : adl) {
            dest = adn.dest;
            if (visited[dest] == 1) // "Grey":
                return true;

            if (visited[dest] == 0) // "White":
                if (isCyclePresentDFSColour(graph, dest, visited))
                    return true;
        }
        visited[index] = 2; // "Black"
        return false;
    }

    public static boolean isCyclePresentColour(Graph graph) {
        int count = graph.count;
        int[] visited = new int[count];
        for (int i = 0; i < count; i++) {
            if (visited[i] == 0) // "White"
                if (isCyclePresentDFSColour(graph, i, visited))
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
        //gph.addDirectedEdge(4, 1);
        System.out.println(isCyclePresent(gph));
        System.out.println(isCyclePresentColour(gph));
    }
    
    /*
    true
    */
    
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
    * 1) Create a visited array of size V, and Initialize all count in visited array as 0. 
    * 2) Choose any vertex and perform a DFS traversal of graph. For 
    * all visited count mark them visited as 1. 
    * 3) If DFS traversal does not mark
    * all count as 1, then return 0. 
    * 4) Find transpose or reverse of graph 
    * 5) Repeat step 1, 2 and 3 for the reversed graph. 
    * 6) If DFS traversal mark all the count as 1, then return 1.
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

    // Testing Code
    public static void main9() {
        Graph gph = new Graph(5);
        gph.addDirectedEdge(0, 1);
        gph.addDirectedEdge(1, 2);
        gph.addDirectedEdge(2, 3);
        gph.addDirectedEdge(3, 0);
        gph.addDirectedEdge(2, 4);
        gph.addDirectedEdge(4, 2);
        System.out.println("IsStronglyConnected:: " + isStronglyConnected(gph));
    }
    
    /*
    IsStronglyConnected:: true
    */
    
    public static void stronglyConnectedComponent(Graph gph) {
        int count = gph.count;
        boolean[] visited = new boolean[count];
        
        Stack<Integer> stk = new Stack<Integer>();
        for (int i = 0; i < count; i++) {
            if (visited[i] == false)
                dfsUtil2(gph, i, visited, stk);
        }
        
        Graph gReversed = transposeGraph(gph);
        Arrays.fill(visited, false);
        
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

    // Testing Code
    public static void main10() {
        Graph gph = new Graph(7);
        gph.addDirectedEdge(0, 1);
        gph.addDirectedEdge(1, 2);
        gph.addDirectedEdge(2, 0);
        gph.addDirectedEdge(2, 3);
        gph.addDirectedEdge(3, 4);
        gph.addDirectedEdge(4, 5);
        gph.addDirectedEdge(5, 3);
        gph.addDirectedEdge(5, 6);
        stronglyConnectedComponent(gph);
        
        Graph gReversed = transposeGraph(gph);
        gReversed.print();
    }
    
    /*
    [1, 2, 0]
    [4, 5, 3]
    [6]
    */
    
    public static void primsMST(Graph gph) {
        int count = gph.count;
        int[] previous = new int[count];
        int[] dist = new int[count];
        boolean[] visited = new boolean[count];
        int source = 1;

        for (int i = 0; i <count; i++) {
            previous[i] = -1;
            dist[i] = Integer.MAX_VALUE; // infinite
        }

        dist[source] = 0;
        previous[source] = -1;
        PriorityQueue<Edge> queue = new PriorityQueue<Edge>(100);
        Edge node = new Edge(source, source, 0);
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
                    node = new Edge(source, dest, alt);
                    queue.add(node);
                }
            }
        }
        // printing result.
        int sum = 0;
        boolean isMst = true;;
        for (int i = 0; i < count; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("Node id " + i + "  prev " + previous[i] + " distance : Unreachable");
                isMst = false;
            } else {
                System.out.println("Node id " + i + "  prev " + previous[i] + " distance : " + dist[i]);
                sum += dist[i];
            }
        }

        if(isMst)
            System.out.print("Total MST cost: " + sum);
        else 
            System.out.print("Not a mst");
        
    }
    /*
    public static void kruskalMST((Graph gph) {
        int count = gph.count;
        int[] parent = new int[count];
        Arrays.fill(parent, -1);
        Edge edge[] = new Edge[100];
        LinkedList<Edge> output = new LinkedList<Edge>();
        
        int E = 0;
        for (int i = 0; i < count; i++) {
            LinkedList<Edge> ad = gph.Adj.get(i);
            for (Edge adn : ad) {
                edge[E++] = adn;
            }
        }

        int sum=0;
        Arrays.sort(edge, 0, E-1);
        for (int i = 0; i < E; i++) {
            int x = find(parent, edge[i].src);
            int y = find(parent, edge[i].dest);            
            if(x != y) {
                System.out.print("(" + edge[i].src + ", " + edge[i].dest + ", " + edge[i].cost + ") ");
                sum += edge[i].cost;
                output.add(edge[i]);
                union(parent, x, y);
            }
        }

        System.out.print("\nTotal MST cost: " + sum);
    }
    */
    public static class Sets{
        int parent;
        int rank;
        Sets(int p, int r){
            parent = p;
            rank = r;
        }
    }
    
    public static int find(Sets[] sets, int index) {
        int p = sets[index].parent; 
        while(p != index) {
            index = p;
            p = sets[index].parent;
        }
        return index;
    }

    // consider x and y are roots of sets.
    public static void union(Sets[] sets, int x, int y) {
        if (sets[x].rank < sets[y].rank)
            sets[x].parent = y;
        else if (sets[y].rank < sets[x].rank)
            sets[y].parent = x;
        else {
            sets[x].parent = y;
            sets[y].rank++;
        }
    }
        
    public static void kruskalMST(Graph gph) {
        int count = gph.count;
        
        //Different subsets are created.
        Sets[] sets = new Sets[count];
        for (int i = 0; i < count; i++)
            sets[i] = new Sets(i, 0);

        // Edges are added to array and sorted.
        int E=0;
        Edge edge[] = new Edge[100];
        for (int i = 0; i < count; i++) {
            LinkedList<Edge> ad = gph.Adj.get(i);
            for (Edge adn : ad) {
                edge[E++] = adn; 
            }
        }
        Arrays.sort(edge, 0, E-1);
        
        int sum=0;
        LinkedList<Edge> output = new LinkedList<Edge>();
        for (int i = 0; i < E; i++) {
            int x = find(sets, edge[i].src);
            int y = find(sets, edge[i].dest);            
            if(x != y) {
                System.out.print("(" + edge[i].src + ", " + edge[i].dest + ", " + edge[i].cost + ") ");
                sum += edge[i].cost;
                output.add(edge[i]);
                union(sets, x, y);
            }
        }
        System.out.print("\nTotal MST cost: " + sum);
    }


    // Testing Code
    public static void main11() {
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
        //gph.print();
        //gph.out.println();
        //primsMST(gph);
        //System.out.println();
        kruskalMST(gph);
        //dijkstra(gph, 0);
        //floydWarshall(gph);
    }
    
    /*
    Vertex 0 is connected to : (1, 4) (7, 8) 
    Vertex 1 is connected to : (0, 4) (2, 8) (7, 11) 
    Vertex 2 is connected to : (1, 8) (3, 7) (8, 2) (5, 4) 
    Vertex 3 is connected to : (2, 7) (4, 9) (5, 14) 
    Vertex 4 is connected to : (3, 9) (5, 10) 
    Vertex 5 is connected to : (2, 4) (3, 14) (4, 10) (6, 2) 
    Vertex 6 is connected to : (5, 2) (7, 1) (8, 6) 
    Vertex 7 is connected to : (0, 8) (1, 11) (6, 1) (8, 7) 
    Vertex 8 is connected to : (2, 2) (6, 6) (7, 7) 

    node id 0  prev 1 distance : 4
    node id 1  prev -1 distance : 0
    node id 2  prev 1 distance : 8
    node id 3  prev 2 distance : 7
    node id 4  prev 3 distance : 9
    node id 5  prev 2 distance : 4
    node id 6  prev 5 distance : 2
    node id 7  prev 6 distance : 1
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

    // Unweighed graph
    public static void shortestPath(Graph gph, int source) {
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

    // Testing Code
    public static void main12() {
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
        bellmanFordShortestPath(gph, 1);
        // dijkstra(gph, 1);
        primsMST(gph);
        //System.out.println("isConnectedUndirected :: " + isConnectedUndirected(gph));
        System.out.println();
        kruskalMST(gph);
    }
    
    /*
    2 to 0 weight 6
    -1 to 1 weight 0
    1 to 2 weight 5
    1 to 3 weight 7
    1 to 4 weight 9
    3 to 5 weight 11
    4 to 6 weight 12
    5 to 7 weight 12
    7 to 8 weight 29
    isConnectedUndirected :: true
    */

/*
0   2   4   3   7   8   7   
2   0   3   1   5   7   5   
4   3   0   2   6   4   6   
3   1   2   0   4   6   4   
7   5   6   4   0   4   2   
8   7   4   6   4   0   3   
7   5   6   4   2   3   0   
*/

    public static void dijkstra(Graph gph, int source) {
        int[] previous = new int[gph.count];
        Arrays.fill(previous, -1);
        int[] dist = new int[gph.count];
        Arrays.fill(dist, Integer.MAX_VALUE); // infinite
        boolean[] visited = new boolean[gph.count];

        dist[source] = 0;
        previous[source] = -1;

        PriorityQueue<Edge> queue = new PriorityQueue<Edge>(100);
        Edge node = new Edge(source, source, 0);
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
                    node = new Edge(source, dest, alt);
                    queue.add(node);
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

    public static void bellmanFordShortestPath(Graph gph, int source) {
        int count = gph.count;
        int[] distance = new int[count];
        int[] path = new int[count];

        for (int i = 0; i < count; i++) {
            distance[i] = Integer.MAX_VALUE; // infinite
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

    // Testing Code
    public static void main13() {
        Graph gph = new Graph(5);
        gph.addDirectedEdge(0, 1, 3);
        gph.addDirectedEdge(0, 4, 2);
        gph.addDirectedEdge(1, 2, 1);
        gph.addDirectedEdge(2, 3, 1);
        gph.addDirectedEdge(4, 1, -2);
        gph.addDirectedEdge(4, 3, 1);
        gph.print();
        System.out.println();
        bellmanFordShortestPath(gph, 0);
    }
    
    /*
    Vertex 0 is connected to : (1, 3) (4, 2) 
    Vertex 1 is connected to : (2, 1) 
    Vertex 2 is connected to : (3, 1) 
    Vertex 3 is connected to : 
    Vertex 4 is connected to : (1, -2) (3, 1) 

    -1 to 0 weight 0
    4 to 1 weight 0
    1 to 2 weight 1
    2 to 3 weight 2
    0 to 4 weight 2
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

    public static int bestFirstSearchPQ(Graph gph, int source, int dest) {
        int[] previous = new int[gph.count];
        int[] dist = new int[gph.count];
        boolean[] visited = new boolean[gph.count];
        for (int i = 0; i < gph.count; i++) {
            previous[i] = -1;
            dist[i] = Integer.MAX_VALUE; // infinite
        }
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(100);
        dist[source] = 0;
        previous[source] = -1;
        Edge node = new Edge(source, source, 0);
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
                    node = new Edge(source, curr, alt);
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

    // Testing Code
    public static void main15() {
        Graph gph = new Graph(5);
        gph.addDirectedEdge(1, 0);
        gph.addDirectedEdge(0, 2);
        gph.addDirectedEdge(2, 1);
        gph.addDirectedEdge(0, 3);
        gph.addDirectedEdge(3, 4);
        System.out.println(isEulerian(gph));
    }
    
    /*
    graph is Semi-Eulerian
    1
    */
    
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

    // Testing Code
    public static void main16() {
        Graph gph = new Graph(5);
        gph.addDirectedEdge(0, 1);
        gph.addDirectedEdge(1, 2);
        gph.addDirectedEdge(2, 0);
        gph.addDirectedEdge(0, 4);
        gph.addDirectedEdge(4, 3);
        gph.addDirectedEdge(3, 0);
        System.out.println(isEulerianCycle(gph));
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
        
        Graph gReversed = transposeGraph(gph);
        gReversed.print();
    }

    /*
    Vertex 0 is connected to : (2, 1) 
    Vertex 1 is connected to : (0, 1) 
    Vertex 2 is connected to : (1, 1) 
    Vertex 3 is connected to : (2, 1) (5, 1) 
    Vertex 4 is connected to : (3, 1) 
    Vertex 5 is connected to : (4, 1) 
    Vertex 6 is connected to : (5, 1) 
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
        shortestPath(gph, 0);
    }
    
    /*
    0 to 0 weight 0
    0 to 1 weight 1
    1 to 2 weight 2
    2 to 3 weight 3
    3 to 4 weight 4
    2 to 5 weight 3
    7 to 6 weight 2
    0 to 7 weight 1
    7 to 8 weight 2
    */

    static void floydWarshall(Graph gph) {
        int V = gph.count;
        int dist[][] = new int[V][V];
        int path[][] = new int[V][V];
        final int INF = Integer.MAX_VALUE;
        
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = INF;
                if(i == j)
                    path[i][j] = 0;
                else
                    path[i][j] = -1;
            }
        }
        
        for (int i = 0; i < V; i++) {
            LinkedList<Edge> adl = gph.Adj.get(i);
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
                    if(  dist[i][k] + dist[k][j] < dist[i][j]) {
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

        private static void printSolution(int[][] cost, int[][] path, int V) {
            for (int u = 0; u < V; u++) {
                for (int v = 0; v < V; v++) {
                    if (u != v && path[u][v] != -1) {
                        System.out.printf("Shortest Path from %d —> %d ", u , v);
                    System.out.printf("Cost:" + cost[u][v] + " Path:");
                    printPath(path, u, v);
                    System.out.println();
                }
            }
        }
    } 

    private static void printPath(int[][] path, int u, int v) {
        if (path[u][v] == u) {
            System.out.print(u + " " + v + " ");
            return;
        }
        printPath(path, u, path[u][v]);
        System.out.print(v + " ");
    }
    
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
        floydWarshall(gph);
    }

/*
Shortest Path from 0 —> 1 Cost:5 Path:0 1 
Shortest Path from 0 —> 2 Cost:8 Path:0 1 2 
Shortest Path from 0 —> 3 Cost:9 Path:0 1 2 3 
Shortest Path from 1 —> 2 Cost:3 Path:1 2 
Shortest Path from 1 —> 3 Cost:4 Path:1 2 3 
Shortest Path from 2 —> 3 Cost:1 Path:2 3
*/

    static void printSolution(int dist[][], int V) {
        for (int i=0; i<V; i++) {
            for (int j=0; j<V; j++) {
                if (dist[i][j] == Integer.MAX_VALUE)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }
    
    
    public static void main(String[] args) {
        //main1();
        //main2(); 
        //main3(); 
        //main4(); 
        //main5(); 
        //main6(); 
        //main7(); 
        //main8();
        //main10(); 
        main11(); 
        //main12();
        //main13(); 
        //main15(); 
        //main16();
        //main17();
        //main18();
        //main19();
    }
}