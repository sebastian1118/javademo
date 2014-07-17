package basic.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: tian
 * Date: 21/1/14
 * Time: 13:35
 */
public class TcpServer {

	public static void main(String... args) {

		try {
			ServerSocket socket = new ServerSocket(10000);
			while(true) {
				Socket s = socket.accept();
				InputStream in = s.getInputStream();
				OutputStream out = s.getOutputStream();

				byte[] buffer = new byte[100];
				int size = in.read(buffer);
				if(size != -1) {
					String str = new String(buffer);
					System.out.println("Received: " + str);
					s.close();
				}

			}
		} catch(IOException e) {
			e.printStackTrace();
		}

	}
}
