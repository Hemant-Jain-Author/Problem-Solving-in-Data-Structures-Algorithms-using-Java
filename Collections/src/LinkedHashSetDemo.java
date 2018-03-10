import java.util.HashSet;
import java.util.LinkedHashSet;

public class LinkedHashSetDemo {
	public static void main(String[] args) {
		// Create a hash set.
		HashSet<String> hs = new HashSet<String>();
		// Add elements to the hash set.
		hs.add("India");
		hs.add("USA");
		hs.add("Brazile");
		hs.add("Canada");
		hs.add("UK");
		hs.add("China");
		hs.add("France");
		hs.add("Spain");
		hs.add("Italy");
		System.out.println("HashSet value:: " + hs);

		// Create a linked hash set.
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();
		// Add elements to the linked hash set.
		lhs.add("India");
		lhs.add("USA");
		lhs.add("Brazile");
		lhs.add("Canada");
		lhs.add("UK");
		lhs.add("China");
		lhs.add("France");
		lhs.add("Spain");
		lhs.add("Italy");
		System.out.println("LinkedHashSet value:: " + lhs);
	}
}
