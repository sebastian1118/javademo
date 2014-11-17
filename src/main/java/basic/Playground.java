package basic;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastian MA
 * Date: August 19, 2014
 * Time: 9:43
 */
public class Playground {

	public static void main(String... args) {

		test("name", "name", "name", "name", "name");
	}


	public static void test(Object name, Object... values) {

		System.out.println(name);
		for(Object o : values) {
			System.out.println(o);
		}


	}
}
