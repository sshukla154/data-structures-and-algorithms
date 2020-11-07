package recursion;

import java.util.Scanner;

public class Fibonacci {

	// This class is not for instantiation
	private Fibonacci() {
	}

	private static int fibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter no of terms : ");
		int terms = scanner.nextInt();
		for (int i = 0; i <= terms; i++) {
			System.out.println(fibonacci(i));
		}
		scanner.close();
	}
}
