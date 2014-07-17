package basic.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: tian
 * Date: 26/1/14
 * Time: 10:51
 */
public class ThreadPoolExecutor {

	public static void main(String... args) {

		ExecutorService executor = Executors.newFixedThreadPool(5);
		for(int i = 0; i < 10; i++) {
			Runnable worker = new Worker("" + i);
			executor.execute(worker);
		}
		executor.shutdown();
		while(!executor.isTerminated()) {
		}
		System.out.println("Finished all threads");
	}

	static public class Worker implements Runnable {

		private String command;

		public Worker(String s) {

			this.command = s;
		}

		@Override
		public void run() {

			System.out.println(Thread.currentThread().getName() + " Start. Command = " + command);
			processCommand();
			System.out.println(Thread.currentThread().getName() + " End.");
		}

		private void processCommand() {

			try {
				Thread.sleep(5000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}

		@Override
		public String toString() {

			return this.command;
		}
	}
}
