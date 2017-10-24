package com.devopsbuddy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.devopsbuddy.backend.service.EmailService;
import com.devopsbuddy.backend.service.SmtpEmailService;

/**
 * 
 * @author sreenu
 *
 */

@Configuration
@Profile("prod")
@PropertySource("file:///${user.home}/sreenu/my_workspace/devopsbuddy/src/main/resources/application-prod.properties")
public class ProductionConfig {
	
	public EmailService emailService() {
		return new SmtpEmailService();
	}

}
