package binarySearchTree;

import java.util.Scanner;

public class RecursiveDemo {

	public static void main(String[] args) {

		BinarySearchTree binarySearchTree = new BinarySearchTree();
		int choice, x;
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("1. Display Tree");
			System.out.println("2. Search");
			System.out.println("3. Insert A Node");
			System.out.println("4. Delete A Node");
			System.out.println("5. Preorder Traversal");
			System.out.println("6. Inorder traversal");
			System.out.println("7. Postorder Traversal");
			System.out.println("8. Height Of Tree");
			System.out.println("9. Find Minimum Key");
			System.out.println("10. Find Maximum Key");
			System.out.println("11. Quit");

			System.out.print("Enter you choice : ");
			choice = scanner.nextInt();

			if (choice == 11) {
				break;
			}

			switch (choice) {
			case 1:
				binarySearchTree.display();
				break;
			case 2:
				System.out.print("Enter the key to be searched :");
				x = scanner.nextInt();
				boolean searchResult = binarySearchTree.search(x);
				if (searchResult) {
					System.out.println("Key found...");
				} else {
					System.out.println("Key not found...");
				}
				break;
			case 3:
				System.out.print("Enter the key to be inserted :");
				x = scanner.nextInt();
				binarySearchTree.insert(x);
				break;
			case 4:
				System.out.print("Enter the key to be deleted :");
				x = scanner.nextInt();
				binarySearchTree.delete(x);
				break;
			case 5:
				binarySearchTree.preOrder();
				break;
			case 6:
				binarySearchTree.preOrder();
				break;
			case 7:
				binarySearchTree.preOrder();
				break;
			case 8:
				System.out.println("Height of tree is : " + binarySearchTree.height());
				break;
			case 9:
				System.out.println("Minimum key is : " + binarySearchTree.min());
				break;
			case 10:
				System.out.println("Maximum key is : " + binarySearchTree.max());
				break;
			default:
				System.out.println("Incorrect option selected...");
				break;
			}
		}
		scanner.close();
	}

}
