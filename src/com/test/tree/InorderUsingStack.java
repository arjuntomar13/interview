package com.test.tree;

import java.util.Stack;

public class InorderUsingStack {

	public void inOrder(Node node){
		
		if(node == null){
			return;
		}
		
		Stack<Node> stack = new Stack<Node>();
		
		while(node != null){
			stack.push(node);
			node = node.left;
		}
		
		while(!stack.isEmpty()){
			Node node1 = stack.pop();
			System.out.print(node1.data + " ");
			
			if(node1.right != null){
				node1 = node1.right;
				while(node1 != null){
					stack.push(node1);
					node1 = node1.left;
				}
			}
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
		
		
		InorderUsingStack inorderUsingStack = new InorderUsingStack();
		inorderUsingStack.inOrder(root);
		
	}
	
}
