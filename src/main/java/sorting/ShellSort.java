package sorting;

import java.util.Scanner;

public class ShellSort {

	public ShellSort() {// This class is not for instantiation
	}

	public static void sort(int[] a, int n) {

		/* 
		 * Note 1 - Same as InsertionSort
		 * 
		 * Note 2 - if h=1 than same as insertionSort code
		 * 
		 * Note 3 - We are providing as Odd-Value so that at the LAST PASS, the value of h should be one 
		 * 
		 */
		
		int i, j, temp, h;

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Maximum increment (Odd Value) : ");
		h = scan.nextInt();

		while (h >= 1) {
			for (i = h; i < n; i++) {
				temp = a[1];
				for (j = i - h; j >= 0 && a[j] > temp; j = j - h) {
					a[j + h] = temp;
				}
				h = h - 2;
			}
			scan.close();
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
