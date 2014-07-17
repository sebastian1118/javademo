package basic.hierarchy;

/**
 * Created with IntelliJ IDEA.
 * User: tian
 * Date: 30/12/13
 * Time: 14:14
 */
public class Person {


	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	protected String name;

	public void introduce() {

		System.out.println("I'm " + name);
		System.out.println(this.getClass().getSimpleName());
	}

	public String say_jd(String a, String b, int c) {

		System.out.println(a + b + c);
		return a + b + c;
	}

}
