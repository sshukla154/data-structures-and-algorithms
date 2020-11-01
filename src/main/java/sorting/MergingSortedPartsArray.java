package sorting;

import java.util.Scanner;

public class MergingSortedPartsArray {

	public MergingSortedPartsArray() {// This class is not for instantiation
	}

	public static void merge(int[] a, int[] temp, int low1, int up1, int low2, int up2) {
		/*
		* a[low1] to a[up1] and a[low2] to a[up2] is merged into temp[low1] to temp[low1]
		* 
		* i is for a[low1] to a[up1]
		* i is for a[low2] to a[up2]
		* i is for temp[low1] to temp[up2]
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

	public static void _sort(int[] numberArray, int arraySize) {

	}

	public static void main(String[] args) {

		int i;
		int[] temp = new int[20];
		int[] a = { 1, 3, 5, 7, 2, 4, 6, 9, 11, 14 };
		Scanner scan = new Scanner(System.in);

		merge(a, temp, 0, 3, 4, 9);

		System.out.print("Array a Is : ");
		for (i = 0; i <= 9; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();

		System.out.print("Merged Array In Temp Is : ");
		for (i = 0; i <= 9; i++) {
			System.out.print(temp[i] + " ");
		}
		System.out.println();
		scan.close();
	}
}
