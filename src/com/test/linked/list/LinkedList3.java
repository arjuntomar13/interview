package com.test.linked.list;

public class LinkedList3 {

	public static void main(String[] args) {

		Node node1 = new Node(1);
		Node node2 = new Node(2);
		node1.setNext(node2);
		Node node3 = new Node(4);
		node2.setNext(node3);
		Node node4 = new Node(6);
		node3.setNext(node4);
		Node node5 = new Node(8);
		node4.setNext(node5);
		Node node6 = new Node(9);
		node5.setNext(node6);

		Node node7 = new Node(10);
		node6.setNext(node7);
		Node node8 = new Node(12);
		node7.setNext(node8);
		Node node9 = new Node(14);
		node8.setNext(node9);
		node9.setNext(node6);

		printMiddleNode(node1);

	}

	public static void printMiddleNode(Node node){

		Node head = node;
		Node current2 = node;
		Node current1 = node;
		int counter = -1;

		while(current2 != null){

			if((current2!=head) && (current1 == current2)){
				System.out.println("Loop started at this node: " + current1.getData() + " Current2 value: " + current2.getData());
				break;
			}
			if(counter >0 && counter%2 == 0){
				current1 = current1.getNext();
				System.out.println(current1.getData() + " this is the current1 node value. Current2 value is : " + current2.getData() + " Value of counter : " +counter);
			}
			System.out.println("current1: " + current1.getData() + " Current2: " + current2.getData());
			current2 = current2.getNext();
			counter++;
		}
		
		
	}
}
