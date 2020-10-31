package sorting;

import java.util.Scanner;

public class SelectionSort {

	// This class is not for instantiation
	private SelectionSort() {
	}

	public static void _sort(int[] a, int n) {

		// Iterate over unsorted array
		int minIndex = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[i] > a[j]) {

				}

			}

		}

	}

	public static void sort(int[] a, int n) {

		/*
			Pass-1: i=0, j=1-5
			Pass-2: i=1, j=2-5
			Pass-3: i=2, j=3-5
			Pass-4: i=3, j=4-5
			Pass-5: i=4, j=5
		*/
		int minIndex, temp, i, j;
		for (i = 0; i < n - 1; i++) {
			minIndex = i;
			// Finding the minIndex
			for (j = i + 1; j < n; j++) {
				if (a[minIndex] > a[j]) {
					minIndex = j;
				}
			}
			// Swapping i-th index value with minIndex Value
			if(i!=minIndex) {
				temp=a[i];
				a[i] = a[minIndex];
				a[minIndex] = temp;
			}

		}

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
		for (i = 0; i < arraySize; i++) {
			System.out.print(numberArray[i] + " ");
		}
		System.out.println();
		scan.close();
	}

}
