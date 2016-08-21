package com.test.linked.list;

//Java program for reversing the Linked list

class LinkedList {

	static Node head;

	static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public Node reverseUtil(Node current, Node prev) {

		if (current.next == null) {
			head = current;
			current.next = prev;
			return null;
		}

		Node next = current.next;
		current.next = prev;
		reverseUtil(next, current);
		return head;
	}

	// prints content of double linked list
	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.head = new Node(1);
		list.head.next = new Node(2);
		list.head.next.next = new Node(2);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(5);
		list.head.next.next.next.next.next = new Node(6);
		list.head.next.next.next.next.next.next = new Node(7);
		list.head.next.next.next.next.next.next.next = new Node(8);

		System.out.println("Original Linked list is :");
		list.printList(head);
		Node res = list.reverseUtil(head, null);
		System.out.println("");
		System.out.println("");
		System.out.println("Reversed linked list : ");
		list.printList(res);
	}
}