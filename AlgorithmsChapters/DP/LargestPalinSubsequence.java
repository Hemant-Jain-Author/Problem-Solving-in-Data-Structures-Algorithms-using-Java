package DP;

// Palindromic Subsequence
public class LargestPalinSubsequence {
    static int palinSubsequence(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];
        for (int i=0;i<n;i++)
            dp[i][i] = 1;

        for (int l = 1; l < n; l++) {
            for (int i = 0; i < n-l; i++) {
                int j = i + l;

                if (str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    int first = (i > 0)?dp[i+1][j] : 0;
                    int second = (j > 0)?dp[i][j-1] : 0;
                    dp[i][j] = Math.max(first , second);
                }
            }
        }
        return dp[0][n-1];
    }

    public static void main(String args[])
    {
        String str = "ABCAUCBCxxCBA"; 
        System.out.println("Max Palindromic Subsequence length: " + palinSubsequence(str));

    }    
}
/*
Max Palindromic Subsequence length: 9
*/