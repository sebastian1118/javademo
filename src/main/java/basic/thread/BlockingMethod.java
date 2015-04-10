package basic.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastian MA
 * Date: December 05, 2014
 * Time: 15:27
 */
public class BlockingMethod {

	List<Object> list = new ArrayList<>();

	public void blockingMethod() {

		Object object = new Object();
		new Thread(() -> {
			try {
				Thread.sleep(5000);
				synchronized(object) {
					object.notify();
				}
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		});

		System.out.println("Thread: " + Thread.currentThread().getName() + " accessing " +
				"blockingMethod");

		synchronized(object) {
			try {
				object.wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Thread: " + Thread.currentThread().getName() + " return from " +
				"blockingMethod");
	}


	public static void main(String... args) {

		BlockingMethod object = new BlockingMethod();
		new Thread(object::blockingMethod).start();
		new Thread(object::blockingMethod).start();
		new Thread(object::blockingMethod).start();
		new Thread(object::blockingMethod).start();

	}
}
