package DP;

// Palindromic Substrings
public class PalinSubstr {
    static int palStr(String str) {
        char st[] = str.toCharArray();        
        int n = st.length;
        int[][] dp = new int[n][n];
        for (int i=0;i<n;i++)
            dp[i][i] = 1;
        int max = 1;
        
        for (int l = 1; l < n; l++) {
            for (int i = 0; i < n-l; i++) {
                int j = i + l;

                if (st[i] == st[j] && dp[i+1][j-1] == j-i-1) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                    if(dp[i][j] > max) {
                        max = dp[i][j];
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println("Max Length of Palindromic Substrings : " + max);
        int count = 0;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
            if(dp[i][j] > 0)
                count++;
        return count;
    }
     
    public static void main(String args[])
    {
        String str = "aba";
        System.out.println("Palindromic Substrings count: " + palStr(str));
    }    
}
