package basic.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastian MA
 * Date: August 21, 2014
 * Time: 10:44
 */
public class TestCountDownLatch {


	public static void main(String... args) {

		CountDownLatch latch = new CountDownLatch(1);
	}

	public static class Passenger implements Runnable {

		Train t;

		public Passenger(Train t) {

			this.t = t;
		}

		@Override
		public void run() {

		}
	}

	public static class Train implements Runnable {

		@Override
		public void run() {

		}
	}
}
