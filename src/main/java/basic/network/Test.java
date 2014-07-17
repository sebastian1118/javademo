package basic.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * User: tian
 * Date: 13-12-15
 * Time: 下午4:50
 */
public class Test {



	public static void main(String[] args) {
		System.out.println("****** START ******");
		ping();

	}

	public static void ping()  {

		String host = "www.baidu.com";
		int timeOut = 5000; //超时应该在3钞以上
		boolean status = false;
		try {
			resolveIpFromDomain(host);
			status = InetAddress.getByName(host).isReachable(timeOut);
			System.out.println(status);
		} catch(IOException e) {
			e.printStackTrace();
		}

	}


	// 取得 www.abc.com 的IP地址
	public static void resolveIpFromDomain(String domain) {

		InetAddress myServer = null;
		try {
			myServer = InetAddress.getByName(domain);
			System.out.println("The Server IP is :" + myServer.getHostAddress());
		} catch(UnknownHostException e) {
		}
	}

}




