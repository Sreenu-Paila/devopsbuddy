package com.devopsbuddy.utils;

import com.devopsbuddy.backend.persistence.domain.backend.User;
import com.devopsbuddy.web.controllers.ForgotMyPassworldController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by sreeu on 3-11-2017.
 */
public class UserUtils {

    private UserUtils() {
        throw new AssertionError("Non Instantiable");
    }

    /**
     * Create a user with basic user information
     *
     * @param username User name
     * @param email    Password
     * @return
     */
    public static User createBasicUser(String username, String email) {
        User user = new User();
        user.setUsername(username);
        user.setPassword("secret");
        user.setEmail(email);
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setCountry("NL");
        user.setEnabled(true);
        user.setDescription("Basic User");
        user.setProfileImageUrl("...");

        return user;
    }

    /**
     * Buils and return the URL to reset the user password
     *
     * @param request
     * @param userId
     * @param token
     * @return
     */
    public static String createPasswordResetUrl(HttpServletRequest request, long userId, String token) {
        String passwordResetUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() +
                request.getContextPath() +
                ForgotMyPassworldController.CHANGE_PASSWORD_PATH +
                "?id=" + userId + "&token=" + token;
        return passwordResetUrl;
    }
}
