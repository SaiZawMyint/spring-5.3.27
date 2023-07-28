package com.mtm.plan.bl.service;

import com.mtm.plan.web.forms.UserForm;

public interface MailService {

    public void sendMail(String subject, String body, UserForm user);
    
}
