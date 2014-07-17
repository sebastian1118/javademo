package basic.thread;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: tian
 * Date: 15/1/14
 * Time: 11:12
 */
public class WakeSleepingThread {


	public static void main(String[] args) {

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {

				while(true) {
					System.out.println(UUID.randomUUID());
					try {
						Thread.sleep(10000);
					} catch(InterruptedException e) {
						System.out.println(Thread.currentThread().getName() + " waken by main demo.thread");
					}
				}
			}
		});
		t.setName("Sub demo.thread");
		t.start();

		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		t.interrupt();
	}
}
