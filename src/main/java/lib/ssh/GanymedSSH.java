package lib.ssh;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SFTPv3Client;
import ch.ethz.ssh2.SFTPv3FileHandle;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastian MA
 * Date: December 30, 2014
 * Time: 14:00
 */
public class GanymedSSH {

	public static void main(String... args) {

		byte[] bb = { 1, 1, 1 };
		Connection conn = new Connection("dev.eggcharge.com");
		try {
			conn.connect();
			conn.authenticateWithPassword("admin", "admin");
			SFTPv3Client client = new SFTPv3Client(conn);
			SFTPv3FileHandle file = client.createFile("/tmp/hello.txt");
			client.write(file, 0, bb, 0, bb.length);
		} catch(IOException e) {
			e.printStackTrace();
		}


	}
}
