import java.util.HashMap;
import java.util.Arrays;

public class Introduction {
	public static int factorial(int i) {
		// Termination Condition
		if (i <= 1) {
			return 1;
		}
		// Body, Recursive Expansion
		return i * factorial(i - 1);
	}

	/* Testing code */
	public static void main1() {
		System.out.println("Factorial:" + factorial(5));
	}

	// Factorial:120


	public static void printInt10(int number) {
		char digit = (char) (number % 10 + '0');
		number = number / 10;
		if (number != 0) {
			printInt10(number);
		}
		System.out.print(digit);
	}

	public static void printInt(int number, int base) {
		String conversion = "0123456789ABCDEF";
		char digit = (char) (number % base);
		number = number / base;
		if (number != 0) {
			printInt(number, base);
		}
		System.out.print(conversion.charAt(digit));
	}

	/* Testing code */
	public static void main2() {
		printInt10(50);
		System.out.println();
		printInt(500, 16);
		System.out.println();
	}
	/*
	50
	1F4
	*/

	public static void towerOfHanoi(int num, char src, char dst, char temp) {
		if (num < 1) {
			return;
		}

		towerOfHanoi(num - 1, src, temp, dst);
		System.out.println("Move " + num + " disk  from peg " + src + " to peg " + dst);
		towerOfHanoi(num - 1, temp, dst, src);
	}

	/* Testing code */
	public static void main3() {
		int num = 3;
		System.out.println("Moves involved in the Tower of Hanoi are:");
		towerOfHanoi(num, 'A', 'C', 'B');
	}

	/*
Moves involved in the Tower of Hanoi are:
Move 1 disk  from peg A to peg C
Move 2 disk  from peg A to peg B
Move 1 disk  from peg C to peg B
Move 3 disk  from peg A to peg C
Move 1 disk  from peg B to peg A
Move 2 disk  from peg B to peg C
Move 1 disk  from peg A to peg C
	*/
	

	public static int gcd(int m, int n) {
	    if (n == 0)
	        return m;
	    
	    if (m == 0)
	        return n;

	    return (gcd(n, m % n));
	}

	/* Testing code */
	public static void main4() {
		System.out.println("Gcd is:: " + gcd(5, 2));
	}

	/*
	Gcd is:: 1
	*/

	public static int fibonacci(int n) {
		if (n < 2)
			return n;

		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static int fibonacci2(int n) {
		if (n < 2)
			return n;

		int first = 0;
		int second = 1;
		int temp = 1;

		for (int i = 2; i <= n; i++) {
			temp = first + second;
			first = second;
			second = temp;
		}
		return temp;
	}

	/* Testing code */
	public static void main5() {
		System.out.println(fibonacci(10));
	}

	/*
	55 
	*/

	public static void main(String[] args) {
		main1();
		main2();
		main3();
		main4();
		main5();
	}
}
