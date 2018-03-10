public class QuickSelectDemo {
	public static void main(String[] args) {
		int[] array = { 3, 4, 2, 1, 6, 5, 7, 8, 10, 9 };
		QuickSelect.quickSelect(array, 5);
		System.out.print("value at index 5 is : " + array[4]);
	}
}