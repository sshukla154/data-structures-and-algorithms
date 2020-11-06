package dequeueCircularArray;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		int choice, x;

		Scanner scan = new Scanner(System.in);

		DequeueCircularArray stack = new DequeueCircularArray(8);

		while (true) {
			System.out.println("1. Insert an element at front end");
			System.out.println("2. Insert an element at rear end");
			System.out.println("3. Delete an element from front end");
			System.out.println("4. Delete an element from rear end");
			System.out.println("5. Display all elements of De-Queue");
			System.out.println("6. Exit");

			System.out.print("Enter your choice : ");
			choice = scan.nextInt();

			if (choice == 6) {
				break;
			}

			switch (choice) {
			case 1:
				System.out.print("Enter the element to be inserted :");
				x = scan.nextInt();
				stack.insertFront(x);
				break;
			case 2:
				System.out.print("Enter the element to be inserted :");
				x = scan.nextInt();
				stack.insertRear(x);
				break;
			case 3:
				x = stack.deleteFront();
				System.out.println("Popped element is : " + x);
				break;
			case 4:
				x = stack.deleteRare();
				System.out.println("Popped element is : " + x);
				break;
			case 5:
				stack.display();
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
