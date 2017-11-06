package com.devopsbuddy.utils;

import com.devopsbuddy.backend.persistence.domain.backend.User;

/**
 * Created by sreeu on 3-11-2017.
 */
public class UserUtils {

    private UserUtils(){
        throw new AssertionError("Non Instantiable");
    }

    public static User createBasicUser(){
        User user = new User();
        user.setUsername("basicUser");
        user.setPassword("secret");
        user.setEmail("sample@example.com");
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setCountry("NL");
        user.setEnabled(true);
        user.setDescription("Basic User");
        user.setProfileImageUrl("...");

        return user;
    }
}
