import java.util.Arrays;

public class MatrixCM {

    static int MatrixChainMulBruteForce(int p[], int i, int j) {
        if (i == j)
            return 0;

        int min = Integer.MAX_VALUE;

        // place parenthesis at different places between
        // first and last matrix, recursively calculate
        // count of multiplications for each parenthesis
        // placement and return the minimum count
        for (int k = i; k < j; k++) {
            int count = MatrixChainMulBruteForce(p, i, k)
                        + MatrixChainMulBruteForce(p, k + 1, j)
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
        return MatrixChainMulTD(dp, p, 1, n-1);
    }

    // Function for matrix chain multiplication
    static int MatrixChainMulTD(int[][] dp, int[] p, int i, int j) {
        // Base Case
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }

        for (int k = i; k < j; k++) {
            dp[i][j] = Math.min(
                dp[i][j], MatrixChainMulTD(dp, p, i, k)
                + MatrixChainMulTD(dp, p, k + 1, j)
                + p[i-1] * p[k] * p[j]);
        }
        return dp[i][j];
    }
        

        
    static int MatrixChainMulBU(int[] p, int n) {   
        int[][] dp = new int[n][n];
        for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);
        
        for (int i = 1; i < n; i++)
                dp[i][i] = 0;

        for(int l = 1; l<n; l++) { // l is length of range.
            for(int i = 1,j = i+l ; j<n; i++, j++) {
                for(int k = i; k<j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + p[i-1] * p[k] * p[j] + dp[k+1][j]);
                }
            }
        } 
        return dp[1][n-1];
    }

    // Driver Code
    public static void main (String[] args)
    {
        int arr[] = { 1, 2, 3, 4 };
        int n= arr.length;
        System.out.println("Matrix Chain Multiplication is: " + MatrixChainMulBruteForce(arr, n));
        System.out.println("Matrix Chain Multiplication is: " + MatrixChainMulTD(arr, n));
        System.out.println("Matrix Chain Multiplication is: " + MatrixChainMulBU(arr, n));
    }
}

/*
Matrix Chain Multiplication is: 18
Matrix Chain Multiplication is: 18
Matrix Chain Multiplication is: 18
*/

