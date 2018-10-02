public class Heap {

	private static final int CAPACITY = 32;
	private int size; // Number of elements in Heap
	private int[] arr; // The Heap array
	boolean isMinHeap;

	public Heap(boolean isMin) {
		arr = new int[CAPACITY];
		size = 0;
		isMinHeap = isMin;
	}

	public Heap(int[] array, boolean isMin) {
		size = array.length;
		arr = array;
		isMinHeap = isMin;
		// Build Heap operation over array
		for (int i = (size / 2); i >= 0; i--) {
			proclateDown(i);
		}
	}

	// Other Methods.

	boolean compare(int[] arr, int first, int second) {
		if (isMinHeap)
			return (arr[first] - arr[second]) > 0; // Min heap compare
		else
			return (arr[first] - arr[second]) < 0; // Max heap compare
	}

	private void proclateDown(int parent) {
		int lChild = 2 * parent + 1;
		int rChild = lChild + 1;
		int child = -1;
		int temp;

		if (lChild < size) {
			child = lChild;
		}

		if (rChild < size && compare(arr, lChild, rChild)) {
			child = rChild;
		}

		if (child != -1 && compare(arr, parent, child)) {
			temp = arr[parent];
			arr[parent] = arr[child];
			arr[child] = temp;
			proclateDown(child);
		}
	}

	private void proclateUp(int child) {
		int parent = (child - 1) / 2;
		int temp;
		if (parent < 0) {
			return;
		}

		if (compare(arr, parent, child)) {
			temp = arr[child];
			arr[child] = arr[parent];
			arr[parent] = temp;
			proclateUp(parent);
		}
	}

	public void add(int value) {
		if (size == arr.length) {
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
			System.out.print(arr[i] + " ");
		}
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public int length() {
		return size;
	}

	public int peek() {
		if (isEmpty()) {
			throw new IllegalStateException();
		}
		return arr[0];
	}

	public static void heapSort(int[] array, boolean inc) {
		// Create max heap for increasing order sorting.
		Heap hp = new Heap(array, !inc);
		for (int i = 0; i < array.length; i++) {
			array[array.length - i - 1] = hp.remove();
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 9, 6, 7, 8, 0, 2, 4, 5, 3 };
		Heap hp = new Heap(a, true);
		hp.add(-1);
		hp.add(100);
		hp.print();
		System.out.println();
		while (!hp.isEmpty()) {
			System.out.print(hp.remove() + " ");
		}
		System.out.println();

		int[] a2 = { 1, 9, 6, 7, 8, 0, 2, 4, 5, 3 };
		Heap.heapSort(a2, true);
		for (int i = 0; i < a2.length; i++) {
			System.out.print(a2[i] + " ");
		}
		System.out.println();

		int[] a3 = { 1, 9, 6, 7, 8, 0, 2, 4, 5, 3 };
		Heap.heapSort(a3, false);
		for (int i = 0; i < a3.length; i++) {
			System.out.print(a3[i] + " ");
		}
	}

	boolean isMinHeap(int[] arr, int size) {
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

	boolean isMaxHeap(int[] arr, int size) {
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
}
