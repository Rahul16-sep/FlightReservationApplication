package com.rahul.flightReservation.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.rahul.flightReservation.service.ReservationServiceImpl;

@Component
public class EmailUtil {
	
	@Value("${com.rahul.flightReservation.itinerary.email.body}")
	private String EMAIL_BODY;

	@Value("${com.rahul.flightReservation.itinerary.email.subject}")
	private  String EMAIL_SUBJECT;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendIteranary(String toAddress, String filePath) {
		LOGGER.info("Inside sendIteranary()");
		
		MimeMessage message = mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message,true);
			helper.setTo(toAddress);
			helper.setSubject(EMAIL_SUBJECT);
			helper.setText(EMAIL_BODY);
			helper.addAttachment("Ticket", new File(filePath));
			mailSender.send(message);
		} catch (MessagingException e) {
			LOGGER.error("Exception inside sendIteranary()"+e);
			e.printStackTrace();
		}
		
	}

}
