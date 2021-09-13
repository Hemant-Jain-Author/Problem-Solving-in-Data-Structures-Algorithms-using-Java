import java.util.Arrays;
public class MultipleStageGraph {
    static int INF = Integer.MAX_VALUE;

    // Returns shortest distance from 0 to N-1.
    public static int shortestDist(int[][] graph, int n) {
        // dist[i] is going to store shortest
        // distance from node i to node n-1.
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        int[] path = new int[n];
        int value;
        dist[0] = 0;
        path[0] = -1;
        
        // Calculating shortest path for the nodes
        for (int i = 0; i < n; i++) {
            // Check all nodes of next 
            for (int j = i; j < n; j++) {
                // Reject if no edge exists
                if (graph[i][j] == INF)
                    continue;
                value = graph[i][j] + dist[i];
                if( dist[j] > value){
                    dist[j] = value;
                    path[j] = i;     
                }
            }
        }
        value = n-1;
        while(value != -1){
            System.out.print( " " + value );
            value = path[value];
        }
        System.out.println();

        return dist[n-1];
    }

    // Driver code
    public static void main(String[] args)
    {
        // Graph stored in the form of an
        // adjacency Matrix
        int[][] graph = new int[][]{
            {INF, 1, 2, 5, INF, INF, INF, INF},
            {INF, INF, INF, INF, 4, 11, INF, INF},
            {INF, INF, INF, INF, 9, 5, 16, INF},
            {INF, INF, INF, INF, INF, INF, 2, INF},
            {INF, INF, INF, INF, INF, INF, INF, 18},
            {INF, INF, INF, INF, INF, INF, INF, 13},
            {INF, INF, INF, INF, INF, INF, INF, 2}, 
            {INF, INF, INF, INF, INF, INF, INF, INF}};

        System.out.println(shortestDist(graph, 8));
    }
}
