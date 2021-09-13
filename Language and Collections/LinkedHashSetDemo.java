import java.util.HashSet;
import java.util.LinkedHashSet;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        // Create a hash set.
        HashSet<String> hs = new HashSet<String>();
        // Add elements to the hash set.
        hs.add("Banana");
        hs.add("Apple");
        hs.add("Mango");
        System.out.println("HashSet :: " + hs);

        // Create a linked hash set.
        LinkedHashSet<String> lhs = new LinkedHashSet<String>();
        // Add elements to the linked hash set.
        lhs.add("Banana");
        lhs.add("Apple");
        lhs.add("Mango");
        System.out.println("LinkedHashSet :: " + lhs);    
    }
}

/* 
HashSet :: [Apple, Mango, Banana]
LinkedHashSet :: [Banana, Apple, Mango]
*/