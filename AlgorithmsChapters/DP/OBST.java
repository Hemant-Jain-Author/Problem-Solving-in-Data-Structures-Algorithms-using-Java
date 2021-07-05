package DP;

public class OBST {
    static int optCost(int freq[], int i, int j) {
       if (j == i) // one element in this subarray
         return freq[i];

       int min = Integer.MAX_VALUE;
       for (int r = i; r <= j; r++) {
            min = Math.min(min, ((r-1 >= i )? optCost(freq, i, r-1): 0) + 
            ((r+1 <= j)? optCost(freq, r+1, j): 0));
       }
       return min + sum(freq, i, j);
    }
     
    static int optCost(int keys[], int freq[], int n) {
         return optCost(freq, 0, n-1);
    }
     
    static int sum(int freq[], int i, int j) {
        int s = 0;
        for (int k = i; k <=j; k++)
           s += freq[k];
        return s;
    }
    
    static int optCostDP(int keys[], int freq[], int n) {
        int cost[][] = new int[n][n];
        for (int i = 0; i < n; i++)
            cost[i][i] = freq[i];
 
        for (int l = 1; l < n; l++) {
             for (int i = 0; i < n - l; i++) {
                int j = i + l;
                cost[i][j] = Integer.MAX_VALUE;
                for (int r = i; r <= j; r++) {
                    cost[i][j] = Math.min( cost[i][j], sum(freq, i, j) +
                    ((r-1 >= i)? cost[i][r-1] : 0) + ((r+1 <= j)? cost[r+1][j] : 0));
                }
            }
        }
        return cost[0][n - 1];
    }

    public static void main(String[] args) {
        int keys[] = {9, 15, 25};
        int freq[] = {30, 10, 40};
        int n = keys.length;
        System.out.println("OBST cost:" + optCost(keys, freq, n));
        System.out.println("OBST cost:" + optCostDP(keys, freq, n));
    }  
}
/*
OBST cost:130
OBST cost:130
*/