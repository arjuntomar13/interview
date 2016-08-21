package misc;

import java.util.HashSet;
import java.util.Set;

public class Test2 {

	static int numberOfPairs(int[] a, long k) {

        int count = 0;
        Set set = new HashSet();
        
        for(int i=0; i < a.length; i++){
            int num1 = a[i];
            if(set.contains(i)){
            	continue;
            }
            for(int j=i+1; j< a.length; j++){
                int num2 = a[j];
                if((num1 + num2)== k){
                	set.add(j);
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
        return count;
    }

	
	public static void main(String[] args) {
		int[] numbers = { 1, 3, 46, 1, 3, 9 };

		numberOfPairs(numbers, 47);
	}
	
}
