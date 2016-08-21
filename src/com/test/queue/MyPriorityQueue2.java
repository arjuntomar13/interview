package com.test.queue;

public class MyPriorityQueue2 {

	/*
	 * For node i:
	 * 
	 * parent(i) = i/2
	 * left child of i = 2i
	 * right child of i = 2i + 1
	 * 
	 * maxHeapify : parent >= children 
	 * 
	 * (n/2 +1) to n --- leaves of the heap
	 * 
	 * for max_heapify --- bottoms up approach -- start with node n/2 (floor value) and move to the first element.
	 */
	
	static int size = 5;
	int[] elementArray;
	int counter = 0;

	public MyPriorityQueue2(int [] elementArray){
		this.elementArray = elementArray;
	}
	
	public static void main(String[] args) {
		
		int[] elementArray =new int[size]; 
		
		elementArray[0] = 10;
		elementArray[1] = 12;
		elementArray[2] = 28;
		elementArray[3] = 82;
		elementArray[4] = 68;

		MyPriorityQueue2 myPriorityQueue = new MyPriorityQueue2(elementArray);
		System.out.println("Largest Element : " + myPriorityQueue.extractMax());
	}

	public int extractMax() {
		elementArray = maxHeapify(elementArray);
		int max = elementArray[0];
		return max;
	}

	public int[] maxHeapify(int[] elementArray) {
		int arraySize = elementArray.length;
		for(int i = (arraySize/2-1); i >= 0 ; i--){
			int leftChild = elementArray[i*2+1];
			int rightChild = elementArray[i*2 +2];
			
			if(leftChild > rightChild){
				if(!(elementArray[i] > leftChild)){
					elementArray = exchangeElements((i*2+1), i, elementArray);
				}
			}else{
				if(!(elementArray[i] > rightChild)){
					elementArray = exchangeElements((i*2+2 ), i, elementArray);
				}
			}
		}
		/*for(int i=0; i< 5; i++){
			System.out.println("Elements : " + elementArray[i]);
		}*/
		return elementArray;
	}

	public int[] exchangeElements(int index1, int index2, int[] elementArray) {
		int buffer = elementArray[index1];
		elementArray[index1] = elementArray[index2];
		elementArray[index2] = buffer;
		return elementArray;
	}

	public void deleteMax() {

	}
}