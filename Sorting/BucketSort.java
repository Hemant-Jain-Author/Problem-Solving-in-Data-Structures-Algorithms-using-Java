public class BucketSort {

	int[] array;
	int range;
	int lowerRange;

	public BucketSort(int[] arr, int lowerRange, int upperRange) {
		array = arr;
		range = upperRange - lowerRange;
		this.lowerRange = lowerRange;
	}

	public void sort() {
		int i, j;
		int size = array.length;
		int[] count = new int[range];

		for (i = 0; i < range; i++) {
			count[i] = 0;
		}

		for (i = 0; i < size; i++) {
			count[array[i] - lowerRange]++;
		}

		j = 0;

		for (i = 0; i < range; i++) {
			for (; count[i] > 0; (count[i])--) {
				array[j++] = i + lowerRange;
			}
		}
	}
}