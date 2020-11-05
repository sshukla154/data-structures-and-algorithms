package singleLinkedList;

import java.util.Scanner;

public class SingleLinkedList {

	private Node start;

	public SingleLinkedList() {
		start = null;
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

		/* If list is empty */
		if (start == null) {
			System.out.println("List is empty.");
			return;
		}

		/* If list has only one node */
		if (start.info == x) {
			start = start.link;
			return;
		}

		/* If list has more than one node, in between or at the end */
		Node p = start;
		while (p.link != null) {
			if (p.link.info == x) {
				break;
			}
			p = p.link;
		}

		if (p.link == null) {
			System.out.println("Element " + x + " not in the list.");
		} else {
			p.link = p.link.link;
		}

	}

	public void reverseList() {

		Node previous, p, next;
		previous = null;
		p = start;
		while (p != null) {
			next = p.link;
			p.link = previous;
			previous = p;
			p = next;
		}
		start = previous;
	}

	public void BubbleSortExchangingData() {

		Node p, q, end;

		/* for loop: end to p */
		for (end = null; end != start.link; end = p) {
			for (p = start; p.link != end; p = p.link) {
				q = p.link;
				if (p.info > q.info) {
					int temp = p.info;
					p.info = q.info;
					q.info = temp;
				}
			}

		}

	}

	public void BubbleSortExchangingLink() {
		/* reference r is always behind reference p */
		Node p, q, r, temp, end;

		for (end = null; end != start.link; end = p) {

			for (r = p = start; p.link != end; r = p, p = p.link) {
				q = p.link;
				/*
				 * If p.info is grater then we wont exchange p.info and q.info instead we will
				 * change the positions of Node referred by p&q. For this only we need extra
				 * reference r
				 */
				if (p.info > q.info) {
					p.link = q.link;
					q.link = p;
					if (p != start) {
						r.link = q;
					} else {
						start = q;
					}
					/* Exchange p and q for next pass */
					temp = p;
					p = q;
					q = temp;
				}
			}

		}

	}

	public SingleLinkedList mergeByCreatingNewList(SingleLinkedList list) {
		SingleLinkedList mergeList = new SingleLinkedList();
		mergeList.start = mergeByCreatingNewList(start, list.start);
		return mergeList;
	}

	private Node mergeByCreatingNewList(Node p1, Node p2) {

		/* First node of merged list */
		Node startM;

		if (p1.info <= p2.info) {
			startM = new Node(p1.info);
			p1 = p1.link;
		} else {
			startM = new Node(p2.info);
			p2 = p2.link;
		}

		/* Newly inserted node of merged list */
		Node pM = startM;

		/* While loop will terminate either p1 or p2 will be null */
		while (p1 != null && p2 != null) {
			if (p1.info <= p2.info) {
				pM.link = new Node(p1.info);
				p1 = p1.link;
			} else {
				pM.link = new Node(p2.info);
				p2 = p2.link;
			}
			pM = pM.link;
		}

		/* If second list has finished and elements left in first list */
		while (p1 != null) {
			pM.link = new Node(p1.info);
			p1 = p1.link;
			pM = pM.link;
		}

		/* If first list has finished and elements left in second list */
		while (p2 != null) {
			pM.link = new Node(p2.info);
			p2 = p2.link;
			pM = pM.link;
		}

		return startM;
	}

	public SingleLinkedList mergeByRearrangingList(SingleLinkedList list) {
		SingleLinkedList mergeList = new SingleLinkedList();
		mergeList.start = mergeByRearrangingList(start, list.start);
		return mergeList;
	}

	private Node mergeByRearrangingList(Node p1, Node p2) {

		/* First node of merged list */
		Node startM;

		if (p1.info <= p2.info) {
			startM = p1;
			p1 = p1.link;
		} else {
			startM = p2;
			p2 = p2.link;
		}

		/* Newly inserted node of merged list */
		Node pM = startM;

		/* While loop will terminate either p1 or p2 will be null */
		while (p1 != null && p2 != null) {
			if (p1.info <= p2.info) {
				pM.link = p1;
				pM = pM.link;
				p1 = p1.link;
			} else {
				pM.link = p2;
				pM = pM.link;
				p2 = p2.link;
			}
		}

		/* If second list has finished and elements left in first list */
		if (p1 == null) {
			pM.link = p2;
		}

		/* If first list has finished and elements left in second list */
		if (p2 == null) {
			pM.link = p1;
		}

		return startM;
	}

	public void mergeSort() {
		start = mergeSortRecursive(start);
	}

	private Node mergeSortRecursive(Node listStart) {

		/* If list is empty or has one element */
		if (listStart == null || listStart.link == null) {
			return listStart;
		}

		/* If list has more than one element */
		Node start1 = listStart;
		Node start2 = divideList(listStart);
		start1 = mergeSortRecursive(start1);
		start2 = mergeSortRecursive(start2);
		Node startM = mergeByRearrangingList(start1, start2);
		return startM;
	}

	private Node divideList(Node p) {
		Node q = p.link.link;
		while (q != null && q.link != null) {
			p = p.link;
			q = q.link.link;
		}

		Node start2 = p.link;
		p.link = null;
		return start2;
	}

	public boolean hasCycle() {
		if (findCycle() == null) {
			return false;
		} else {
			return true;
		}

	}

	private Node findCycle() {
		if (start == null || start.link == null) {
			return null;
		}

		Node slowReference = start;
		Node fastReference = start;
		/* If the list has no cycle then in while(condition), condition will be false */
		while (fastReference != null && slowReference != null) {
			/* Increasing one node at a time */
			slowReference = slowReference.link;
			/* Increasing two node at a time */
			fastReference = fastReference.link.link;
			/* If both references then cyclic is formed */
			if (slowReference == fastReference) {
				return slowReference;
			}
		}

		return null;
	}

	public void removeCycle() {
		Node c = findCycle();
		if (c == null) {
			return;
		}
		System.out.println("Node at which cycle is detected is : " + c.info);

		Node p = c, q = c;
		int cycleListLength = 0;

		do {
			cycleListLength++;
			q = q.link;
		} while (p != q);

		System.out.println("Length of cycle is : " + cycleListLength);

		int remainingListLength = 0;
		p = start;
		while (p != q) {
			remainingListLength++;
			p = p.link;
			q = q.link;
		}
		System.out.println("No of nodes not included in cycle : " + remainingListLength);

		int totalListlength = cycleListLength + remainingListLength;
		System.out.println("Length of cycle is : " + cycleListLength);
		p = start;
		for (int i = 1; i <= totalListlength - 1; i++) {
			p = p.link;
		}
		p.link = null;
	}

	public void insertCycle(int x) {
		if (start == null) {
			return;
		}

		Node p = start, px = null, prev = null;

		while (p != null) {
			if (p.info == 0) {
				px = p;
			}
			prev = p;
			p = p.link;
		}

		if (px != null) {
			prev.link = px;
		} else {
			System.out.println(x + " is not present in the list");
		}
	}

	public void concatenate(SingleLinkedList list) {
		/* If first list is empty */
		if (start == null) {
			start = list.start;
			return;
		}

		/* if input list (the one in parameter) is empty */
		if (list.start == null) {
			return;
		}

		Node p = start;
		while (p.link != null) {
			p = p.link;
		}
		p.link = list.start;
	}

}
