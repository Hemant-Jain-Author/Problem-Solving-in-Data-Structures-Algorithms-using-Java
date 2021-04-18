import java.util.Stack;
import java.util.Scanner;
import java.util.ArrayDeque;

public class StackExercise {

    public static boolean isBalancedParenthesis(String expn) {
        Stack<Character> stk = new Stack<Character>();
        for (char ch : expn.toCharArray()) {
            switch (ch) {
            case '{':
            case '[':
            case '(':
                stk.push(ch);
                break;
            case '}':
                if (stk.pop() != '{') {
                    return false;
                }
                break;
            case ']':
                if (stk.pop() != '[') {
                    return false;
                }
                break;
            case ')':
                if (stk.pop() != '(') {
                    return false;
                }
                break;
            }
        }
        return stk.isEmpty();
    }

    public static void main1() {
        String expn = "{()}[]";
        boolean value = isBalancedParenthesis(expn);
        System.out.println("Result after isParenthesisMatched:" + value);
    }

/*
Result after isParenthesisMatched:true
*/

    public static <T> void insertAtBottom(Stack<T> stk, T value) {
        if (stk.isEmpty()) {
            stk.push(value);
        } else {

            T out = stk.pop();
            insertAtBottom(stk, value);
            stk.push(out);
        }
    }

    public static <T> void reverseStack(Stack<T> stk) {
        if (stk.isEmpty()) {
            return;
        } else {

            T value = stk.pop();
            reverseStack(stk);
            insertAtBottom(stk, value);
        }
    }

    public static int postfixEvaluate(String expn) {
        Stack<Integer> stk = new Stack<Integer>();
        Scanner tokens = new Scanner(expn);

        while (tokens.hasNext()) {
            if (tokens.hasNextInt()) {
                stk.push(tokens.nextInt());
            } else {
                int num1 = stk.pop();
                int num2 = stk.pop();
                char op = tokens.next().charAt(0);
                switch (op) {
                case '+':
                    stk.push(num1 + num2);
                    break;
                case '-':
                    stk.push(num1 - num2);
                    break;
                case '*':
                    stk.push(num1 * num2);
                    break;
                case '/':
                    stk.push(num1 / num2);
                    break;
                }
            }
        }
        tokens.close();
        return stk.pop();
    }

    public static void main2() {
        String expn = "6 5 2 3 + 8 * + 3 + *";
        int value = postfixEvaluate(expn);
        System.out.println("Given Postfix Expn: " + expn);
        System.out.println("Result after Evaluation: " + value);
    }

/*
Given Postfix Expn: 6 5 2 3 + 8 * + 3 + *
Result after Evaluation: 288
*/

    public static int precedence(char x) {
        if (x == '(') {
            return (0);
        }
        if (x == '+' || x == '-') {
            return (1);
        }
        if (x == '*' || x == '/' || x == '%')
            return (2);
        if (x == '^') {
            return (3);
        }
        return (4);
    }

    public static String infixToPostfix(String expn) {
        String output = "";
        char[] out = infixToPostfix(expn.toCharArray());

        for (char ch : out) {
            output = output + ch;
        }
        return output;
    }

    public static char[] infixToPostfix(char[] expn) {
        Stack<Character> stk = new Stack<Character>();

        String output = "";
        char out;

        for (char ch : expn) {
            if (ch <= '9' && ch >= '0') {
                output = output + ch;
            } else {
                switch (ch) {
                case '+':
                case '-':
                case '*':
                case '/':
                case '%':
                case '^':
                    while (stk.isEmpty() == false && precedence(ch) <= precedence(stk.peek())) {
                        out = stk.pop();
                        output = output + " " + out;
                    }
                    stk.push(ch);
                    output = output + " ";
                    break;
                case '(':
                    stk.push(ch);
                    break;
                case ')':
                    while (stk.isEmpty() == false && (out = stk.pop()) != '(') {
                        output = output + " " + out + " ";
                    }
                    break;
                }
            }
        }

        while (stk.isEmpty() == false) {
            out = stk.pop();
            output = output + out + " ";
        }
        return output.toCharArray();
    }

    public static void main3() {
        String expn = "10+((3))*5/(16-4)";
        String value = infixToPostfix(expn);
        System.out.println("Infix Expn: " + expn);
        System.out.println("Postfix Expn: " + value);
    }

/*
Infix Expn: 10+((3))*5/(16-4)
Postfix Expn: 10 3 5 * 16 4 - / + 
*/

