package recursion;

import java.util.Scanner;

public class TowerOfHanoi {

	// This class is not for instantiation
	private TowerOfHanoi() {
	}

	public static void hanoi(int n, char source, char temp, char destination) {
		if (n == 1) {
			System.out.println("Move disk " + n + " from " + source + " to " + destination);
			return;
		}
		hanoi(n - 1, source, destination, temp);
		System.out.println("Move disk " + n + " from " + source + " to " + destination);
		hanoi(n - 1, temp, source, destination);

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n;
		System.out.print("Enter the no of disks : ");
		n = scanner.nextInt();

		hanoi(n, 'A', 'B', 'C');

		scanner.close();
	}
}
