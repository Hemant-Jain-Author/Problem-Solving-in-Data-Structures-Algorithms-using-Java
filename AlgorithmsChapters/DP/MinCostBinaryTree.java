import java.util.Arrays;

public class MinCostBinaryTree {
    
    static int maxVal(int[][] max, int i, int j){
        if(max[i][j] != Integer.MIN_VALUE)
            return max[i][j];
        
        for(int k=i;k<j;k++){
            max[i][j] = Integer.max( max[i][j], Integer.max( maxVal(max, i, k), maxVal(max, k+1, j)));
        }
        return max[i][j];
    }

    static int findSumTD(int[][] dp, int[][] max,  int i, int j, int[] arr) {
    if(j <= i)
        return 0;

    if (dp[i][j] != Integer.MAX_VALUE)
        return dp[i][j];

    for(int k=i;k<j;k++){
        dp[i][j] = Math.min(dp[i][j], findSumTD(dp, max, i, k, arr) + 
                findSumTD(dp, max, k+1, j, arr) + maxVal(max, i, k)* maxVal(max, k+1,j));
    }
    return dp[i][j];
    }

    static int findSumTD(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int[] row:dp)
            Arrays.fill(row, Integer.MAX_VALUE);

        int[][] max = new int[n][n];
        for(int[] row:max)
            Arrays.fill(row, Integer.MIN_VALUE);
        
        for(int i=0;i<n;i++)
            max[i][i] = arr[i];

            return findSumTD(dp, max, 0, n-1, arr);       
    }

    static int findSumBU(int[] arr){
        int n = arr.length;
        int[][] dp = new int[n][n];

        int[][] max = new int[n][n];
        for(int i=0;i<n;i++)
            max[i][i] = arr[i];
        
        for (int l = 1; l < n; l++) { // l is length of range.
            for (int i = 0, j = i+l; j < n; i++, j++) { 
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + max[i][k] * max[k+1][j]);
                    max[i][j] = Math.max(max[i][k], max[k+1][j]);
                }
            }
        }
        return dp[0][n-1];
    }
    
    public static void main(String args[]) {
        int arr[] = {6,2,4} ;
        System.out.println("Total cost: " + findSumTD(arr));
        System.out.println("Total cost: " + findSumBU(arr));
    }
}

/*
Total cost: 32
Total cost: 32
*/