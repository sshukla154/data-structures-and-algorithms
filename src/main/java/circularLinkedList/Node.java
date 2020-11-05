package circularLinkedList;

public class Node {
	/*Implementing SingleLinkedList as Circular Linked List so there is only one link part*/
	public int info;
	public Node link;
	
	//Constructor
	public Node(int i) {
		info = i;
		link= null;
	}

}
