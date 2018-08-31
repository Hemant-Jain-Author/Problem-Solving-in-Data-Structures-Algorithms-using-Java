public class Heap {

	private static final int CAPACITY = 16;
	private int size; // Number of elements in heap
	private int[] arr; // The heap array

	public Heap() {
		arr = new int[CAPACITY];
		size = 0;
	}

	public Heap(int[] array) {
		size = array.length;
		arr = new int[array.length + 1];
		System.arraycopy(array, 0, arr, 1, array.length);// we do not use 0
															// index

		// Build Heap operation over array
		for (int i = (size / 2); i > 0; i--) {
			proclateDown(i);
		}
	}
	// Other Methods.

	private void proclateDown(int position) {
		int lChild = 2 * position;
		int rChild = lChild + 1;
		int small = -1;
		int temp;

		if (lChild <= size) {
			small = lChild;
		}

		if (rChild <= size && (arr[rChild] - arr[lChild]) < 0) {
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
		int parent = position / 2;
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

		arr[++size] = value;
		proclateUp(size);
	}

	private void doubleSize() {
		int[] old = arr;
		arr = new int[arr.length * 2];
		System.arraycopy(old, 1, arr, 1, size);
	}

	public int remove() {
		if (isEmpty()) {
			throw new IllegalStateException();
		}

		int value = arr[1];
		arr[1] = arr[size];
		size--;
		proclateDown(1);
		return value;
	}

	public void print() {
		for (int i = 1; i <= size; i++) {
			System.out.print(" " +arr[i]);
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
		return arr[1];
	}

	public static void heapSort(int[] array) {
		Heap hp = new Heap(array);
		for (int i = 0; i < array.length; i++) {
			array[i] = hp.remove();
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 9, 6, 7, 8, 0, 2, 4, 5, 3 };
		Heap hp = new Heap(a);
		hp.print();
/*		for (int i = 0; i < a.length; i++) {
			System.out.println("pop value :: " + hp.remove());
		}

		Heap.heapSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println("value is :: " + a[i]);
		}*/
	}
}
