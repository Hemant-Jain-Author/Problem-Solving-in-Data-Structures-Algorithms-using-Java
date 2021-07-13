package DP;

public class MinStairCost {
    static int minCost(int cost[], int n) {    
        // base case
        if (n == 1)
            return cost[0];
        
        int dp[] = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
    
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
    
        return Math.min(dp[n - 2], dp[n - 1]);
    }
 
    public static void main(String args[]) {
        int a[] = { 1, 5, 6, 3, 4, 7, 9, 1, 2, 11 };
        int n = a.length;
        System.out.print(minCost(a, n));
    }
}
