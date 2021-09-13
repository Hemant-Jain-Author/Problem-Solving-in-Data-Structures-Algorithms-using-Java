import java.util.HashMap;

public class CountMap<T> {
    HashMap<T, Integer> hm = new HashMap<T, Integer>();

    public void add(T key) {
        if (hm.containsKey(key)) {
            hm.put(key, hm.get(key) + 1);
        } else {
            hm.put(key, 1);
        }
    }

    public void remove(T key) {
        if (hm.containsKey(key)) {
            if (hm.get(key) == 1)
                hm.remove(key);
            else {
                hm.put(key, hm.get(key) - 1);
            }
        }
    }

    public int get(T key) {
        if (hm.containsKey(key))
            return hm.get(key);
        return 0;
    }

    public boolean containsKey(T key) {
        return hm.containsKey(key);
    }

    public int size() {
        return hm.size();
    }

    public static void main(String[] args) {
        CountMap<Integer> cm = new CountMap<Integer>();
        cm.add(2);
        cm.add(2);
        System.out.println("count is : " + cm.get(2));
        cm.remove(2);
        System.out.println("count is : " + cm.get(2));
        cm.remove(2);
        System.out.println("count is : " + cm.get(2));
    }

/*
count is : 2
count is : 1
count is : 0
*/

}
