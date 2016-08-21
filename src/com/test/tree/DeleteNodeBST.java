package com.test.tree;

public class DeleteNodeBST {

	boolean isFound;
	Node deleteNode(Node currentRoot, int val){
		if(currentRoot == null){
			return currentRoot;
		}

		if(currentRoot.data == val){
			isFound = true;
			return currentRoot;
		}

		if(currentRoot.left != null){
			Node left = deleteNode(currentRoot.left, val);
			if(isFound){
				if(left.left == null && left.right == null){
					currentRoot.left = null;
					currentRoot.right = null;
				}else if(left.left == null){
					currentRoot.left = left.right;
				}else if(left.right == null){
					currentRoot.left = left.left;
				}else{
					currentRoot.left = left.right;
					Node leftMost = getLeftMostNode(left.right);
					leftMost.left = left.left;
				}
				isFound = false;
			}
		}

		if(currentRoot.right != null){
			Node right = deleteNode(currentRoot.right, val);
			if(isFound){
				if(right.left == null && right.right == null){
					currentRoot.left = null;
					currentRoot.right = null;
				}else if(right.left == null){
					currentRoot.right = right.right;
				}else if(right.right == null){
					currentRoot.right = right.left;
				}else{
					currentRoot.right = right.left;
					Node rightMost = getLeftMostNode(right.left);
					rightMost.right = right.right;
				}
				isFound = false;
			}
		}
		return currentRoot;
	}

	Node getLeftMostNode(Node node){
		if(node == null){
			return null;
		}
		while(node.left != null){
			node = node.left;
		}
		return node;
	}

	Node getRightMostNode(Node node){
		if(node == null){
			return null;
		}
		while(node.right != null){
			node = node.right;
		}
		return node;
	}

	void printTree(Node node){
		if(node == null){
			return;
		}

		printTree(node.left);
		System.out.print(node.data + " ");
		printTree(node.right);
	}

	public static void main(String[] args) {
		PopulateBST populateBST = new PopulateBST();
		Node root1 = populateBST.insert(20);
		populateBST.insert(12);
		populateBST.insert(32);
		populateBST.insert(78);
		populateBST.insert(18);
		populateBST.insert(43);
		populateBST.insert(11);
		populateBST.insert(1);
		populateBST.insert(98);
		populateBST.insert(345);

		DeleteNodeBST deleteNode = new DeleteNodeBST();

		deleteNode.printTree(root1);

		System.out.println();

		deleteNode.deleteNode(root1, 12);

		deleteNode.printTree(root1);

		System.out.println();

		deleteNode.deleteNode(root1, 78);

		deleteNode.printTree(root1);
		
		System.out.println();

		deleteNode.deleteNode(root1, 32);

		deleteNode.printTree(root1);
	}

}
