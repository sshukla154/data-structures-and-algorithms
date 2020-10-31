package sorting;

import java.util.Scanner;

public class InsertionSort {

	public InsertionSort() {// This class is not for instantiation
	}

	public static void sort(int[] a, int n) {
		
		/*
		 * i-> 1 to (n-1) 
		 * Each iteration correspond to pass.
		 * In each iteration 0 to (i-1) is sorted part and i to (n-1) is unsorted part
		 * 
		 * j->
		 * is use to scanned the position for temp variable
		 * scanning begins from the end of the sorted part
		 * 
		 */
		
		
		int i, j, temp;
		for (i = 1; i < n; i++) {
			//a[i] is the first element of unsorted part
			temp = a[i];
			for (j = i - 1; j >= 0 && a[j] > temp; j--) {
				a[j + 1] = a[j];
			}
			a[j + 1] = temp;
		}

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
		for (i = 0; i < arraySize; i++) {
			System.out.print(numberArray[i] + " ");
		}
		System.out.println();
		scan.close();
	}
}
