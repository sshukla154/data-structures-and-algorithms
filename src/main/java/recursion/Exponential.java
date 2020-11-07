package recursion;

import java.util.Scanner;

public class Exponential {

	// This class is not for instantiation
	public Exponential() {
	}

	public static float power(float x, int n) {
		if (n == 0) {
			return 1;
		}
		return x * power(x, (n - 1));
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number : ");
		float x = scanner.nextFloat();
		System.out.print("Enter the exponent : ");
		int n = scanner.nextInt();
		System.out.println(x + "^" + n + " = " + power(x, n));
	}

}
