package com.test.tree;

public class TreeHeight {

	public int findTreeHeight(Node currentRoot){
		
		if(currentRoot == null){
			return 0;
		}
		
		int lDepth = findTreeHeight(currentRoot.left);
		int rDepth = findTreeHeight(currentRoot.right);
		
		if(lDepth > rDepth){
			return (lDepth +1);
		}else{
			return (rDepth +1);
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
		
		TreeHeight treeHeight = new TreeHeight();
		
		System.out.println(treeHeight.findTreeHeight(root));
	}
}
