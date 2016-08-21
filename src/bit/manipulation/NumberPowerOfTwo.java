package bit.manipulation;

import java.util.concurrent.Semaphore;

public class NumberPowerOfTwo {

	static int findPow(int num){
		int count = 0;
		
		while(num > 0){
			num = num & (num -1);
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int num = 12;
		int setBitCount = findPow(num);
		if(setBitCount == 1){
			System.out.println("The number : " + num + " is a power of 2");
			System.out.println("The number of set bits are : " + setBitCount);
		}else{
			System.out.println("The number : " + num + " is not a power of 2");
			System.out.println("The number of set bits are : " + setBitCount);
		}
	}
	
}