    public static String infixToPrefix(String expn) {
        char[] arr = expn.toCharArray();
        reverseString(arr);
        replaceParanthesis(arr);
        arr = infixToPostfix(arr);
        reverseString(arr);
        expn = new String(arr);
        return expn;
    }

    public static void replaceParanthesis(char[] a) {
        int lower = 0;
        int upper = a.length - 1;
        while (lower <= upper) {
            if (a[lower] == '(') {
                a[lower] = ')';
            } else if (a[lower] == ')') {
                a[lower] = '(';
            }
            lower++;
        }
    }

    public static void reverseString(char[] expn) {
        int lower = 0;
        int upper = expn.length - 1;
        char tempChar;
        while (lower < upper) {
            tempChar = expn[lower];
            expn[lower] = expn[upper];
            expn[upper] = tempChar;
            lower++;
            upper--;
        }
    }

    public static void main4() {
        String expn = "10+((3))*5/(16-4)";
        String value = infixToPrefix(expn);
        System.out.println("Infix Expn: " + expn);
        System.out.println("Prefix Expn: " + value);
    }

/*
Infix Expn: 10+((3))*5/(16-4)
Prefix Expn:  +10 * 3 / 5  - 16 4
*/

    public static int[] stockSpanRange(int[] arr) {
        int[] SR = new int[arr.length];
        SR[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            SR[i] = 1;
            for (int j = i - 1; (j >= 0) && (arr[i] >= arr[j]); j--) {
                SR[i]++;
            }
        }
        return SR;
    }

    public static int[] stockSpanRange2(int[] arr) {
        Stack<Integer> stk = new Stack<Integer>();

        int[] SR = new int[arr.length];
        stk.push(0);
        SR[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            while (!stk.isEmpty() && arr[stk.peek()] <= arr[i]) {
                stk.pop();
            }
            SR[i] = (stk.isEmpty()) ? (i + 1) : (i - stk.peek());
            stk.push(i);
        }
        return SR;
    }

    public static void main5() {
        int[] arr = { 6, 5, 4, 3, 2, 4, 5, 7, 9 };
        int[] value = stockSpanRange(arr);
        System.out.print("stockSpanRange : ");
        for (int val : value)
            System.out.print(val + " ");
        System.out.println();

        value = stockSpanRange2(arr);
        System.out.print("stockSpanRange : ");
        for (int val : value)
            System.out.print(val + " ");
        System.out.println();
    }

/*
stockSpanRange : 1 1 1 1 1 4 6 8 9 
stockSpanRange : 1 1 1 1 1 4 6 8 9 
*/

    public static int getMaxArea(int[] arr) {
        int size = arr.length;
        int maxArea = -1;
        int currArea;
        int minHeight = 0;
        for (int i = 1; i < size; i++) {
            minHeight = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (minHeight > arr[j]) {
                    minHeight = arr[j];
                }
                currArea = minHeight * (i - j + 1);
                if (maxArea < currArea) {
                    maxArea = currArea;
                }
            }
        }
        return maxArea;
    }

    public static int getMaxArea2(int[] arr) {
        int size = arr.length;
        Stack<Integer> stk = new Stack<Integer>();
        int maxArea = 0;
        int top;
        int topArea;
        int i = 0;
        while (i < size) {
            while ((i < size) && (stk.isEmpty() || arr[stk.peek()] <= arr[i])) {
                stk.push(i);
                i++;
            }
            while (!stk.isEmpty() && (i == size || arr[stk.peek()] > arr[i])) {
                top = stk.peek();
                stk.pop();
                topArea = arr[top] * (stk.isEmpty() ? i : i - stk.peek() - 1);
                if (maxArea < topArea) {
                    maxArea = topArea;
                }
            }
        }
        return maxArea;
    }

    public static void main6() {
        int[] arr = { 7, 6, 5, 4, 4, 1, 6, 3, 1 };
        int value = getMaxArea(arr);
        System.out.println("getMaxArea :: " + value);
        value = getMaxArea2(arr);
        System.out.println("getMaxArea :: " + value);
    }

