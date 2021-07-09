package DP;

// Palindromic Substrings
public class PalinSubstr {
    static int palinSubstring(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];
        for (int i=0;i<n;i++)
            dp[i][i] = 1;

        int max = 1;
        int start = 0;
        
        for (int l = 1; l < n; l++) {
            for (int i = 0; i < n-l; i++) {
                int j = i + l;

                if (str.charAt(i) == str.charAt(j) && dp[i+1][j-1] == j-i-1) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                    if(dp[i][j] > max) {
                        max = dp[i][j];
                        start = i;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println("Max Length Palindromic Substrings : " + str.substring(start, start+max));
        return max;
/*
        int count = 0;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
            if(dp[i][j] > 0)
                count++;
        return count;
*/
    }

    public static void main(String args[])
    {
        String str = "ABCAUCBCxxCBA"; 
        System.out.println("Max Palindromic Substrings len: " + palinSubstring(str));
    }    
}
/*
Max Palindromic Substrings len: 6
*/