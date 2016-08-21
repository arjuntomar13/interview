package com.test.linked.list;

public class AddTwoListNumbers {

	static Node head1;
	static Node head2;
	Node res;

	static class Node {
		int data;
		Node next;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

		public Node(int data) {
			this.data = data;
		}
	}

	public void add(Node node1, Node node2) {
		Node prev = null;
		int carry = 0;

		while (node1 != null) {
			int tempSum = 0;
			int data1 = node1.data;
			int data2 = 0;
			if (node2 != null) {
				data2 = node2.data;
				node2 = node2.next;
			}

			tempSum = data1 + data2 + carry;
			if (tempSum >= 10) {
				carry = 1;
			}else{
				carry = 0;
			}
			tempSum = tempSum % 10;

			if (res == null) {
				res = new Node(tempSum);
				prev = res;
			} else {
				Node node = new Node(tempSum);
				prev.next = node;
				prev = node;
			}

			node1 = node1.next;
			
			if(node1 == null && node2 != null){
				while(node2 != null){
					if(carry == 0){
						prev.next = node2;
						break;
					}else{
						tempSum = node2.data + carry;
						if (tempSum >= 10) {
							carry = 1;
						}else{
							carry = 0;
						}
						tempSum = tempSum % 10;
						if (res == null) {
							res = new Node(tempSum);
							prev = res;
						} else {
							Node node = new Node(tempSum);
							prev.next = node;
							prev = node;
						}
						node2 = node2.next;
					}
				}
			}
		}
		
		if(carry == 1){
			Node node = new Node(carry);
			prev.next = node;
		}
	}

	public static void main(String[] args) {
		AddTwoListNumbers list1 = new AddTwoListNumbers();
		list1.head1 = new Node(1);
//		list1.head1.next = new Node(3);
//		list1.head1.next.next = new Node(5);
//		list1.head1.next.next.next = new Node(7);
//		list1.head1.next.next.next.next = new Node(9);

		AddTwoListNumbers list2 = new AddTwoListNumbers();
		list2.head2 = new Node(2);
		list2.head2.next = new Node(4);
		list2.head2.next.next = new Node(6);
		list2.head2.next.next.next = new Node(8);
		list2.head2.next.next.next.next = new Node(9);
//		list2.head2.next.next.next.next.next = new Node(9);
//		list2.head2.next.next.next.next.next.next = new Node(4);
//		list2.head2.next.next.next.next.next.next.next = new Node(9);
//		list2.head2.next.next.next.next.next.next.next.next = new Node(3);

		list1.add(head1, head2);

		list1.printList();
	}

	public void printList() {
		Node tNode = res;
		while (tNode != null) {
			System.out.print(tNode.data + " ");
			tNode = tNode.next;
		}
		System.out.println("\n");
	}

}