/*
getMaxArea :: 20
getMaxArea :: 20
*/

    public static void sortedInsert(Stack<Integer> stk, int element) {
        int temp;
        if (stk.isEmpty() || element > stk.peek())
            stk.push(element);
        else {
            temp = stk.pop();
            sortedInsert(stk, element);
            stk.push(temp);
        }
    }

    public static void sortStack(Stack<Integer> stk) {
        int temp;
        if (stk.isEmpty() == false) {
            temp = stk.pop();
            sortStack(stk);
            sortedInsert(stk, temp);
        }
    }

    public static void sortStack2(Stack<Integer> stk) {
        int temp;
        Stack<Integer> stk2 = new Stack<Integer>();
        while (stk.isEmpty() == false) {
            temp = stk.pop();
            while ((stk.isEmpty() == false) && (stk2.peek() < temp))
                stk.push(stk2.pop());
            stk2.push(temp);
        }
        while (stk2.isEmpty() == false)
            stk.push(stk2.pop());
    }

    public static void bottomInsert(Stack<Integer> stk, int element) {
        int temp;
        if (stk.isEmpty())
            stk.push(element);
        else {
            temp = stk.pop();
            bottomInsert(stk, element);
            stk.push(temp);
        }
    }

    public static void reverseStack2(Stack<Integer> stk) {
        ArrayDeque<Integer> que = new ArrayDeque<Integer>();
        while (stk.isEmpty() == false)
            que.add(stk.pop());

        while (que.isEmpty() == false)
            stk.push(que.remove());
    }

    public static void reverseKElementInStack(Stack<Integer> stk, int k) {
        ArrayDeque<Integer> que = new ArrayDeque<Integer>();
        int i = 0;
        while (stk.isEmpty() == false && i < k) {
            que.add(stk.pop());
            i++;
        }
        while (que.isEmpty() == false)
            stk.push(que.remove());
    }

    public static void reverseQueue(ArrayDeque<Integer> que) {
        Stack<Integer> stk = new Stack<Integer>();
        while (que.isEmpty() == false)
            stk.push(que.remove());

        while (stk.isEmpty() == false)
            que.add(stk.pop());
    }

    public static void reverseKElementInQueue(ArrayDeque<Integer> que, int k) {
        Stack<Integer> stk = new Stack<Integer>();
        int i = 0, diff, temp;
        while (que.isEmpty() == false && i < k) {
            stk.push(que.remove());
            i++;
        }
        while (stk.isEmpty() == false) {
            que.add(stk.pop());
        }
        diff = que.size() - k;
        while (diff > 0) {
            temp = que.remove();
            que.add(temp);
            diff -= 1;
        }
    }

    public static void main7() {
        Stack<Integer> stk = new Stack<Integer>();
        stk.push(1);
        stk.push(2);
        stk.push(3);
        System.out.println(stk);
    }

// [1, 2, 3]

    public static void main8() {
        Stack<Integer> stk = new Stack<Integer>();
        stk.push(-2);
        stk.push(13);
        stk.push(16);
        stk.push(-6);
        stk.push(40);
        System.out.println(stk);

        reverseStack2(stk);
        System.out.println(stk);
        reverseKElementInStack(stk, 2);
        System.out.println(stk);
        /*
         * System.out.println(stk); sortStack2(stk); System.out.println(stk);
         */
        ArrayDeque<Integer> que = new ArrayDeque<Integer>();
        que.add(1);
        que.add(2);
        que.add(3);
        System.out.println(que);
        reverseQueue(que);
        System.out.println(que);
        reverseKElementInQueue(que, 2);
        System.out.println(que);
    }

/*
[-2, 13, 16, -6, 40]
[40, -6, 16, 13, -2]
[40, -6, 16, -2, 13]
[1, 2, 3]
[3, 2, 1]
[2, 3, 1]
*/

    public static int maxDepthParenthesis(String expn, int size) {
        Stack<Character> stk = new Stack<Character>();
        int maxDepth = 0;
        int depth = 0;
        char ch;

        for (int i = 0; i < size; i++) {
            ch = expn.charAt(i);

            if (ch == '(') {
                stk.push(ch);
                depth += 1;
            } else if (ch == ')') {
                stk.pop();
                depth -= 1;
            }
            if (depth > maxDepth)
                maxDepth = depth;
        }
        return maxDepth;
    }

    public static int maxDepthParenthesis2(String expn, int size) {
        int maxDepth = 0;
        int depth = 0;
        char ch;
        for (int i = 0; i < size; i++) {
            ch = expn.charAt(i);
            if (ch == '(')
                depth += 1;
            else if (ch == ')')
                depth -= 1;

            if (depth > maxDepth)
                maxDepth = depth;
        }
        return maxDepth;
    }

    public static void main9() {
        String expn = "((((A)))((((BBB()))))()()()())";
        int size = expn.length();
        System.out.println("Max depth parenthesis is " + maxDepthParenthesis(expn, size));
        System.out.println("Max depth parenthesis is " + maxDepthParenthesis2(expn, size));
    }

