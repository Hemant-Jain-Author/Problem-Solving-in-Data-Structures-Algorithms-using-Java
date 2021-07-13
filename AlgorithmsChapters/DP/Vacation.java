import java.util.Arrays;

public class Vacation {
    // days are must travel days, costs are cost of tickets.
    public static int minCost(int[] days, int[] costs) {
        int n = days.length;
        int max = days[n-1];
        int[] dp = new int[max+1];

        int j = 0;
        for(int i = 1; i <= max; i++) {
            if(days[j] == i) {// That days is definitely travelled.
                j++;
                dp[i] = dp[i-1] + costs[0]; 
                dp[i] = Math.min(dp[i], dp[Math.max(0, i - 7)] + costs[1]);
                dp[i] = Math.min(dp[i], dp[Math.max(0, i - 30)] + costs[2]);
            } else
                dp[i] = dp[i - 1]; // day may be ignored.
        }
        return dp[max];
    }

    public static void main(String[] args) {
        int[] days = {1, 3, 5, 7, 12, 20, 30};
        int[] costs = {2, 7, 20};
        System.out.println("Min cost is:" + minCost(days, costs)); 

    }
}
/*
Min cost is:13
*/