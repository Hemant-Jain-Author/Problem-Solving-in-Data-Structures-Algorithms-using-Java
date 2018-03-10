public class StringAlgo {

	boolean matchExpUtil(char[] exp, char[] str, int i, int j) {
		if (i == exp.length && j == str.length) {
			return true;
		}
		if ((i == exp.length && j != str.length) || (i != exp.length && j == str.length)) {
			return false;
		}
		if (exp[i] == '?' || exp[i] == str[j]) {
			return matchExpUtil(exp, str, i + 1, j + 1);
		}
		if (exp[i] == '*') {
			return matchExpUtil(exp, str, i + 1, j) || matchExpUtil(exp, str, i, j + 1)
					|| matchExpUtil(exp, str, i + 1, j + 1);
		}

		return false;
	}

	boolean matchExp(char[] exp, char[] str) {
		return matchExpUtil(exp, str, 0, 0);
	}

	int match(char[] source, char[] pattern) {
		int iSource = 0;
		int iPattern = 0;
		int sourceLen = source.length;
		int patternLen = pattern.length;
		for (iSource = 0; iSource < sourceLen; iSource++) {
			if (source[iSource] == pattern[iPattern]) {
				iPattern++;
			}
			if (iPattern == patternLen) {
				return 1;
			}
		}
		return 0;
	}

	char[] myStrdup(char[] src) {
		int index = 0;
		char[] dst = new char[src.length];
		for (char ch : src) {
			dst[index] = ch;
		}
		return dst;
	}

	boolean isPrime(int n) {
		boolean answer = (n > 1) ? true : false;

		for (int i = 2; i * i < n; ++i) {
			if (n % i == 0) {
				answer = false;
				break;
			}
		}
		return answer;
	}

	int myAtoi(String str) {
		int value = 0;

		int size = str.length();
		for (int i = 0; i < size; i++) {
			char ch = str.charAt(i);
			value = (value << 3) + (value << 1) + (ch - '0');
		}
		return value;
	}

	boolean isUniqueChar(String str) {
		int[] bitarr = new int[26];
		for (int i = 0; i < 26; i++) {
			bitarr[i] = 0;
		}
		int size = str.length();
		for (int i = 0; i < size; i++) {
			char c = str.charAt(i);
			if ('A' <= c && 'Z' >= c) {
				c = (char) (c - 'A');
			} else if ('a' <= c && 'z' >= c) {
				c = (char) (c - 'a');
			} else {
				System.out.println("Unknown Char!\n");
				return false;
			}
			if (bitarr[c] != 0) {
				System.out.println("Duplicate detected!\n");
				return false;
			}
		}
		System.out.println("No duplicate detected!\n");
		return true;
	}

	char ToUpper(char s) {
		if (s >= 97 && s <= (97 + 25)) {
			s = (char) (s - 32);
		}
		return s;
	}

	char ToLower(char s) {
		if (s >= 65 && s <= (65 + 25)) {
			s = (char) (s + 32);
		}
		return s;
	}

	char LowerUpper(char s) {
		if (s >= 97 && s <= (97 + 25)) {
			s = (char) (s - 32);
		} else if (s >= 65 && s <= (65 + 25)) {
			s = (char) (s + 32);
		}
		return s;
	}

	boolean isPermutation(String s1, String s2) {
		int[] count = new int[256];
		int length = s1.length();
		if (s2.length() != length) {
			System.out.println("is permutation return false\n");
			return false;
		}
		for (int i = 0; i < 256; i++) {
			count[i] = 0;
		}
		for (int i = 0; i < length; i++) {
			char ch = s1.charAt(i);
			count[ch]++;
			ch = s2.charAt(i);
			count[ch]--;
		}
		for (int i = 0; i < length; i++) {
			if (count[i] != 0) {
				System.out.println("is permutation return false\n");
				return false;
			}
		}
		System.out.println("is permutation return true\n");
		return true;
	}

	boolean isPalindrome(String str) {
		int i = 0, j = str.length() - 1;
		while (i < j && str.charAt(i) == str.charAt(j)) {
			i++;
			j--;
		}
		if (i < j) {
			System.out.println("String is not a Palindrome");
			return false;
		} else {
			System.out.println("String is a Palindrome");
			return true;
		}
	}

	int pow(int x, int n) {
		int value;
		if (n == 0) {
			return (1);
		} else if (n % 2 == 0) {
			value = pow(x, n / 2);
			return (value * value);
		} else {
			value = pow(x, n / 2);
			return (x * value * value);
		}
	}

	int myStrcmp(String a, String b) {
		int index = 0;
		int len1 = a.length();
		int len2 = b.length();
		int minlen = len1;
		if (len1 > len2) {
			minlen = len2;
		}

		while (index < minlen && a.charAt(index) == b.charAt(index)) {
			index++;
		}

		if (index == len1 && index == len2) {
			return 0;
		} else if (len1 == index) {
			return -1;
		} else if (len2 == index) {
			return 1;
		} else {
			return a.charAt(index) - b.charAt(index);
		}
	}

	void reverseString(char[] a) {
		int lower = 0;
		int upper = a.length - 1;
		char tempChar;
		while (lower < upper) {
			tempChar = a[lower];
			a[lower] = a[upper];
			a[upper] = tempChar;
			lower++;
			upper--;
		}
	}

	void reverseString(char[] a, int lower, int upper) {
		char tempChar;
		while (lower < upper) {
			tempChar = a[lower];
			a[lower] = a[upper];
			a[upper] = tempChar;
			lower++;
			upper--;
		}
	}

	void reverseWords(char[] a) {
		int length = a.length;
		int lower, upper = -1;
		lower = 0;
		for (int i = 0; i <= length; i++) {
			if (a[i] == ' ' || a[i] == '\0') {
				reverseString(a, lower, upper);
				lower = i + 1;
				upper = i;
			} else {
				upper++;
			}
		}
		reverseString(a, 0, length - 1);
	}

	void printAnagram(char[] a) {
		int n = a.length;
		printAnagram(a, n, n);
	}

	void printAnagram(char[] a, int max, int n) {
		if (max == 1) {
			System.out.println(a.toString());
		}
		for (int i = -1; i < max - 1; i++) {
			if (i != -1) {
				a[i] ^= a[max - 1] ^= a[i] ^= a[max - 1];
			}
			printAnagram(a, max - 1, n);
			if (i != -1) {
				a[i] ^= a[max - 1] ^= a[i] ^= a[max - 1];
			}
		}
	}

	void shuffle(char[] ar) {
		int n = ar.length / 2;
		int count = 0;
		int k = 1;
		char temp = '\0';
		for (int i = 1; i < n; i = i + 2) {
			temp = ar[i];
			k = i;
			do {
				k = (2 * k) % (2 * n - 1);
				temp ^= ar[k] ^= temp ^= ar[k];
				count++;
			} while (i != k);
			if (count == (2 * n - 2)) {
				break;
			}
		}
	}

	char[] addBinary(char[] first, char[] second) {
		int size1 = first.length;
		int size2 = second.length;
		int totalIndex;
		char[] total;
		if (size1 > size2) {
			total = new char[size1 + 2];
			totalIndex = size1;
		} else {
			total = new char[size2 + 2];
			totalIndex = size2;
		}
		total[totalIndex + 1] = '\0';
		int carry = 0;
		size1--;
		size2--;
		while (size1 >= 0 || size2 >= 0) {
			int firstValue = (size1 < 0) ? 0 : first[size1] - '0';
			int secondValue = (size2 < 0) ? 0 : second[size2] - '0';
			int sum = firstValue + secondValue + carry;
			carry = sum >> 1;
			sum = sum & 1;
			total[totalIndex] = (sum == 0) ? '0' : '1';
			totalIndex--;
			size1--;
			size2--;
		}
		total[totalIndex] = (carry == 0) ? '0' : '1';
		return total;
	}
}