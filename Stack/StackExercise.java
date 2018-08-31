import java.util.ArrayDeque;
import java.util.Scanner;

public class StackExercise {

	public static boolean isBalancedParenthesis(String expn) {
		ArrayDeque<Character> stk = new ArrayDeque<Character>();
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

	public static void main2(String[] args) {
		String expn = "{()}[";
		boolean value = isBalancedParenthesis(expn);
		System.out.println("Given Expn:" + expn);
		System.out.println("Result after isParenthesisMatched:" + value);
	}

	public static <T> void insertAtBottom(ArrayDeque<T> stk, T value) {
		if (stk.isEmpty()) {
			stk.push(value);
		} else {

			T out = stk.pop();
			insertAtBottom(stk, value);
			stk.push(out);
		}
	}

	public static <T> void reverseStack(ArrayDeque<T> stk) {
		if (stk.isEmpty()) {
			return;
		} else {

			T value = stk.pop();
			reverseStack(stk);
			insertAtBottom(stk, value);
		}
	}

	public static int postfixEvaluate(String expn) {
		ArrayDeque<Integer> stk = new ArrayDeque<Integer>();

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

	public static void main3(String[] args) {
		String expn = "6 5 2 3 + 8 * + 3 + *";
		int value = postfixEvaluate(expn);
		System.out.println("Given Postfix Expn: " + expn);
		System.out.println("Result after Evaluation: " + value);
	}

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
		ArrayDeque<Character> stk = new ArrayDeque<Character>();

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

	public static void main(String[] args) {
		String expn = "10+((3))*5/(16-4)";
		String value = infixToPostfix(expn);
		System.out.println("Infix Expn: " + expn);
		System.out.println("Postfix Expn: " + value);
	}

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

	public static void main5(String[] args) {
		String expn = "10+((3))*5/(16-4)";
		String value = infixToPrefix(expn);
		System.out.println("Infix Expn: " + expn);
		System.out.println("Prefix Expn: " + value);
	}

	public static int[] StockSpanRange(int[] arr) {
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

	int[] StockSpanRange2(int[] arr) {
		ArrayDeque<Integer> stk = new ArrayDeque<Integer>();

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

	public static int GetMaxArea(int[] arr) {
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

	public static int GetMaxArea2(int[] arr) {
		int size = arr.length;
		ArrayDeque<Integer> stk = new ArrayDeque<Integer>();
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
}