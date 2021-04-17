public class QuickSelect {
    public static void quickSelect(int arr[], int lower, int upper, int k) {
        if (upper <= lower)
            return;

        int pivot = arr[lower];
        int start = lower;
        int stop = upper;

        while (lower < upper) {
            while (arr[lower] <= pivot && lower < upper) {
                lower++;
            }
            while (arr[upper] > pivot && lower <= upper) {
                upper--;
            }
            if (lower < upper) {
                swap(arr, upper, lower);
            }
        }

        swap(arr, upper, start); // upper is the pivot position
        if (k < upper)
            quickSelect(arr, start, upper - 1, k); // pivot -1 is the upper for
                                                   // left sub array.
        if (k > upper)
            quickSelect(arr, upper + 1, stop, k); // pivot + 1 is the lower for
                                                  // right sub array.
    }

    public static void swap(int arr[], int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static int get(int arr[], int k) {
        quickSelect(arr, 0, arr.length - 1, k);
        return arr[k-1];
    }

    public static void main(String[] args) {
        int[] array = { 3, 4, 2, 1, 6, 5, 7, 8 };
        System.out.print("value at index 5 is : " + QuickSelect.get(array, 5));
    }
}

// value at index 5 is : 5