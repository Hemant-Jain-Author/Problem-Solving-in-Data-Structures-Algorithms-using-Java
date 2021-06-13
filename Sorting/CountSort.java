public class CountSort {
    public void sort(int[] arr, int lowerRange, int upperRange) {
        int i, j;
        int size = arr.length;
        int range = upperRange - lowerRange;
        int[] count = new int[range];

        for (i = 0; i < size; i++) {
            count[arr[i] - lowerRange]++;
        }

        j = 0;
        for (i = 0; i < range; i++) {
            for (; count[i] > 0; (count[i])--) {
                arr[j++] = i + lowerRange;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = { 23, 24, 22, 21, 26, 25, 27, 28, 21, 21 };
        CountSort b = new CountSort();
        b.sort(array, 20, 30);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}

/*
21 21 21 22 23 24 25 26 27 28
*/