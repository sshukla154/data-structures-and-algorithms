package binaryTree;

public class Demo {

	public static void main(String[] args) {
		
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createtree();

		binaryTree.display();
		System.out.println();

		System.out.println("Preorder : ");
		binaryTree.preOrder();
		System.out.println();

		System.out.println("Inorder : ");
		binaryTree.inOrder();
		System.out.println();

		System.out.println("Postorder : ");
		binaryTree.postOrder();
		System.out.println();

		System.out.println("Level Order: ");
		binaryTree.levelOrder();
		System.out.println();

		System.out.println("Height of tree is " + binaryTree.height());

	}

}
