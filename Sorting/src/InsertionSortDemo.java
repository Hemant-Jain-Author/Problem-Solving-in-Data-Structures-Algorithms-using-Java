public class InsertionSortDemo {
	public static void main(String[] args) {
		int[] array = { 9, 1, 8, 2, 7, 3, 6, 4, 5 };
		InsertionSort bs = new InsertionSort(array);
		bs.sort();
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");

		}
	}
}
