package com.mtm.plan.bl.service;

import com.mtm.plan.bl.dto.UserDTO;
import com.mtm.plan.web.forms.UserForm;

public interface TokenService {

    public String generateForgotPasswordToken(UserForm user);
    
    public boolean checkToken(String token, Integer userId);
    
    public UserDTO sendPasswordToken(String email);
    
    public boolean resetPassword(String password, Integer id);
    
    public UserDTO getUserFromToken(String token);
    
}
