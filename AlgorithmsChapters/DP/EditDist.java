package DP;

public class EditDist {
    static int min(int x, int y, int z) {
        x = Math.min(x, y);
        return Math.min(x, z);   
    }

    static int editDist(String str1, String str2) {
        int m = str1.length(); 
        int n = str2.length();
        return editDist(str1, str2, m, n);
    }

    static int editDist(String str1, String str2, int m, int n) {
        if (m == 0 || n == 0) // If any one string is empty, then empty the other string.
            return m + n;
    
        // If last characters of both strings are same, ignore last characters.
        if (str1.charAt(m-1) == str2.charAt(n-1))
            return editDist(str1, str2, m-1, n-1);
    
        // If last characters are not same, 
        // consider all three operations:
        // Insert last char of second into first.
        // Remove last char of first.
        // Replace last char of first with second.
        return 1 + min(editDist(str1, str2, m, n-1),    // Insert
                       editDist(str1, str2, m-1, n),    // Remove
                       editDist(str1, str2, m-1, n-1)); // Replace
    }
    
    static int editDistDP(String str1, String str2) {
        int m = str1.length(); 
        int n = str2.length();
        int[][] dp = new int[m+1][n+1];

        // Fill dp[][] in bottom up manner.
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // If any one string is empty, then empty the other string.
                if (i == 0 || j == 0)
                    dp[i][j] = (i+j);
                // If last characters of both strings are same, ignore last characters.
                else if (str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                // If last characters are not same, 
                // consider all three operations:
                // Insert last char of second into first.
                // Remove last char of first.
                // Replace last char of first with second.
                else
                    dp[i][j] = 1 + min(dp[i][j-1], // Insert
                                       dp[i-1][j], // Remove
                                       dp[i-1][j-1]); // Replace
            }
        }
        return dp[m][n];
    }

    public static void main(String args[])
    {
        String str1 = "sunday";
        String str2 = "saturday";    
        System.out.println(editDist(str1, str2));
        System.out.println(editDistDP(str1, str2));
    }
}