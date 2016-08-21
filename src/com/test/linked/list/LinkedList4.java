package com.test.linked.list;

public class LinkedList4 {

	public static void main(String[] args) {

		Node node1 = new Node(0);
		Node node2 = new Node(2);
		node1.setNext(node2);
		Node node4 = new Node(1);
		Node node3 = new Node(0, node4);
		node2.setNext(node3);
		Node node5 = new Node(0);
		node4.setNext(node5);
		Node node6 = new Node(2);
		node5.setNext(node6);

		Node head = sortList(node1);
		printList(head);
	}

	public static Node sortList(Node node){

		Node current = node;
		Node head = current;
		Node tail = null;
		Node node0 = null;
		Node node1 = null;
		Node node2 = null;

		Node prev = null;
		Node next = node.getNext();

		while(current !=null){

			if(current.getData() == 0){
				if(prev == null || prev.getData() == 0){
					node0 = current;
					prev = current;
				}
				else{
					if(node0==null){
						Node x = head;
						head = current;
						head.setNext(x);
						node0 = head;
						prev.setNext(next);
					}else{
						Node x = node0.getNext();
						node0.setNext(current);
						prev.setNext(next);
						current.setNext(x);
						node0 = node0.getNext();
					}
				}
			}else if(current.getData() == 1){
				if(prev == null || prev.getData() == 1){
					node1 = current;
					prev = current;
				}
				else{
					if(node1==null){
						Node x = null;
						if(node0!=null){
							node1 = current;
							if(current.getNext()==null){
								Node y = node0.getNext();
								node0.setNext(current);
								prev.setNext(next);
								current.setNext(y);
							}
							prev = current;
						}else{
							x = head;
							head = current;
							head.setNext(x);
							node1 = head;
							prev.setNext(next);
						}
					}else{
						Node x = node1.getNext();
						node1.setNext(current);
						prev.setNext(next);
						current.setNext(x);
						node1 = node1.getNext();
					}
				}

			}else if(current.getData() == 2){
				if(prev == null || prev.getData() == 2){
					node2 = current;
					prev = current;
				}
				else{
					if(node2==null){
						Node x = null;
						if(node1!=null || node0!=null){
							node2 = current;
							prev = current;
						}else{
							x = head;
							head = current;
							head.setNext(x);
							node2 = head;
							prev.setNext(next);
						}
					}
					else{
						Node x = node2.getNext();
						node2.setNext(current);
						prev.setNext(next);
						current.setNext(x);
						node2 = node2.getNext();
					}
				}
			}
			current = next;
			if(next!=null){
				next = next.getNext();
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
