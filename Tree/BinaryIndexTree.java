import java.util.*;

public class BinaryIndexTree {
    int BIT[];
    int size;     

    BinaryIndexTree(int arr[])
    {
        size = arr.length;
        BIT = new int[size+1];
        Arrays.fill(BIT, 0);

        // Populating bit. 
        for(int i = 0; i < size; i++)
            update(i, arr[i]);    
    }

    public void set(int arr[], int index, int val)
    {
        int diff = val - arr[index];
        arr[index] = val;
        
        // Difference is propagated.
        update(index, diff);
    }

    private void update(int index, int val)
    {
        // Index in bit is 1 more than the input array.
        index = index + 1;
      
        // Traverse to ancestors of nodes.
        while(index <= size)
        {
            // Add val to current node of Binary Index Tree.
            BIT[index] += val;
        
            // Next element which need to store val.
            index += index & (-index);
        }
    }

    // Range sum in the range start to end.
    int rangeSum(int start, int end)
    {
        // Check for error conditions.
        if (start > end || start < 0 || end > size - 1 ) {
            System.out.println("Invalid Input.");
            return -1;
        }

        return prefixSum(end) - prefixSum(start-1);
    }

    // Prefix sum in the range 0 to index.
    int prefixSum(int index) 
    {
        int sum = 0;
        index = index + 1;

        // Traverse ancestors of Binary Index Tree nodes.
        while(index > 0)
        {
            // Add current element to sum.
            sum += BIT[index];
      
            // Parent index calculation.
            index -= index & (-index);
        }
        return sum;
    }
  
  
    // Main function
    public static void main(String args[])
    {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        BinaryIndexTree tree = new BinaryIndexTree(arr);
    
        System.out.println("Sum of elements in range(0, 5): " + tree.prefixSum(5));
        System.out.println("Sum of elements in range(2, 5): " + tree.rangeSum(2, 5));

        // Set fourth element to 10.
        tree.set(arr, 3, 10); 
  
        // Find sum after the value is updated
        System.out.println("Sum of elements in range(0, 5): " + tree.prefixSum(5));
    }
}

/*
Sum of elements in range(0, 5): 21
Sum of elements in range(2, 5): 15
Sum of elements in range(0, 5): 27
*/