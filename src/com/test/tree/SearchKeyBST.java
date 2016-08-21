package com.test.tree;

public class SearchKeyBST {

	int counter;
	void findKey(Node currentNode, int key){
		counter ++;
		if(currentNode == null){
			return;
		}
		
		if(key == currentNode.data){
			System.out.println("Found Key in BST :: " + key + " :: number of iterations :: " + counter);
			return;
		}else if(key < currentNode.data){
			findKey(currentNode.left, key);
		}else{
			findKey(currentNode.right, key);
		}
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

		SearchKeyBST searchKeyBST = new SearchKeyBST();
		
		searchKeyBST.findKey(root1, 78);
	}
}
