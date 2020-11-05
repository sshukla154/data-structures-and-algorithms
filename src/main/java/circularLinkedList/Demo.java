package circularLinkedList;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		int choice, data, k, x;

		Scanner scan = new Scanner(System.in);

		CircularLinkedList List = new CircularLinkedList();
		List.createList();

		while (true) {
			System.out.println("1. Display List");
			System.out.println("2. Insert In Empty List");
			System.out.println("3. Insert A Node At The Beginning Of The List");
			System.out.println("4. Insert A Node At The End Of The List");
			System.out.println("5. Insert A Node After A Specific Node");
			System.out.println("6. Delete First Node");
			System.out.println("7. Delete Last Node");
			System.out.println("8. Delete Any Node");
			System.out.println("9. Quit");

			System.out.print("Enter your choice : ");
			choice = scan.nextInt();

			if (choice == 9) {
				break;
			}

			switch (choice) {
			case 1:
				List.displayList();
				break;
			case 2:
				System.out.print("Insert the element to be inserted in empty list : ");
				data= scan.nextInt();
				List.insertInEmptyList(data);
				break;
			case 3:
				System.out.print("Insert the element to be inserted at the beginning of the list : ");
				data= scan.nextInt();
				List.insertInBeginning(data);
				break;
			case 4:
				System.out.print("Insert the element to be inserted at the end of the list : ");
				data= scan.nextInt();
				List.insertAtEnd(data);
				break;
			case 5:
				System.out.print("Enter the element to be inserted : ");
				data= scan.nextInt();
				System.out.print("Enter the element before which to insert : ");
				x= scan.nextInt();
				List.insertAfter(data, x);
				break;
			case 6:
				List.deleteFirstNode();
				break;
			case 7:
				List.deleteLastNode();
				break;
			case 8:
				System.out.print("Enter the element to be deleted : ");
				data= scan.nextInt();
				List.deleteNode(data);
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
