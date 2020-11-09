package heap;

import java.util.NoSuchElementException;

public class Heap {

	/* This is the Array which is use to implement HEAP */
	private int[] a;

	/* Size of the heap */
	private int n;

	public Heap() {
		a = new int[10];
		n = 0;
		a[0] = 99999;
	}

	public Heap(int maxSize) {
		a = new int[maxSize];
		n = 0;
		a[0] = 99999;
	}

	public void insert(int value) {
		n++;
		a[n] = value;
		restoreup(n);
	}

	private void restoreup(int i) {
		/* K Key which is to be up */
		int k = a[i];
		int iParent = i / 2;

		while (a[iParent] < k) {
			a[i] = a[iParent];
			i = iParent;
			iParent = i / 2;
		}
		/* When a[0] dont have sentinel then the below while condition is changed */
//		while (iParent >= 1 && a[iParent] < k) {
//			a[i] = a[iParent];
//			i = iParent;
//			iParent = i / 2;
//		}
		a[i] = k;

	}

	public int deleteRoot() {
		if (n == 0) {
			throw new NoSuchElementException("Heap is empty");
		}
		int maxValue = a[1];
		a[1] = a[n];
		n--;
		restoreDown(1);
		return maxValue;
	}

	private void restoreDown(int i) {
		int k = a[i];
		int leftChild = 2 * i;
		int rightChild = leftChild + 1;
		while (rightChild <= n) {
			if (k >= a[leftChild] && k >= a[rightChild]) {
				a[i] = k;
				return;
			} else if (a[leftChild] > a[rightChild]) {
				a[i] = a[leftChild];
				i = leftChild;
			} else {
				a[i] = a[rightChild];
				i = rightChild;
			}
			leftChild = 2 * i;
			rightChild = leftChild + 1;
		}

		/* If no of nodes is even */
		if (leftChild == n && k < a[leftChild]) {
			a[i] = a[leftChild];
			i = leftChild;
		}
		a[i] = k;
	}

	public void display() {

		int i;
		if (n == 0) {
			System.out.println("Heap is empty");
		}

	}

}
