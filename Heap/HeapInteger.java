public class HeapInteger {

    private static final int CAPACITY = 32;
    private int size; // Number of elements in heap
    private int[] arr; // The heap array

    public HeapInteger() {
        arr = new int[CAPACITY];
        size = 0;
    }

    public HeapInteger(int[] array) {
        size = array.length;
        arr = array;
        // Build Heap operation over array
        for (int i = (size / 2); i >= 0; i--) {
            proclateDown(i);
        }
    }
    // Other Methods.

    private void proclateDown(int position) {
        int lChild = 2 * position + 1;
        int rChild = lChild + 1;
        int small = -1;
        int temp;

        if (lChild < size) {
            small = lChild;
        }

        if (rChild < size && (arr[rChild] - arr[lChild]) < 0) {
            small = rChild;
        }

        if (small != -1 && (arr[small] - arr[position]) < 0) {
            temp = arr[position];
            arr[position] = arr[small];
            arr[small] = temp;
            proclateDown(small);
        }
    }

    private void proclateUp(int position) {
        int parent = (position - 1) / 2;
        int temp;
        if (parent == 0) {
            return;
        }

        if ((arr[parent] - arr[position]) > 0) {
            temp = arr[position];
            arr[position] = arr[parent];
            arr[parent] = temp;
            proclateUp(parent);
        }
    }

    public void add(int value) {
        if (size == arr.length - 1) {
            doubleSize();
        }

        arr[size++] = value;
        proclateUp(size - 1);
    }

    private void doubleSize() {
        int[] old = arr;
        arr = new int[arr.length * 2];
        System.arraycopy(old, 0, arr, 0, size);
    }

    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        int value = arr[0];
        arr[0] = arr[size - 1];
        size--;
        proclateDown(0);
        return value;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(" " + arr[i]);
        }
    }

    boolean IsMinHeap(int[] arr, int size) {
        for (int i = 0; i <= (size - 2) / 2; i++) {
            if (2 * i + 1 < size) {
                if (arr[i] > arr[2 * i + 1]) {
                    return false;
                }
            }
            if (2 * i + 2 < size) {
                if (arr[i] > arr[2 * i + 2]) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean IsMaxHeap(int[] arr, int size) {
        for (int i = 0; i <= (size - 2) / 2; i++) {
            if (2 * i + 1 < size) {
                if (arr[i] < arr[2 * i + 1]) {
                    return false;
                }
            }
            if (2 * i + 2 < size) {
                if (arr[i] < arr[2 * i + 2])
                    return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return arr[0];
    }

    public static void heapSort(int[] array, boolean inc) {
        HeapInteger hp = new HeapInteger(array);
        int temp;
        for (int i = 0; i < array.length; i++) {
            array[array.length - i - 1] = hp.remove();
        }
        if (inc)
            for (int start = 0, stop = array.length - 1; start < stop; start++, stop--) {
                temp = array[start];
                array[start] = array[stop];
                array[stop] = temp;
            }

    }

    public static void main(String[] args) {
        int[] a = { 1, 9, 6, 7, 8, 0, 2, 4, 5, 3 };
        HeapInteger hp = new HeapInteger(a);
        hp.print();

        for (int i = 0; i < a.length; i++) {
            System.out.println("pop value :: " + hp.remove());
        }

        System.out.println();
        int[] a1 = { 1, 9, 6, 7, 8, 0, 2, 4, 5, 3 };
        HeapInteger.heapSort(a1, true);
        for (int i = 0; i < a1.length; i++) {
            System.out.print(" " + a1[i]);
        }
        System.out.println();
        int[] a2 = { 1, 9, 6, 7, 8, 0, 2, 4, 5, 3 };
        HeapInteger.heapSort(a2, false);
        for (int i = 0; i < a2.length; i++) {
            System.out.print(" " + a2[i]);
        }
    }
}
