public class BubbleSort {

    private int[] arr;

    public BubbleSort(int[] array) {
        arr = array;
    }

    private boolean less(int value1, int value2) {
        return value1 < value2;
    }

    private boolean more(int value1, int value2) {
        return value1 > value2;
    }

    public void sort() {
        int size = arr.length;

        int i, j, temp;
        for (i = 0; i < (size - 1); i++) {
            for (j = 0; j < size - i - 1; j++) {
                if (more(arr[j], arr[j + 1])) {
                    /* Swapping */
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

public void sort2() {
    int size = arr.length;
    int i, j, temp, swapped = 1;
    for (i = 0; i < (size - 1) && swapped == 1; i++) {
        swapped = 0;
        for (j = 0; j < size - i - 1; j++) {
            if (more(arr[j], arr[j + 1])) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                swapped = 1;
            }
        }
    }
}

    public static void main(String[] args) {
        int[] array = { 9, 1, 8, 2, 7, 3, 6, 4, 5 };
        BubbleSort bs = new BubbleSort(array);
        bs.sort2();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}