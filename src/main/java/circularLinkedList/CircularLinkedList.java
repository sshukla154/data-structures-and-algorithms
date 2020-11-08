package circularLinkedList;

import java.util.Scanner;

import singleLinkedList.Node;

public class CircularLinkedList {

	private Node last;

	public CircularLinkedList() {
		last = null;
	}

	public void displayList() {
		Node p;
		if (last == null) {
			System.out.println("List is empty");
			return;
		}

		/*
		 * in Circular, reference stops when p becomes first node while in non Circular,
		 * reference stops when p becomes first node
		 */
		p = last.link;
		do {
			System.out.print(p.info + " ");
			p = p.link;
		} while (p != last.link);
		System.out.println();

	}

	public void insertInBeginning(int data) {
		Node temp = new Node(data);
		temp.link = last.link;
		last.link = temp;
	}

	public void insertInEmptyList(int data) {
		Node temp = new Node(data);
		last = temp;
		last.link = last;
	}

	public void insertAtEnd(int data) {
		Node temp = new Node(data);
		temp.link = last.link;
		last.link = temp;
		last = temp;
	}

	@SuppressWarnings("resource")
	public void createList() {
		int i, n, data;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the no of nodes : ");
		n = scan.nextInt();

		if (n == 0) {
			System.out.println("List is empty");
			return;
		}

		System.out.print("Enter the element to be inserted : ");
		data = scan.nextInt();

		insertInEmptyList(data);

		for (i = 2; i <= n; i++) {
			System.out.print("Enter te element to be inserted : ");
			data = scan.nextInt();
			insertAtEnd(data);
		}
		scan.close();
	}

	public void insertAfter(int data, int x) {
		Node p = last.link;
		do {
			if (p.info == x) {
				break;
			}
			p = p.link;
		} while (p != last.link);

		if (p == last.link && p.info != x) {
			System.out.println(x + " is not present in the list");
		} else {
			Node temp = new Node(data);
			temp.link = p.link;
			p.link = temp;
			if (p == last) {
				last = temp;
			}
		}

	}

	public void deleteFirstNode() {
		if (last == null) {
			System.out.println("List is empty");
			return;
		}

		if (last.link == last) {
			last = null;
			return;
		}
		last.link = last.link.link;
	}

	public void deleteLastNode() {
		if (last == null) {
			System.out.println("List is empty");
			return;
		}

		if (last.link == last) {
			last = null;
			return;
		}

		Node p = last.link;
		while (p.link != last) {
			p = p.link;
		}
		p.link = last.link;
		last = p;
	}

	public void deleteNode(int x) {

		/* List is empty */
		if (last == null) {
			System.out.println("List is empty");
			return;
		}

		/* Deletion of only node */
		if (last.link == last && last.info == x) {
			last = null;
			return;
		}

		/* Deletion of first node */
		if (last.link.info == x) {
			last.link = last.link.link;
			return;
		}

		Node p = last.link;
		while (p.link != last.link) {
			if (p.link.info == x) {
				break;
			}
			p = p.link;
		}

		if (p.link == last.link) {
			System.out.println(x + " is not found.");
		} else {
			p.link = p.link.link;
			if (last.info == x) {
				last = p;
			}
		}

	}

	public void concatenate(CircularLinkedList list) {
		/* If first list is empty */
		if (last == null) {
			last = list.last;
			return;
		}

		/* if input list (the one in parameter) is empty */
		if (list.last == null) {
			return;
		}

		Node p = last.link;
		last.link = list.last.link;
		list.last.link = p;
		last = list.last;
	}

}
