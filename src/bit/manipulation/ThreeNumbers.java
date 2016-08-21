package bit.manipulation;

public class ThreeNumbers {

	static int findSingle(int[] arr){
		int result = 0;
		int len = arr.length;
		for(int i=0; i < 32; i++){
			int sum =0;
			int x = (1 << i);
			for(int j =0; j < len; j++){
				if((arr[j] & x) == x){
					sum++;
				}
			}
			if(sum % 3 == 1){
				result |= x;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = {3,3,3,4,4,4,5,5,5,6,6,6,7,8,8,8};
		System.out.println(findSingle(arr));
	}
}
