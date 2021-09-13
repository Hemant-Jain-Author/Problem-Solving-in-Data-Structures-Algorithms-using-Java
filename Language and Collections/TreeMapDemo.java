import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        // create a tree map.
        TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
        // Put elements into the map
        tm.put("Apple", 40);
        tm.put("Banana", 10);
        tm.put("Mango", 20);

        System.out.println("Size :: " + tm.size());
        for(String key : tm.keySet())
            System.out.println(key + " cost :" + tm.get(key));
        System.out.println("Apple present ::" + tm.containsKey("Apple"));
        System.out.println("Grapes present :: " + tm.containsKey("Grapes"));
    }
}

/*
Size :: 3
Apple cost :40
Banana cost :10
Mango cost :20
Apple present ::true
Grapes present :: false
*/