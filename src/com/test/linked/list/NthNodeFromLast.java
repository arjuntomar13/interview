package com.test.linked.list;

public class NthNodeFromLast {

	Node head;
	
	static class Node{
		int data;
		Node next;
		
		public Node(int data, Node next){
			this.data = data;
			this.next = next;
		}
		
		public Node(int data){
			this.data = data;
		}
	}
	
	static int getNode(Node head,int n) {
	     // This is a "method-only" submission. 
	     // You only need to complete this method. 

	    int data = -1;
	    Node helperNode = head;
	    int count = 0;
	    while(head != null){
	    	System.out.println("Head Data : " + head.data);
	        if(count > n-1){
	        	System.out.println("Helper Data : " + helperNode.data);
	        	data = helperNode.data;
	        	helperNode = helperNode.next;
	        }
	        count++;
	        if(head.next == null){
	            return data;
	        }
	        head = head.next;
	    }
	    return data;
	}
	
	public static void main(String[] args) {
		
		NthNodeFromLast list = new NthNodeFromLast();
		list.head = new Node(1);
		list.head.next = new Node(2);
		list.head.next.next = new Node(3);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(5);
		list.head.next.next.next.next.next = new Node(6);
		list.head.next.next.next.next.next.next = new Node(7);
		list.head.next.next.next.next.next.next.next = new Node(8);
		list.head.next.next.next.next.next.next.next.next = new Node(9);
		list.head.next.next.next.next.next.next.next.next.next = new Node(10);
		
		Node node = list.head;
		System.out.println("Data " + getNode(node, 0));
	}
	
	
}
