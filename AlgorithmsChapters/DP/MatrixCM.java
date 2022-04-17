import java.util.Arrays;

public class MatrixCM {

	static int MatrixChainMulBruteForce(int[] p, int i, int j) {
		if (i == j)
			return 0;

		int min = Integer.MAX_VALUE;

		// place parenthesis at different places between
		// first and last matrix, recursively calculate
		// count of multiplications for each parenthesis
		// placement and return the minimum count
		for (int k = i; k < j; k++) {
			int count = MatrixChainMulBruteForce(p, i, k) + MatrixChainMulBruteForce(p, k + 1, j)
					+ p[i - 1] * p[k] * p[j];

			if (count < min)
				min = count;
		}

		// Return minimum count
		return min;
	}

	static int MatrixChainMulBruteForce(int[] p, int n) {
		int i = 1, j = n - 1;
		return MatrixChainMulBruteForce(p, i, j);
	}

	static int MatrixChainMulTD(int[] p, int n) {
		int[][] dp = new int[n][n];
		for (int[] row : dp)
			Arrays.fill(row, Integer.MAX_VALUE);

		for (int i = 1; i < n; i++)
			dp[i][i] = 0;

		return MatrixChainMulTD(dp, p, 1, n - 1);
	}

	// Function for matrix chain multiplication
	static int MatrixChainMulTD(int[][] dp, int[] p, int i, int j) {
		// Base Case
		if (dp[i][j] != Integer.MAX_VALUE) {
			return dp[i][j];
		}

		for (int k = i; k < j; k++) {
			dp[i][j] = Math.min(dp[i][j],
					MatrixChainMulTD(dp, p, i, k) + MatrixChainMulTD(dp, p, k + 1, j) + p[i - 1] * p[k] * p[j]);
		}
		return dp[i][j];
	}

	static int MatrixChainMulBU(int[] p, int n) {
		int[][] dp = new int[n][n];
		for (int[] row : dp)
			Arrays.fill(row, Integer.MAX_VALUE);

		for (int i = 1; i < n; i++)
			dp[i][i] = 0;

		for (int l = 1; l < n; l++) { // l is length of range.
			for (int i = 1, j = i + l; j < n; i++, j++) {
				for (int k = i; k < j; k++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + p[i - 1] * p[k] * p[j] + dp[k + 1][j]);
				}
			}
		}
		return dp[1][n - 1];
	}

	static void PrintOptPar(int n, int[][] pos, int i, int j) {
		if (i == j)
			System.out.print("M" + pos[i][i] + " ");
		else {
			System.out.print("( ");
			PrintOptPar(n, pos, i, pos[i][j]);
			PrintOptPar(n, pos, pos[i][j] + 1, j);
			System.out.print(") ");
		}
	}

	static void PrintOptimalParenthesis(int n, int[][] pos) {
		System.out.print("OptimalParenthesis : ");
		PrintOptPar(n, pos, 1, n - 1);
		System.out.println("");
	}

	static int MatrixChainMulBU2(int[] p, int n) {
		int[][] dp = new int[n][n];
		int[][] pos = new int[n][n];

		for (int[] row : dp)
			Arrays.fill(row, Integer.MAX_VALUE);

		for (int i = 1; i < n; i++) {
			dp[i][i] = 0;
			pos[i][i] = i;
		}

		for (int l = 1; l < n; l++) { // l is length of range.
			for (int i = 1, j = i + l; j < n; i++, j++) {
				for (int k = i; k < j; k++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + p[i - 1] * p[k] * p[j] + dp[k + 1][j]);
					pos[i][j] = k;
				}
			}
		}
		PrintOptimalParenthesis(n, pos);
		return dp[1][n - 1];
	}

	// Driver Code
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4 };
		int n = arr.length;
		System.out.println("Matrix Chain Multiplication is: " + MatrixChainMulBruteForce(arr, n));
		System.out.println("Matrix Chain Multiplication is: " + MatrixChainMulTD(arr, n));
		System.out.println("Matrix Chain Multiplication is: " + MatrixChainMulBU(arr, n));
		System.out.println("Matrix Chain Multiplication is: " + MatrixChainMulBU2(arr, n));
	}
}

/*
Matrix Chain Multiplication is: 18
Matrix Chain Multiplication is: 18
Matrix Chain Multiplication is: 18
OptimalParenthesis : ( ( M1 M2 ) M3 ) 
Matrix Chain Multiplication is: 18
 */
