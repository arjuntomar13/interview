package misc;

public class OnlyTest {

	private String test;
	
	public OnlyTest(){
		
	}
	
	public OnlyTest(String test){
		this.test = test;
	}
	
	public static void main(String[] args) {
		OnlyTest onlyTest = new OnlyTest();
		
		System.out.println(Double.MIN_VALUE);
		System.out.println(Math.min(Double.MIN_VALUE, 0.0d));
	}
	
}
