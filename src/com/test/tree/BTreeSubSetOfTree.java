package com.test.tree;

public class BTreeSubSetOfTree {

	boolean isSubTree;
	boolean checkSubTree(Node node1, Node node2){
		
		if(node1 == null && node2 == null){
			return true;
		}
		
		if(node1 !=null && node2 != null && (node1.data == node2.data)){
			System.out.println("Nodes matched.. going to check for identical check..!!");
			isSubTree = identicalTrees(node1, node2);
		}
		
		if(!isSubTree && (node1 != null)){
			checkSubTree(node1.left, node2);
			checkSubTree(node1.right, node2);
		}
		return isSubTree;
	}
	
	boolean identicalTrees(Node node1, Node node2){
		if(node1 == null && node2 == null){
			return true;
		}else if(node2 == null){
			return true;
		}
		
		if(node1 != null && node2 != null){
			return (node1.data == node2.data) && identicalTrees(node1.left, node2.left) && identicalTrees(node1.right, node2.right);
		}
		return false;
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
		
		PopulateBST populateBST1 = new PopulateBST();
		Node root2 = populateBST1.insert(32);
		populateBST1.insert(78);
		populateBST1.insert(43);
		populateBST1.insert(98);
		populateBST1.insert(18);
		populateBST1.insert(43);
		populateBST1.insert(11);
		populateBST1.insert(1);
		populateBST1.insert(98);
		populateBST1.insert(345);
		
		BTreeSubSetOfTree bt = new BTreeSubSetOfTree();
		
		System.out.println(bt.checkSubTree(root1, root2));
		System.out.println(bt.identicalTrees(root1, root2));
	}
}
