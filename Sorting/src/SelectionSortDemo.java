public class SelectionSortDemo {
	public static void main(String[] args) {
		int[] array = { 9, 1, 8, 2, 7, 3, 6, 4, 5 };
		SelectionSort bs = new SelectionSort(array);
		bs.sort2();
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}