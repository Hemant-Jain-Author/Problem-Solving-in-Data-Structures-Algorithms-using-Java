package DP;

public class HouseRobber {
    public static int maxRobbery(int[] house) {
        int n = house.length;
        int[] dp = new int[n];
        dp[0] = house[0];
        dp[1] = house[1];
        dp[2] = dp[0] + house[2];
        for(int i =3; i<n; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3]) + house[i];
        }
        return Math.max(dp[n-1], dp[n-2]);
    }
    
    public static int maxRobbery2(int[] house) {
        int n = house.length;
        int[][] dp = new int[n][2];

        dp[0][1] = house[0];
        dp[0][0] = 0;

        for (int i = 1; i < n; ++i) {
            dp[i][1] = Math.max(dp[i-1][0] + house[i], dp[i-1][1]);
            dp[i][0] = dp[i-1][1];
        }
        return Math.max(dp[n-1][1] , dp[n-1][0]);
    }

    public static void main(String args[]) {
        int arr[] = {10, 12, 9, 23, 25, 55, 49, 70 };
        System.out.println("Total cash: " + maxRobbery(arr));
        System.out.println("Total cash: " + maxRobbery2(arr));
    }

}
