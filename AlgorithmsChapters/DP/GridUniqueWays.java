public class GridUniqueWays{

    private static int uniqueWays(int m, int n) {
        int dp[][]=new int[m][n];
        dp[0][0] = 1;

        // Initialize first column.
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0];
        }
        // Initialize first row.
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) 
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
        }
        return dp[m-1][n-1];
    }

    // Diagonal movement allowed.
    private static int unique3Ways(int m, int n) {
        int dp[][]=new int[m][n];
        dp[0][0] = 1;

        // Initialize first column.
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0];
        }
        // Initialize first row.
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) 
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j] + dp[i][j-1];
        }
        return dp[m-1][n-1];
    }
    
    public static void main(String args[]) {                        
        System.out.println(uniqueWays(3, 3));
        System.out.println(unique3Ways(3, 3));

    }
}

/*
6
*/