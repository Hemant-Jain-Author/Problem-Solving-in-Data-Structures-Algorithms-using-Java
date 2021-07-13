package DP;

class LargestIncreasingSubseq {
    static int lis(int[] arr) {
        int n = arr.length;
        int[] lis = new int[n];
        int max = 0;

        // Populating LIS values in bottom up manner.
        for (int i = 0; i < n; i++) {
            lis[i] = 1;  // Initialize LIS values for all indexes as 1.
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;
            }
            if (max < lis[i]) // Max LIS values.
                max = lis[i]; 
        }
        return max;
    }
 
    public static void main(String args[]) {
        int arr[] = { 10, 12, 9, 23, 25, 55, 49, 70 };
        System.out.println("Length of lis is " + lis(arr));
    }
}