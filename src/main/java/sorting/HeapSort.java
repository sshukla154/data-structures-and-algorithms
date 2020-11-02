package sorting;

import java.util.Scanner;

public class HeapSort {

	public HeapSort() {// This class is not for instantiation
	}

	public static void sort(int[] a, int n) {

		buildHeap_BottomUp(a, n);

		int maxValue;

		while (n > 1) {
			maxValue = a[1];
			a[1] = a[n];
			a[n] = maxValue;
			n--;
			restoreDown(1, a, n);
		}

	}

	private static void buildHeap_BottomUp(int[] arr, int n) {

		int i;

		for (i = n / 2; i >= 1; i--) {
			restoreDown(i, arr, n);
		}

	}

	private static void restoreDown(int i, int[] a, int n) {

		int k = a[i];
		int lchild = 2 * i, rchild = lchild + 1;

		while (rchild <= n) {
			if (k >= a[lchild] && k >= a[rchild]) {
				a[i] = k;
				return;
			} else if (a[lchild] > a[rchild]) {
				a[i] = a[lchild];
				i = lchild;
			} else {
				a[i] = a[rchild];
				i = rchild;
			}
			lchild = 2 * i;
			rchild = lchild + 1;
		}

		/* If no of nodes is even */
		if (lchild == n && k < a[lchild]) {
			a[i] = a[lchild];
			i = lchild;
		}
		a[i] = k;

	}

	public static void _sort(int[] numberArray, int arraySize) {

	}

	public static void main(String[] args) {

		int i, arraySize;
		int[] numberArray = new int[20];
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the number of elements : ");
		arraySize = scan.nextInt();

		for (i = 0; i < arraySize; i++) {
			System.out.print("Enter element " + (i + 1) + " : ");
			numberArray[i] = scan.nextInt();
		}

		sort(numberArray, arraySize);

		System.out.print("Sorted Array Is : ");
		for (i = 0; i <= arraySize; i++) {
			System.out.print(numberArray[i] + " ");
		}
		System.out.println();
		scan.close();
	}
}
