package com.test.linked.list;

public class MergeSortedLists {

	static Node head1;
	static Node head2;
	static Node mergedListHead;

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

	public void mergeSortedLists(Node node1, Node node2){

		int counter = 0;
		Node next1 = null;
		Node next2 = null;

		while(node1 != null){
			if(node1.data < node2.data){
				if(counter == 0){
					mergedListHead = node1;
					counter++;
				}
				next1 = node1.next;
			}else{
				if(counter == 0){
					mergedListHead = node2;
					counter++;
				}
				node2 = node2.next;
				next2 = node2;
			}
			node1 = node1.next;
		}

	}

	public static void main(String[] args) {
		MergeSortedLists list1 = new MergeSortedLists();
		list1.head1 = new Node(1);
		list1.head1.next = new Node(3);
		list1.head1.next.next = new Node(5);
		list1.head1.next.next.next = new Node(7);
		list1.head1.next.next.next.next = new Node(9);

		MergeSortedLists list2 = new MergeSortedLists();
		list2.head2 = new Node(2);
		list2.head2.next = new Node(4);
		list2.head2.next.next = new Node(6);
		list2.head2.next.next.next = new Node(8);
		list2.head2.next.next.next.next = new Node(10);

		list2.mergeSortedLists(head1, head2);

	}

	public void printList() {
		Node tNode = mergedListHead;
		while (tNode != null) {
			System.out.print(tNode.data + " ");
			tNode = tNode.next;
		}
	}
}
