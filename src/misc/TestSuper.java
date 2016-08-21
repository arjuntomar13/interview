package misc;

public class TestSuper {

	public TestSuper(){
		System.out.println("I am Super");
	}
	
	public static void main(String[] args) {
		int a = 11;
		
		if((a & 1) == 1){
			System.out.println("Number is odd");
		}else{
			System.out.println("Number id even");
		}
	}
	
}
