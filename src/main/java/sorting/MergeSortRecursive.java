package sorting;

import java.util.Scanner;

public class MergeSortRecursive {

	public MergeSortRecursive() {// This class is not for instantiation
	}

	public static void sort(int[] a, int n) {

		int[] temp = new int[n];

		// Below is recursive method
		sort(a, temp, 0, n - 1);
	}

	private static void sort(int[] a, int[] temp, int low, int up) {

		/* Only one element */
		if (low == up) {
			return;
		}

		int mid = (low + up) / 2;

		/* Sort a[low] to a[mid] */
		sort(a, temp, low, mid);

		/* Sort a[mid+1] to a[up] */
		sort(a, temp, (mid + 1), up);

		/* Merge a[low] to a[mid] and a[mid+1] to a[up] in temp[low] to temp[up] */
		merge(a, temp, low, mid, (mid + 1), up);

		/* Copy temp[low] to temp[up] in a[low] to a[up] */
		copy(a, temp, low, up);

	}

	private static void merge(int[] a, int[] temp, int low1, int up1, int low2, int up2) {
		/*
		 * a[low1] to a[up1] and a[low2] to a[up2] is merged into temp[low1] to
		 * temp[low1]
		 * 
		 * i is for a[low1] to a[up1] i is for a[low2] to a[up2] i is for temp[low1] to
		 * temp[up2]
		 * 
		 */

		int i = low1;
		int j = low2;
		int k = low1;

		while ((i <= up1) && (j <= up2)) {
			if (a[i] <= a[j]) {
				temp[k++] = a[i++];
			} else {
				// a1[i]>a2[j]
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

	private static void copy(int[] a, int[] temp, int low, int up) {
		for (int i = low; i <= up; i++) {
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
