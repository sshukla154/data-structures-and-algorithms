package recursion;

import java.util.Scanner;

public class BaseConversion {

	// This class is not for instantiation
	private BaseConversion() {
	}

	public static void toBinary(int n) {
		if (n == 0) {
			return;
		}
		toBinary(n / 2);
		System.out.print(n % 2);
	}

	public static void convertBase(int n, int base) {
		if (n == 0) {
			return;
		}
		convertBase(n / base, base);
		int remainder = n % base;

		if (remainder < 10) {
			System.out.print(remainder);
		} else {
			System.out.print((char) remainder - 10 + 'a');
		}

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n;
		System.out.print("Enter a positive decimal number : ");
		n = scanner.nextInt();
		System.out.print("Binary form : ");
		toBinary(n);
		System.out.println();
		System.out.print("Binary form : ");
		convertBase(n, 2);
		System.out.println();
		System.out.print("Octal form : ");
		convertBase(n, 8);
		System.out.println();
		System.out.print("Hexadecimal form : ");
		convertBase(n, 16);
		System.out.println();
		scanner.close();
	}
}
