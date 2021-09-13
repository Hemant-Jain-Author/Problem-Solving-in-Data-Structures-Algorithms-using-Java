import java.util.TreeSet;
public class TreeSetDemo {
    public static void main(String[] args) {
        // Create a tree set.
        TreeSet<String> ts = new TreeSet<String>();
        // Add elements to the hash set.
        ts.add("Banana");
        ts.add("Apple");
        ts.add("Mango");
        System.out.println(ts);
        System.out.println("Apple present : " + ts.contains("Apple"));
        System.out.println("Grapes present : " + ts.contains("Grapes"));
        ts.remove("Apple");
        System.out.println(ts);
        System.out.println("Apple present : " + ts.contains("Apple"));
    }
}

/*
[Apple, Banana, Mango]
Apple present : true
Grapes present : false
[Banana, Mango]
Apple present : false
*/