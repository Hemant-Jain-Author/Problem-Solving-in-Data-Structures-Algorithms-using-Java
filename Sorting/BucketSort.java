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
    
	public static void main(String[] args) {
		int[] array = { 23, 24, 22, 21, 26, 25, 27, 28, 21, 21 };

		BucketSort m = new BucketSort(array, 20, 30);
		m.sort();
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

}