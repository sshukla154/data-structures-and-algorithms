package parentheses;

import java.util.EmptyStackException;

public class StackArray {

	private char[] stackArray;

	private int top;

	public StackArray() {
		stackArray = new char[10];
		top = -1;
	}

	public StackArray(int maxSize) {
		stackArray = new char[maxSize];
		top = -1;
	}

	public int size() {
		return top + 1;
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == (stackArray.length - 1));
	}

	public void push(char x) {
		
		if(isFull()) {
			System.out.println("Stack Overflow");
			return;
		}
		/*top is increased by 1*/
		top = top+1;
		/*New element is placed at index top*/
		stackArray[top]=x;
	}
	
	/* pop() return the top most element of the stack after deleting it */
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

	/* peek() return the top most element of the stack without deleting it */
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
