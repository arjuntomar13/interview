package com.test.tree;

public class PrintTree {

	public void printInOrderRec(Node currentRoot , int k){
		if(currentRoot == null){
			return;
		}
		
		printInOrderRec(currentRoot.left, k);
		System.out.print(currentRoot.data + " ");
		printInOrderRec(currentRoot.right, k);
	}

	public static void main(String[] args) {
		PrintTree printTree = new PrintTree();

		PopulateBST populateBST = new PopulateBST();
		populateBST.insert(20);
		populateBST.insert(12);
		populateBST.insert(32);
		populateBST.insert(78);
		populateBST.insert(18);
		populateBST.insert(43);
		populateBST.insert(11);
		populateBST.insert(1);
		populateBST.insert(98);
		Node root = populateBST.insert(345);

		printTree.printInOrderRec(root, 9);
		
		printTree.printInOrderRec(root, 10);
		
	}
}
