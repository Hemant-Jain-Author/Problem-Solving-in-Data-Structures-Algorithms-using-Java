public class QuickSort {
    private void swap(int arr[], int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private void quickSortUtil(int arr[], int lower, int upper) {
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
        quickSortUtil(arr, start, upper - 1); // pivot -1 is the upper for left sub array.
        quickSortUtil(arr, upper + 1, stop); // pivot + 1 is the lower for right sub array.
    }

    public void sort(int[] arr) {
        int size = arr.length;
        quickSortUtil(arr, 0, size - 1);
    }

    public static void main(String[] args) {
        int[] array = { 3, 4, 2, 1, 6, 5, 7, 8, 1, 1 };
        QuickSort m = new QuickSort();
        m.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}