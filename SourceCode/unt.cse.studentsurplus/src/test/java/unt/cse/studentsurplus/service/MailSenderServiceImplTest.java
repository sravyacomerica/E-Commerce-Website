package unt.cse.studentsurplus.service;

/**
 * 
 * @author haidi chen 
 *
 */
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

@RunWith(MockitoJUnitRunner.class)
public class MailSenderServiceImplTest {

	@Mock
	MailSender mailSender;

	@InjectMocks
	MailSenderServiceImpl msService;

	@Test
	public void testSendMail() {
		/*
		 * SimpleMailMessage message = new SimpleMailMessage();
		 * doNothing().when(mailSender).send(message); msService.sendMail("", null,
		 * null); verify(mailSender).send(message);
		 */
		msService.sendMail("test@test.com", "subject", "body");
	}

}
