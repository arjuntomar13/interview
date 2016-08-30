package misc;

public class TestOverriding extends TestSuper{

	public static void testStaticOverriding(int test){
		System.out.println("Child static method");
	}
	
	public static void main(String args[]){
		
		/*boolean isNeg = false;
		String test = "1-3";
		String[] testArr = test.split("-");
		for (String string : testArr) {
			
			if(string.equals("")){
				isNeg = true;
			}else{
				if(isNeg){
					System.out.println(-1 * Integer.parseInt(string));
					isNeg = false;
				}else{
					System.out.println(Integer.parseInt(string));
				}
			}
		}*/
		
		    Super superRef =new Sub();
		    Sub subRef = new Sub();
		    Super suRef=new Super();
		    
		    superRef.tests();
		    subRef.tests();
		    suRef.tests();

	}
}