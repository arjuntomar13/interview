package misc;


public class Binary {

	public void decimalToBinary(int num){
	     int binary[] = new int[40];
	     int index = 0;
	     while(num > 0){
	       binary[index++] = num%2;
	       num = num/2;
	     }
	     for(int i = index-1;i >= 0;i--){
	       System.out.print(binary[i]);
	     }
	  }
	
	public int binaryToDecimal(int binary){
		 
	    int decimal = 0;
	    int p = 0;
	    while(true){
	      if(binary == 0){
	        break;
	      } else {
	          int temp = binary%10;
	          decimal += temp*Math.pow(2, p);
	          binary = binary/10;
	          p++;
	       }
	    }
	    return decimal;
	  }
	
	public static void main(String[] args) {
		Binary binary = new Binary();
		binary.decimalToBinary(45);
	    System.out.println("110 --> "+binary.binaryToDecimal(110));
	}
	
	/*public static void main(String[] args) 
	  { 
	    Scanner in = new Scanner(System.in);
	 
	    // Create Stack object
	    Stack<Integer> stack = new Stack<Integer>();
	 
	    // User input 
	    System.out.println("Enter decimal number: ");
	    int num = in.nextInt();
	 
	    while (num != 0)
	    {
	      int d = num % 2;
	      stack.push(d);
	      num /= 2;
	    } 
	 
	    System.out.print("\nBinary representation is:");
	    while (!(stack.isEmpty() ))
	    {
	      System.out.print(stack.pop());
	    }
	    System.out.println();
	  }*/
}
