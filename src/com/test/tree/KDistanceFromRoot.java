package com.test.tree;

public class KDistanceFromRoot {

	void printKDistance(Node node, int k){
		if(node == null){
			return;
		}else if(k == 0){
			System.out.println(node.data);
			return;
		}
		
		printKDistance(node.left, k-1);
		
		printKDistance(node.right, k-1);
		
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
		
		
		KDistanceFromRoot kDistanceFromRoot = new KDistanceFromRoot();
		
		
		kDistanceFromRoot.printKDistance(root, 2);
	}
}
