package basic.bytes;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastian MA
 * Date: March 27, 2014
 * Time: 12:52
 */
public class Utf8Character {

	public static void main(String... args) {

		//chinese character take 3 bytes, ascii take 1.
		String string = "索尼";
		System.out.println(string.length() == string.getBytes().length);
		for(byte b : string.getBytes()) {
			System.out.print(b + " ");
		}

		System.out.println("1" + "hello".contains(""));
		System.out.println("hello world".replace(" ", ".*"));


	}
}
