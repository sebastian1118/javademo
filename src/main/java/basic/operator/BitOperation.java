package basic.operator;

/**
 * Created with IntelliJ IDEA.
 * User: tian
 * Date: 21/1/14
 * Time: 9:33
 */
public class BitOperation {

	public static void main(String... args) {

		int a = 1;
		int b = 1 << 1;
		int c = 1 << 2;
		int flags = a | b;

		System.out.println(((flags & a) != 0 ? "has" : "no") + " a");
		System.out.println(((flags & b) != 0 ? "has" : "no") + " b");
		System.out.println(((flags & c) != 0 ? "has" : "no") + " c");

	}

}
