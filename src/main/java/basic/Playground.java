package basic;

import java.lang.management.ManagementFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastian MA
 * Date: August 19, 2014
 * Time: 9:43
 */
public class Playground {

	public static void main(String... args) {


		String name = ManagementFactory.getRuntimeMXBean().getName();
		System.out.println(name);
		// get pid
		String pid = name.split("@")[0];
		System.out.println("Pid is:" + pid);

		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			System.out.println("going to shutdown");
		}));

	}


}
