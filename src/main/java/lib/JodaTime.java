package lib;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastian MA
 * Date: July 29, 2014
 * Time: 9:42
 */
public class JodaTime {


	public static void main(String... args) {

		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH");
		System.out.println(formatter.print(System.currentTimeMillis()));
	}
}
