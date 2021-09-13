import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<Integer>();    
        al.add(1); // add 1 to the end of the list 
        al.add(2); // add 2 to the end of the list
        System.out.println("Contents of Array : " + al);     
        System.out.println("Array Size : " + al.size()); 
        System.out.println("Array IsEmpty : " + al.isEmpty());
        al.remove(al.size() -1); // last element of array is removed.
        al.removeAll(al); // all the elements of array are removed.
        System.out.println("Array IsEmpty : " + al.isEmpty());
    }
}

/*
Contents of Array : [1, 2]
Array Size : 2
Array IsEmpty : false
Array IsEmpty : true
*/
