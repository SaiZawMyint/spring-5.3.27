package com.mtm.plan.web.controllers;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mtm.plan.bl.service.UserService;

/**
 * Write your controller here...<br>
 * This is the main place where to define all route for your app.
 *<br>
 *<pre style='color: orange;'>Note::Please do not use the business logic here!</pre>
 *
 * @author SaiZawMyint
 */
@Controller
@RequestMapping("/")
public class ApplicationController {

    private static Logger LOGGER = LogManager.getLogger(ApplicationController.class);
    
    @Autowired
    HttpSession session;

    @Value("${app.title}")
    String title;
    
    @Autowired
    UserService userService;

    @GetMapping("")
    public ModelAndView index(Authentication authentication, HttpSession s) {
        session.setAttribute("AppTitle", title);
        ModelAndView model = new ModelAndView("dashboard");
        model.addObject("usersList", userService.doGetAllUsers());
        LOGGER.info(String.format("[%s] Index Page [%s] - ", new Date().toString(), authentication.getName()));
        return model;
    }

}