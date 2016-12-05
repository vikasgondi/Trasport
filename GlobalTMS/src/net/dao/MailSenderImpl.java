package net.dao;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Repository;
@Repository("mailsender")
public class MailSenderImpl implements MailSender {

	@Autowired
	private JavaMailSender mail;
	@Override
	public void sendMail(String from, String to, String subject, String msg,
			String path) {
		// TODO Auto-generated method stub
		MimeMessage message = mail.createMimeMessage();

		   try{
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject("Booking"+subject);
			helper.setText(msg);

			FileSystemResource file = new FileSystemResource(path);
			helper.addAttachment(file.getFilename(), file);

		     }catch (MessagingException e) {
			throw new MailParseException(e);
		     }
			/*message.setFrom(from);
			message.setTo(to);
			message.setSubject(subject);
			message.setText(msg);*/
			
		  
			mail.send(message);	
			System.out.println("Mail Sent Successfully...!");
		
	}

}
