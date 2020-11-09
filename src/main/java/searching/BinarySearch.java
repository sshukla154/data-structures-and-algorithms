package searching;

import java.util.Scanner;

public class BinarySearch {

	private BinarySearch() {
	}

	public static int search(int a[], int n, int searchValue) {

		return search(a, 0, n - 1, searchValue);

	}

	private static int search(int[] a, int first, int last, int searchValue) {
		int mid = (first + last) / 2;

		if (searchValue < a[mid]) {
			/* Search in left */
			return search(a, mid + 1, last, searchValue);
		} else if (searchValue > a[mid]) {
			/* Search in right */
			return search(a, first, mid - 1, searchValue);
		} else {
			return mid;
		}
		
	}

	public static void main(String[] args) {
		int i, n, searchValue, index;

		int a[] = new int[100];

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the no to be searched : ");
		searchValue = scanner.nextInt();
		System.out.print("Enter the no of elements : ");
		n = scanner.nextInt();
		System.out.println("Enter the elements : ");
		for (i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}

		index = search(a, n, searchValue);
		if (index == -1) {
			System.out.println("Value " + searchValue + " is not present in array");
		} else {
			System.out.println("Value " + searchValue + " is present at " + index + "th index in array");
		}

	}

}
