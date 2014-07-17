package basic.operator;


import basic.hierarchy.Person;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: tian
 * Date: 20/1/14
 * Time: 15:00
 */
public class PlusPlus {

	public static void main(String... args) {

		int a = 0;
		System.out.println(a++);
		System.out.println(++a);

		System.out.println(UUID.nameUUIDFromBytes("1234".getBytes()));
		System.out.println(UUID.nameUUIDFromBytes("1234".getBytes()));

		try {
			Person p = (Person) Class.forName("demo.basic.hierarchy.Student").newInstance();
			String cc = (String) p.getClass().getMethod("say_" + "jd", String.class, String.class,
					int.class).invoke(p, "a", "b", 1);
			System.out.println(cc);
			int ab = 0;
		} catch(InstantiationException | IllegalAccessException | ClassNotFoundException |
				InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}


	}
}
