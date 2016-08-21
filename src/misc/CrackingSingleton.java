package misc;

import java.lang.reflect.InvocationTargetException;

public class CrackingSingleton {

	public static void main(String[] args) throws ClassNotFoundException,
			IllegalArgumentException, SecurityException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {

		/*
		 * //First statement retrieves the Constructor object for private
		 * constructor of SimpleSingleton class. Constructor<?> pvtConstructor =
		 * Class
		 * .forName("CrackingSingleton.SingletonObject").getDeclaredConstructors
		 * ()[0]; //Since the constructor retrieved is a private one, we need to
		 * set its accessibility to true. pvtConstructor.setAccessible(true);
		 * //Last statement invokes the private constructor and create a new
		 * instance of SimpleSingleton class. SingletonObject notSingleton1 = (
		 * SingletonObject) pvtConstructor.newInstance(null);
		 * System.out.println(notSingleton1.hashCode());
		 * System.out.println("notSingleton1 --->"+notSingleton1.toString());
		 * SingletonObject notSingleton2 = ( SingletonObject)
		 * pvtConstructor.newInstance(null);
		 * System.out.println("notSingleton2 --->"+notSingleton2.hashCode());
		 * System.out.println(notSingleton2.toString());
		 */

		/*BigDecimal d1 = new BigDecimal(0.1);
		BigDecimal d2 = new BigDecimal(3);
		BigDecimal res = d1.multiply(d2);
		BigDecimal d3 = new BigDecimal(0.3);
		System.out.println(res);
		System.out.println(res.compareTo(d3));
*/		/*
		 * if(res.compareTo(d3)){ System.out.println(true); }else{
		 * System.out.println(false); }
		 */
	}
}
