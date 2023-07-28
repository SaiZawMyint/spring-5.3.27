package com.mtm.plan.utils;

import org.springframework.stereotype.Component;

@Component
public class EmailUtils {

    public String mailTemplateForPasswordReset(String recipientName, String recipentEmail,String link) {
        return "<h2>Password Reset Request</h2>\r\n"
                + "<p>Dear "+recipientName+",</p>\r\n"
                + "<p>We have received a request to reset your password for your account associated with our website. To proceed with the password reset, please click on the button below:</p>\r\n"
                + "<p><a class=\"button\" href=\""+link+"\">Reset Password</a></p>\r\n"
                + "<p>If the above button does not work, you can also copy and paste the following URL into your web browser:</p>\r\n"
                + "<p>"+link+"</p>\r\n"
                + "<p>Please note that this password reset link is valid for a limited time period. If you did not request a password reset, you can ignore this email and your account will remain secure.</p>\r\n"
                + "<p>If you have any further questions or need assistance, please feel free to contact our support team at [Support Email Address].</p>\r\n"
                + "<p>Thank you and best regards,</p>\r\n"
                + "<p>[Admin]</p>";
    }
    
}
