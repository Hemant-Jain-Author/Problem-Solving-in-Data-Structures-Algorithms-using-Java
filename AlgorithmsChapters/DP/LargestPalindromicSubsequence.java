// Palindromic Subsequence
public class LargestPalindromicSubsequence {
    static int palindromicSubsequence(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];
        
        for (int i=0;i<n;i++) // each char is itself palindromic with length 1
            dp[i][i] = 1;

        for (int l = 1; l < n; l++) {
            for (int i = 0, j = l; j < n; i++, j++) {
                if (str.charAt(i) == str.charAt(j))
                    dp[i][j] = dp[i+1][j-1] + 2;
                else 
                    dp[i][j] = Math.max(dp[i+1][j] , dp[i][j-1]);
            }
        }
        return dp[0][n-1];
    }

    public static void main(String args[]) {
        String str = "ABCAUCBCxxCBA"; 
        System.out.println("Max Palindromic Subsequence length: " + 
        palindromicSubsequence(str));

    }    
}
/*
Max Palindromic Subsequence length: 9
*/