package sorting;

import java.util.Scanner;

public class AddressCalculationSort {

	private static void sort(int[] a, int n) {

		int i, j, x;

		SortedLinkedList[] List = new SortedLinkedList[6];
		for (i = 0; i < 6; i++) {
			List[i] = new SortedLinkedList();
		}

		int large = 0;
		for (i = 0; i < n; i++) {
			if (a[i] > large) {
				large = a[i];
			}
		}

		for (i = 0; i < n; i++) {
			x = hash(a[i], large);
			List[x].insertInOrder(a[i]);
		}
		
		/*Elements of Linked Lists are copied to array*/
		Node p;
		i=0;
		for(j=0; j<=5; j++) {
			p=List[j].getStart();
			while(p!=null) {
				a[i++]=p.info;
				p=p.link;
			}
		}

	}

	private static int hash(int x, int large) {
		float temp;
		temp = (float) x / large;
		return (int) (temp * 5);
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
