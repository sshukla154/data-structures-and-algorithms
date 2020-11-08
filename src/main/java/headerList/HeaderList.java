package headerList;

import java.util.Scanner;

public class HeaderList {

	private Node head;

	public HeaderList() {
		head = new Node(0);
	}

	public void displayList() {
		if (head.link == null) {
			System.out.println("List is empty");
		}

		Node p = head.link;
		System.out.println("List is : ");
		while (p != null) {
			System.out.print(p.info + " ");
			p = p.link;
		}
		System.out.println();
	}

	public void insertAtEnd(int data) {

		Node temp = new Node(data);
		Node p = head;

		while (p.link != null) {
			p = p.link;
		}

		p.link = temp;
		temp.link = null;

	}

	public void createList() {

		int i, n, data;

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the no of nodes : ");
		n = scan.nextInt();
		for (i = 0; i <= n; i++) {
			System.out.print("Enter the element to be inserted : ");
			data = scan.nextInt();
			insertAtEnd(data);
		}
		scan.close();

	}

	public void insertBefore(int data, int x) {

		Node temp;

		/* Find pointer to predecessor of node containing x */

		Node p = head;
		while (p.link != null) {
			if (p.link.info == x) {
				break;
			}
			p = p.link;
		}

		if (p.link == null) {
			System.out.println(x + "is not present in the list");
		} else {
			temp = new Node(data);
			temp.link = p.link;
			p.link = temp;
		}

	}

	public void insertAtPosition(int data, int k) {

		Node temp;
		int i;

		Node p = head;

		for (i = 1; i <= k - 1 && p != null; i++) {
			p = p.link;
		}

		if (p == null) {
			System.out.println("You can insert only upto " + (i - 1) + "th position");
		} else {
			temp = new Node(data);
			temp.link = p.link;
			p.link = temp;
		}

	}

	public void deleteNode(int data) {
		Node p = head;
		while (p.link != null) {
			if (p.link != null) {
				break;
			}
			p = p.link;
		}

		if (p.link == null) {
			System.out.println(data + "Element %d is not found in the list");
		} else {
			p.link = p.link.link;
		}
	}

	public void reverse() {
		
	}
}
