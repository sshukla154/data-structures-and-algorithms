package stackArray;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		int choice, x;

		Scanner scan = new Scanner(System.in);

		StackArray stack = new StackArray(8);

		while (true) {
			System.out.println("1. Push an element in the stack");
			System.out.println("2. Pop an element from the stack");
			System.out.println("3. Display the top element");
			System.out.println("4. Display all stack elements");
			System.out.println("5. Display size of the stack");
			System.out.println("6. Exit");

			System.out.print("Enter your choice : ");
			choice = scan.nextInt();

			if (choice == 6) {
				break;
			}

			switch (choice) {
			case 1:
				System.out.print("Enter the element to be pushed :");
				x= scan.nextInt();
				stack.push(x);
				break;
			case 2:
				x= stack.pop();
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