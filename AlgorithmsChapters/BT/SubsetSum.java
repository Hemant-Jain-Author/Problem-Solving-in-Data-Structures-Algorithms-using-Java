public class SubsetSum {
    static void printSubset(boolean flags[], int arr[], int size) {
        for(int i = 0; i < size; i++){
            if(flags[i])
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void subsetSum(int arr[], int n, int target) {
        boolean[] flags = new boolean[n];
        subsetSum(arr, n, flags, 0, 0, target);
    }

    static void subsetSum(int arr[], int n, boolean flags[], int sum, int curr, int target) {
        if( target == sum ) {
            printSubset(flags, arr, n); // Solution found.
            return;
        }

        if( curr >= n || sum > target ) { // constraint check
            // Backtracking.
            return;
        }

        // Current element included.
        flags[curr] = true;
        subsetSum(arr, n, flags, sum + arr[curr], curr+1, target);
        // Current element excluded.
        flags[curr] = false;
        subsetSum(arr, n, flags, sum, curr+1, target); 
    }

    public static void main(String[] args) {
        int arr[] = {15, 22, 14, 26, 32, 9, 16, 8};
        int target = 53;
        int n = arr.length;
        subsetSum(arr, n, target);
    }
}