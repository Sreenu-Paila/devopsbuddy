package com.devopsbuddy.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.devopsbuddy.backend.service.EmailService;
import com.devopsbuddy.backend.service.MockEmailService;

import java.io.Serializable;

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

	public ServletRegistrationBean  h2ConsoleServletRegistration(){
		ServletRegistrationBean bean = new ServletRegistrationBean();
		bean.addUrlMappings("/console/*");
		return bean;
	}

}
