package com.devopsbuddy.utils;

import com.devopsbuddy.backend.persistence.domain.backend.User;

/**
 * Created by sreeu on 3-11-2017.
 */
public class UserUtils {

    private UserUtils(){
        throw new AssertionError("Non Instantiable");
    }

    /**
     * Create a user with basic user information
     * @param username User name
     * @param email Password
     * @return
     */
    public static User createBasicUser(String username, String email){
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
}
