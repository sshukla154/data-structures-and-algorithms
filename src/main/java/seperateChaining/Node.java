package seperateChaining;

public class Node {

	/* Info of student record */
	StudentRecord info;

	/* Refers to next node of the linked list */
	Node link;

	public Node(StudentRecord record) {
		info = record;
		link = null;
	}

	public StudentRecord getInfo() {
		return info;
	}

	public void setInfo(StudentRecord info) {
		this.info = info;
	}

	public Node getLink() {
		return link;
	}

	public void setLink(Node link) {
		this.link = link;
	}

}
