package misc;

public class TestSuper {

	public TestSuper() {
		System.out.println("I am Super");
	}
	
	public static void testStaticOverriding(int test){
		System.out.println("Parent static method");
	}

	public static void main(String[] args) {
		int a = 2, b = 3;
		if (a == 3)
			if (b == 3)
				System.out.println("===============");
			else
				System.out.println("#################");
		System.out.println("&&&&&&&&&&&");
	}

}