/*
Max depth parenthesis is 6
Max depth parenthesis is 6
*/

    public static int longestContBalParen(String string, int size) {
        Stack<Integer> stk = new Stack<Integer>();
        stk.push(-1);
        int length = 0;

        for (int i = 0; i < size; i++) {

            if (string.charAt(i) == '(')
                stk.push(i);
            else // string[i] == ')'
            {
                stk.pop();
                if (stk.size() != 0)
                    length = Math.max(length, i - stk.peek());
                else
                    stk.push(i);
            }
        }
        return length;
    }

    public static void main10() {
        String expn = "())((()))(())()(()";
        int size = expn.length();
        System.out.println("longestContBalParen " + longestContBalParen(expn, size));
    }

// longestContBalParen 12

    public static int reverseParenthesis(String expn, int size) {
        Stack<Character> stk = new Stack<Character>();
        int openCount = 0;
        int closeCount = 0;
        char ch;

        if (size % 2 == 1) {
            System.out.println("Invalid odd length " + size);
            return -1;
        }
        for (int i = 0; i < size; i++) {
            ch = expn.charAt(i);
            if (ch == '(')
                stk.push(ch);
            else if (ch == ')')
                if (stk.size() != 0 && stk.peek() == '(')
                    stk.pop();
                else
                    stk.push(')');
        }
        while (stk.size() != 0) {
            if (stk.pop() == '(')
                openCount += 1;
            else
                closeCount += 1;
        }
        int reversal = (int) Math.ceil(openCount / 2.0) + (int) Math.ceil(closeCount / 2.0);
        return reversal;
    }

    public static void main11() {
        String expn2 = ")(())(((";
        int size = expn2.length();
        int value = reverseParenthesis(expn2, size);
        System.out.println("reverse Parenthesis is : " + value);
    }

// reverse Parenthesis is : 3

    public static boolean findDuplicateParenthesis(String expn, int size) {
        Stack<Character> stk = new Stack<Character>();
        char ch;
        int count;

        for (int i = 0; i < size; i++) {
            ch = expn.charAt(i);
            if (ch == ')') {
                count = 0;
                while (stk.size() != 0 && stk.peek() != '(') {
                    stk.pop();
                    count += 1;
                }
                if (count <= 1)
                    return true;
            } else
                stk.push(ch);
        }
        return false;
    }

    public static void main12() {
        String expn = "(((a+b))+c)";
        int size = expn.length();
        boolean value = findDuplicateParenthesis(expn, size);
        System.out.println("Duplicate Found : " + value);
    }

// Duplicate Found : true

    public static void printParenthesisNumber(String expn, int size) {
        char ch;
        Stack<Integer> stk = new Stack<Integer>();
        String output = new String();
        int count = 1;
        for (int i = 0; i < size; i++) {
            ch = expn.charAt(i);
            if (ch == '(') {
                stk.push(count);
                output += count;
                output += " ";
                count += 1;
            } else if (ch == ')'){
                output += stk.pop();
                output += " ";
            }
                
        }
        System.out.println("Parenthesis Count " + output);
    }

    public static void main13() {
        String expn1 = "(((a+(b))+(c+d)))";
        String expn2 = "(((a+b))+c)(((";
        printParenthesisNumber(expn1, expn1.length());
        printParenthesisNumber(expn2, expn2.length());
    }

