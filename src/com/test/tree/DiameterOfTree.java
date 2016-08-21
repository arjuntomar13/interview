package com.test.tree;

public class DiameterOfTree {

	public int diameterOfTree(Node currentNode){
		
		if(currentNode == null){
			return 0;
		}
		
		int lHeight = height(currentNode.left);
		int rHeight = height(currentNode.right);
		
		int lDiameter = diameterOfTree(currentNode.left);
		int rDiameter = diameterOfTree(currentNode.right);
		
		return Math.max((lHeight+ rHeight +1), Math.max(lDiameter, rDiameter));
	}
	
	public int height(Node node){
		if(node == null){
			return 0;
		}
		
		int lHeight = height(node.left);
		int rHeight = height(node.right);
		
		if(lHeight < rHeight){
			return (rHeight + 1);
		}else{
			return (lHeight +1);
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
		
		DiameterOfTree diameterOfTree = new DiameterOfTree();
		
		System.out.println(diameterOfTree.diameterOfTree(root));
	}
}
