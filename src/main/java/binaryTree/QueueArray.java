package binaryTree;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class QueueArray {

	private Node[] queueArray;
	private int front;
	private int rear;

	public QueueArray() {
		queueArray = new Node[10];
		/* both rear and front is -1 i.e: Empty array/list */
		rear = -1;
		front = -1;
	}

	public QueueArray(int maxSize) {
		queueArray = new Node[maxSize];
		rear = -1;
		front = -1;
	}

	public int size() {
		if (isEmpty()) {
			return 0;
		}
		return rear - front + 1;
	}

	public boolean isEmpty() {
		return (front == -1 || (front == (rear + 1)));
	}

	public boolean isFull() {
		return (rear == (queueArray.length - 1));
	}

	/* insertorEnqueue() element at the rear end of the array */
	public void insertorEnqueue(Node x) {

		if (isFull()) {
			System.out.println("Queue Overflow");
			return;
		}

		if (front == -1) {
			front = 0;
		}

		/* rear is increased by 1 */
		rear = rear + 1;
		/* New element is inserted at rear index */
		queueArray[rear] = x;

	}

	/* deleteOrDequeue() return the front element of the queue after deleting it */
	public Node deleteOrDequeue() {

		Node x;
		if (isEmpty()) {
			System.out.println("Queue Underflow");
			throw new NoSuchElementException();
		}

		/* Element at index front is taken out */
		x = queueArray[front];
		/* front is incremented by 1 */
		front = front + 1;
		return x;

	}

	/* peek() return the top most element of the stack without deleting it */
	public Node peek() {
		if (isEmpty()) {
			System.out.println("Queue Underflow");
			throw new EmptyStackException();
		}
		return queueArray[front];
	}

	public void display() {
		int i;
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return;
		}
		System.out.println("Queue is...");
		for (i = front; i >= rear; i++) {
			System.out.println(queueArray[i] + " ");
		}
		System.out.println();
	}

}
