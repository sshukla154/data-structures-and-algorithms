package queueCircularList;

import java.util.NoSuchElementException;

public class QueueCircularList {

	/* Index of last element in queue - for insertion and deletion */
	private Node rear;

	public QueueCircularList() {
		/* rear is null i.e: Empty array/list */
		rear = null;
	}

	public boolean isEmpty() {
		return (rear == null);
	}

	/* insertorEnqueue() element at the rear end of the circular list */
	public void insertorEnqueue(int x) {

		Node temp = new Node(x);

		/* If queue is empty */
		if (isEmpty()) {
			rear = temp;
			rear.link = rear;
		} else {
			temp.link = rear.link;
			rear.link = temp;
			rear = temp;
		}
	}

	/* deleteOrDequeue() return the front element of the queue after deleting it */
	public int deleteOrDequeue() {

		if (isEmpty()) {
			System.out.println("Queue Underflow");
			throw new NoSuchElementException();
		}

		Node temp;
		if (rear.link == rear) {
			temp = rear;
			rear = null;
		} else {
			temp = rear.link;
			rear.link = temp.link;
		}
		return temp.info;

	}

	/* peek() return the top most element of the stack without deleting it */
	public int peek() {
		if (isEmpty()) {
			System.out.println("Queue Underflow");
			throw new NoSuchElementException();
		}
		return rear.link.info;
	}

	public void display() {
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return;
		}
		System.out.println("Queue is...");
		Node p = rear.link;
		do {
			System.out.println(p.info + " ");
			p = p.link;
		} while (p != rear.link);
		System.out.println();
	}

	public int size() {

		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return 0;
		}
		System.out.println("Queue is...");
		Node p = rear.link;
		int size = 0;
		do {
			size++;
			System.out.println(p.info + " ");
			p = p.link;
		} while (p != rear.link);
		System.out.println();
		return size;
	}

}
