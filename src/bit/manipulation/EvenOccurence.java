package bit.manipulation;

import java.util.BitSet;

public class EvenOccurence {

	static void findEven(int[] arr){
		
		BitSet bitset = new BitSet();
		
		for (int i = 0; i < 64; i++) {
			bitset.set(i, false);
		}
		
		for (int i : arr) {
			if(bitset.get(i)){
				bitset.set(i, false);
			}else{
				bitset.set(i, true);
			}
		}
		
		for (int i = 0; i < 64; i++) {
			if(bitset.get(i)){
				System.out.print(i + " ");
			}
		}
		
	}
	
	public static void main(String[] args) {
		int[] arr = {2,3,4,5,6,7,8,9,2,3,4,4,5,5,6,6,7,7,8,8,9,9};
		findEven(arr);
		
	}
}
