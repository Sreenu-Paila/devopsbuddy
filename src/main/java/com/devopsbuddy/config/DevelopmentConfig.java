package com.devopsbuddy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.devopsbuddy.backend.service.EmailService;
import com.devopsbuddy.backend.service.MockEmailService;

/**
 * 
 * @author sreenu
 *
 */

@Configuration
@Profile("dev")
@PropertySource("file:///${user.home}/sreenu/my_workspace/devopsbuddy/src/main/resources/application-dev.properties")
public class DevelopmentConfig {
	
	public EmailService emailService() {
		return new MockEmailService();
	}

}
