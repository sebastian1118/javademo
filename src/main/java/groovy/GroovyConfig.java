package groovy;


import groovy.util.ConfigObject;
import groovy.util.ConfigSlurper;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastian MA
 * Date: November 12, 2014
 * Time: 13:43
 */
public class GroovyConfig {

	public static void main(String... args) throws IOException {

		URL url = new URL("http://dev.eggcharge.com:8080/conf/config.groovy");

		//		URLConnection connection = url.openConnection();
		//
		//		connection.connect();
		//		OutputStream out = connection.getOutputStream();
		//		ConfigObject conf
		//				= new ConfigSlurper().pa


		ConfigObject conf
				= new ConfigSlurper().parse(url);
		final Map config = conf.flatten();

		//
		System.out.println(config.get("config.debug"));
		//		assert new Integer(20).equals(config.get("app.setting2"));
		//		assert new Date().after((Date) config.get("app.date"));
		//		assert "http://localhost".equals(config.get("server.URL"));
		//		assert "smtpservername".equals(config.get("mail.smtp.host"));
	}
}
