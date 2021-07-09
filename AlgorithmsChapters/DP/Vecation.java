import java.util.Arrays;

public class Vecation {
    // days are must travel days, costs are cost of tickets.
    public static int minCost(int[] days, int[] costs) {
        int n = days.length;
        int max = days[n-1];
        int[] dp = new int[max+1];

        int j = 0;
        for(int i = 1; i <= max; i++) {
            dp[i] = costs[0] + dp[i-1];

            if(i - 7 > 0)
                dp[i] = Math.min(dp[i], dp[i - 7] + costs[1]);

            if(i - 30 > 0)
                dp[i] = Math.min(dp[i], dp[i - 30] + costs[2]);

            if(j < n && days[j] == i) // That days is definitely travelled.
                j++;
            else
                dp[i] = Math.min(dp[i], dp[i - 1]); // day may be ignored.
        }
        return dp[max];
    }

    public static void main(String[] args) {
        int[] days = {1, 3, 5, 7, 12, 20, 30};
        int[] cost = {2, 7, 20};
        System.out.println("Min cost is:" + minCost(days, cost)); 
    }
}
/*
Min cost is:14
*/