public class StockBuySell {
    public static int maxProfit(int[] arr){
        int buyProfit = -arr[0]; // Buy stock profit
        int sellProfit = 0; // Sell stock profit
        int n = arr.length;
        for(int i=1;i<n;i++) {
            int newBuyProfit = (sellProfit - arr[i] > buyProfit)?
                                sellProfit - arr[i] : buyProfit;
            int newSellProfit = (buyProfit + arr[i] > sellProfit)?
                                buyProfit + arr[i] : sellProfit;
            buyProfit = newBuyProfit;
            sellProfit = newSellProfit;
        }
        return sellProfit;
    }

    public static int maxProfitTC(int[] arr, int t){
        int buyProfit = -arr[0];
        int sellProfit = 0;
        int n = arr.length;
        for(int i=1;i<n;i++) {
            int newBuyProfit = ((sellProfit - arr[i]) > buyProfit) ? (sellProfit - arr[i]) : buyProfit;
            int newSellProfit = ((buyProfit + arr[i] - t) > sellProfit) ? (buyProfit + arr[i] - t) : sellProfit;
            buyProfit = newBuyProfit;
            sellProfit = newSellProfit;
        }
        return sellProfit;
    }

    public static int maxProfit2(int[] arr){
        int n = arr.length;
        int[][] dp = new int[n][2];
        dp[0][0] = -arr[0];  // Buy stock profit
        dp[0][1] = 0; // Sell stock profit
        
        for(int i=1;i<n;i++) {
            dp[i][0] = (dp[i-1][1] - arr[i] > dp[i-1][0]) ? dp[i-1][1] - arr[i] : dp[i-1][0];
            dp[i][1] = (dp[i-1][0] + arr[i] > dp[i-1][1]) ? dp[i-1][0] + arr[i] : dp[i-1][1];
        }
        return dp[n-1][1];
    }

    public static int maxProfitTC2(int[] arr, int t){
        int n = arr.length;
        int[][] dp = new int[n][2];
        dp[0][0] = -arr[0];
        dp[0][1] = 0;
        
        for(int i=1;i<n;i++) {
            dp[i][0] = ((dp[i-1][1] - arr[i]) > dp[i-1][0]) ? 
            (dp[i-1][1] - arr[i]) : dp[i-1][0];
            dp[i][1] = ((dp[i-1][0] + arr[i] - t) > dp[i-1][1]) ? 
            (dp[i-1][0] + arr[i] - t) : dp[i-1][1];
        }
        return dp[n-1][1];
    }

    public static void main(String args[]) {
        int arr[] = {10, 12, 9, 23, 25, 55, 49, 70 };
        System.out.println("Total profit: " + maxProfit(arr));
        System.out.println("Total profit: " + maxProfit2(arr));
        System.out.println("Total profit: " + maxProfitTC(arr, 2));
        System.out.println("Total profit: " + maxProfitTC2(arr, 2));
    }
}
