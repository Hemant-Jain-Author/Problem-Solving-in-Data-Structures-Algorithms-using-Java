import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

public class QueueEx {
    public static int CircularTour(int[][] arr, int n) {
        for(int i=0;i<n;i++){
            int total = 0;
            boolean found = true;
            for(int j=0;j<n;j++){
                total += (arr[(i+j)%n][0] - arr[(i+j)%n][1]);
                if(total < 0){
                    found = false;
                    break;
                }
            }
            if(found)
                return i;
        }
        return -1;
    }

    public static int CircularTour2(int[][] arr, int n) {
        ArrayDeque<Integer> que = new ArrayDeque<Integer>();
        int nextPump = 0, prevPump;
        int count = 0;
        int petrol = 0;

        while (que.size() != n) {
            while (petrol >= 0 && que.size() != n) {
                que.add(nextPump);
                petrol += (arr[nextPump][0] - arr[nextPump][1]);
                nextPump = (nextPump + 1) % n;
            }
            while (petrol < 0 && que.size() > 0) {
                prevPump = que.remove();
                petrol -= (arr[prevPump][0] - arr[prevPump][1]);
            }
            count += 1;
            if (count == n)
                return -1;
        }
        if (petrol >= 0)
            return que.remove();
        else
            return -1;
    }

    public static void main1() {
        // Testing code
        int tour[][] = { { 8, 6 }, { 1, 4 }, { 7, 6 } };
        System.out.println("Circular Tour : " + CircularTour(tour, 3));
        System.out.println("Circular Tour : " + CircularTour2(tour, 3));
    }
    /*
    Circular Tour : 2
    */
    public static int convertXY(int src, int dst) {
        ArrayDeque<Integer> que = new ArrayDeque<Integer>();
        int arr[] = new int[100];
        int steps = 0;
        int index = 0;
        int value;

        que.add(src);
        while (que.size() != 0) {
            value = que.remove();
            arr[index++] = value;

            if (value == dst) {
                return steps;
            }
            steps++;
            if (value < dst)
                que.add(value * 2);
            else
                que.add(value - 1);
        }
        return -1;
    }

    public static void main2() {
        System.out.println("Steps counter :: " + convertXY(2, 7));
    }
    /*
    Steps counter :: 3
    */

    public static void maxSlidingWindows(int arr[], int size, int k) {
        for(int i=0;i<size-k+1;i++) {
            int max = arr[i];
            for(int j=1;j<k;j++) {
                max = Math.max(max, arr[i+j]);
            }
            System.out.print(max + " ");
        }
        System.out.println();
    }

    public static void maxSlidingWindows2(int arr[], int size, int k) {
        ArrayDeque<Integer> que = new ArrayDeque<Integer>();
        for (int i = 0; i < size; i++) {
            // Remove out of range elements
            if (que.size() > 0 && que.peek() <= i - k)
                que.remove();
            // Remove smaller values at left.
            while (que.size() > 0 && arr[que.peekLast()] <= arr[i])
                que.removeLast();

            que.add(i);
            // Largest value in window of size k is at index que[0]
            // It is displayed to the screen.
            if (i >= (k - 1))
                System.out.print(arr[que.peek()] + " ");
        }
        System.out.println();
    }

    public static void main3() {
        int arr[] = { 11, 2, 75, 92, 59, 90, 55 };
        maxSlidingWindows(arr, 7, 3);
        maxSlidingWindows2(arr, 7, 3);

    }

    /*
    75 92 92 92 90 
    */

    public static int minOfMaxSlidingWindows(int arr[], int size, int k) {
        ArrayDeque<Integer> que = new ArrayDeque<Integer>();
        int minVal = 999999;
        for (int i = 0; i < size; i++) {
            // Remove out of range elements
            if (que.size() > 0 && que.peek() <= i - k)
                que.remove();
            // Remove smaller values at left.
            while (que.size() > 0 && arr[que.peekLast()] <= arr[i])
                que.remove();
            que.add(i);
            // window of size k
            if (i >= (k - 1) && minVal > arr[que.peek()])
                minVal = arr[que.peek()];
        }
        System.out.println("Min of max is :: " + minVal);
        return minVal;
    }

    public static void main4() {
        int arr[] = { 11, 2, 75, 92, 59, 90, 55 };
        minOfMaxSlidingWindows(arr, 7, 3);
    }
    /*
    Min of max is :: 75
    */
    public static void maxOfMinSlidingWindows(int arr[], int size, int k) {
        ArrayDeque<Integer> que = new ArrayDeque<Integer>();
        int maxVal = -999999;
        for (int i = 0; i < size; i++) {
            // Remove out of range elements
            if (que.size() > 0 && que.peek() <= i - k)
                que.remove();
            // Remove smaller values at left.
            while (que.size() > 0 && arr[que.peekLast()] >= arr[i])
                que.remove();
            que.add(i);
            // window of size k
            if (i >= (k - 1) && maxVal < arr[que.peek()])
                maxVal = arr[que.peek()];
        }
        System.out.println("Max of min is :: " + maxVal);
    }

