public class QuickSortDemo {
	public static void main(String[] args) {
		int[] array = { 3, 4, 2, 1, 6, 5, 7, 8, 1, 1 };
		QuickSort m = new QuickSort(array);
		m.sort();
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}