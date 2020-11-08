package sorting;

import javax.swing.tree.TreeNode;

public class BinarySearchTree {
	
	private TreeNode root;
	
	public BinarySearchTree() {
		root=null;
	}

	public void insert(int i) {
		// TODO Auto-generated method stub
		
	}

	public void inorder(int[] a) {
		inorder(root, a);
	}

	private void inorder(TreeNode p, int[] a) {
		if(p==null) {
			return;
		}
//		inorder(p.lchild, a);
		
	}

}
