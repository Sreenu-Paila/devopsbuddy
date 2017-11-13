package com.devopsbuddy.test.unit;

import com.devopsbuddy.DevopsbuddyApplication;
import com.devopsbuddy.utils.UserUtils;
import com.devopsbuddy.web.controllers.ForgotMyPasswordController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * Created by sreenu on 10-11-2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DevopsbuddyApplication.class)
public class UserUtilsUnitTest {

    private MockHttpServletRequest mockHttpServletRequest;

    @Before
    public void init() {
        mockHttpServletRequest = new MockHttpServletRequest();
    }

    @Test
    public void testPasswordResetEmailUrlConstruction() throws Exception {
        mockHttpServletRequest.setServerPort(9080);
        String token = UUID.randomUUID().toString();
        long userId = 12345;
        String expectedUrl = "http://localhost:9080" + ForgotMyPasswordController.CHANGE_PASSWORD_PATH + "?id=" + userId + "&token=" + token;
        String actualUrl = UserUtils.createPasswordResetUrl(mockHttpServletRequest, userId, token);
        Assert.assertEquals(expectedUrl, actualUrl);
    }
}