/*
Parenthesis Count 1 2 3 4 4 3 5 5 2 1 
Parenthesis Count 1 2 3 3 2 1 4 5 6 
*/

    public static void nextLargerElement(int[] arr, int size) {
        int[] output = new int[size];
        int outIndex = 0;
        int next;

        for (int i = 0; i < size; i++) {
            next = -1;
            for (int j = i + 1; j < size; j++) {
                if (arr[i] < arr[j]) {
                    next = arr[j];
                    break;
                }
            }
            output[outIndex++] = next;
        }
        for (int val : output)
            System.out.print(val + " ");
        System.out.println();
    }

    public static void nextLargerElement2(int[] arr, int size) {
        Stack<Integer> stk = new Stack<Integer>();
        int[] output = new int[size];
        int index = 0;
        int curr;

        for (int i = 0; i < size; i++) {
            curr = arr[i];
            // stack always have values in decreasing order.
            while (stk.isEmpty() == false && arr[stk.peek()] <= curr) {
                index = stk.pop();
                output[index] = curr;
            }
            stk.push(i);
        }
        // index which dont have any next Larger.
        while (stk.isEmpty() == false) {
            index = stk.pop();
            output[index] = -1;
        }
        for (int val : output)
            System.out.print(val + " ");
        System.out.println();
    }

    public static void nextSmallerElement(int[] arr, int size) {
        Stack<Integer> stk = new Stack<Integer>();
        int[] output = new int[size];
        int curr, index;
        for (int i = 0; i < size; i++) {
            curr = arr[i];
            // stack always have values in increasing order.
            while (stk.isEmpty() == false && arr[stk.peek()] > curr) {
                index = stk.pop();
                output[index] = curr;
            }
            stk.push(i);
        }
        // index which dont have any next Smaller.
        while (stk.isEmpty() == false) {
            index = stk.pop();
            output[index] = -1;
        }
        for (int val : output)
            System.out.print(val + " ");
        System.out.println();
    }

    public static void main14() {
        int[] arr = { 13, 21, 3, 6, 20, 3 };
        int size = arr.length;
        nextLargerElement(arr, size);
        nextLargerElement2(arr, size);
        nextSmallerElement(arr, size);
    }

/*
21 -1 6 20 -1 -1 
21 -1 6 20 -1 -1 
3 3 -1 3 3 -1 
*/

    public static void nextLargerElementCircular(int[] arr, int size) {
        Stack<Integer> stk = new Stack<Integer>();
        int curr, index;
        int[] output = new int[size];
        for (int i = 0; i < (2 * size - 1); i++) {
            curr = arr[i % size];
            // stack always have values in decreasing order.
            while (stk.isEmpty() == false && arr[stk.peek()] <= curr) {
                index = stk.pop();
                output[index] = curr;
            }
            stk.push(i % size);
        }
        // index which dont have any next Larger.
        while (stk.isEmpty() == false) {
            index = stk.pop();
            output[index] = -1;
        }
        for (int val : output)
            System.out.print(val + " ");
        System.out.println();
    }

    public static void main15() {
        int arr[] = { 6, 3, 9, 8, 10, 2, 1, 15, 7 };
        nextLargerElementCircular(arr, arr.length);
    }

