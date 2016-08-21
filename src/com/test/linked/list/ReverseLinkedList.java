package com.test.linked.list;

public class ReverseLinkedList {

	private static Node head;

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

	public Node reverse(Node node){
		Node current = node;
		Node next = null;
		Node prev = null;

		while(current != null){

			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		node = prev;
		return node;
	}

	public void reverseInChunks(Node node, int k){
		int counter = 0;
		Node prevTail = null;

		while(node != null){
			Node nextHead = node;
			Node tempHead = nextHead;

			for(int i = 0; i < (k-1) ; i++){
				if(node != null && node.next != null){
					node = node.next;
				}
			}

			nextHead = node.next;
			node.next = null;

			Node nodeX = reverse(tempHead);
			if(counter == 0){
				head = nodeX;
				counter++;
			}else{
				prevTail.next = nodeX;
			}
			tempHead.next = nextHead;
			node = nextHead;
			prevTail = tempHead;
		}

	}


	public static void main(String[] args) {
		ReverseLinkedList list = new ReverseLinkedList();
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

		int k = 3;

		list.reverseInChunks(head, k);

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