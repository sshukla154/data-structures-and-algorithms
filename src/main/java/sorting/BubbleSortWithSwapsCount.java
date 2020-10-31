package sorting;

import java.util.Scanner;

public class BubbleSortWithSwapsCount {

	public BubbleSortWithSwapsCount() {// This class is not for instantiation
	}

	public static void sort(int[] a, int n) {

		int x, j, temp, swapCount;

		for (x = n - 2; x >= 0; x--) {
			swapCount = 0;
			for (j = 0; j <= x; j++) {
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					swapCount++;
				}
			}
			if (swapCount == 0) {
				break;
			}
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

		System.out.print("Sorted Array is : ");
		for (i = 0; i < arraySize; i++) {
			System.out.print(numberArray[i] + " ");
		}
		System.out.println(); 
		scan.close();
	}
}
