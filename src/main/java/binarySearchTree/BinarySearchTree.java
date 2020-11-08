package binarySearchTree;

public class BinarySearchTree {

	private Node root;

	public BinarySearchTree() {
		root = null;
	}

	public boolean isEmpty() {
		return false;
	}

	public void insert(int n) {
		root = recursiveInsert(root, n);
	}

	private Node recursiveInsert(Node p, int n) {

		if (p == null) {
			/* Tree is empty */
			p = new Node(n);
		} else if (n < p.info) {
			/* New Temp node will be inserted in left subtree */
			p.leftChild = recursiveInsert(p.leftChild, n);
		} else if (n > p.info) {
			/* New Temp node will be inserted in right subtree */
			p.rightChild = recursiveInsert(p.rightChild, n);
		} else {
			System.out.println(n + " is already present in the tree.");
		}

		return p;
	}

	public void iterativeInsert(int x) {
		Node p = root;
		Node parentReference = null;

		while (p != null) {
			parentReference = p;
			if (x < p.info) {
				p = p.leftChild;
			} else if (x < p.info) {
				p = p.rightChild;
			} else {
				System.out.println(x + " already present in the tree.");
				return;
			}
		}

		Node temp = new Node(x);
		if (parentReference == null) {
			/* Tree is empty */
			root = temp;
		} else if (x < parentReference.info) {
			/* New Temp node will be inserted in left subtree */
			parentReference.leftChild = temp;
		} else {
			/* New Temp node will be inserted in right subtree */
			parentReference.rightChild = temp;
		}

	}

	public boolean search(int x) {
		return (recursiveSearch(root, x) != null);
	}

	private Node recursiveSearch(Node p, int x) {
		if (p == null) {
			/* Key Not Found */
			return null;
		}
		if (x < p.info) {
			/* Search left subtree */
			return recursiveSearch(p.leftChild, x);
		} else if (x > p.info) {
			/* Search in right subtree */
			return recursiveSearch(p.rightChild, x);
		}

		/* Key Found */
		return p;
	}

	public boolean iterativeSearch(int x) {
		Node p = root;
		/* If all the Elements/Nodes are scanned then reference p will be ZERO */
		while (p != null) {
			if (x < p.info) {
				/* Move to left subtree */
				p = p.leftChild;
			} else if (x > p.info) {
				/* Move to right subtree */
				p = p.rightChild;
			} else {
				/* Match Found...!!!! */
				return true;
			}
		}
		return false;
	}

	public void delete(int n) {
		root = recursiveDelete(root, n);
	}

	private Node recursiveDelete(Node p, int x) {
		Node ch, s;
		if (p == null) {
			System.out.println(x + " is not found.");
		}

		if (x < p.info) {
			/* Delete from left sub tree */
			p.leftChild = recursiveDelete(p.leftChild, x);
		} else if (x > p.info) {
			/* Delete from right sub tree */
			p.rightChild = recursiveDelete(p.rightChild, x);
		} else {
			/* Key to be deleted is found */
			if (p.leftChild != null && p.rightChild != null) {
				/* Has 2 children */
				s = p.rightChild;
				while (s.leftChild != null) {
					s = s.leftChild;
				}
				p.info = s.info;
				p.rightChild = recursiveDelete(p.rightChild, s.info);
			} else {
				/* has one or no children */
				if (p.leftChild != null) {
					/* Only left child */
					ch = p.leftChild;
				} else {
					/* Only right child or no child */
					ch = p.rightChild;
				}
				p = ch;
			}
		}
		return p;
	}

	public void iterativeDelete(int n) {
		Node p = root;
		Node parentReference = null;
		while (p != null) {
			if (p.info == n) {
				break;
			}
			parentReference = p;
			if (p.info > n) {
				p = p.leftChild;
			} else {
				p = p.rightChild;
			}
		}

		if (p == null) {
			System.out.println(n + " is not found in tree.");
			return;
		}

		/* Case C: Node to be deleted has 2 children */
		/* Find inorder successor and its parent */
		Node s, ps;
		if (p.leftChild != null && p.rightChild != null) {
			ps = p;
			s = p.rightChild;

			while (s.leftChild != null) {
				ps = s;
				s = s.leftChild;
			}
			p.info = s.info;
			p = s;
			parentReference = ps;
		}

		/* Case B and Case A : 1 or no child */
		Node ch;
		if (p.leftChild != null) {
			/* Node to be deleted has left child */
			ch = p.leftChild;
		} else {
			/* Node to be deleted has right child or no child */
			ch = p.rightChild;
		}

		if (parentReference == null) {
			/* Node to be deleted is the root node */
			root = ch;
		} else if (p == parentReference.leftChild) {
			/* Node to be deleted is left child of its parent */
			parentReference.leftChild = ch;
		} else {
			/* Node to be deleted is right child of its parent */
			parentReference.rightChild = ch;
		}
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

	public int iterativeMax() {
		if (isEmpty()) {
			throw new NullPointerException("Tree is empty");
		}
		Node p = root;
		/* When while() is terminated than p will be at right most node */
		while (p.rightChild != null) {
			p = p.rightChild;
		}
		return p.info;
	}

	public int iterativeMin() {
		if (isEmpty()) {
			throw new NullPointerException("Tree is empty");
		}
		Node p = root;
		/* When while() is terminated than p will be at left most node */
		while (p.leftChild != null) {
			p = p.leftChild;
		}
		return p.info;
	}

	public int max() {
		if (isEmpty()) {
			throw new NullPointerException("Tree is empty");
		}
		return recursiveMax(root).info;
	}

	private Node recursiveMax(Node p) {
		if (p.rightChild == null) {
			return p;
		}
		return recursiveMax(p.rightChild);
	}

	public int min() {
		if (isEmpty()) {
			throw new NullPointerException("Tree is empty");
		}
		return recursiveMin(root).info;
	}

	private Node recursiveMin(Node p) {
		if (p.leftChild == null) {
			return p;
		}
		return recursiveMin(p.leftChild);
	}
}
