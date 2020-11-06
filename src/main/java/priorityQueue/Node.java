package priorityQueue;

public class Node {
	
	public int info;
	public Node link;
	public int priority;
	
	//Constructor
	public Node(int i, int elementPriority) {
		info = i;
		priority=elementPriority;
		link = null;
	}

}
