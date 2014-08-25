package basic.collection;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastian MA
 * Date: August 21, 2014
 * Time: 16:10
 */
public class NullableList {

	public static void main(String... args){

		ArrayList<String> list = new ArrayList<>();
		list.add(null);
		list.add("null");
		list.add("null");
		list.add(null);
		System.out.println(list.size());
	}
}
