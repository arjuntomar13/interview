package misc;

import com.test.linked.list.Node;

public class PalindromeLinkedList {

	public Node reverse(Node node){

		Node current = node;
		Node next = null;
		Node prev = null;

		while(current != null){

			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}

		node = prev;
		return node;
	}

	public Node copy(Node node){

		Node head = null;
		Node prev = null;
		
		while(node != null){
			if(head == null){
				head = new Node(node.getData());
				prev = head;
			}else{
				Node newNode = new Node(node.getData());
				prev.setNext(newNode);
				prev = newNode;
			}
			node = node.getNext();
		}
		return head;
	}

	public boolean isPalindrome(Node head1, Node head2){
		boolean isPalindrome = true;
		Node node1 = head1;
		Node node2 = head2;
		while(node1 != null){
			int data1 = node1.getData();
			int data2 = node2.getData();

			if(!(data1 == data2)){
				isPalindrome = false;
				break;
			}

			node1 = node1.getNext();
			node2 = node2.getNext();
		}

		return isPalindrome;
	}

	public static void main(String[] args) {

		PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();

		Node node1 = new Node(1);
		Node node2 = new Node(2);
		node1.setNext(node2);
		Node node3 = new Node(3);
		node2.setNext(node3);
		Node node4 = new Node(3);
		node3.setNext(node4);
		Node node5 = new Node(2);
		node4.setNext(node5);
		Node node6 = new Node(0);
		node5.setNext(node6);

		palindromeLinkedList.printList(node1);

		System.out.println("####################################");
		
		Node newHead = palindromeLinkedList.copy(node1);
		
		Node reverseHead = palindromeLinkedList.reverse(node1);

		palindromeLinkedList.printList(newHead);

		System.out.println("####################################");

		palindromeLinkedList.printList(reverseHead);

		System.out.println(palindromeLinkedList.isPalindrome(node1, reverseHead));
	}

	public void printList(Node head){
		Node temp = head;

		while(temp != null){
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}

}
