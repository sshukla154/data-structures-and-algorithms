package sorting;

import java.util.Scanner;

public class RedixSort {

	public RedixSort() {
	}

	private static Node sort(Node start) {

		Node[] rear = new Node[10];
		Node[] front = new Node[10];

		int leastSignificantPosition = 1;
		int mostSignificantPosition = digitsInLargest(start);

		int i, dig;
		Node p;

		for (int k = leastSignificantPosition; k <= mostSignificantPosition; k++) {

			/* Making all the queue at the beginning of each pass */
			for (i = 0; i <= 9; i++) {
				rear[i] = null;
				front[i] = null;
			}

			for (p = start; p != null; p = p.link) {
				/* Find kth digit from right in the number */
				dig = digit(p.info, k);

				/* Insert the node in Queue(dig) */
				if (front[dig] == null) {
					front[dig] = p;
				} else {
					rear[dig].link = p;
				}
				rear[dig] = p;
			}

			/* Join all queues to form a new linked list */
			i = 0;
			while (front[i] == null) {
				/* Finding first non empty queue */
				i++;
			}

			start = front[i];

			while (i <= 8) {
				if (rear[i + 1] != null) {/* If (i=1)th queue is not empty */
					/* join end of ith queue to start of (i+1)th queue */
					rear[i].link = front[i + 1];
				} else {
					/* Continue with rear[i] */
					rear[i + 1] = rear[i];
				}
				i++;
			}
			rear[9].link = null;
		}

		return start;
	}

	/* Return kth digit from right in n */
	private static int digit(int n, int k) {

		int d = 0, i;
		for (i = 1; i <= k; i++) {
			d = n % 10;
			n /= 10;
		}

		return d;
	}

	/* Returns no of digits in the largest element of the list */
	private static int digitsInLargest(Node start) {
		/* Find largest element */
		int large = 0;
		Node p = start;

		while (p != null) {
			if (p.info > large) {
				large = p.info;
			}
			p = p.link;
		}

		/* Find no of digits in largest element */
		int nDigits = 0;
		while (large != 0) {
			nDigits++;
			large /= 10;
		}

		return nDigits;
	}

	public static void main(String[] args) {

		Node temp, p;
		int i, n, data;
		int[] numberArray = new int[20];
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the number of elements in the list : ");
		n = scan.nextInt();

		Node start = null;
		/* Inserting elements in linked list */
		for (i = 1; i <= n; i++) {
			System.out.print("Enter element " + i + " : ");
			data = scan.nextInt();
			temp = new Node(data);

			if (start == null) {
				start = temp;
			} else {
				p = start;
				while (p.link != null) {
					p = p.link;
				}
				p.link = temp;

			}

		}

		start = sort(start);

		System.out.print("Sorted Array Is : ");
		p = start;
		while (p != null) {
			System.out.print(p.info + " ");
			p=p.link;
		}
		System.out.println();
		scan.close();
	}

}
