package recursion;

import java.util.Scanner;

public class SumOfDigits {

	// This class is not for instantiation
	public SumOfDigits() {
	}

	public static long sumDigits(long n) {
		if (n / 10 == 0) {
			/* n is single digit number */
			return n;
		}
		return sumDigits(n / 10) + (n % 10);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n;
		System.out.print("Enter the number : ");
		n = scanner.nextLong();
		System.out.println("Sum of digits is : " + sumDigits(n));
		scanner.close();
	}

}
