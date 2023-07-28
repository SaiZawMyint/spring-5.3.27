package com.mtm.plan.utils;

import java.util.UUID;

import com.mtm.plan.web.forms.UserForm;

public class TokenUtils {

    public static String generateForgotPasswordToken(UserForm user){
        String token = generateUniqueToken(user.getEmail());
        return token;
    }
    
    private static String generateUniqueToken(String prefix) {
        String uniqueId = UUID.randomUUID().toString();
        String token = prefix + "-" + uniqueId;
        return token;
    }
    
}
