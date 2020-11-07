package postfix;

import java.util.EmptyStackException;

public class StackChar {

	private char[] stackArray;
	private int top;

	public StackChar() {
		stackArray = new char[10];
		top = -1;
	}

	public StackChar(int maxSize) {
		stackArray = new char[maxSize];
		top = -1;
	}

	public int size() {
		return 0;
	}

	public boolean isEmpty() {
		return false;
	}

	public boolean isFull() {
		return false;
	}

	public void push(char symbol) {
		if(isFull()) {
			System.out.println("Stack Overflow");
			return;
		}
		/*top is increased by 1*/
		top = top+1;
		/*New element is placed at index top*/
		stackArray[top]=symbol;
	}

	public char pop() {
		char x;
		if (isEmpty()) {
			System.out.println("Stack Underflow");
			throw new EmptyStackException();
		}
		/* Element at index top is taken out */
		x = stackArray[top];
		/* top is decreased by 1 */
		top = top - 1;
		return x;
	}

	public char peek() {
		if (isEmpty()) {
			System.out.println("Stack Underflow");
			throw new EmptyStackException();
		}
		return stackArray[top];
	}

	public void display() {
		int i;
		if(isEmpty()) {
			System.out.println("Stack is empty.");
			return;
		}
		System.out.println("Stack is...");
		for (i=top; i>=0; i--) {
			System.out.println(stackArray[i] + " ");
		}
		System.out.println();
	}

}
