package basic.toolkit;

/**
 * Created with IntelliJ IDEA.
 * User: tian
 * Date: 27/1/14
 * Time: 10:44
 */
public class StringToolkit {


	/**
	 * a=1, b=2
	 */
	public static String list(String pointer, String separator, Object... list) {

		StringBuilder buffer = new StringBuilder();

		boolean title = true;
		boolean firtElement = true;
		for(Object aList : list) {

			if(!firtElement && title) {
				buffer.append(separator);
			} else {
				firtElement = false;
			}
			buffer.append(aList);
			if(title) {
				buffer.append(pointer);
			}
			title = !title;

		}

		return buffer.toString();
	}

	public static void main(String... args) {

		System.out.println(list("->", ", ", "a", 1, "b", 2));
	}
}
