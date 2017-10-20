package com.devopsbuddy.web.i18n;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;


/**
 * 
 * @author sreenu
 *
 */
@Service
public class I18NService {
	
	@Autowired
	private MessageSource messageSource;
	
	/**
	 * @param messageId hey key to the message
	 * @return returns the message
	 */
	public String getMessage(String messageId) {
		Locale locale = LocaleContextHolder.getLocale();
		return getMessage(messageId, locale);
	}
	
	/**
	 * @param messageId They key to the message
	 * @param locale The locale
	 * @return return the messge
	 */
	public String getMessage(String messageId, Locale locale) {
		return messageSource.getMessage(messageId, null, locale);
	}

}
