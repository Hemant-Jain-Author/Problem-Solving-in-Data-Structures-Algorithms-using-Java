public class LongestCommonSubseq {
    static int LCSubStr(String st1, String st2) {
        char X[] = st1.toCharArray();
        char Y[] = st2.toCharArray();
        int m = st1.length();
        int n = st2.length();
        int dp[][] = new int[m+1][n+1]; // Dynamic programming array.
        int p[][] = new int[m+1][n+1]; // For printing the substring.

        // Fill dp array in bottom up fashion.
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X[i-1] == Y[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    p[i][j] = 0;
                } else {
                    dp[i][j] = (dp[i-1][j] > dp[i][j-1])? dp[i-1][j]: dp[i][j-1];
                    p[i][j] = (dp[i-1][j] > dp[i][j-1])? 1 : 2;
                }
            }
        }
        PrintLCS(p, X, m, n);
        return dp[m][n];
    }

    static void PrintLCS(int[][] p, char[] X, int i, int j) {
        if (i == 0 || j == 0)
            return;

        if (p[i][j] == 0) {
            PrintLCS(p, X, i-1, j-1);
            System.out.print(X[i-1]);
        } else if (p[i][j] == 1)
            PrintLCS(p, X, i-1, j);
        else
            PrintLCS(p, X, i, j-1);
    }

    public static void main(String[] args) {
        String X = "carpenter";
        String Y = "sharpener";
        System.out.println(LCSubStr(X, Y));
    }
}