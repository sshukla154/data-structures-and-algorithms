package seperateChaining;

public class SingleLinkedList {

	private Node start;

	public SingleLinkedList() {
		start = null;
	}

	public void displayList() {
		Node p;

		if (start == null) {
			System.out.println("___");
			return;
		}

		p = start;
		while (p != null) {
			System.out.println(p.info + " ");
			p = p.link;
		}
		System.out.println();
	}

	public StudentRecord search(int x) {
		Node p = start;
		while (p != null) {
			if (p.info.getStudentId() == x) {
				break;
			}
			p = p.link;
		}
		if (p == null) {
			System.out.println(x + " is not found in the list");
			return null;
		} else {
			return p.info;
		}
	}

	public void insertInBeginning(StudentRecord newRecord) {
		Node temp = new Node(newRecord);
		temp.link = start;
		start = temp;
	}

	public void deleteNode(int x) {
		/* List is empty */
		if (start == null) {
			System.out.println(x + " is not found in the list.");
			return;
		}

		/* Deletion of first node */
		if (start.info.getStudentId() == x) {
			start = start.link;
			return;
		}

		/* Deletion of node in between or at the end of the list */
		Node p = start;
		while (p.link != null) {
			if (p.link.info.getStudentId() == x) {
				break;
			}
			p = p.link;
		}

		if (p.link == null) {
			System.out.println(x + " is not found in the list.");
		} else {
			p.link = p.link.link;
		}

	}

}
