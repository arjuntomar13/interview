package com.test.tree;

public class PopulateBST {

	private Node root;

	public Node insert(int data){

		Node node = new Node(data);
		if(root == null){
			root = node;
		}else{
			insertRec(root,node);
		}
		return root;
	}

	public Node insert1(Node root, int data){

		Node node = new Node(data);
		if(root == null){
			root = node;
		}else{
			insertRec(root,node);
		}
		return root;
	}

	public void insertRec(Node currentRoot, Node node){

		if(node.data < currentRoot.data){
			if(currentRoot.left == null){
				currentRoot.left = node;
			}else{
				insertRec(currentRoot.left, node);
			}
		}else{
			if(currentRoot.right == null){
				currentRoot.right = node;
			}else{
				insertRec(currentRoot.right, node);
			}
		}
	}

	public static void main(String[] args) {
		PopulateBST populateBST = new PopulateBST();
		Node root = populateBST.insert1(null,20);
		populateBST.insert1(root, 12);
		populateBST.insert1(root, 32);
		populateBST.insert1(root, 78);
		populateBST.insert1(root, 18);
		populateBST.insert1(root, 43);
		populateBST.insert1(root, 11);
		populateBST.insert1(root, 1);
		populateBST.insert1(root, 98);
		populateBST.insert1(root, 345);
		
		TreeHeight treeHeight = new TreeHeight();
		
		System.out.println(treeHeight.findTreeHeight(root));
	}
}
