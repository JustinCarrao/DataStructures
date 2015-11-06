package algorithms;

import java.util.ArrayList;

public class BST {
	
	public TreeNode root;
	
	public BST(TreeNode head) {
		root = head;
	}
	
	public BST() {
		root = null;
	}
	
	public static class TreeNode {
		TreeNode left;
		TreeNode right;
		int data;
		
		TreeNode(int newData) {
			data = newData;
			left = null;
			right = null;
		}
	}
	
	public void insert(int i) {
		root = insert(root, i);
	}
	
	public TreeNode insert(TreeNode n, int data) {
		if (n == null) {
			return new TreeNode(data);
		}
		if (data == n.data) {
			return n;
		}
		else if (data < n.data) {
			n.left = insert(n.left, data);
		}
		else {
			n.right = insert(n.right, data);
		}
		return n;
		
	}
	
	public void inOrder(TreeNode root) {
		
		if (root == null) return;
		
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
		
	}
	
	public void preOrder(TreeNode root) {
		if (root == null) return;
		
		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void postOrder(TreeNode root) {
		if (root == null) return;
		
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data);
	}
	
	public TreeNode search(TreeNode n, int value) {
		
		if (n.data == value) return n;
		
		else if (n.data > value) {
			if (n.left == null) return null;
			return search(n.left, value);
		}
		else {
			if (n.right == null) return null;
			return search(n.right, value);
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n = new TreeNode(7);
		BST tree = new BST(n);
		tree.insert(2);
		tree.insert(1);
		tree.insert(3);
		tree.insert(11);
		tree.insert(10);
		tree.insert(12);

		//tree.inOrder(tree.root);
		//tree.preOrder(tree.root);
		//tree.postOrder(tree.root);
		
		System.out.println(tree.search(tree.root, 11));

	}
	

}
