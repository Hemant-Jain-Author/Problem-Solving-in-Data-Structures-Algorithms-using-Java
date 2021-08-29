public class TSP { 
	// Function to find the minimum weight
	// *Hamiltonian Cycle not always guarantee solution for tsp.
    // we can repeat particular city visit but not allowed in hamiltonian cycle.
	static int tsp(int[][] graph, int n, boolean[] visited,
				int currPos, int count, int cost, int ans) {
		
        if(cost > ans) {
            System.out.println("Backtracking.");
            return ans;
        }

        if (count == n && graph[currPos][0] > 0) {
			ans = Math.min(ans, cost + graph[currPos][0]);
			return ans;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i] == false && graph[currPos][i] > 0) {
				visited[i] = true;
				ans = tsp(graph, n, visited, i, count + 1,
						cost + graph[currPos][i], ans);

				visited[i] = false;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int n = 4;
		int[][] graph = {{0, 10, 15, 20},
						{10, 0, 35, 25},
						{15, 35, 0, 30},
						{20, 25, 30, 0}};

		boolean[] visited = new boolean[n];
		visited[0] = true;
		int ans = Integer.MAX_VALUE;
		ans = tsp(graph, n, visited, 0, 1, 0, ans);
        System.out.println(ans);
	}
}