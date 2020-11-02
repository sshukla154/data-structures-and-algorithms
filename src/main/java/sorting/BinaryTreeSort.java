package sorting;

import java.util.Scanner;

public class BinaryTreeSort {

	public BinaryTreeSort() {// This class is not for instantiation
	}

	public static void sort(int[] a, int n) {
		
		BinarySearchTree tree = new BinarySearchTree();
		for(int i=0; i< n; i++) {
			tree.insert(a[i]);
		}
		/*Copies all the elements of the tree to a[] in in-order*/
		tree.inorder(a);

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
