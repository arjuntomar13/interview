package com.test.tree;

public class AncestorOfNode {

	boolean printAncestors(Node node, int val){
		if(node == null){
			return false;
		}

		if(node.data == val){
			return true;
		}

		boolean isFoundLeft = printAncestors(node.left, val);
		if(isFoundLeft){
			System.out.println(node.data);
			return true;
		}
		boolean isFoundRight = printAncestors(node.right, val);
		if(isFoundRight){
			System.out.println(node.data);
			return true;
		}
		return isFoundRight;
	}

	boolean checkSumOfAncestors(Node node, int sum){
		if(node == null){
			return false;
		}
		
		boolean isSumChecked = false;
		
		int subSum = sum - node.data;
		if(subSum == 0 && node.left == null && node.right == null){
			return true;
		}
		
		isSumChecked = isSumChecked || checkSumOfAncestors(node.left, subSum);
		
		isSumChecked = isSumChecked || checkSumOfAncestors(node.right, subSum);
		
		return isSumChecked;
	}
	
	public static void main(String[] args) {

		PopulateBST populateBST = new PopulateBST();
		Node root = populateBST.insert(20);
		populateBST.insert(12);
		populateBST.insert(32);
		populateBST.insert(78);
		populateBST.insert(18);
		populateBST.insert(43);
		populateBST.insert(11);
		populateBST.insert(1);
		populateBST.insert(98);
		populateBST.insert(345);

		AncestorOfNode anc = new AncestorOfNode();
		anc.printAncestors(root, 1);
		System.out.println("***********");
		anc.printAncestors(root, 78);
		System.out.println("***********");
		System.out.println(anc.checkSumOfAncestors(root, 573));
		System.out.println("***********");
		System.out.println(anc.checkSumOfAncestors(root, 44));
	}

}
