public class ShellSort {
    private boolean less(int value1, int value2) {
        return value1 < value2;
    }

    private boolean more(int value1, int value2) {
        return value1 > value2;
    }

    public void sort(int[] arr) {
        int n = arr.length;
 
        // Gap starts with n/2 and half in each iteration.
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            // Do a gapped insertion sort.
            for (int i = gap; i < n; i += 1)
            {
                int curr = arr[i];

                // Shift elements of already sorted list
                // to find right possition for curr value.
                int j;
                for (j = i; j >= gap && more(arr[j - gap], curr); j -= gap)
                    arr[j] = arr[j - gap];
 
                // Put current value in its correct location
                arr[j] = curr;
            }
            printArray(arr);
        }
    }

    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = { 36, 32, 11, 6, 19, 31, 17, 3 };
        
        ShellSort b = new ShellSort();
        b.printArray(array);
        b.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
/*
1 2 3 4 5 6 7 8 9 
*/