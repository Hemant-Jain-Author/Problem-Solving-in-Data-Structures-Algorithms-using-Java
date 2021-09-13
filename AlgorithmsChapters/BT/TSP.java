public class TSP { 
    // Function to find the minimum weight Hamiltonian Cycle 
    static int tsp(int[][] graph, int n, int[] path, 
    int pSize,int pCost, boolean[] visited,  int ans) {
    /*    if(pCost > ans) {
            return ans;
        }
    */
        int curr = path[n-1];
        if (pSize == n && graph[curr][0] > 0) {
            ans = Math.min(ans, pCost + graph[curr][0]);
            return ans;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == false && graph[curr][i] > 0) {
                visited[i] = true;
                path[pSize] = i;
                ans = tsp(graph, n, path, pSize+1, pCost + graph[curr][i],visited, ans);
                visited[i] = false;
            }
        }
        return ans;
    }

    static int tsp(int[][] graph, int n) {
        boolean[] visited = new boolean[n];
        int[] path = new int[n];
        path[0] = 0;
        visited[0] = true;
        int ans = Integer.MAX_VALUE;
        ans = tsp(graph, n, path, 1, 0, visited, ans);
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] graph = {{0, 10, 15, 20},
                        {10, 0, 35, 25},
                        {15, 35, 0, 30},
                        {20, 25, 30, 0}};
        tsp(graph, n);        
    }
}