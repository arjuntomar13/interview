package com.test.tree;

public class BST {
	public TreeNode root;

	private TreeNode linkedListHead = null;
	
	public void insert(int value) {
		TreeNode treeNode = new TreeNode(value, null, null);
		if (root == null) {
			root = treeNode;
		} else {
			insert1(root, treeNode);
		}
	}

	public void insert1(TreeNode latestRoot, TreeNode node) {

		if (node.data < latestRoot.data) {
			if (latestRoot.leftNode == null) {
				latestRoot.leftNode = node;
				return;
			} else {
				insert1(latestRoot.leftNode, node);
			}
		} else {
			if (latestRoot.rightNode == null) {
				latestRoot.rightNode = node;
				return;
			} else {
				insert1(latestRoot.rightNode, node);
			}
		}
	}

	public int getMax() {
		if (root == null) {
			return 0;
		}
		TreeNode current = root;
		while (current.rightNode != null) {
			current = current.rightNode;
		}
		return current.data;
	}

	public int getMin() {
		if (root == null) {
			return 0;
		}
		TreeNode current = root;
		while (current.leftNode != null) {
			current = current.leftNode;
		}
		return current.data;
	}
	
	public void printInOrder(){
		printInOrderRec(root);
	}
	
	public TreeNode printInOrderRec(TreeNode currentRoot){
		if(currentRoot == null){
			return null;
		}
		currentRoot.leftNode = printInOrderRec(currentRoot.leftNode);
		System.out.print(currentRoot.data + ", ");
		
		if(linkedListHead == null){
			linkedListHead = currentRoot;
		}
		if(currentRoot.leftNode !=null){
			currentRoot.leftNode.rightNode = currentRoot;
		}
		
		currentRoot.rightNode = printInOrderRec(currentRoot.rightNode);
		if(currentRoot.rightNode != null){
			currentRoot.rightNode.leftNode = currentRoot;
			return currentRoot.rightNode;
		}
		else
			return currentRoot;
	}
	
	    public void printList() {
	        TreeNode current = linkedListHead;
	        System.out.println("\n");
	        while (current != null) {
	            System.out.print(current.data + " ");
	            current = current.rightNode;
	            if (current == linkedListHead) break;
	        }
	    }
	    
	public static void main(String[] args) {
		BST bst = new BST();

		bst.insert(20);
		bst.insert(12);
		bst.insert(32);
		bst.insert(78);
		bst.insert(18);
		bst.insert(43);
		bst.insert(11);
		bst.insert(1);
		bst.insert(98);
		bst.insert(345);

		System.out.println("The max Value in BST is : " + bst.getMax());

		System.out.println("The min Value in BST is : " + bst.getMin());
		
		bst.printInOrder();
		
		bst.printList();
		
	}

}
