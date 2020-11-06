package queueArray;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		int choice, x;

		Scanner scan = new Scanner(System.in);

		QueueArray stack = new QueueArray(8);

		while (true) {
			System.out.println("1. Insert an element in the Queue");
			System.out.println("2. Delete an element from the Queue");
			System.out.println("3. Display the front element");
			System.out.println("4. Display all Queue elements");
			System.out.println("5. Display size of the Queue");
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
				stack.insertorEnqueue(x);
				break;
			case 2:
				x = stack.deleteOrDequeue();
				System.out.println("Popped element is : " + x);
				break;
			case 3:
				System.out.print("Peek of the stack is : " + stack.peek());
				break;
			case 4:
				stack.display();
				break;
			case 5:
				System.out.print("Size of stack is : " + stack.size());
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
