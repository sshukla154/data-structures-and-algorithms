package sorting;

import java.util.Scanner;

public class BubbleSort {

	public BubbleSort() {// This class is not for instantiation
	}

	public static void sort(int[] a, int n) {
		/*
		n=6,
		Values : 45, 23, 59, 66, 38, 12
		
		Pass 1: x=4, j=0 to 4
		Pass 2: x=3, j=0 to 3
		Pass 3: x=2, j=0 to 2
		Pass 4: x=1, j=0 to 1
		Pass 5: x=0, j=0
		
		x= n-2 to 0
		j= 0 to x
		
		*/
		int x, j, temp;

		for (x = n - 2; x >= 0; x--) {
			for (j = 0; j <= x; j++) {
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;

				}
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

		System.out.print("Sorted Array Is : ");
		for (i = 0; i < arraySize; i++) {
			System.out.print(numberArray[i] + " ");
		}
		System.out.println();
		scan.close();
	}
}
