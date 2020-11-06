package queueLinkedList;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class QueueSingleLinkedList {

	/* Index of first element in queue - deletion from front end */
	private Node front;

	/* Index of last element in queue - insertion from rear end */
	private Node rear;

	public QueueSingleLinkedList() {
		/* both rear and front is null i.e: Empty array/list */
		rear = null;
		front = null;
	}

	public int size() {

		int size = 0;
		Node p = front;
		while (p != null) {
			size++;
			p = p.link;
		}
		return size;
	}

	public boolean isEmpty() {
		return (front == null);
	}

	/* insertorEnqueue() element at the rear end of the array */
	public void insertorEnqueue(int x) {

		Node temp;
		temp = new Node(x);

		/* If queue is empty */
		if (front == null) {
			front = temp;
		} else {
			rear.link = temp;
		}
		rear = temp;

	}

	/* deleteOrDequeue() return the front element of the queue after deleting it */
	public int deleteOrDequeue() {

		int x;
		if (isEmpty()) {
			System.out.println("Queue Underflow");
			throw new NoSuchElementException();
		}

		/* Element at index front is taken out */
		x = front.info;
		/* front is incremented by 1 */
		front = front.link;
		return x;

	}

	/* peek() return the top most element of the stack without deleting it */
	public int peek() {
		if (isEmpty()) {
			System.out.println("Queue Underflow");
			throw new NoSuchElementException();
		}
		return front.info;
	}

	public void display() {
		Node p = front;
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return;
		}
		System.out.println("Queue is...");
		while (p != null) {
			System.out.println(p.info + " ");
			p = p.link;
		}
		System.out.println();
	}

}
