package recursion;

import java.util.Scanner;

public class Factorial {

	// This class is not for instantiation
	private Factorial() {
	}

	public static long factorial(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * factorial(n);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n;
		System.out.print("Enter the number greater than or equal to zero : ");
		n = scanner.nextInt();
		System.out.println("Factorial of " + n + " is " + factorial(n));
		scanner.close();
	}
}
