public class DiceThrow{
    public static int findWays(int n, int m, int V){
        int[][] dp = new int[n+1][V+1];
         
        // Table entries for only one dice.
        for(int j = 1; j <= m && j <= V; j++)
            dp[1][j] = 1;
                    
        // i is number of dice, j is Value, k value of dice.
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= V; j++) {
                for(int k = 1; k <= j && k <= m; k++)
                    dp[i][j] += dp[i-1][j-k];
            }
        }
        return dp[n][V];
    }

    public static void main (String[] args) {
        for(int i=1;i<= 6;i++){
            System.out.println(findWays(i, 6, 6));    
        }
    }
}

/*
1
5
10
10
5
1
*/