package com.test;

import java.util.*;

public class Interview {

	public static void main(String[] args) {
		

	}
	
	public static int findRep(int A[])
	{
		Map<Integer,Integer> myMap = new HashMap();
		int count=0,result=-1;
		for(int i=0;i<A.length;i++)
		{
			if(!myMap.containsKey(A[i]))
			{
				myMap.put(A[i], count+1);
			}
			else
			{
				result=A[i];
				break;
			}
		}
		return result;
	}
}