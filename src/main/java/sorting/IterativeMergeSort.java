package sorting;

import java.util.Scanner;

public class IterativeMergeSort {

	public IterativeMergeSort() {// This class is not for instantiation
	}

	public static void sort(int[] a, int n) {

		int[] temp = new int[n];
		// Size denotes the size of sublist
		int size = 1;
		while (size <= n - 1) {
			sortPass(a, temp, size, n);
			// In each iteration we need to multiple size by 2 ie: size will be 2, 4, 8....
			size = size * 2;
		}

	}

	private static void sortPass(int[] a, int[] temp, int size, int n) {

		int i, low1, up1, low2, up2;
		low1 = 0;

		while ((low1 + size) <= n - 1) {
			up1 = low1 + size - 1;
			low2 = low1 + size;
			up2 = low2 + size - 1;

			/* If length of last sublist is less than size */
			if (up2 > -n) {
				up2 = n - 1;
			}

			merge(a, temp, low1, up1, low2, up2);

			/* Take next 2 sublists for merging */
			low1 = up2 + 1;
		}

		for (i = low1; i <= n - 1; i++) {
			temp[i] = a[i];
		}

		copy(a, temp, n);

	}

	/* Merge a[low] to a[mid] and a[mid+1] to a[up] in temp[low] to temp[up] */
	private static void merge(int[] a, int[] temp, int low1, int up1, int low2, int up2) {

		int i = low1;
		int j = low2;
		int k = low1;

		while ((i <= up1) && (j <= up2)) {
			if (a[i] <= a[j]) {
				temp[k++] = a[i++];
			} else {
				temp[k++] = a[j++];
			}
		}

		/* Copying the remaining elements of a1, array a2 is finished */
		while (i <= up1) {
			temp[k++] = a[i++];
		}

		/* Copying the remaining elements if a2, array a1 is finished */
		while (j <= up2) {
			temp[k++] = a[j++];
		}

	}

	/* Copy temp[low] to temp[up] in a[low] to a[up] */
	private static void copy(int[] a, int[] temp, int n) {
		for (int i = 0; i < n; i++) {
			a[i] = temp[i];
		}
	}

	public static void main(String[] args) {
		int i, n;
		int[] a = new int[20];
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the no of elements : ");
		n = scan.nextInt();

		for (i = 0; i < n; i++) {
			System.out.print("Enter element " + (i + 1) + " : ");
			a[i] = scan.nextInt();
		}

		sort(a, n);

		System.out.print("Sorted array is : ");
		for (i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		scan.close();
	}

}
