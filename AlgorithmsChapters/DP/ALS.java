package DP;

import java.util.Arrays;

public class ALS {
    static int fastestWayBU2(int a[][], int t[][], int e[], int x[], int n) {
        int[] f1= new int[n];
        int[] f2 =new int[n];        
     
        // Time taken to leave first station.
        f1[0] = e[0] + a[0][0];
        f2[0] = e[1] + a[1][0];
     
        // Fill the tables f1[] and f2[] using
        // bottom up approach.
        for (int i = 1; i < n; ++i) {
            f1[i] = Math.min(f1[i-1] + a[0][i],
                    f2[i-1] + t[1][i-1] + a[0][i]);
            f2[i] = Math.min(f2[i-1] + a[1][i],
                    f1[i-1] + t[0][i-1] + a[1][i]);
        }
     
        // Consider exit times and return minimum.
        return Math.min(f1[n-1] + x[0], f2[n-1] + x[1]);
    }
/*    
    static int fastestWayTD(int a[][], int t[][], int e[], int x[], int n) {
        int[] f1= new int[n];
        int[] f2 =new int[n];  

        // time taken to leave first station.
        f1[0] = e[0] + a[0][0];
        f2[0] = e[1] + a[1][0];
     
        fastestWayTD(f1, f2, a, t, n-1);
        return Math.min(f1[n-1] + x[0], f2[n-1] + x[1]);      
    }

    static void fastestWayTD(int[] f1, int[] f2, int a[][], int t[][], int i) {
        if(i == 0)
            return;
        fastestWayTD(f1, f2, a, t, i-1);
        // Fill the tables f1[] and f2[] using top-down approach.
        f1[i] = Math.min(f1[i-1] + a[0][i], f2[i-1] + t[1][i-1] + a[0][i]);
        f2[i] = Math.min(f2[i-1] + a[1][i], f1[i-1] + t[0][i-1] + a[1][i]);
    }
*/
    static int fastestWayBU(int a[][], int t[][], int e[], int x[], int n) {
        int[][] f= new int[2][n];
     
        // Time taken to leave first station.
        f[0][0] = e[0] + a[0][0];
        f[1][0] = e[1] + a[1][0];
     
        // Fill the tables f1[] and f2[] using
        // bottom up approach.
        for (int i = 1; i < n; ++i) {
            f[0][i] = Math.min(f[0][i-1] + a[0][i],
                    f[1][i-1] + t[1][i-1] + a[0][i]);
            f[1][i] = Math.min(f[1][i-1] + a[1][i],
                    f[0][i-1] + t[0][i-1] + a[1][i]);
        }
     
        // Consider exit times and return minimum.
        return Math.min(f[0][n-1] + x[0], f[1][n-1] + x[1]);
    }

    
    static int fastestWayTD(int a[][], int t[][], int e[], int x[], int n) {
        int[][] f= new int[2][n];
     
        // Time taken to leave first station.
        f[0][0] = e[0] + a[0][0];
        f[1][0] = e[1] + a[1][0];
     
        fastestWayTD(f, a, t, n-1);
        return Math.min(f[0][n-1] + x[0], f[1][n-1] + x[1]);      
    }

    static void fastestWayTD(int[][] f, int a[][], int t[][], int i) {
        if(i == 0)
            return;
        fastestWayTD(f, a, t, i-1);
        // Fill the tables f1[] and f2[] using top-down approach.
        f[0][i] = Math.min(f[0][i-1] + a[0][i], f[1][i-1] + t[1][i-1] + a[0][i]);
        f[1][i] = Math.min(f[1][i-1] + a[1][i], f[0][i-1] + t[0][i-1] + a[1][i]);
    }



    // Driver code
    public static void main (String[] args) {
        int a[][] = {{7, 9, 3, 4, 8, 4},
                    {8, 5, 6, 4, 5, 7}};
        int t[][] = {{2, 3, 1, 3, 4},
                    {2, 1, 2, 2, 1}};
        int e[] = {2, 4};
        int x[] = {3, 2};
        int n = 6;
        System.out.println(fastestWayBU2(a, t, e, x, n));   
        System.out.println(fastestWayBU(a, t, e, x, n));   
        System.out.println(fastestWayTD(a, t, e, x, n));   
    }
}
