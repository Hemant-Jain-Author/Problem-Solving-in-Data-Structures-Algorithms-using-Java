public class BubbleSort {
    private boolean less(int value1, int value2) {
        return value1 < value2;
    }

    private boolean more(int value1, int value2) {
        return value1 > value2;
    }

    public void sort(int[] arr) {
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

    public void sort2(int[] arr) {
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
        BubbleSort b = new BubbleSort();
        b.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        int[] array2 = { 9, 1, 8, 2, 7, 3, 6, 4, 5 };
        b = new BubbleSort();
        b.sort2(array2);
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + " ");
        }
    }
}
/*
1 2 3 4 5 6 7 8 9 
1 2 3 4 5 6 7 8 9
*/