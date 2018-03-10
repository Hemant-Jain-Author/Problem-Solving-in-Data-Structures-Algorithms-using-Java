
/*
 * A map is an object that stores associations between keys and values, or key/value pairs.
 Both keys and values are objects. The keys must be unique, but
the values may be duplicated.
 */
import java.util.HashMap;

public class HashMapDemo {

	public static void main(String[] args) {

		// Create a hash map.
		HashMap<String, Integer> hm = new HashMap<String, Integer>();

		// Put elements into the map
		hm.put("Mason", new Integer(55));
		hm.put("Jacob", new Integer(77));
		hm.put("William", new Integer(99));
		hm.put("Alexander", new Integer(80));
		hm.put("Michael", new Integer(50));
		hm.put("Emma", new Integer(65));
		hm.put("Olivia", new Integer(77));
		hm.put("Sophia", new Integer(88));
		hm.put("Emily", new Integer(99));
		hm.put("Isabella", new Integer(100));

		System.out.println("Total number of students in class :: " + hm.size());
		for (String key : hm.keySet()) {
			System.out.println(key + " score marks :" + hm.get(key));
		}

		System.out.println("Emma present in class :: " + hm.containsKey("Emma"));
		System.out.println("John present in class :: " + hm.containsKey("John"));
	}
}
