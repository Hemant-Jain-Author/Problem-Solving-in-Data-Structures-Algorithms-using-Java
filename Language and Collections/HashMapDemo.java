
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
        hm.put("Apple", 40);
        hm.put("Banana", 10);
        hm.put("Mango", 20);

        System.out.println("Size :: " + hm.size());
        for(String key : hm.keySet())
            System.out.println(key + " cost :" + hm.get(key));
        System.out.println("Apple present ::" + hm.containsKey("Apple"));
        System.out.println("Grapes present :: " + hm.containsKey("Grapes"));
    }
}

/*
Size :: 3
Apple cost :40
Mango cost :20
Banana cost :10
Apple present ::true
Grapes present :: false
*/