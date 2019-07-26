package unt.cse.studentsurplus.service;
/**
 * 
 * @author Sri Sravya Tirupachur Comerica 
 *              // Interface for mail sending feature
 *
 */
import org.springframework.mail.MailSender;

public interface MailSenderService {
	public void setMailSender(MailSender mailSender);
	 public void sendMail(String to, String subject, String body);
	
}
