import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        // Create a hash set.
        HashSet<String> hs = new HashSet<String>();
        // Add elements to the hash set.
        hs.add("Banana");
        hs.add("Apple");
        hs.add("Mango");
        System.out.println(hs);
        System.out.println("Apple present : " + hs.contains("Apple"));
        System.out.println("Grapes present : " + hs.contains("Grapes"));
        hs.remove("Apple");
        System.out.println(hs);
        System.out.println("Apple present : " + hs.contains("Apple"));
    }
}

/*
[Apple, Mango, Banana]
Apple present : true
Grapes present : false
[Mango, Banana]
Apple present : false
*/