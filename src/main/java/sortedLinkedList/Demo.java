package sortedLinkedList;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		int choice, data, x;

		Scanner scan = new Scanner(System.in);

		SortedLinkedList List = new SortedLinkedList();
		List.createList();

		while (true) {
			System.out.println("1. Display List");
			System.out.println("2. Insert A Node");
			System.out.println("3. Search");
			System.out.println("4. Exit");

			System.out.print("Enter your choice : ");
			choice = scan.nextInt();

			if (choice == 4) {
				break;
			}

			switch (choice) {
			case 1:
				List.displayList();
				break;
			case 2:
				System.out.print("Enter the node to be inserted in the list :");
				data= scan.nextInt();
				List.insertInOrder(data);
				break;
			case 3:
				System.out.print("Enter the element to be serched : ");
				x = scan.nextInt();
				List.search(x);
				break;
			default:
				System.out.println("Incorrect choice !!!");
			}
			System.out.println();
		}
		scan.close();
		System.out.println("Exiting");
	}
}
