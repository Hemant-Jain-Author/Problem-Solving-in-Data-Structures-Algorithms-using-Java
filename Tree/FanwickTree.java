import java.util.*;

public class FanwickTree {
    int fanArray[];
    int size;     

    FanwickTree(int arr[])
    {
        size = arr.length;
        fanArray = new int[size+1];
        Arrays.fill(fanArray, 0);

        // Populating fanArray. 
        for(int i = 0; i < size; i++)
            update(i, arr[i]);    
    }

    public void set(int arr[], int index, int val)
    {
        int diff = val - arr[index];
        arr[index] = val;
        
        // Difference is propogated.
        update(index, diff);
    }

    private void update(int index, int val)
    {
        // Index in fanArray is 1 more than the input array.
        index = index + 1;
      
        // Traverse to ancestors of nodes.
        while(index <= size)
        {
            // Add val to current node of fanwick Tree.
            fanArray[index] += val;
        
            // Next element index calculation.
            index += index & (-index);
        }
    }

    // Get sum in the range start to end.
    int getSum(int start, int end)
    {
        // Check for error conditions.
        if (start > end || start < 0 || end > size - 1 ) {
            System.out.println("Invalid Input.");
            return -1;
        }

        return getSum(end) - getSum(start);
    }

    // Get sum in the range 0 to index.
    int getSum(int index) 
    {
        int sum = 0;
        index = index + 1;

        // Traverse ancestors of fanwick nodes.
        while(index>0)
        {
            // Add current element to sum.
            sum += fanArray[index];
      
            // Parent index calculation.
            index -= index & (-index);
        }
        return sum;
    }
  
  
    // Main function
    public static void main(String args[])
    {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        FanwickTree tree = new FanwickTree(arr);
    
        System.out.println("Sum of elements in range(0, 5) :" + tree.getSum(5));
          
        // Set fourth element to 10.
        tree.set(arr, 3, 10); 
  
        // Find sum after the value is updated
        System.out.println("Sum of elements in range(0, 5): " + tree.getSum(5));
    }
}