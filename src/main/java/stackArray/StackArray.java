package stackArray;

import java.util.EmptyStackException;

public class StackArray {

	private int[] stackArray;

	/* Stores the top most element index */
	private int top;

	public StackArray() {
		stackArray = new int[10];
		top = -1;
	}

	public StackArray(int maxSize) {
		stackArray = new int[maxSize];
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

	public void push(int x) {
		
		if(isFull()) {
			System.out.println("Stack Overflow");
			return;
		}
		/*top is increased by 1*/
		top = top+1;
		/*New element is placed at index top*/
		stackArray[top]=x;

	}

	/*pop() return the top most element of the stack after deleting it*/
	public int pop() {
		
		int x;
		if(isEmpty()) {
			System.out.println("Stack Underflow");
			throw new EmptyStackException();
		}
		
		/*Element at index top is taken out*/
		x=stackArray[top];
		/*top is decreased by 1*/
		top=top-1;
		return x;
		
	}

	/*peek() return the top most element of the stack without deleting it*/
	public int peek() {
		if(isEmpty()) {
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
