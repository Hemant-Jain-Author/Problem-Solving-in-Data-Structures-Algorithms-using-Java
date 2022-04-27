public class TSP {
	// Function to find the minimum weight Hamiltonian Cycle
	static int tsp(int[][] graph, int n, int[] path, int pSize, int pCost, boolean[] visited, int ans, int[] ansPath) {
		if (pCost > ans)
			return ans;

		int curr = path[pSize - 1];
		if (pSize == n) {
			if (graph[curr][0] > 0 && ans > pCost + graph[curr][0]) {
				ans = pCost + graph[curr][0];
				for (int i = 0; i <= n; i++)
					ansPath[i] = path[i % n];
			}
			return ans;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i] == false && graph[curr][i] > 0) {
				visited[i] = true;
				path[pSize] = i;
				ans = tsp(graph, n, path, pSize + 1, pCost + graph[curr][i], visited, ans, ansPath);
				visited[i] = false;
			}
		}
		return ans;
	}

	static int tsp(int[][] graph, int n) {
		boolean[] visited = new boolean[n];
		int[] path = new int[n];
		int[] ansPath = new int[n + 1];
		path[0] = 0;
		visited[0] = true;
		int ans = Integer.MAX_VALUE;
		ans = tsp(graph, n, path, 1, 0, visited, ans, ansPath);
		System.out.println("Path length : " + ans);
		System.out.print("Path : ");
		for (int i = 0; i <= n; i++)
			System.out.print(ansPath[i] + " ");
		return ans;
	}

	public static void main(String[] args) {
		int n = 4;
		int[][] graph = { { 0, 10, 15, 20 }, 
		                  { 10, 0, 35, 25 }, 
						  { 15, 35, 0, 30 }, 
						  { 20, 25, 30, 0 } };
		tsp(graph, n);
	}
}

/*
Path length : 80
Path : 0 1 3 2 0 
*/