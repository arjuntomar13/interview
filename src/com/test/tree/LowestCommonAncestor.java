package com.test.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestor {

	Queue<Integer> q = new LinkedList<>();
	
	Node findLCA(Node node, int val1, int val2){

		while(node != null){
			if(val1 < node.data && val2 < node.data){
				node = node.left;
			}else if(val1 > node.data && val2 > node.data){
				node = node.right;
			}else{
				return node;
			}
		}
		return node;
	}

	void findLCA1(Node root, int a, int b){
		getAncestors(root, a);
		Queue<Integer> q1 = q;
		q = new LinkedList<>();
		getAncestors(root, b);
		Queue<Integer> q2 = q;
		if(q1.size() == 0 || q2.size() == 0){
			System.out.println("Either/Both of the elements not found.. No common ancestors");
			return;
		}
		if(q1.size() > q2.size()){
			int n = q1.size() - q2.size();
			for(int i = 0; i < n ; i++){
				q1.poll();
			}
		}else if(q2.size() > q1.size()){
			int n = q2.size() - q1.size();
			for(int i = 0; i < n ; i++){
				q2.poll();
			}
		}
		int n = q1.size();
		for(int i =0; i<n; i++){
			int d1 = q1.poll();
			int d2 = q2.poll();
			
			if(d1 == d2){
				System.out.println("Lowest common Ancestor is : " + d1);
				break;
			}
		}
	}
	
	boolean getAncestors(Node node, int a){
		if(node == null){
			return false;
		}
		if(a == node.data){
			return true;
		}
		
		boolean isFoundLeft = getAncestors(node.left, a);
		if(isFoundLeft){
			q.add(node.data);
			return true;
		}
		boolean isFoundRight = getAncestors(node.right, a);
		if(isFoundRight){
			q.add(node.data);
			return true;
		}
		return isFoundRight;
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

		LowestCommonAncestor lca = new LowestCommonAncestor();
		lca.findLCA1(root, 32, 13);
	}
}
