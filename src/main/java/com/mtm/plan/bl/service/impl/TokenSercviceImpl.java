package com.mtm.plan.bl.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mtm.plan.bl.dto.UserDTO;
import com.mtm.plan.bl.service.MailService;
import com.mtm.plan.bl.service.TokenService;
import com.mtm.plan.persistence.entity.PasswordResetToken;
import com.mtm.plan.persistence.entity.User;
import com.mtm.plan.persistence.repository.TokenRepository;
import com.mtm.plan.persistence.repository.UserRepository;
import com.mtm.plan.utils.EmailUtils;
import com.mtm.plan.utils.TokenUtils;
import com.mtm.plan.web.forms.UserForm;

@Service
@Transactional
public class TokenSercviceImpl implements TokenService {

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    TokenRepository tokenRepository;
    
    @Autowired
    MailService mailService;
    
    @Autowired
    PasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    EmailUtils emailUtils;
    
    @Override
    public String generateForgotPasswordToken(UserForm user) {
        User data = userRepository.getUserByEmail(user.getEmail());
        if(data == null) return null;
        return TokenUtils.generateForgotPasswordToken(user);
    }

    @Override
    public boolean checkToken(String token, Integer userId) {
        Optional<User> data = userRepository.findById(userId);
        if(data.get() == null) return false;
        
        PasswordResetToken tokenData = tokenRepository.getTokenByUserId(data.get().getId());
        if(tokenData == null) return false;
        
        return true;
    }

    @Override
    public UserDTO sendPasswordToken(String email) {
        User userData = userRepository.getUserByEmail(email);
        if(userData == null) return null;
        UserForm form = new UserForm(userData);
        String token = generateForgotPasswordToken(form);
        
        PasswordResetToken passwordResetToken = new PasswordResetToken();
        passwordResetToken.setToken(token);
        passwordResetToken.setUsed(false);
        passwordResetToken.setUser(userData);
        
        this.tokenRepository.save(passwordResetToken);
        
        StringBuilder mailBody = new StringBuilder();
        mailBody.append("http://localhost:8080/Demo/auth/reset-password");
        mailBody.append("?");
        mailBody.append("token=");
        mailBody.append(token);
        
        String template = emailUtils.mailTemplateForPasswordReset(userData.getName(), userData.getEmail(), mailBody.toString());
        
        mailService.sendMail("Reset yor account password", template, form);
        return new UserDTO(userData);
    }

    @Override
    public boolean resetPassword(String password, Integer id) {
        Optional<User> user = this.userRepository.findById(id);
        if(user.get() == null) return false;
        PasswordResetToken passwordResetToken = this.tokenRepository.getTokenByUserId(id);
        if(passwordResetToken == null) return false;
        
        user.get().setPassword(this.bCryptPasswordEncoder.encode(password));
        this.userRepository.save(user.get());
        
        tokenRepository.delete(passwordResetToken);
        return true;
    }

    @Override
    public UserDTO getUserFromToken(String token) {
        if(!token.contains("-")) return null;
        String email = token.substring(0, token.indexOf("-"));
        User user = this.userRepository.getUserByEmail(email);
        if(user == null) return null;
        return new UserDTO(user);
    }

}
