package recursion;

import java.util.Scanner;

public class Euclids_FindGCD {

	// This class is not for instantiation
	public Euclids_FindGCD() {
	}

	public static void main(String[] args) {
		int a, b;
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter value of a and b : ");
		a = scanner.nextInt();
		b = scanner.nextInt();

		System.out.println("GCD of " + a + " and " + b + " is :" + findGCD(a, b));

	}

	private static int findGCD(int a, int b) {

		if (b == 0) {
			return a;
		}
		return findGCD(b, a % b);
	}

}
