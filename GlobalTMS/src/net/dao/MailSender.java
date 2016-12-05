package net.dao;

public interface MailSender {
	public void sendMail(String from, String to, String subject, String msg,String path);

}
