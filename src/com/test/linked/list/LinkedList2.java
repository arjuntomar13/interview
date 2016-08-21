package com.test.linked.list;

public class LinkedList2 {

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

		Node head = deleteNode(node1, 3);
		printList(head);
	}

	public static Node deleteNode(Node node, int searchValue){
		
		Node current = node;
		Node head = node;
		Node prev = null;
		
		while(current != null){
			if(current.getData() == searchValue){
				if(current == head){
					head = current.getNext();
					prev = current;
				}
				Node x = current.getNext();
				prev.setNext(x);
				current.setNext(null);
				current = x;
			}else{
				prev = current;
				current = current.getNext();
			}
		}
		return head;
	}

	public static void printList(Node head){
		Node temp = head;

		while(temp != null){
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}
}
