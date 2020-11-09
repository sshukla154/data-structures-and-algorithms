package heap;

public class BuildingHeapDemo {

	public static void main(String[] args) {

		int a1[] = { 99999, 1, 4, 5, 7, 9, 10 };
		int n1 = a1.length - 1;

		buildHeap_BottomUp(a1, n1);

		for (int i = 1; i <= n1; i++) {
			System.out.print(a1[i] + " ");
		}
		System.out.println();
		int a2[] = { 99999, 1, 4, 5, 7, 9, 10 };
		int n2 = a2.length - 1;
		buildHeap_TopDown(a2, n2);

		for (int i = 1; i <= n2; i++) {
			System.out.print(a2[i] + " ");
		}
		System.out.println();

	}

	private static void buildHeap_TopDown(int[] a, int n) {
		for (int i = 2; i <= n; i++) {
			restoreUp(i, a);
		}
	}

	private static void restoreUp(int i, int[] a) {
		int k = a[i];
		int iParent = i / 2;

		/* When a[0] don't have sentinel then the below while condition is changed */
		// while (iParent >= 1 && a[iParent] < k) {
		while (a[iParent] < k) {
			a[i] = a[iParent];
			i = iParent;
			iParent = i / 2;
		}
		a[i] = k;
	}

	private static void buildHeap_BottomUp(int[] a, int n) {
		for (int i = n / 2; i >= 1; i--) {
			restoreDown(i, a, n);
		}
	}

	private static void restoreDown(int i, int[] a, int n) {
		int k = a[i];
		int leftChild = 2 * i;
		int rightChild = leftChild + 1;
		while (rightChild <= n) {
			if (k >= a[leftChild] && k >= a[rightChild]) {
				a[i] = k;
				return;
			} else if (a[leftChild] > a[rightChild]) {
				a[i] = a[leftChild];
				i = leftChild;
			} else {
				a[i] = a[rightChild];
				i = rightChild;
			}
			leftChild = 2 * i;
			rightChild = leftChild + 1;
		}

		/* If no of nodes is even */
		if (leftChild == n && k < a[leftChild]) {
			a[i] = a[leftChild];
			i = leftChild;
		}
		a[i] = k;
	}

}
