package DP;

public class StockBuySell {
    public static int maxProfit(int[] arr){
        int obsp = -arr[0];
        int ossp = 0;
        int n = arr.length;
        for(int i=1;i<n;i++) {
            int nbsp = (ossp - arr[i] > obsp)?ossp - arr[i]:obsp;
            int nssp = (obsp + arr[i] > ossp)?obsp + arr[i]:ossp;
            obsp = nbsp;
            ossp = nssp;
        }
        return ossp;
    }

    public static int maxProfit2(int[] arr){
        int n = arr.length;
        int[][] dp = new int[n][2];
        dp[0][0] = -arr[0];
        dp[0][1] = 0;
        
        for(int i=1;i<n;i++) {
            dp[i][0] = (dp[i-1][1] - arr[i] > dp[i-1][0])?dp[i-1][1] - arr[i]:dp[i-1][0];
            dp[i][1] = (dp[i-1][0] + arr[i] > dp[i-1][1])?dp[i-1][0] + arr[i]:dp[i-1][1];
        }
        return dp[n-1][1];
    }

    public static int maxProfitTC(int[] arr, int t){
        int obsp = -arr[0];
        int ossp = 0;
        int n = arr.length;
        for(int i=1;i<n;i++) {
            int nbsp = ((ossp - arr[i]) > obsp) ? (ossp - arr[i]) : obsp;
            int nssp = ((obsp + arr[i] - t) > ossp) ? (obsp + arr[i] - t) : ossp;
            obsp = nbsp;
            ossp = nssp;
        }
        return ossp;
    }
    public static int maxProfitTC2(int[] arr, int t){
        int n = arr.length;
        int[][] dp = new int[n][2];
        dp[0][0] = -arr[0];
        dp[0][1] = 0;
        
        for(int i=1;i<n;i++) {
            dp[i][0] = ((dp[i-1][1] - arr[i]) > dp[i-1][0])? (dp[i-1][1] - arr[i]) : dp[i-1][0];
            dp[i][1] = ((dp[i-1][0] + arr[i] - t) > dp[i-1][1])? (dp[i-1][0] + arr[i] - t) : dp[i-1][1];
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
