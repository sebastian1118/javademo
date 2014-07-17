package basic.thread;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastian MA
 * Date: February 23, 2014
 * Time: 16:38
 */
public class StopThread {

	public static void main(String... args) {

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {


				for(int i = 0; i <= 1000000; i++) {
					System.out.println(i);
				}
			}
		}
		);

		thread.start();


	}
}
