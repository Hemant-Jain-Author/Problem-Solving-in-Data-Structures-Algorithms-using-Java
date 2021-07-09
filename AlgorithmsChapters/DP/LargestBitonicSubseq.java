package DP;

import java.util.Arrays;

public class LargestBitonicSubseq {
    static int lbs(int[] arr) {
        int n = arr.length;
        int[] lis = new int[n];
        Arrays.fill(lis, 1); // Initialize LIS values for all indexes as 1.
        int[] lds = new int[n];
        Arrays.fill(lds, 1); // Initialize LDS values for all indexes as 1.
        int max = 0;

        // Populating LIS values in bottom up manner.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;
            }
        }

        // Populating LDS values in bottom up manner.
        for (int i = n-1; i > 0; i--) {
            for (int j = n-1; j > i; j--) {
                if (arr[j] < arr[i] && lds[i] < lds[j] + 1)
                    lds[i] = lds[j] + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            max = Math.max(max, lis[i] + lds[i] - 1);
        }

        return max;
    }
 
    public static void main(String args[])
    {
        int arr[] = { 1, 6, 3, 11, 1, 9, 5, 12, 3, 14, 6, 17, 3, 19, 2, 19};
        System.out.println("Length of lis is " + lbs(arr));
    }    
}
/*

Function LBS(arr ):
    maxValue = 0
    size = len(arr)
    lis = [1]*size
    lds = [1]*size
    for i in range(size):
        for j in range(i):
            if arr[j] < arr[i] and lis[i] < lis[j] + 1:
                lis[i] = lis[j] + 1

    for i in reversed(range(size)):
        for j in reversed(range(i, size)):
            if arr[j] < arr[i] and lds[i] < lds[j] + 1:
                lds[i] = lds[j] + 1

    for i in range(size):
        maxValue = max((lis[i] + lds[i] - 1), maxValue)
    return maxValue

arr = [1, 6, 3, 11, 1, 9, 5, 12, 3, 14, 6, 17, 3, 19, 2, 19]
print LBS(arr)

1 6 11 12 14 17 3 2
1 6 9 12 14 6 3 2 


*/