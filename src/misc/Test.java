package misc;


public class Test{

	public Test(){
		System.out.println("I am here too in child");
	}
	
	public void getNonStatic(){
		System.out.println("Child");
	}
	
	public static void getStatic(){
		System.out.println("Child");
	}
	
	/*public String getSomething(){
		return "Child returns";
	}*/
	
	public Integer getSomething(int a){
		return 2;
	}
	
	public String getSomething(String a) {
		System.out.println("Child");
		
		return "Super Return";
	}
	
	public String getString(){
		String a = "xyz";
		
		try{
			for(int i = 0; i < 5 ; i++){

				a = a + i;
				if(i == 3){
					System.out.println("i = 3");
					int b = 1/0;
				}else{
					System.out.println("Fine" + i);
				}
			}
		}catch(Exception e){
//			System.out.println(e.getMessage());
		}
		finally{
//			return "abc";
		}
		return a;
	}
	
	public static void main(String[] args) {
		/*TestSuper test = new TestSuper();
		TestSuper test1 = new Test();
		Test test2 = new Test();
		Test t = null;
		test1.getSomething("");*/
		
		Test test = new Test();
		
		String a = test.getString();
		
		System.out.println(a);
	}
}