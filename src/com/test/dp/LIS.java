package com.test.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LIS {

	static void findLIS1(int[] arr){

		// Preparing active lists for getting longest increasing sequence
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		list.add(arr[0]);
		set.add(list);
		for(int i=1; i < arr.length ; i++){
			List<Integer> newList = new ArrayList<Integer>();
			Iterator<List<Integer>> itr1 = set.iterator();
			if(itr1.hasNext()){
				List<Integer> tempList = (List<Integer>)itr1.next();
				for (Integer val : tempList) {
					if(val < arr[i]){
						newList.add(val);
					}
				}
			}
			newList.add(arr[i]);
			set.add(newList);
			
			Set<List<Integer>> tempSet = new HashSet<List<Integer>>();
			Iterator<List<Integer>> itr = set.iterator();
			while(itr.hasNext()){
				List<Integer> tempList = (List<Integer>)itr.next();
				List<Integer> newList1 = new ArrayList<>();
				newList1 = tempList;
				if(tempList.get(tempList.size()-1) < arr[i]){
					newList1.add(arr[i]);
				}
				tempSet.add(newList1);
			}
			set = tempSet;
		}

		//use the active lists created above to get the max length 
		List<Integer> longestList = null;
		int longestLength = 0;
		Iterator<List<Integer>> itr = set.iterator();

		while(itr.hasNext()){
			List<Integer> tempList = (List<Integer>)itr.next();
			if(tempList.size() > longestLength){
				longestLength = tempList.size();
				longestList = tempList;
			}
		}

		System.out.println("Longest Length : " + longestLength);
		for (Integer val : longestList) {
			System.out.print(val + " ");
		}
	}

	public static void main(String[] args) {
		int[] arr = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15, 23, 1, 45, 32,105, 324 };
		int[] arr1 = { 10, 22,9,33,21,50,41,60,80 };
		//		System.out.println(LongestIncreasingSubsequenceLength(arr, arr.length));
		findLIS1(arr);

	}

	// Below methods give the length correct but not the sequence
	static int CeilIndex(int A[], int l, int r, int key)
	{
		while (r - l > 1)
		{
			int m = l + (r - l)/2;
			if (A[m]>=key)
				r = m;
			else
				l = m;
		}

		return r;
	}

	static int LongestIncreasingSubsequenceLength(int A[], int size)
	{
		// Add boundary case, when array size is one

		int[] tailTable   = new int[size];
		int len; // always points empty slot

		tailTable[0] = A[0];
		len = 1;
		for (int i = 1; i < size; i++)
		{
			if (A[i] < tailTable[0])
				// new smallest value
				tailTable[0] = A[i];

			else if (A[i] > tailTable[len-1])
				// A[i] wants to extend largest subsequence
				tailTable[len++] = A[i];

			else
				// A[i] wants to be current end candidate of an existing
				// subsequence. It will replace ceil value in tailTable
				tailTable[CeilIndex(tailTable, -1, len-1, A[i])] = A[i];
		}

		return len;
	}
}
