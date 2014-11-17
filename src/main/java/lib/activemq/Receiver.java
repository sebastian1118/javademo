package lib.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastian MA
 * Date: October 27, 2014
 * Time: 11:31
 */
public class Receiver {

	public static void main(String... args) throws JMSException {

		String url = "tcp://localhost:61616";
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		connectionFactory.setUserName("system");
		connectionFactory.setPassword("manager");
		Connection connection = connectionFactory.createConnection();
		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Destination dest = session.createQueue("foo.bar");

		MessageConsumer consumer = session.createConsumer(dest,"");
		while(true) {
			Message msg = consumer.receive();
			if(msg instanceof TextMessage) {
				TextMessage tm = (TextMessage) msg;
				System.out.println(tm.getText());
			}
		}
	}
}
