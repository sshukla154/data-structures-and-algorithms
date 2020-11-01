package sorting;

import java.util.Scanner;

public class IterativeMergeSort {

	public IterativeMergeSort() {// This class is not for instantiation
	}

	public static void sort(int[] a, int n) {

		int[] temp = new int[n];
		//Size denotes the size of sublist
		int size = 1;
		while(size<=n-1) {
			sortPass(a, temp, size, n);
			// In each iteration we need to multiple size by 2
			size= size*2;
		}
		
	}

	private static void sortPass(int[] a, int[] temp, int size, int n) {
		
		int i, low1, up1, low2, up2;
		low1=1;
		
		


	}

	private static void merge(int[] a, int[] temp, int low1, int up1, int low2, int up2) {
		
	}

	public static void main(String[] args) {
		int i, n;
		int[] a = new int[20];
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the no of elements : ");
		n = scan.nextInt();

		for (i = 0; i < n; i++) {
			System.out.print("Enter element " + (i + 1) + " : ");
			a[i] = scan.nextInt();
		}

		sort(a, n);

		System.out.print("Sorted array is : ");
		for (i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		scan.close();
	}

}
