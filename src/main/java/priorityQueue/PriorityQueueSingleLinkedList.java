package priorityQueue;

import java.util.NoSuchElementException;

public class PriorityQueueSingleLinkedList {

	/* Index of first element in queue - deletion from front end */
	private Node front;

	public PriorityQueueSingleLinkedList() {
		/* both front is null i.e: Empty queue */
		front = null;
	}

	public boolean isEmpty() {
		return (front == null);
	}

	/* insert() element at the rear end of the array */
	public void insert(int element, int elementPriority) {

		Node temp, p;
		temp = new Node(element, elementPriority);

		/*
		 * If queue is empty or element to be added has more priority than first element
		 */
		if (isEmpty() || elementPriority < front.priority) {
			temp.link = front;
			front = temp;
		} else {
			p = front;
			while (p.link != null && p.link.priority <= elementPriority) {
				p = p.link;
			}
			temp.link = p.link;
			p.link = temp;
		}

	}

	/* delete() return the front element of the queue after deleting it */
	public int delete() {

		int element;
		if (isEmpty()) {
			System.out.println("Queue Underflow");
			throw new NoSuchElementException();
		} else {
			/* Element at index front is taken out */
			element = front.info;
			/* front is incremented by 1 */
			front = front.link;
		}

		return element;

	}

	public void display() {
		Node p = front;
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return;
		} else {
			System.out.println("Queue is...");
			System.out.println("Element priority");
			while (p != null) {
				System.out.println(p.info + " " + p.priority);
				p = p.link;
			}
		}
		System.out.println();
	}

}
