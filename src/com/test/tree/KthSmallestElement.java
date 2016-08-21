package com.test.tree;

import java.util.Stack;

public class KthSmallestElement {

	private static Node root;

	class Node{
		int data;
		int rank;
		Node left;
		Node right;

		public Node(int data){
			this.data = data;
		}
	}

	Node buildTreeWithRanks(int val){
		Node node = new Node(val);
		if(root == null){
//			node.rank++;
			root = node;
		}else{
			buildTreeWithRanksRec(root, node);
		}

		return root;
	}

	void buildTreeWithRanksRec(Node currentRoot, Node node){

		if(node.data < currentRoot.data){
			//updateRank(currentRoot.right);
			currentRoot.rank++;
			if(currentRoot.left == null){
				/*if(node.rank == 0){
					node.rank++;
				}*/
				//node.rank++;
				currentRoot.left = node;
			}else{
				buildTreeWithRanksRec(currentRoot.left, node);
			}
		}else{
//			node.rank = currentRoot.rank +1;
			if(currentRoot.right == null){
				currentRoot.right = node;
			}else{
				buildTreeWithRanksRec(currentRoot.right, node);
			}
		}
	}

	/*void updateRank(Node node){
		if(node == null){
			return;
		}
		updateRank(node.left);
		node.rank++;
		updateRank(node.right);
	}*/
	
	void findKth(Node node, int k){
		
		if(node == null){
			return;
		}
		
		if((node.rank+1) == k){
			System.out.println("Kth element is : " + node.data);
		}else if(k > node.rank){
			k -= (node.rank +1);
			findKth(node.right, k);
		}else{
			findKth(node.left, k);
		}
		
	}
	
	public void printInOrderRec(Node currentRoot){
		if(currentRoot == null){
			return;
		}

		printInOrderRec(currentRoot.left);
		System.out.println(currentRoot.data + " This is the rank : " + currentRoot.rank);
		printInOrderRec(currentRoot.right);
	}

	public static void main(String[] args) {
		/*PopulateBST populateBST = new PopulateBST();
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

		KthSmallestElement kthSmallestElement = new KthSmallestElement();

		kthSmallestElement.findKthSmallest(root, 2);
		kthSmallestElement.findKthSmallest(root, 4);
		kthSmallestElement.findKthSmallest(root, 6);
		kthSmallestElement.findKthSmallest(root, 8);
		kthSmallestElement.findKthSmallest(root, 10);
		kthSmallestElement.findKthSmallest(root, 12);*/

		KthSmallestElement kthSmallestElement = new KthSmallestElement();
		kthSmallestElement.buildTreeWithRanks(20);
		kthSmallestElement.buildTreeWithRanks(12);
		kthSmallestElement.buildTreeWithRanks(32);
		kthSmallestElement.buildTreeWithRanks(78);
		kthSmallestElement.buildTreeWithRanks(18);
		kthSmallestElement.buildTreeWithRanks(43);
		kthSmallestElement.buildTreeWithRanks(11);
		kthSmallestElement.buildTreeWithRanks(1);
		kthSmallestElement.buildTreeWithRanks(98);
		kthSmallestElement.buildTreeWithRanks(17);
		kthSmallestElement.buildTreeWithRanks(44);
		kthSmallestElement.buildTreeWithRanks(345);

		kthSmallestElement.printInOrderRec(root);
		
		kthSmallestElement.findKth(root, 6);
		
		kthSmallestElement.buildTreeWithRanks(19);
		
		kthSmallestElement.findKth(root, 7);
	}

	void findKthSmallest(Node currentRoot, int num){
		int k = num;
		if(currentRoot == null){
			return;
		}

		Stack<Node> stack = new Stack<Node>();

		while(currentRoot != null){
			stack.push(currentRoot);
			currentRoot = currentRoot.left;
		}

		while(!stack.isEmpty()){
			Node node = stack.pop();
			num--;
			if(num == 0){
				System.out.println(k + "th smallest value is : " + node.data);
				break;
			}
			if(node.right != null){
				node = node.right;
				while(node != null){
					stack.push(node);
					node = node.left;
				}
			}
		}
	}
}
