public class StringAlgo {
    public static boolean matchExpUtil(char[] exp, char[] str, int i, int j) {
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

    public static boolean matchExp(String exp, String str) {
        return matchExpUtil(exp.toCharArray(), str.toCharArray(), 0, 0);
    }

    public static void main1() {
        System.out.println(matchExp("*llo,?World?", "Hello, World!"));
    }
// true

    public static boolean match(String src, String ptn) {
        char[] source = src.toCharArray();
        char[] pattern = ptn.toCharArray();
        int iSource = 0;
        int iPattern = 0;
        int sourceLen = source.length;
        int patternLen = pattern.length;
        for (iSource = 0; iSource < sourceLen; iSource++) {
            if (source[iSource] == pattern[iPattern]) {
                iPattern++;
            }
            if (iPattern == patternLen) {
                return true;
            }
        }
        return false;
    }

    public static void main2() {
        System.out.println(match("harrypottermustnotgotoschool", "pottergo"));
    }
// true

    public static char[] myStrdup(char[] src) {
        int index = 0;
        char[] dst = new char[src.length];
        for (char ch : src) {
            dst[index] = ch;
        }
        return dst;
    }

    public static boolean isPrime(int n) {
        boolean answer = (n > 1) ? true : false;
        for (int i = 2; i * i <= n; ++i) {
            if (n % i == 0) {
                answer = false;
                break;
            }
        }
        return answer;
    }

    public static void main3() {
        System.out.print("Prime numbers under 10 :: ");
        for (int i = 0; i < 10; i++)
            if (isPrime(i))
                System.out.print(i + " ");
        System.out.println();
    }
// Prime numbers under 10 :: 2 3 5 7 

    public static int myAtoi(String str) {
        int value = 0;
        int size = str.length();
        for (int i = 0; i < size; i++) {
            char ch = str.charAt(i);
            value = (value << 3) + (value << 1) + (ch - '0');
        }
        return value;
    }

    public static void main4() {
        System.out.println(myAtoi("1000"));
    }
// 1000
    public static boolean isUniqueChar(String str) {
        int[] bitarr = new int[26];
        int index;
        for (int i = 0; i < 26; i++) {
            bitarr[i] = 0;
        }
        int size = str.length();
        for (int i = 0; i < size; i++) {
            char c = str.charAt(i);
            if ('A' <= c && 'Z' >= c) {
                index = (c - 'A');
            } else if ('a' <= c && 'z' >= c) {
                index = (c - 'a');
            } else {
                System.out.println("Unknown Char!\n");
                return false;
            }
            if (bitarr[index] != 0) {
                System.out.println("Duplicate detected!");
                return false;
            }
            bitarr[index] += 1;
        }
        System.out.println("No duplicate detected!");
        return true;
    }

    public static void main5() {
        isUniqueChar("aple");
        isUniqueChar("apple");
    }
/*
No duplicate detected!
Duplicate detected!
*/
    public static char toUpper(char s) {
        if (s >= 97 && s <= (97 + 25)) {
            s = (char) (s - 32);
        }
        return s;
    }

    public static char toLower(char s) {
        if (s >= 65 && s <= (65 + 25)) {
            s = (char) (s + 32);
        }
        return s;
    }

    public static char lowerUpper(char s) {
        if (s >= 97 && s <= (97 + 25)) {
            s = (char) (s - 32);
        } else if (s >= 65 && s <= (65 + 25)) {
            s = (char) (s + 32);
        }
        return s;
    }

    public static void main6() {
        System.out.println(toLower('A'));
        System.out.println(toUpper('a'));
        System.out.println(lowerUpper('s'));
        System.out.println(lowerUpper('S'));
    }
/*
a
A
S
s
*/

    public static boolean isPermutation(String s1, String s2) {
        int[] count = new int[256];
        int length = s1.length();
        if (s2.length() != length) {
            System.out.println("is permutation return false");
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
                System.out.println("is permutation return false");
                return false;
            }
        }
        System.out.println("is permutation return true");
        return true;
    }

    public static void main7() {
        System.out.println(isPermutation("apple", "plepa"));
    }
/*
is permutation return true
true
*/
    public static boolean isPalindrome(String str) {
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

    public static void main8() {
        isPalindrome("hello");
        isPalindrome("eoloe");
    }
/*
String is not a Palindrome
String is a Palindrome
*/

    public static int pow(int x, int n) {
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

    public static void main9() {
        System.out.println(pow(5, 2));
    }
// 25

    public static int myStrcmp(String a, String b) {
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

    public static void main10() {
        System.out.println(myStrcmp("abs", "abs"));
    }
// 0
    public static String reverseString(String str) {
        char[] a = str.toCharArray();
        reverseStringUtil(a);
        String expn = new String(a);
        return expn;
    }

    public static void reverseStringUtil(char[] a) {
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

    public static void reverseStringUtil(char[] a, int lower, int upper) {
        char tempChar;
        while (lower < upper) {
            tempChar = a[lower];
            a[lower] = a[upper];
            a[upper] = tempChar;
            lower++;
            upper--;
        }
    }

    public static String reverseWords(String str) {
        char[] a = str.toCharArray();
        int length = a.length;
        int lower = 0, upper = -1;
        for (int i = 0; i <= length; i++) {
            if (i == length || a[i] == ' ') {
                reverseStringUtil(a, lower, upper);
                lower = i + 1;
                upper = i;
            } else {
                upper++;
            }
        }
        reverseStringUtil(a, 0, length - 1);
        String expn = new String(a);
        return expn;
    }

    public static void main11() {
        System.out.println(reverseString("apple"));
        System.out.println(reverseWords("hello world"));
    }
/*
elppa
world hello
*/
    public static void printAnagram(String str) {
        char[] a = str.toCharArray();
        int n = a.length;
        printAnagram(a, n, n);
    }

    public static void printAnagram(char[] a, int max, int n) {
        if (max == 1) {
            System.out.println(a);
        }
        char temp;
        for (int i = -1; i < max - 1; i++) {
            if (i != -1) {
                temp = a[i];
                a[i] = a[max - 1];
                a[max - 1] = temp;
            }
            printAnagram(a, max - 1, n);
            if (i != -1) {
                temp = a[i];
                a[i] = a[max - 1];
                a[max - 1] = temp;
            }
        }
    }

    public static void main12() {
        printAnagram("123");
    }
/*
123
213
321
231
132
312
*/
    public static void shuffle(String str) {
        char[] ar = str.toCharArray();
        int n = ar.length / 2;
        int count = 0;
        int k = 1;
        char temp = '\0', temp2;
        for (int i = 1; i < n; i = i + 2) {
            temp = ar[i];
            k = i;
            do {
                k = (2 * k) % (2 * n - 1);
                temp2 = temp;
                temp = ar[k];
                ar[k] = temp2;
                count++;
            } while (i != k);
            if (count == (2 * n - 2)) {
                break;
            }
        }
        System.out.println(ar);
    }

    public static void main13() {
        shuffle("ABCDE12345");
    }
// A1B2C3D4E5

    public static char[] addBinary(String firstStr, String secondStr) {
        char[] first = firstStr.toCharArray();
        char[] second = secondStr.toCharArray();
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

    public static void main14() {
        System.out.println(addBinary("1000", "11111111"));
    }
// 100000111 
    public static void main(String[] args) {
        main1();
        main2();
        main3();
        main4();
        main5();
        main6();
        main7();
        main8();
        main9();
        main10();
        main11();
        main12();
        main13();
        main14();
    }
}