package basic.network;

import java.nio.ByteBuffer;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastian MA
 * Date: September 06, 2014
 * Time: 17:42
 */
public class ByteBufferDemo {

	public static void main(String... args) {

		ByteBuffer buffer = ByteBuffer.allocate(1024);
		buffer.put((byte) 255);
		buffer.put((byte) 255);
		buffer.put((byte) 222);

		buffer.flip();
		System.out.println(Integer.toHexString(buffer.get() & 0xFF));
		System.out.println(Integer.toHexString(buffer.get() & 0xFF));
		System.out.println(Integer.toHexString(buffer.get() & 0xFF));


	}

}
