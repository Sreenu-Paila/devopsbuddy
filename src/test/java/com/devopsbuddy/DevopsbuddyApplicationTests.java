package com.devopsbuddy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.devopsbuddy.web.i18n.I18NService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DevopsbuddyApplication.class)
@WebAppConfiguration
public class DevopsbuddyApplicationTests {

	@Autowired
	private I18NService i18nService;

	@Test
	public void testMessageByLocaleService() throws Exception {
		String expectedResult = "Bootstrap starter template";
		String messageId = "index.main.callout";
		String actual = i18nService.getMessage(messageId);
		Assert.assertEquals("The actual and expected String don't match", expectedResult, actual);
	}

}
