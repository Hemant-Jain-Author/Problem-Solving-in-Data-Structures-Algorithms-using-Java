
public class InsertionSort {
	private int[] arr;

	public InsertionSort(int[] array) {
		arr = array;
	}

	private boolean more(int value1, int value2) {
		return value1 > value2;
	}

	public void sort() {
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
}