    public static void main5() {
        int arr[] = { 11, 2, 75, 92, 59, 90, 55 };
        maxOfMinSlidingWindows(arr, 7, 3);
        // Output 59, as minimum values in sliding windows are [2, 2, 59, 59, 55]
    }
    /*
    Max of min is :: 59
    */
    public static void firstNegSlidingWindows(int arr[], int size, int k) {
        ArrayDeque<Integer> que = new ArrayDeque<Integer>();

        for (int i = 0; i < size; i++) {
            // Remove out of range elements
            if (que.size() > 0 && que.peek() <= i - k)
                que.remove();
            if (arr[i] < 0)
                que.add(i);
            // window of size k
            if (i >= (k - 1)) {
                if (que.size() > 0)
                    System.out.print(arr[que.peek()] + " ");
                else
                    System.out.print("NAN");
            }
        }
    }

    public static void main6() {
        int arr[] = { 3, -2, -6, 10, -14, 50, 14, 21 };
        firstNegSlidingWindows(arr, 8, 3);
    }

    /*
    -2 -2 -6 -14 -14 NAN
    */
    
    public static void rottenFruitUtil(int[][] arr, int maxCol, int maxRow, 
    int currCol, int currRow, int[][] traversed, int day) { 
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int x, y;
        for(int i=0; i<4; i++){ 
            x = currCol + dir[i][0];
            y = currRow + dir[i][1];
            if(x >= 0 && x < maxCol && y >= 0 && y < maxRow && 
            traversed[x][y] > day+1 && arr[x][y] == 1){
                traversed[x][y] = day+1;
                rottenFruitUtil(arr, maxCol, maxRow, x, y, traversed, day+1);
            }
        }
    }
    
    public static int rottenFruit(int[][] arr, int maxCol, int maxRow) {
        int[][] traversed = new int[maxCol][maxRow];
        for (int i = 0; i < maxCol; i++) {
            for (int j = 0; j < maxRow; j++) {
                traversed[i][j] = Integer.MAX_VALUE;
            }
        }
    
        for (int i = 0; i < maxCol; i++) {
            for (int j = 0; j < maxRow; j++) {
                if (arr[i][j] == 2) {
                    traversed[i][j] = 0;
                    rottenFruitUtil(arr, maxCol, maxRow, i, j, traversed, 0);
                }
            }
        }
    
        int maxDay = 0;
        for (int i = 0; i < maxCol; i++) {
            for (int j = 0; j < maxRow; j++) {
                if (arr[i][j] == 1) {
                    if (traversed[i][j] == Integer.MAX_VALUE)
                        return -1;
                    if (maxDay < traversed[i][j])
                        maxDay = traversed[i][j];
                }
            }
        }
        return maxDay;
    }
    
    public static class Fruit{
        int x, y;
        int day;
        Fruit(int a, int b, int d){
            x = a;
            y = b;
            day = d;
        }
    }
    
    public static int rottenFruit2(int[][] arr, int maxCol, int maxRow) {
        boolean[][] traversed = new boolean[maxCol][maxRow];
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        ArrayDeque<Fruit> que = new ArrayDeque<Fruit>();

        for (int i = 0; i < maxCol; i++) {
            for (int j = 0; j < maxRow; j++) {
                traversed[i][j] = false;
                if (arr[i][j] == 2) {    
                    que.add(new Fruit(i,j, 0));
                    traversed[i][j] = true;
                }
            }
        }
        int max = 0, x, y, day;
        Fruit temp;
        while(!que.isEmpty()){
            temp = que.peek();
            que.pop();
            for(int i=0;i<4;i++){
                x = temp.x + dir[i][0];
                y = temp.y + dir[i][1];
                day = temp.day + 1;
                if(x >= 0 && x < maxCol && y >= 0 && y < maxRow && 
                            arr[x][y] != 0 && traversed[x][y] == false){
                    que.add(new Fruit(x, y, day));
                    max = Math.max(max, day);
                    traversed[x][y] = true;
                }
            }
        }
        for (int i = 0; i < maxCol; i++) {
            for (int j = 0; j < maxRow; j++) {
                if (arr[i][j] == 1 && traversed[i][j] == false){
                    return -1;
                }
            }
        }
        return max;
    }
    
