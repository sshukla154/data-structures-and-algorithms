package priorityQueue;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		int choice, element, elementPriority;

		Scanner scan = new Scanner(System.in);

		PriorityQueueSingleLinkedList priorityQueueSingleLinkedList = new PriorityQueueSingleLinkedList();

		while (true) {
			System.out.println("1. Insert an element in the Queue");
			System.out.println("2. Delete an element from the Queue");
			System.out.println("3. Display all Queue elements");
			System.out.println("4. Exit");

			System.out.print("Enter your choice : ");
			choice = scan.nextInt();

			if (choice == 4) {
				break;
			}

			switch (choice) {
			case 1:
				System.out.print("Enter the element to be inserted :");
				element = scan.nextInt();
				System.out.print("Enter it's priority :");
				elementPriority = scan.nextInt();
				priorityQueueSingleLinkedList.insert(element, elementPriority);
				break;
			case 2:
				int delete = priorityQueueSingleLinkedList.delete();
				System.out.println("Deleted element is : " + delete);
				break;
			case 3:
				priorityQueueSingleLinkedList.display();
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
