package sorting;

import java.util.Scanner;

public class MergingSortedArraysToSingleArray {

	public MergingSortedArraysToSingleArray() {// This class is not for instantiation
	}

	public static void merge(int[] a1, int[] a2, int[] temp, int n1, int n2) {
		/*
		
		*/

		int i = 0, j = 0, k = 0;

		while ((i <= n1 - 1) && (j <= n2 - 1)) {
			if (a1[i] < a2[j]) {
				temp[k++] = a1[i++];
			} else {
				// a1[i]>a2[j]
				temp[k++] = a2[j++];
			}
		}

		/* Copying the remaining elements of a1, array a2 is finished */
		while (i <= (n1 - 1)) {
			temp[k++] = a1[i++];
		}

		/* Copying the remaining elements if a2, array a1 is finished */
		while (j <= (n2 - 1)) {
			temp[k++] = a2[j++];
		}

	}

	public static void _sort(int[] numberArray, int arraySize) {

	}

	public static void main(String[] args) {

		int i, a1Size, a2Size;
		int[] a1 = new int[20];
		int[] a2 = new int[20];
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the number of elements in a1 : ");
		a1Size = scan.nextInt();
		System.out.println("Enter elements in sorted order : ");
		for (i = 0; i < a1Size; i++) {
			System.out.print("Enter element " + (i + 1) + " : ");
			a1[i] = scan.nextInt();
		}

		System.out.print("Enter the number of elements in a2 : ");
		a2Size = scan.nextInt();
		System.out.println("Enter elements in sorted order : ");
		for (i = 0; i < a2Size; i++) {
			System.out.print("Enter element " + (i + 1) + " : ");
			a2[i] = scan.nextInt();
		}

		int[] temp = new int[100];
		merge(a1, a2, temp, a1Size, a2Size);

		System.out.print("Merged Array In Temp Is : ");
		for (i = 0; i < (a1Size + a2Size); i++) {
			System.out.print(temp[i] + " ");
		}
		System.out.println();
		scan.close();
	}
}
