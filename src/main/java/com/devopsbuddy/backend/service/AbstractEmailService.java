package com.devopsbuddy.backend.service;

import com.devopsbuddy.web.controllers.ContactController;
import com.devopsbuddy.web.domain.frontend.FeedbackPojo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 * @author sreenu
 */
@Service("emailService")
public class AbstractEmailService implements EmailService {
	/** The application logger */
	private static final Logger LOG = LoggerFactory.getLogger(ContactController.class);
	@Value("${default.to.address}")
	private String defaultToAddress;

	/**
	 * Creates a Simple Mail Message from a Feedback Pojo.
	 * 
	 * @param feedback
	 *            The Feedback pojo
	 * @return
	 */
	protected SimpleMailMessage prepareSimpleMailMessageFromFeedbackPojo(FeedbackPojo feedback) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(defaultToAddress);
		message.setFrom(feedback.getEmail());
		message.setReplyTo(feedback.getEmail());
		message.setSubject("[DevOps Buddy]: Feedback received from " + feedback.getFirstName() + " "
				+ feedback.getLastName() + "!");
		message.setText("User with email: " + feedback.getEmail() + " left this feedback:\n" + feedback.getFeedback());
		LOG.debug("Mail  POJO content: {}", message);
		return message;
	}

	@Override
	public void sendFeedbackEmail(FeedbackPojo feedbackPojo) {
		sendGenericEmailMessage(prepareSimpleMailMessageFromFeedbackPojo(feedbackPojo));
	}

	@Override
	public void sendGenericEmailMessage(SimpleMailMessage message) {
		
	}
}