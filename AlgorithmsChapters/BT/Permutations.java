class Permutations {
    private static void printArray(int[] arr, int n) {
        for(int i=0;i<n;i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void permutation(int[] arr, int i, int length) {
        if (length == i) {
            printArray(arr, length);
            return;
        }
    
        for (int j = i; j < length; j++) {
            swap(arr, i, j);
            permutation(arr, i + 1, length);
            swap(arr, i, j);
        }
        return;
    }

/*
1 2 3 4 
1 2 4 3 
.....
4 1 3 2 
4 1 2 3 
*/

    private static boolean isValid(int[] arr, int n){
        for(int j = 1;j<n;j++){
            if(Math.abs(arr[j] - arr[j-1]) < 2)
                return false;
        }
        return true;
    }

    public static void permutation2(int[] arr, int i, int length) {
        if (length == i) {
            if(isValid(arr, length))
                printArray(arr, length);
            return;
        }
    
        for (int j = i; j < length; j++) {
            swap(arr, i, j);
            permutation2(arr, i + 1, length);
            swap(arr, i, j);
        }
        return;
    }
    
    private static boolean isValid2(int[] arr, int i){
        if(i < 1 || Math.abs(arr[i] - arr[i-1]) >= 2)
            return true;
        return false;
    }

    public static void permutation3(int[] arr, int i, int length) {
        if (length == i) {
            printArray(arr, length);
            return;
        }
    
        for (int j = i; j < length; j++) {
            swap(arr, i, j);
            if(isValid2(arr, i))
                permutation3(arr, i + 1, length);
            swap(arr, i, j);
        }
        return;
    }

    /* Testing code */
    public static void main(String[] args) {
        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = i+1;
        }
        permutation3(arr, 0, 4);
    }
}

/*
2 4 1 3 
3 1 4 2
*/
