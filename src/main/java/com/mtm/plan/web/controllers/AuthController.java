package com.mtm.plan.web.controllers;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mtm.plan.bl.dto.UserDTO;
import com.mtm.plan.bl.service.MailService;
import com.mtm.plan.bl.service.TokenService;
import com.mtm.plan.bl.service.UserService;

/**
 * Write your web form here...<br>
 * This is the main place where to make form for request and response.
 ** <br>
 * <pre style='color: orange;'>Note::Please do not use the business logic here!</pre>
 *
 * @author SaiZawMyint
 */
@Controller
public class AuthController {
    
    private static Logger LOGGER = LogManager.getLogger(AuthController.class);

    @Autowired
    TokenService tokenService;
    
    @Autowired
    MailService mailService;
    
    @Autowired
    UserService userService;
    
    @Autowired
    HttpSession session;
    
    
    @GetMapping("/login")
    public ModelAndView LoginPage(Authentication auth) {
        String page = auth == null ? "guestLogin":"redirect:/";
        ModelAndView model = new ModelAndView(page);
        return model;
    }
    
    @GetMapping("/auth/forgot-password")
    public ModelAndView forgotPassword() {
        return new ModelAndView("forgotPassword");
    }
    
    @PostMapping("/auth/forgot-password")
    public ModelAndView requestToken(@RequestParam String email) {
        LOGGER.info(email);
        tokenService.sendPasswordToken(email);
        return new ModelAndView("redirect:/auth/success-send-mail");
    }
    
    @GetMapping("/auth/success-send-mail")
    public ModelAndView mailSentSuccessPage() {
        return new ModelAndView("mailSentSuccess");
    }

    @GetMapping("/auth/reset-password")
    public ModelAndView passwordResetPage(@RequestParam String token) {
        ModelAndView model = new ModelAndView();
        UserDTO user = this.tokenService.getUserFromToken(token);
        if(user == null) {
            return new ModelAndView("redirect:/login");
        }
        boolean check = tokenService.checkToken(token, user.getId());
        if(check) {
            model.addObject("token", token);
            model.setViewName("passwordReset");
            return model;
        }
        model.setViewName("redirect:/login");
        return model;
    }
    
    @PostMapping("/auth/reset-password")
    public ModelAndView resetPassword(@RequestParam String password, @RequestParam String token) {
        UserDTO user = this.tokenService.getUserFromToken(token);
        if(user == null) return new ModelAndView("redirect:/login");
        boolean check = this.tokenService.resetPassword(password, user.getId());
        if(!check) {
            ModelAndView model = new ModelAndView("passwordReset");
            model.addObject("error", "Token expired!");
            return model;
        }
        return new ModelAndView("redirect:/login");
    }
    
}
