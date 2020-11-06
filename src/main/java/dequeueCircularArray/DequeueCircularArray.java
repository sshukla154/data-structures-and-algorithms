package dequeueCircularArray;

import java.util.NoSuchElementException;

public class DequeueCircularArray {

	private int[] queueArray;

	/* Index of first element in queue - deletion from front end */
	private int front;

	/* Index of last element in queue - insertion from rear end */
	private int rear;

	public DequeueCircularArray() {
		queueArray = new int[10];
		/* both rear and front is -1 i.e: Empty array/list */
		rear = -1;
		front = -1;
	}

	public DequeueCircularArray(int maxSize) {
		queueArray = new int[maxSize];
		rear = -1;
		front = -1;
	}

	/* insertFront() insert element at front end of the circular array */
	public void insertFront(int x) {

		if (isFull()) {
			System.out.println("Queue Overflow");
			return;
		}
		if (front == -1) {
			front = 0;
			rear = 0;
		} else if (front == 0) {
			front = queueArray.length - 1;
		} else {
			front = front - 1;
		}
		queueArray[front] = x;

	}

	/* insertRear() insert element at rear end of the circular array */
	public void insertRear(int x) {

		if (isFull()) {
			System.out.println("Queue Overflow");
			return;
		}

		if (front == -1) {
			front = 0;
		}

		if (rear == queueArray.length - 1) {
			rear = 0;
		} else {
			rear = rear + 1;
		}
		queueArray[rear] = x;

	}

	/* deleteFront() return the front element of the queue after deleting it */
	public int deleteFront() {

		int x;
		if (isEmpty()) {
			System.out.println("Queue Underflow");
			throw new NoSuchElementException();
		}

		/* Element at index front is taken out */
		x = queueArray[front];

		if (front == rear) {
			/* Has only one element */
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

	/* deleteRare() return the rare element of the queue after deleting it */
	public int deleteRare() {

		int x;
		if (isEmpty()) {
			System.out.println("Queue Underflow");
			throw new NoSuchElementException();
		}

		/* Element at index rear is taken out */
		x = queueArray[rear];

		if (front == rear) {
			/* Has only one element */
			front = -1;
			rear = -1;
		} else if (rear == 0) {
			rear = queueArray.length - 1;
		} else {
			/* front is incremented by 1 */
			rear = rear - 1;
		}
		return x;

	}

	public void display() {
		int i;
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return;
		}
		System.out.println("Queue is...");
		i = front;
		if (front <= rear) {
			System.out.println(queueArray[i++] + " ");
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

	public boolean isEmpty() {
		return (front == -1 || (front == (rear + 1)));
	}

	public boolean isFull() {
		return (rear == (queueArray.length - 1));
	}

}
