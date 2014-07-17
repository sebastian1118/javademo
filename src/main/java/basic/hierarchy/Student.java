package basic.hierarchy;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: tian
 * Date: 30/12/13
 * Time: 14:15
 */
public class Student extends Person {

	private Student friend;

	public static void main(String... args) {

		Student a = new Student();
		a.setName("stu");
		a.introduce();

		System.out.print(a);

		Student b = new Student();
		a.setFriend(b);


		while(true) {
			System.out.println(genereateOrderId());
		}


	}

	public static String genereateOrderId() {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String prefix = formatter.format(new Date());
		int number = (int) (Math.random() * 1000000);

		return String.format("%s-%06d", prefix, number);
	}

	public void setFriend(Student a) {

		this.friend = a;
		a.friend = this;
	}

	public String toString() {

		return "[" + name + " " + friend + "]";
	}
}
