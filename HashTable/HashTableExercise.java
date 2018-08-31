import java.util.HashSet;

public class HashTableExercise {

	public static void main(String[] args) {
		char[] first = "hello".toCharArray();
		char[] second = "elloh".toCharArray();
		char[] third = "world".toCharArray();

		System.out.println("isAnagram : " + isAnagram(first, second));
		System.out.println("isAnagram : " + isAnagram(first, third));

		removeDuplicate(first);
		System.out.println(first);

		int arr[] = { 1, 2, 3, 5, 6, 7, 8, 9, 10 };
		System.out.println(findMissing(arr, 1, 10));

		int arr1[] = { 1, 2, 3, 4, 4, 5, 6, 7, 8, 9, 1 };
		printRepeating(arr1);
		printFirstRepeating(arr1);
	}

	public static boolean isAnagram(char[] str1, char[] str2) {
		int size1 = str1.length;
		int size2 = str2.length;

		if (size1 != size2)
			return false;

		CountMap<Character> cm = new CountMap<Character>();

		for (char ch : str1) {
			cm.add(ch);
		}

		for (char ch : str2) {
			cm.remove(ch);
		}

		return (cm.size() == 0);
	}

	public static void removeDuplicate(char[] str) {
		int index = 0;
		HashSet<Character> hs = new HashSet<Character>();

		for (char ch : str) {
			if (hs.contains(ch) == false) {
				str[index++] = ch;
				hs.add(ch);
			}
		}
		str[index] = '\0';
	}

	public static int findMissing(int[] arr, int start, int end) {
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i : arr) {
			hs.add(i);
		}

		for (int curr = start; curr <= end; curr++) {
			if (hs.contains(curr) == false)
				return curr;
		}

		return Integer.MAX_VALUE;
	}

	public static void printRepeating(int[] arr) {
		HashSet<Integer> hs = new HashSet<Integer>();

		System.out.print("Repeating elements are:");
		for (int val : arr) {
			if (hs.contains(val))
				System.out.print("  " + val);
			else
				hs.add(val);
		}
	}

	public static void printFirstRepeating(int[] arr) {
		int i;
		int size = arr.length;
		CountMap<Integer> hs = new CountMap<Integer>();

		for (i = 0; i < size; i++) {
			hs.add(arr[i]);
		}
		for (i = 0; i < size; i++) {
			hs.remove(arr[i]);
			if (hs.containsKey(arr[i])) {
				System.out.println("First Repeating number is : " + arr[i]);
				return;
			}
		}
	}

	int hornerHash(char[] key, int tableSize) {
		int size = key.length;
		int h = 0;
		int i;
		for (i = 0; i < size; i++) {
			h = (32 * h + key[i]) % tableSize;
		}
		return h;
	}
}