    public static void main21() {
        int arr[][] = { 
            { 1, 0, 1, 1, 0 }, 
            { 2, 1, 0, 1, 0 }, 
            { 0, 0, 0, 2, 1 }, 
            { 0, 2, 0, 0, 1 }, 
            { 1, 1, 0, 0, 1 } };
        System.out.println(rottenFruit(arr, 5, 5));
        System.out.println(rottenFruit2(arr, 5, 5));
    }
    
    // 3
    
    public static void stepsOfKnightUtil(int size, int currCol, int currRow, int[][] traversed, int dist) {
        int[][] dir = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {1, -2}, {-1, 2}, {1, 2}};
        int x, y;
        for(int i=0;i<8;i++){
            x = currCol + dir[i][0];
            y = currRow + dir[i][1];
            if(x >= 0 && x < size && y >= 0 && y < size && 
            traversed[x][y] > dist+1){
                traversed[x][y] = dist+1;
                stepsOfKnightUtil(size, x, y, traversed, dist + 1);
            }
        }
    }
    
    public static int stepsOfKnight(int size, int srcX, int srcY, int dstX, int dstY) {
        int[][] traversed = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                traversed[i][j] = Integer.MAX_VALUE;
            }
        }
        traversed[srcX - 1][srcY - 1] = 0;
        stepsOfKnightUtil(size, srcX - 1, srcY - 1, traversed, 0);
        return traversed[dstX - 1][dstY - 1];
    }

    public static class Knight{
        int x, y;
        int cost;
        Knight(int a, int b, int c){
            x = a;
            y = b;
            cost = c;
        }
    }
    
    public static int stepsOfKnight2(int size, int srcX, int srcY, 
    int dstX, int dstY) {
        int[][] traversed = new int[size][size];
        int[][] dir = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {1, -2}, {-1, 2}, {1, 2}};
        ArrayDeque<Knight> que = new ArrayDeque<Knight>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                traversed[i][j] = Integer.MAX_VALUE;
            }
        }
        que.add(new Knight(srcX-1,srcY-1, 0));
        traversed[srcX-1][srcY-1] = 0;

        int x, y, cost;
        Knight temp;
        while(!que.isEmpty()){
            temp = que.peek();
            que.pop();
            for(int i=0;i<8;i++){
                x = temp.x + dir[i][0];
                y = temp.y + dir[i][1];
                cost = temp.cost + 1;
                if(x >= 0 && x < size && y >= 0 && y < size && 
                        traversed[x][y] > cost){
                    que.add(new Knight(x, y, cost));
                    traversed[x][y] = cost;
                }
            }
        }
        return traversed[dstX-1][dstY-1];
    }

    public static void main22() {
        System.out.println(stepsOfKnight(20, 10, 10, 20, 20));
        System.out.println(stepsOfKnight2(20, 10, 10, 20, 20));
    }
    
    // 8
    
    public static void distNearestFillUtil(int[][] arr, int maxCol, int maxRow, int currCol, int currRow,
        int[][] traversed, int dist) { // Range check
        int x, y;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int i=0;i<4;i++){
            x = currCol + dir[i][0];
            y = currRow + dir[i][1];
            if(x >= 0 && x < maxCol && y >= 0 && y < maxRow && 
            traversed[x][y] > dist+1){
                traversed[x][y] = dist+1;
                distNearestFillUtil(arr, maxCol, maxRow, x, y, traversed, dist+1);
            }
        }
    }
    
    public static void distNearestFill(int[][] arr, int maxCol, int maxRow) {
        int[][] traversed = new int[maxCol][maxRow];
        for (int i = 0; i < maxCol; i++) {
            for (int j = 0; j < maxRow; j++) {
                traversed[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < maxCol; i++) {
            for (int j = 0; j < maxRow; j++) {
                if (arr[i][j] == 1){
                    traversed[i][j] = 0;
                    distNearestFillUtil(arr, maxCol, maxRow, i, j, traversed, 0);
                }
            }
        }
    
        for (int i = 0; i < maxCol; i++) {
            for (int j = 0; j < maxRow; j++) {
                System.out.print(traversed[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static class Node{
        int x, y;
        int dist;
        Node(int a, int b, int d){
            x = a;
            y = b;
            dist = d;
        }
    }
    
    public static void distNearestFill2(int[][] arr, int maxCol, int maxRow) {
        int[][] traversed = new int[maxCol][maxRow];
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        ArrayDeque<Node> que = new ArrayDeque<Node>();

        for (int i = 0; i < maxCol; i++) {
            for (int j = 0; j < maxRow; j++) {
                traversed[i][j] = Integer.MAX_VALUE;
                if (arr[i][j] == 1) {    
                    que.add(new Node(i,j, 0));
                    traversed[i][j] = 0;
                }
            }
        }
        int x, y, dist;
        Node temp;
        while(!que.isEmpty()){
            temp = que.peek();
            que.pop();
            for(int i=0;i<4;i++){
                x = temp.x + dir[i][0];
                y = temp.y + dir[i][1];
                dist = temp.dist + 1;
                if(x >= 0 && x < maxCol && y >= 0 && y < maxRow && 
                traversed[x][y] > dist){
                    que.add(new Node(x, y, dist));
                    traversed[x][y] = dist;
                }
            }
        }
        for (int i = 0; i < maxCol; i++) {
            for (int j = 0; j < maxRow; j++) {
                System.out.print(traversed[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main23() {
        int arr[][] = { 
            { 1, 0, 1, 1, 0 }, 
            { 1, 1, 0, 1, 0 }, 
            { 0, 0, 0, 0, 1 }, 
            { 0, 0, 0, 0, 1 }, 
            { 0, 0, 0, 0, 1 } };
        distNearestFill(arr, 5, 5);
        distNearestFill2(arr, 5, 5);
    }
    
    /*
    0 1 0 0 1 
    0 0 1 0 1 
    1 1 2 1 0 
    2 2 2 1 0 
    3 3 2 1 0 
    */
    
    public static int findLargestIslandUtil(int[][] arr, int maxCol, int maxRow, int currCol, int currRow, boolean[][] traversed) {
        int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int x, y, sum = 1;
        for(int i=0; i<8; i++) {
            x = currCol + dir[i][0];
            y = currRow + dir[i][1];
            if(x >= 0 && x < maxCol && y >= 0 && y < maxRow && 
            traversed[x][y] == false && arr[x][y] == 1){
                traversed[x][y] = true;
                sum += findLargestIslandUtil(arr, maxCol, maxRow, x, y, traversed);
            }
        }
        return sum;
    }
    
    public static int findLargestIsland(int[][] arr, int maxCol, int maxRow) {
        int maxVal = 0;
        int currVal = 0;
        boolean[][] traversed = new boolean[maxCol][maxRow];
        for (int i = 0; i < maxCol; i++) {
            for (int j = 0; j < maxRow; j++) {
                traversed[i][j] = false;
            }
        }

        for (int i = 0; i < maxCol; i++) {
            for (int j = 0; j < maxRow; j++) {
                if(arr[i][j] ==  1){
                    traversed[i][j] = true;
                    currVal = findLargestIslandUtil(arr, maxCol, maxRow, i, j, traversed);
                    if (currVal > maxVal)
                        maxVal = currVal;
                }
            }
        }
        
        return maxVal;
    }
    
    public static void main24() {
        int arr[][] = { 
            { 1, 0, 1, 1, 0 }, 
            { 1, 0, 0, 1, 0 }, 
            { 0, 1, 1, 1, 1 }, 
            { 0, 1, 0, 0, 0 }, 
            { 1, 1, 0, 0, 1 } };
        System.out.println("Largest Island : " + findLargestIsland(arr, 5, 5));
    }
    
    // Largest Island : 12

    static void reverseStack(Stack<Integer> stk){
        ArrayDeque<Integer> que = new ArrayDeque<Integer>(); 
        while(!stk.isEmpty()){
            que.add(stk.peek());
            stk.pop();
        }
        while(!que.isEmpty()){
            stk.push(que.peek());
            que.remove();
        }
    }

    static void reverseQueue(ArrayDeque<Integer> que){
        Stack<Integer> stk = new Stack<Integer>(); 
        while(!que.isEmpty()){
            stk.add(que.peek());
            que.remove();
        }
        while(!stk.isEmpty()){
            que.add(stk.peek());
            stk.pop();
        }
    }
    public static void main25(){
        Stack<Integer> stk = new Stack<Integer>();
        for(int i=0;i<5;i++)
            stk.push(i);
        System.out.println(stk);
        reverseStack(stk);
        System.out.println(stk);

        ArrayDeque<Integer> que = new ArrayDeque<Integer>(); 
        for(int i=0;i<5;i++)
            que.add(i);
        System.out.println(que);
        reverseQueue(que);
        System.out.println(que);
    }

    static int Josephus(int n, int k) {
        ArrayDeque<Integer> que = new ArrayDeque<Integer>();
        for(int i=0;i<n;i++)
            que.add(i+1);
        
        while(que.size() > 1) {
            for(int i=0;i<k-1;i++) {
                que.add(que.peek());
                que.remove();
            }
            que.remove();// Kth person executed.
        }
        return que.peek();
    }



    public static void main26(){
        System.out.println("Position : " + Josephus(11, 5));
    }
/*
Position : 8
*/
    public static void main(String[] args) {
        /*main1();
        main2();
        */
        //main3();
        /*
        main4();
        main5();
        main6();
        main21();
        main22();
        main23();
        main24();
        main25();
        */
        main26();
    }
}