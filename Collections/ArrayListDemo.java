import java.util.ArrayList;

public class ArrayListDemo {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();

		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		System.out.println("Contents of Array: " + al);

		al.add(2, 9);
		al.add(5, 9);
		System.out.println("Contents of Array: " + al);

		System.out.println("Array Size: " + al.size());

		System.out.println("Array IsEmpty: " + al.isEmpty());

		al.remove(al.size() - 1);

		System.out.println("Array Size: " + al.size());
		al.removeAll(al);

		System.out.println("Array IsEmpty: " + al.isEmpty());
	}
}