package searching;

import java.util.Scanner;

public class LinearSearchInSortedArray {

	private LinearSearchInSortedArray() {
	}

	public static int search(int a[], int n, int searchValue) {
		int i = 0;
		for (i = 0; i < n; i++) {
			if (a[i] >= searchValue) {
				break;
			}
		}
		if (a[i] == searchValue) {
			return i;
		} else {
			return -1;
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
		System.out.println("Enter the elements of ARRAY in SORTED order : ");
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
