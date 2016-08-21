package com.test.linked.list;

import java.util.HashMap;

public class LRUCache {

	int capacity;
	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	static Node head = null;
	static Node end = null;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	static class Node {
		int data;
		int key;
		Node next;
		Node prev;

		public Node(int key, int data) {
			this.data = data;
			this.key = key;
		}
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			int value = node.data;
			remove(node);
			makeHead(node);
			// make this node head
			return value;
		}
		return -1;
	}

	public void remove(Node node) {
		if (node.prev != null) {
			node.prev.next = node.next;
		} else {
			head = node.next;
		}

		if (node.next != null) {
			node.next.prev = node.prev;
		} else {
			end = node.prev;
		}
	}

	public void makeHead(Node node) {
		node.next = head;
		node.prev = null;

		if (head != null) {
			head.prev = node;
		}

		head = node;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			node.data = value;
			remove(node);
			makeHead(node);
		} else {
			Node node = new Node(key, value);
			if (map.size() >= capacity) {
				remove(end);
				makeHead(node);
			} else {
				makeHead(node);
			}
			map.put(key, node);
		}
	}

	public static void main(String[] args) {

		LRUCache lruCache = new LRUCache(4);

		Node node1 = new Node(1, 11);
		Node node2 = new Node(2, 21);
		Node node3 = new Node(3, 31);

		head = node1;
		node1.next = node2;
		node2.prev = node1;

		node2.next = node3;
		node3.prev = node2;
		end = node3;

		lruCache.map.put(1, node1);
		lruCache.map.put(2, node2);
		lruCache.map.put(3, node3);

		lruCache.printList();
		int value = lruCache.get(4);
		System.out.println("Value for key is " + lruCache.get(4));

		lruCache.printList();

		if (value == -1) {
			lruCache.set(4, 41);
			System.out.println("Value for key is " + lruCache.get(4));
		}
		lruCache.printList();

		System.out.println("Value is : " + lruCache.get(2));
		lruCache.printList();
		
		value = lruCache.get(5);
		if (value == -1) {
			lruCache.set(5, 51);
			System.out.println("Value for key is " + lruCache.get(5));
		}
		lruCache.printList();
		
		value = lruCache.get(1);
		lruCache.printList();
		
		value = lruCache.get(6);
		if (value == -1) {
			lruCache.set(6, 61);
			System.out.println("Value for key is " + lruCache.get(6));
		}
		lruCache.printList();
	}

	public void printList() {
		Node tNode = head;
		while (tNode != null) {
			System.out.print(tNode.data + " ");
			tNode = tNode.next;
		}
		System.out.println("\n");
	}
}
