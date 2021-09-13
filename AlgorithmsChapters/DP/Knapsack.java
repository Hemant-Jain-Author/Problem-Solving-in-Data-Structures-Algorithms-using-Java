public class Knapsack {
    int getMaxCost01(int[] wt, int[] cost, int capacity) {
        int n = wt.length;
        return getMaxCost01Util(wt, cost, n, capacity);
    }

    int getMaxCost01Util(int[] wt, int[] cost, int n, int capacity) {
        // Base Case
        if (n == 0 || capacity == 0)
            return 0;

        // Return the maximum of two cases:
        // (1) nth item is included
        // (2) nth item is not included
        int first = 0;
        if (wt[n - 1] <= capacity)
            first = cost[n - 1] + getMaxCost01Util(wt, cost, n - 1, capacity - wt[n - 1]);
        
        int second = getMaxCost01Util(wt, cost, n - 1, capacity);
        return Math.max(first, second);
    }

    int getMaxCost01TD(int[] wt, int[] cost, int capacity) {
        int n = wt.length;
        int[][] dp = new int[capacity + 1][n + 1];
        return getMaxCost01TD(dp, wt, cost, n, capacity);
    }

    int getMaxCost01TD(int[][] dp, int[] wt, int[] cost, int i, int w) {
        if(w == 0 || i == 0)
            return 0;
        
        if(dp[w][i] != 0)
            return dp[w][i];

        // Their are two cases:
        // (1) ith item is included
        // (2) ith item is not included
        int first = 0;
        if (wt[i-1] <= w) 
            first = getMaxCost01TD(dp, wt, cost, i-1, w - wt[i-1]) + cost[i-1];
        
        int second = getMaxCost01TD(dp, wt, cost, i-1, w) ;
        return dp[w][i] = Math.max( first,second);
    }

    int getMaxCost01BU(int[] wt, int[] cost, int capacity) {
        int n = wt.length;
        int[][] dp = new int[capacity + 1][n + 1];

        // Build table dp[][] in bottom up approach.
        // Weights considered against capacity.
        for (int w = 1; w <= capacity; w++) {
            for (int i = 1; i <= n; i++) {
                // Their are two cases:
                // (1) ith item is included
                // (2) ith item is not included
                int first = 0;
                if (wt[i-1] <= w) 
                    first = dp[w - wt[i-1]][i-1] + cost[i-1];
                
                int second = dp[w][i-1];
                dp[w][i] = Math.max( first,second);
            }
        }
        //printItems(dp, wt, cost, n, capacity);
        return dp[capacity][n]; // Number of weights considered and final capacity.
    }

    void printItems(int[][] dp, int[] wt, int[] cost, int n, int capacity) {
        int totalCost = dp[capacity][n];
        System.out.print("Selected items are:");
        for( int i = n-1; i > 0 ; i-- ){
            if(totalCost != dp[capacity][i-1]){
                System.out.print(" (" + wt[i] +"," +cost[i]+")");
                capacity -= wt[i];
                totalCost -= cost[i];
            }
        }
    }

    int KS01UnboundBU(int[] wt, int[] cost, int capacity) {
        int n = wt.length;
        int[] dp = new int[capacity + 1];

        // Build table dp[] in bottom up approach.
        // Weights considered against capacity.
        for (int w = 1; w <= capacity; w++) {
            for (int i = 1; i <= n; i++) {
                // Their are two cases:
                // (1) ith item is included 
                // (2) ith item is not included
                if (wt[i-1] <= w)
                    dp[w] = Math.max(dp[w], dp[w - wt[i-1]] + cost[i-1]);
            }
        }
        //printItems(dp, wt, cost, n, capacity);
        return dp[capacity]; // Number of weights considered and final capacity.
    }

    public static void main(String[] args) {
        int[] wt = { 5, 10, 15 };
        int[] cost = { 10, 30, 20 };
        int capacity = 20;

        Knapsack kp = new Knapsack();

        double maxCost = kp.KS01UnboundBU(wt, cost, capacity);
        System.out.println("Maximum cost obtained = " + maxCost);
        maxCost = kp.getMaxCost01BU(wt, cost, capacity);
        System.out.println("Maximum cost obtained = " + maxCost);
        maxCost = kp.getMaxCost01TD(wt, cost, capacity);
        System.out.println("Maximum cost obtained = " + maxCost);
    }

    public static void main2(String[] args) {
        int[] wt = { 10, 40, 20, 30 };
        int[] cost = { 60, 40, 90, 120 };
        int capacity = 50;

        Knapsack kp = new Knapsack();

        double maxCost = kp.getMaxCost01(wt, cost, capacity);
        System.out.println("Maximum cost obtained = " + maxCost);
        maxCost = kp.getMaxCost01BU(wt, cost, capacity);
        System.out.println("Maximum cost obtained = " + maxCost);
        maxCost = kp.getMaxCost01TD(wt, cost, capacity);
        System.out.println("Maximum cost obtained = " + maxCost);
    }
}

/*
Maximum cost obtained = 210.0
Maximum cost obtained = 210.0
Maximum cost obtained = 210.0
*/