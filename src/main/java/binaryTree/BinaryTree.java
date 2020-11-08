package binaryTree;

public class BinaryTree {

	private Node root;

	public BinaryTree() {
		/* Initially tree is empty */
		root = null;
	}

	public void display() {
		display(root, 0);
		System.out.println();
	}

	private void display(Node p, int level) {
	}

	public void preOrder() {
		preOrder(root);
		System.out.println();
	}

	/* NLR */
	private void preOrder(Node p) {

		if (p == null)
			return;

		/* Visiting the root node - N */
		System.out.println(p.info + " ");

		/* traversing the left sub tree - L */
		preOrder(p.leftChild);

		/* traversing the left sub child - R */
		preOrder(p.leftChild);

	}

	public void inOrder() {
		inOrder(root);
		System.out.println();
	}

	/* LNP */
	private void inOrder(Node p) {

		if (p == null)
			return;

		/* traversing the left sub tree - L */
		inOrder(p.leftChild);

		/* Visiting the root node - N */
		System.out.println(p.info + " ");

		/* traversing the left sub child - R */
		inOrder(p.leftChild);

	}

	public void postOrder() {
		postOrder(root);
		System.out.println();
	}

	/* LRN */
	private void postOrder(Node p) {
		if (p == null)
			return;

		/* traversing the left sub tree - L */
		postOrder(p.leftChild);

		/* traversing the left sub child - R */
		postOrder(p.leftChild);

		/* Visiting the root node - N */
		System.out.println(p.info + " ");
	}

	public int height() {
		return height(root);
	}

	private int height(Node p) {

		if (p == null) {
			return 0;
		}

		int leftHeight = height(p.leftChild);
		int rightHeight = height(p.rightChild);

		if (leftHeight > rightHeight) {
			return 1 + leftHeight;
		} else {
			return 1 + rightHeight;
		}

	}

	public void levelOrder() {
		if (root == null) {
			System.out.println("Tree is empty.");
			return;
		}

		QueueArray queueArray = new QueueArray(20);
		/* Insert root node in queue */
		queueArray.insertorEnqueue(root);

		Node p;
		while (!queueArray.isEmpty()) {
			/* Deleting the node from queue */
			p = queueArray.deleteOrDequeue();
			System.out.println(p.info + " ");

			/* Insert left child of visited node in queue */
			if (p.leftChild != null) {
				queueArray.insertorEnqueue(p.leftChild);
			}

			/* Insert right child of visited node in queue */
			if (p.rightChild != null) {
				queueArray.insertorEnqueue(p.rightChild);
			}
		}

		System.out.println();

	}

	public void createtree() {
		root = new Node('P');
		root.leftChild = new Node('Q');
		root.rightChild = new Node('R');
		root.leftChild.leftChild = new Node('A');
		root.leftChild.rightChild = new Node('B');
		root.rightChild.leftChild = new Node('X');
	}

}
