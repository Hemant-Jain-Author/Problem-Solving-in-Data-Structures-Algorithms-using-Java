public class IsPrime {
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

	public static void main(String[] args) {
		System.out.println(IsPrime.isPrime(8));
		System.out.println(IsPrime.isPrime(11));
	}
}

/*
false
true
*/