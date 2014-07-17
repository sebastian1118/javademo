package basic.thread;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastian MA
 * Date: April 24, 2014
 * Time: 16:08
 */
public class ProducerConsumer {


	public static void main(String... args) {

		ArrayBlockingQueue<Double> queue = new ArrayBlockingQueue<>(5000);

		Runnable producer = new Runnable() {

			@Override
			public void run() {

				while(true) {
					try {
						queue.put(Math.random());
						Thread.sleep(50);
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();
		new Thread(producer).start();

		new Thread(new Runnable() {

			@Override
			public void run() {

				while(true) {
					ArrayList<Double> result = new ArrayList<>();
					int size = queue.drainTo(result);
					System.out.println(size + " items drained");
					try {
						Thread.sleep(2000);
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}


}
