package bit.manipulation;

public class FirstMnumbersWith2SetBits {

	static void printFirstMnumbers(int n) {
		int count = 0;
		int num = 0;
		while (count < n) {
			if(getSetBits(num) == 2){
				count++;
				System.out.print(num + " ");
			}
			num++;
		}
		System.out.println();
	}

	static int getSetBits(int n) {
		int count = 0;
		while (n > 0) {
			n &= (n - 1);
			count++;
		}
		return count;
	}
	
	static void betterMethod(int n){
		int x = 1;
		while(n > 0){
			int y = 0;
			while(y < x){
				int a = 1 << x;
				int b = 1 << y;
				System.out.print((a + b) + " ");
				n--;
				if(n == 0){
					System.out.println();
					return;
				}
				y++;
			}
			x++;
		}
	}

	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		printFirstMnumbers(25);
		System.out.println(System.currentTimeMillis());
		betterMethod(50);
		System.out.println(System.currentTimeMillis());
	}
}
