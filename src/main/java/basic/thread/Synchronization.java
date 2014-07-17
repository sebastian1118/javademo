package basic.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastian MA
 * Date: March 01, 2014
 * Time: 21:46
 */
public class Synchronization {


	public static void main(String... args) throws InterruptedException {

		final ArrayList<String> lock = new ArrayList<>();
		lock.add("1");
		lock.add("2");


		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {

				System.out.println(new Date().toString() + " thread 1 try to get lock");
				synchronized(lock) {
					System.out.println(lock.size());
					System.out.println(new Date().toString() + " thread 1 get lock");

					synchronized(lock) {
						System.out.println(new Date().toString() + " thread 1 get lock again");
					}
					try {
						Thread.sleep(10000);
					} catch(InterruptedException e) {
					}
					System.out.println(new Date().toString() + " thread 1 release lock");
				}
			}
		});
		thread1.start();

		Thread.sleep(500);


		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {

				lock.add("3");
				System.out.println(new Date().toString() + " thread 2 try to get lock");
				synchronized(lock) {
					System.out.println(lock.size());
					System.out.println(new Date().toString() + " thread 2 get lock");
					System.out.println(new Date().toString() + " thread 2 release lock");
				}
			}
		});
		thread2.start();
	}


	public static class TestObject {

		private final Object a = new Object();

		public void printA() {

			synchronized(a) {
				System.out.println("A");
				try {
					Thread.sleep(10000);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		public synchronized void printB() {

			System.out.println("B");
		}
	}


}
