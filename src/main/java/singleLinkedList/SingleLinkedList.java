package singleLinkedList;

import java.util.Scanner;

public class SingleLinkedList {

	private Node start;

	public SingleLinkedList() {
		start = null;
	}

	public void createList() {

		int i, n, data;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the number of nodes : ");
		n = scan.nextInt();

		if (n == 0) {
			return;
		}

		for (i = 1; i <= n; i++) {
			System.out.print("Enter the element to be inserted : ");
			data = scan.nextInt();
			insertAtEnd(data);
		}

	}

	public void insertAtEnd(int data) {
		Node p;
		Node temp = new Node(data);
		if (start == null) {
			start = temp;
			return;
		}

		p = start;
		while (p.link != null) {
			p = p.link;
		}
		p.link = temp;

	}

	public void displayList() {
		Node p;
		if (start == null) {
			System.out.println("List is empty...!!!");
			return;
		}
		p = start;
		System.out.print("List is : ");
		while (p != null) {
			System.out.print(p.info + " ");
			p = p.link;
		}
		System.out.println();
	}

	public void countNodes() {
		Node p;
		int count = 0;
		p = start;

		while (p != null) {
			count++;
			p = p.link;
		}

		System.out.println("No of nodes in the list : " + count);
	}

	public boolean search(int x) {
		Node p;
		int position = 1;
		p = start;

		while (p != null) {
			if (p.info == x) {
				break;
			}
			position++;
			p = p.link;
		}

		if (p == null) {
			System.out.println(x + " not found in the list");
			return false;
		} else {
			System.out.println(x + " is at position " + position);
			return true;
		}
	}

	public void insertInBeginning(int data) {
		Node temp = new Node(data);
		temp.link = start;
		start = temp;
	}

	public void insertAfter(int data, int x) {
		Node p = start;
		while (p != null) {
			if (p.info == x) {
				break;
			}
			p = p.link;

			if (p == null) {
				System.out.println(x + " is not present.");
			} else {
				Node temp = new Node(data);
				temp.link = p.link;
				p.link = temp;
			}
		}
	}

	public void insertBefore(int data, int x) {
		Node temp;

		/* If list is empty */
		if (start == null) {
			System.out.println("List is empty.");
		}

		/* x is in first node, new node is to be initiated before first node */
		if (x == start.info) {
			temp = new Node(data);
			temp.link = start;
			start = temp;
			return;
		}

		/* Find reference to predecessor of the node containing x */
		Node p = start;
		while (p.link != null) {
			if (p.link.info == x) {
				break;
			}
			p = p.link;
		}

		if (p.link == null) {
			System.out.println(x + " not present in the list.");
		} else {
			temp = new Node(data);
			temp.link = p.link;
			p.link = temp;
		}
	}

	public void insertAtPosition(int data, int k) {

		Node temp;
		int i;

		if (k == 1) {
			temp = new Node(data);
			temp.link = start;
			start = temp;
			return;

		}

		Node p = start;
		for (i = 1; i < k - 1 && p != null; i++) {/* Find reference to (k-1) */
			p = p.link;
		}

		if (p == null) {
			System.out.println("You can only insert upto " + k + "th position");
		} else {
			temp = new Node(data);
			temp.link = p.link;
			p.link = temp;
		}

	}

	public void deleteFirstNode() {
		if (start == null) {
			return;
		}
		start = start.link;
	}

	public void deleteLastNode() {
		if (start == null) {
			return;
		}

		if (start.link == null) {
			start = null;
		}

		Node p = start;
		/* After this while loop is terminated, pointer will be at second last index */
		while (p.link.link != null) {
			p = p.link;
		}
		p.link = null;
	}

	public void deleteNode(int x) {
		
		/*If list is empty*/
		if (start == null) {
			System.out.println("List is empty.");
			return;
		}

		/*If list has only one node*/
		if(start.info==x) {
			start=start.link;
			return;
		}

		/*If list has more than one node, in between or at the end*/
		Node p = start;
		while(p.link!=null) {
			if(p.link.info==x) {
				break;
			}
			p=p.link;
		}
		
		if(p.link==null) {
			System.out.println("Element " + x + " not in the list.");
		} else {
			p.link = p.link.link;
		}
		
	}

	public void reverseList() {
		
		Node previous, p, next;
		previous = null;
		p = start;
		while(p!=null) {
			next=p.link;
			p.link=previous;
			previous=p;
			p=next;
		}
		start = previous;
	}

}
