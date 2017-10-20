package com.devopsbuddy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * 
 * @author Sreenu
 *
 */
@Configuration
public class I18NConfig {

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource resourceBundleMassageSource = new ReloadableResourceBundleMessageSource();
		resourceBundleMassageSource.setBasename("classpath:i18n/messages");
		resourceBundleMassageSource.setCacheSeconds(1800);
		return resourceBundleMassageSource;
	}
}
