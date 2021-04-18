
public class InsertionSort {
    private boolean more(int value1, int value2) {
        return value1 > value2;
    }

    public void sort(int[] arr) {
        int size = arr.length;
        int temp, j;
        for (int i = 1; i < size; i++) {
            temp = arr[i];
            for (j = i; j > 0 && more(arr[j - 1], temp); j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = { 9, 1, 8, 2, 7, 3, 6, 4, 5 };
        BubbleSort srt = new BubbleSort();
        srt.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");

        }
    }
}
/*
1 2 3 4 5 6 7 8 9
*/