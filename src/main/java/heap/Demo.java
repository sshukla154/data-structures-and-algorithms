package heap;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Heap heap = new Heap(20);
		int choice, value;

		while (true) {
			System.out.println("1. Insert");
			System.out.println("2. Delete Root");
			System.out.println("3. Display");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();

			if (choice == 4) {
				break;
			}

			switch (choice) {
			case 1:
				System.out.print("Enter the value to ber inserted : ");
				value = scanner.nextInt();
				heap.insert(value);
				break;
			case 2:
				System.out.println("Maximum value is : " + heap.deleteRoot());
				break;
			case 3:
				heap.display();
				break;
			default:
				System.out.println("Wrong Choice");
			}
		}
		scanner.close();
	}

}
