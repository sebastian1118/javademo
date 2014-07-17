package basic.network;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: tian
 * Date: 21/1/14
 * Time: 13:22
 */
public class TcpClient {

	public static void main(String... args) {

		Socket socket = new Socket();
		try {
			socket.connect(new InetSocketAddress("localhost", 10000));
			OutputStream out = socket.getOutputStream();
			out.write("hello world".getBytes());
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
