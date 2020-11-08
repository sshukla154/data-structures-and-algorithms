package stackLinkedList;

import java.util.EmptyStackException;

public class StackSingleLinkedList {

	/* Will always refer to the first node of the list */
	private Node top;

	public StackSingleLinkedList() {
		/* Initially the stack is empty */
		top = null;
	}

	public int size() {
		int size = 0;
		Node p = top;

		while (p != null) {
			p = p.link;
			size++;
		}

		return size;
	}

	public void push(int x) {

		Node temp = new Node(x);
		temp.link = top;
		top = temp;

	}

	/* pop() return the top most element of the stack after deleting it */
	public int pop() {

		int x;
		if (isEmpty()) {
			System.out.println("Stack Underflow");
			throw new EmptyStackException();
		}

		/* Element at index top is taken out */
		x = top.info;

		/* top is decreased by 1 */
		top = top.link;
		return x;

	}

	/* peek() return the top most element of the stack without deleting it */
	public int peek() {
		if (isEmpty()) {
			System.out.println("Stack Underflow");
			throw new EmptyStackException();
		}
		return top.info;
	}

	public boolean isEmpty() {
		return (top == null);
	}

	public void display() {
		Node p = top;
		if (isEmpty()) {
			System.out.println("Stack is empty.");
			return;
		}
		System.out.println("Stack is...");
		while (p != null) {
			System.out.println(p.info + " ");
			p = p.link;
		}
		System.out.println();
	}

}
