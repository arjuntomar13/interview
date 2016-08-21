package com.test.linked.list;

public class SwapNodesLlinkedList {

	 Node head;

	static class Node {
		int data;
		Node next;
		
		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void swapNodes(int a, int b) {

		Node node = head;
		Node prev = head;
		boolean isFirstFound = false;
		boolean isBothFound = false;

		Node prev1 = null;
		Node next1 = null;
		Node prev2 = null;
		Node next2 = null;
		Node firstFoundNode = null;

		while (node != null) {
			if (node.data == a || node.data == b) {
				if (!isFirstFound) {
					prev1 = prev;
					next1 = node.next;
					firstFoundNode = node;
					isFirstFound = true;
				} else {
					prev2 = prev;
					next2 = node.next;
					isBothFound = true;
					break;
				}
			}
			prev = node;
			node = node.next;
		}
		if(isBothFound){
			if(prev1 == firstFoundNode){
				head = node;
			}else{
				prev1.next = node;
			}
			if(next1 == node){
				node.next = prev2;
			}else{
				node.next = next1;
				prev2.next = firstFoundNode;
			}
			firstFoundNode.next = next2;
		}
	}

	public static void main(String[] args) {
		SwapNodesLlinkedList list = new SwapNodesLlinkedList();
		list.head = new Node(1);
		list.head.next = new Node(2);
		list.head.next.next = new Node(3);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(5);
		list.head.next.next.next.next.next = new Node(6);
		list.head.next.next.next.next.next.next = new Node(7);
		list.head.next.next.next.next.next.next.next = new Node(8);
		
		System.out.print("\n Linked list before calling swapNodes() ");
		list.printList();

		list.swapNodes(7, 8);

		System.out.print("\n  Linked list after calling swapNodes() ");
		list.printList();
	}

	public void printList() {
		Node tNode = head;
		while (tNode != null) {
			System.out.print(tNode.data + " ");
			tNode = tNode.next;
		}
	}
}
