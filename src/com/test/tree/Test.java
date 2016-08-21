package com.test.tree;

public class Test {


	public Node treeToList(Node currentNode){

		if(currentNode.left != null){
			Node left = treeToList(currentNode.left);

			while(left.right != null){
				left = left.right;
			}
			left.right = currentNode;
			currentNode.left = left;
		}

		if(currentNode.right != null){
			Node right = treeToList(currentNode.right);
			while(right.left != null){
				right = right.left;
			}

			right.left = currentNode;
			currentNode.right = right;
		}
		return currentNode;
	}
	
	Node getHead(Node root){
		Node head = null;
		
		while(root.left != null){
			root = root.left;
		}
		
		head = root;
		return head;
	}
	
	void printList(Node node){
		while(node != null){
			System.out.println(node.data);
			node = node.right;
		}
	}

	public static void main(String[] args) {
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
		
		Test test = new Test();
		test.treeToList(root);
		
		Node head = test.getHead(root);
		
		test.printList(head);
		
	}

}
