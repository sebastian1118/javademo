package basic.thread;


/**
 * Created with IntelliJ IDEA.
 * User: Sebastian MA
 * Date: March 07, 2014
 * Time: 13:11
 */
public class Sync {

	public static void main(String... args) {

		final Synchronization.TestObject obj = new Synchronization.TestObject();

		Thread a = new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					Thread.sleep(1000);
					obj.printB();
				} catch(InterruptedException e) {
					e.printStackTrace();
				}

			}
		});
		a.start();

		obj.printA();

	}
}
