package lib.javamail;

import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created with IntelliJ IDEA.
 * User: Sebastian MA
 * Date: December 26, 2014
 * Time: 15:55
 */
public class Playground {

	public static void main(String... args) {

		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost("smtp.exmail.qq.com");
		sender.setPort(25);
		sender.setUsername("eggcharge@uming.net");
		sender.setPassword("prandpower123");


		MimeMessage mailMessage = sender.createMimeMessage();

		MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, "UTF-8");
		try {
			// 设置收件人，寄件人
			messageHelper.setFrom("eggcharge@uming.net");

			messageHelper.setTo("matian85@foxmail.com");

			messageHelper.setSubject("subject");

			String content = "hello";

			messageHelper.setText(content, true);// true 表示启动HTML格式的邮件
			sender.send(mailMessage);
		} catch(MailAuthenticationException e) {
			System.out.println(e.getMessage());
		} catch(MessagingException e) {
			e.printStackTrace();
		}

		System.out.println("end");
	}


}
