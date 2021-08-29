public class NutsAndBolts {
    public static void main(String[] args) {
        int nuts[] = {1, 2, 6, 5, 4, 3};
        int bolts[] = {6, 4, 5, 1, 3, 2};
        makePairs(nuts, bolts);
    }
 
    private static void printArray(int[] arr) {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }
 
    public static void makePairs(int[] nuts, int[] bolts){
        makePairs(nuts, bolts, 0, nuts.length - 1);
        System.out.println("Matched nuts and bolts are : ");
        printArray(nuts);
        printArray(bolts);
    }

    // Quick sort kind of approach.
    private static void makePairs(int[] nuts, int[] bolts, int low, int high) {
        if (low < high) {
            // Choose first element of bolts array as pivot to partition nuts.
            int pivot = partition(nuts, low, high, bolts[low]);
 
            // Using nuts[pivot] as pivot to partition bolts.
            partition(bolts, low, high, nuts[pivot]);
 
            // Recursively lower and upper half of nuts and bolts are matched.
            makePairs(nuts, bolts, low, pivot-1);
            makePairs(nuts, bolts, pivot+1, high);
        }
    }
    private static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    
    // Partition method similar to quick sort algorithm.
    private static int partition(int[] arr, int low, int high, int pivot) {
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot){
                swap(arr, i, j);
                i++;
            } else if(arr[j] == pivot){
                swap(arr, high, j);
                j--;
            }
        }
        swap(arr, i, high);
        return i;
    }
}