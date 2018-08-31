public class SelectionSort {
	private int[] arr;

	public SelectionSort(int[] array) {
		arr = array;
	}

	private boolean less(int value1, int value2) {
		return value1 < value2;
	}

	private boolean more(int value1, int value2) {
		return value1 > value2;
	}

	public void sort()// back array
	{
		int size = arr.length;
		int i, j, max, temp;
		for (i = 0; i < size - 1; i++) {
			max = 0;
			for (j = 1; j < size - 1 - i; j++) {
				if (arr[j] > arr[max]) {
					max = j;
				}
			}
			temp = arr[size - 1 - i];
			arr[size - 1 - i] = arr[max];
			arr[max] = temp;
		}
	}

	void sort2()// front array
	{
		int size = arr.length;
		int i, j, min, temp;
		for (i = 0; i < size - 1; i++) {
			min = i;
			for (j = i + 1; j < size; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
	}
}