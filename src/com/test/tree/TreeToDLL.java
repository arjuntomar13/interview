package com.test.tree;


public class TreeToDLL {

	Node root = null;

	class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public void insert(int value) {

		root = insert(root, value);
	}

	private Node insert(Node x, Integer value) {

		if (x == null)
			return new Node(value);

		int cmp = value.compareTo(x.data);

		if (cmp < 0)
			x.left = insert(x.left, value);
		else if (cmp > 0)
			x.right = insert(x.right, value);
		else
			x.data = value;

		return x;

	}

	Node binaryToList(Node currentRoot) {

		if (currentRoot.left != null) {
			Node left = binaryToList(currentRoot.left);

			while (left.right != null) {
				left = left.right;
			}
			left.right = currentRoot;
			currentRoot.left = left;
		}

		if (currentRoot.right != null) {
			Node right = binaryToList(currentRoot.right);

			while (right.left != null) {
				right = right.left;
			}
			right.left = currentRoot;
			currentRoot.right = right;
		}
		return currentRoot;
	}

	public Node bintree2list(Node node) {
		if (node == null) {
			return node;
		}

		node = binaryToList(node);

		while (node.left != null) {
			node = node.left;
		}

		return node;
	}

	public void printTree(Node x) {

		if (x == null)
			return;

		printTree(x.left);
		System.out.print(x.data + " ");
		printTree(x.right);
	}

	public void printList(Node x) {
		Node end = x;

		while (x != null) {
			System.out.print(x.data + " ");
			x = x.right;
			if (end == x)
				break;
		}
	}

	public void printListBack(Node x) {

		Node end = getLast(x);

		while (end != null) {
			System.out.print(end.data + " ");
			end = end.left;
		}
	}

	public Node getLast(Node node) {
		Node last = null;

		while (node.right != null) {
			node = node.right;
		}
		last = node;
		return last;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeToDLL binaryTree = new TreeToDLL();

		binaryTree.insert(4);
		binaryTree.insert(5);
		binaryTree.insert(2);
		binaryTree.insert(3);
		binaryTree.insert(1);
		binaryTree.insert(7);
		binaryTree.insert(6);
		System.out.print("Binary tree in sorted order : ");
		binaryTree.printTree(binaryTree.root);

		Node head = binaryTree.bintree2list(binaryTree.root);
		System.out.print("\nLinked List using next in sorted order: ");
		binaryTree.printList(head);

		System.out.print("\nLinked List using prev in sorted order: ");
		binaryTree.printListBack(head);
	}

}
