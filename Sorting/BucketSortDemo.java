
public class BucketSortDemo {
	public static void main(String[] args) {
		int[] array = { 23, 24, 22, 21, 26, 25, 27, 28, 21, 21 };

		BucketSort m = new BucketSort(array, 20, 30);
		m.sort();
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
