package com.test.queue;

public class MyPriorityQueue {

	private int[] heap;
	private int size;
	private int maxSize;

	private static final int FRONT = 1;

	public MyPriorityQueue(int maxSize) {
		this.maxSize = maxSize;
		this.size = 0;
		heap = new int[this.maxSize + 1];
		heap[0] = Integer.MAX_VALUE;
	}

	private int parent(int pos) {
		return pos / 2;
	}

	private int leftChild(int pos) {
		return (2 * pos);
	}

	private int rightChild(int pos) {
		return (2 * pos) + 1;
	}

	public void swap(int pos1, int pos2) {
		int temp = heap[pos1];
		heap[pos1] = heap[pos2];
		heap[pos2] = temp;
	}

	public void insertElement(int element) {
		heap[++size] = element;
		int current = size;

		while (heap[current] > heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	private boolean isLeaf(int pos) {
		if (pos >= (size / 2) && pos <= size) {
			return true;
		}
		return false;
	}

	public void maxHeapify(int pos) {

		for (int i = size / 2; i > 1; i--) {
			if(!isLeaf(pos)){
				int leftChild = leftChild(pos);
				int rightChild = rightChild(pos);

				if (heap[leftChild] > heap[rightChild]) {
					if (!(heap[i] > heap[leftChild])) {
						swap(leftChild, pos);
						maxHeapify(leftChild);
					}
				} else {
					if (!(heap[i] > heap[rightChild])) {
						swap(rightChild, pos);
						maxHeapify(rightChild);
					}
				}
			}
		}
	}

	public int remove(){
		int highestElement = heap[FRONT];
		heap[FRONT] = heap[size--];
		maxHeapify(FRONT);
		return highestElement;
	}

	public void print(){
		for (int i = 1; i <= size / 2; i++) {
			System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : "
					+ heap[2 * i] + " RIGHT CHILD :" + heap[2 * i + 1]);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		MyPriorityQueue myPriorityQueue = new MyPriorityQueue(10);

		myPriorityQueue.insertElement(25);
		myPriorityQueue.insertElement(12);
		myPriorityQueue.insertElement(54);
		myPriorityQueue.insertElement(56);
		myPriorityQueue.insertElement(32);
		myPriorityQueue.insertElement(78);

		myPriorityQueue.print();

		System.out.println("Max Element removed : " + myPriorityQueue.remove());

		myPriorityQueue.print();

		System.out.println("Max Element removed : " + myPriorityQueue.remove());

		myPriorityQueue.print();

		System.out.println("Max Element removed : " + myPriorityQueue.remove());

		myPriorityQueue.print();

		System.out.println("Max Element removed : " + myPriorityQueue.remove());

		myPriorityQueue.print();
		
		System.out.println("Max Element removed : " + myPriorityQueue.remove());

		myPriorityQueue.print();

	}
}
