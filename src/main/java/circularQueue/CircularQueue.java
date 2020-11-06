package circularQueue;

import java.util.NoSuchElementException;

public class CircularQueue {

	private int[] queueArray;

	/* Index of first element in queue - deletion from front end */
	private int front;

	/* Index of last element in queue - insertion from rear end */
	private int rear;

	public CircularQueue() {
		queueArray = new int[10];
		/* both rear and front is -1 i.e: Empty array/list */
		front = -1;
		rear = -1;
	}

	public CircularQueue(int maxSize) {
		queueArray = new int[maxSize];
		/* both rear and front is -1 i.e: Empty array/list */
		front = -1;
		rear = -1;
	}

	public boolean isEmpty() {
		return (front == -1);
	}

	public boolean isFull() {
		return (((front == 0) && (rear == queueArray.length - 1)) || (front == rear + 1));
	}

	/* insertorEnqueue() element at the rear end of the array */
	public void insertorEnqueue(int x) {

		if (isFull()) {
			System.out.println("Queue Overflow");
			return;
		}
		if (front == -1) {
			front = 0;
		}
		if (rear == queueArray.length - 1) {
			/* New element is inserted at 0th index if rear is of array length */
			rear = 0;
		} else {
			/* New element is inserted at rear index */
			rear = rear + 1;
		}
		queueArray[rear] = x;

	}

	/* deleteOrDequeue() return the front element of the queue after deleting it */
	public int deleteOrDequeue() {

		int x;
		if (isEmpty()) {
			System.out.println("Queue Underflow");
			throw new NoSuchElementException();
		}

		/* Element at index front is taken out */
		x = queueArray[front];

		if (front == rear) {
			/* Queue has only one elements */
			front = -1;
			rear = -1;
		} else if (front == queueArray.length - 1) {
			front = 0;
		} else {
			/* front is incremented by 1 */
			front = front + 1;
		}
		return x;

	}

	/* peek() return the top most element of the stack without deleting it */
	public int peek() {
		if (isEmpty()) {
			System.out.println("Queue Underflow");
			throw new NoSuchElementException();
		}
		return queueArray[front];
	}

	public void display() {
		int i = front;
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return;
		}
		System.out.println("Queue is...");
		if (front <= rear) {
			while (i <= rear) {
				System.out.println(queueArray[i++] + " ");
			}
		} else {
			while (i <= queueArray.length - 1) {
				System.out.println(queueArray[i++] + " ");
			}
			i = 0;
			while (i <= rear) {
				System.out.println(queueArray[i++] + " ");
			}
		}
		System.out.println();
	}

	public int size() {
		if (isEmpty()) {
			return 0;
		}
		if (isFull()) {
			return queueArray.length;
		}

		int i = front;
		int size = 0;

		if (front <= rear) {
			while (i <= rear) {
				size++;
				i++;
			}
		} else {
			while (i <= queueArray.length - 1) {
				size++;
				i++;
			}
			i = 0;
			while (i <= rear) {
				size++;
				i++;
			}
		}

		return size;
	}
}
