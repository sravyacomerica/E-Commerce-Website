package unt.cse.studentsurplus.service;
/**
 * 
 * @author Sri Sravya Tirupachur Comerica 
 *              // Sends an email to the seller
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailSenderServiceImpl implements MailSenderService
{
    @Autowired
    private MailSender mailSender;
    
    public void setMailSender(MailSender mailSender) {  
        this.mailSender = mailSender;  
    }      
     
    /**
     * This method will send compose and send the message
     * */
    public void sendMail(String to, String subject, String body)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }

}
