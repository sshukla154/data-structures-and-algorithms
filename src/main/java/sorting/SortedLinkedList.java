package sorting;

public class SortedLinkedList {

	private Node start;

	public SortedLinkedList() {
	}

	public void insertInOrder(int data) {
		Node temp;

		temp = new Node(data);

		/* List empty or new node to be inserted before first node */
		if (start == null || data < start.info) {
			temp.link = start;
			start = temp;
			return;
		}

	}

	public Node getStart() {
		// TODO Auto-generated method stub
		return null;
	}

}
