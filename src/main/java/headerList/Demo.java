package headerList;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		int choice, data, k, x;

		Scanner scan = new Scanner(System.in);

		HeaderList List = new HeaderList();
		List.createList();

		while (true) {
			System.out.println("1. Display List");
			System.out.println("2. Insert A Node At The End Of The List");
			System.out.println("3. Insert A Node Before A Specific Node");
			System.out.println("4. Insert At A Given Position");
			System.out.println("5. Delete A Node");
			System.out.println("6. Reverse The List");
			System.out.println("7. Quit");

			System.out.print("Enter your choice : ");
			choice = scan.nextInt();

			if (choice == 7) {
				break;
			}

			switch (choice) {
			case 1:
				List.displayList();
				break;
			case 2:
				System.out.print("Insert the element to be inserted at the end of the list : ");
				data= scan.nextInt();
				List.insertAtEnd(data);
				break;
			case 3:
				System.out.print("Enter the element to be inserted : ");
				data= scan.nextInt();
				System.out.print("Enter the element before which to insert : ");
				x= scan.nextInt();
				List.insertBefore(data, x);
				break;
			case 4:
				System.out.print("Enter the element to be inserted : ");
				data = scan.nextInt();
				System.out.print("Enter the position at which node is to be inserted : ");
				k = scan.nextInt();
				List.insertAtPosition(data, k);
				break;
			case 5:
				System.out.print("Enter the element to be deleted : ");
				data= scan.nextInt();
				List.deleteNode(data);
				break;
			case 6:
				List.reverse();
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
