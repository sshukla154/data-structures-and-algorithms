package sorting;

import java.util.Scanner;

public class QuickSort {

	public QuickSort() {// This class is not for instantiation
	}

	public static void sort(int[] a, int n) {

		// Initially we need to sort whole array so sending complete array
		sort(a, 0, n - 1);

	}

	public static void sort(int[] a, int low, int up) {

		/* Terminating condition : Zero or One element in sublist */
		if (low >= up) {
			return;
		}

		int p = partition(a, low, up);

		/* Sort left sublist using recursive sort method */
		sort(a, low, p - 1);

		/* Sort right sublist using recursive sort method */
		sort(a, p + 1, up);

	}

	private static int partition(int[] a, int low, int up) {

		int temp, i, j, pivot;

		pivot = a[low];

		/* Move from left to right */
		i = low + 1;

		/* Move from right to left */
		j = up;

		while (i <= j) {
			while (a[i] < pivot && i < up) {
				i++;
			}
			while (a[j] > pivot) {
				j--;
			}
			if (i < j) {
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			} else {
				/* Found proper place for pivot */
				break;
			}
		}

		/* Proper place for pivot is j */
		a[low] = a[j];
		a[j] = pivot;

		return j;
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