// 9 9 10 10 15 15 15 -1 9

    public static void rottenFruitUtil(int[][] arr, int maxCol, int maxRow, int currCol, int currRow, int[][] traversed,
            int day) { // Range check
        if (currCol < 0 || currCol >= maxCol || currRow < 0 || currRow >= maxRow)
            return;
        // Traversable and rot if not already rotten.
        if (traversed[currCol][currRow] <= day || arr[currCol][currRow] == 0)
            return;
        // Update rot time.
        traversed[currCol][currRow] = day;
        // each line corresponding to 4 direction.
        rottenFruitUtil(arr, maxCol, maxRow, currCol - 1, currRow, traversed, day + 1);
        rottenFruitUtil(arr, maxCol, maxRow, currCol + 1, currRow, traversed, day + 1);
        rottenFruitUtil(arr, maxCol, maxRow, currCol, currRow + 1, traversed, day + 1);
        rottenFruitUtil(arr, maxCol, maxRow, currCol, currRow - 1, traversed, day + 1);
    }

    public static int rottenFruit(int[][] arr, int maxCol, int maxRow) {
        int[][] traversed = new int[maxCol][maxRow];
        for (int i = 0; i < maxCol; i++) {
            for (int j = 0; j < maxRow; j++) {
                traversed[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < maxCol - 1; i++) {
            for (int j = 0; j < maxRow - 1; j++) {
                if (arr[i][j] == 2)
                    rottenFruitUtil(arr, maxCol, maxRow, i, j, traversed, 0);
            }
        }

        int maxDay = 0;
        for (int i = 0; i < maxCol - 1; i++) {
            for (int j = 0; j < maxRow - 1; j++) {
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

    public static void main16() {
        int arr[][] = { 
            { 1, 0, 1, 1, 0 }, 
            { 2, 1, 0, 1, 0 }, 
            { 0, 0, 0, 2, 1 }, 
            { 0, 2, 0, 0, 1 }, 
            { 1, 1, 0, 0, 1 } };
        System.out.println(rottenFruit(arr, 5, 5));
    }

// 3

    public static void stepsOfKnightUtil(int size, int currCol, int currRow, int[][] traversed, int dist) {
        // Range check
        if (currCol < 0 || currCol >= size || currRow < 0 || currRow >= size)
            return;

        // Traversable and rot if not already rotten.
        if (traversed[currCol][currRow] <= dist)
            return;

        // Update rot time.
        traversed[currCol][currRow] = dist;
        // each line corresponding to 4 direction.
        stepsOfKnightUtil(size, currCol - 2, currRow - 1, traversed, dist + 1);
        stepsOfKnightUtil(size, currCol - 2, currRow + 1, traversed, dist + 1);
        stepsOfKnightUtil(size, currCol + 2, currRow - 1, traversed, dist + 1);
        stepsOfKnightUtil(size, currCol + 2, currRow + 1, traversed, dist + 1);
        stepsOfKnightUtil(size, currCol - 1, currRow - 2, traversed, dist + 1);
        stepsOfKnightUtil(size, currCol + 1, currRow - 2, traversed, dist + 1);
        stepsOfKnightUtil(size, currCol - 1, currRow + 2, traversed, dist + 1);
        stepsOfKnightUtil(size, currCol + 1, currRow + 2, traversed, dist + 1);
    }

    public static int stepsOfKnight(int size, int srcX, int srcY, int dstX, int dstY) {
        int[][] traversed = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                traversed[i][j] = Integer.MAX_VALUE;
            }
        }

        stepsOfKnightUtil(size, srcX - 1, srcY - 1, traversed, 0);
        int retval = traversed[dstX - 1][dstY - 1];
        return retval;
    }

    public static void main17() {
        System.out.println(stepsOfKnight(20, 10, 10, 20, 20));
    }

// 8

    public static void distNearestFillUtil(int[][] arr, int maxCol, int maxRow, int currCol, int currRow,
            int[][] traversed, int dist) { // Range check
        if (currCol < 0 || currCol >= maxCol || currRow < 0 || currRow >= maxRow)
            return;
        // Traversable if their is a better distance.
        if (traversed[currCol][currRow] <= dist)
            return;
        // Update distance.
        traversed[currCol][currRow] = dist;
        // each line corresponding to 4 direction.
        distNearestFillUtil(arr, maxCol, maxRow, currCol - 1, currRow, traversed, dist + 1);
        distNearestFillUtil(arr, maxCol, maxRow, currCol + 1, currRow, traversed, dist + 1);
        distNearestFillUtil(arr, maxCol, maxRow, currCol, currRow + 1, traversed, dist + 1);
        distNearestFillUtil(arr, maxCol, maxRow, currCol, currRow - 1, traversed, dist + 1);
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
                if (arr[i][j] == 1)
                    distNearestFillUtil(arr, maxCol, maxRow, i, j, traversed, 0);
            }
        }

        for (int i = 0; i < maxCol; i++) {
            for (int j = 0; j < maxRow; j++) {
                System.out.print(traversed[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main18() {
        int arr[][] = { 
            { 1, 0, 1, 1, 0 }, 
            { 1, 1, 0, 1, 0 }, 
            { 0, 0, 0, 0, 1 }, 
            { 0, 0, 0, 0, 1 }, 
            { 0, 0, 0, 0, 1 } };
        distNearestFill(arr, 5, 5);
    }

/*
0 1 0 0 1 
0 0 1 0 1 
1 1 2 1 0 
2 2 2 1 0 
3 3 2 1 0 
*/

    public static int findLargestIslandUtil(int[][] arr, int maxCol, int maxRow, int currCol, int currRow, int value,
            int[][] traversed) {
        if (currCol < 0 || currCol >= maxCol || currRow < 0 || currRow >= maxRow)
            return 0;
        if (traversed[currCol][currRow] == 1 || arr[currCol][currRow] != value)
            return 0;
        traversed[currCol][currRow] = 1;
        // each call corresponding to 8 direction.
        return 1 + findLargestIslandUtil(arr, maxCol, maxRow, currCol - 1, currRow - 1, value, traversed)
                + findLargestIslandUtil(arr, maxCol, maxRow, currCol - 1, currRow, value, traversed)
                + findLargestIslandUtil(arr, maxCol, maxRow, currCol - 1, currRow + 1, value, traversed)
                + findLargestIslandUtil(arr, maxCol, maxRow, currCol, currRow - 1, value, traversed)
                + findLargestIslandUtil(arr, maxCol, maxRow, currCol, currRow + 1, value, traversed)
                + findLargestIslandUtil(arr, maxCol, maxRow, currCol + 1, currRow - 1, value, traversed)
                + findLargestIslandUtil(arr, maxCol, maxRow, currCol + 1, currRow, value, traversed)
                + findLargestIslandUtil(arr, maxCol, maxRow, currCol + 1, currRow + 1, value, traversed);
    }

    public static int findLargestIsland(int[][] arr, int maxCol, int maxRow) {
        int maxVal = 0;
        int currVal = 0;
        int[][] traversed = new int[maxCol][maxRow];
        for (int i = 0; i < maxCol; i++) {
            for (int j = 0; j < maxRow; j++) {
                traversed[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < maxCol; i++) {
            for (int j = 0; j < maxRow; j++) {
                {
                    currVal = findLargestIslandUtil(arr, maxCol, maxRow, i, j, arr[i][j], traversed);
                    if (currVal > maxVal)
                        maxVal = currVal;
                }
            }
        }
        return maxVal;
    }

    public static void main19() {
        int arr[][] = { 
            { 1, 0, 1, 1, 0 }, 
            { 1, 0, 0, 1, 0 }, 
            { 0, 1, 1, 1, 1 }, 
            { 0, 1, 0, 0, 0 }, 
            { 1, 1, 0, 0, 1 } };
        System.out.println("Largest Island : " + findLargestIsland(arr, 5, 5));
    }

// Largest Island : 12

    public static boolean isKnown(int relation[][], int a, int b) {
        if (relation[a][b] == 1)
            return true;
        return false;
    }

    public static int findCelebrity(int relation[][], int count) {
        Stack<Integer> stk = new Stack<Integer>();
        int first = 0, second = 0;
        for (int i = 0; i < count; i++) {
            stk.push(i);
        }
        first = stk.pop();
        while (stk.size() != 0) {
            second = stk.pop();
            if (isKnown(relation, first, second))
                first = second;
        }
        for (int i = 0; i < count; i++) {
            if (first != i && isKnown(relation, first, i))
                return -1;
            if (first != i && isKnown(relation, i, first) == false)
                return -1;
        }
        return first;
    }

    public static int findCelebrity2(int relation[][], int count) {
        int first = 0;
        int second = 1;

        for (int i = 0; i < (count - 1); i++) {
            if (isKnown(relation, first, second))
                first = second;
            second = second + 1;
        }
        for (int i = 0; i < count; i++) {
            if (first != i && isKnown(relation, first, i))
                return -1;
            if (first != i && isKnown(relation, i, first) == false)
                return -1;
        }
        return first;
    }

    public static void main20() {
        int[][] arr = { 
            { 1, 0, 1, 1, 0 }, 
            { 1, 0, 0, 1, 0 }, 
            { 0, 0, 1, 1, 1 }, 
            { 0, 0, 0, 0, 0 }, 
            { 1, 1, 0, 1, 1 } };

        System.out.println("Celebrity : " + findCelebrity(arr, 5));
        System.out.println("Celebrity : " + findCelebrity2(arr, 5));
    }

/*
Celebrity : 3
Celebrity : 3
*/

    public static int isMinHeap(int[] arr, int size) {
        for (int i = 0; i <= (size - 2) / 2; i++) {
            if (2 * i + 1 < size) {
                if (arr[i] > arr[2 * i + 1])
                    return 0;
            }
            if (2 * i + 2 < size) {
                if (arr[i] > arr[2 * i + 2])
                    return 0;
            }
        }
        return 1;
    }

    public static int isMaxHeap(int[] arr, int size) {
        for (int i = 0; i <= (size - 2) / 2; i++) {
            if (2 * i + 1 < size) {
                if (arr[i] < arr[2 * i + 1])
                    return 0;
            }
            if (2 * i + 2 < size) {
                if (arr[i] < arr[2 * i + 2])
                    return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        //main1();
        //main2();
        //main3();
        //main4();
        //main5();
        //main6();
        //main7();
        //main8();
        //main9();
        //main10();
        //main11();
        //main12();
        //main13();
        //main14();
        main15();
        main16();
        main17();
        //main18();
        //main19();
        //main20();
        /*main21();
        main22();
        main23();
        main24();*/
    }
}