package recursion;

import java.util.Scanner;

public class PrintNumbers {

	// This class is not for instantiation
	private PrintNumbers() {
	}

	public static void printAscendingOrder(int n) {
		if (n == 0) {
			return;
		}
		printAscendingOrder(n - 1);
		System.out.print(n + " ");
	}

	public static void printDecendingOrder(int n) {
		if (n == 0) {
			return;
		}
		System.out.print(n + " ");
		printDecendingOrder(n - 1);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n;
		System.out.print("Enter the number greater than or equal to zero : ");
		n = scanner.nextInt();
		System.out.print("Ascending Order : ");
		printAscendingOrder(n);
		System.out.println();
		System.out.print("Decending Order : ");
		printDecendingOrder(n);
		scanner.close();
	}

}
