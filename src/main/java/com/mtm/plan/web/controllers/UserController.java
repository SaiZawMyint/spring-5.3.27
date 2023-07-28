package com.mtm.plan.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mtm.plan.bl.service.RoleService;
import com.mtm.plan.bl.service.UserService;
import com.mtm.plan.web.forms.UserForm;

@Controller
@RequestMapping("/user/")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private RoleService roleService;
    
    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("users", this.userService.doGetAllUsers());
        return "user.list";
    }
    
    @GetMapping("create")
    public String createPage(Model model) {
        model.addAttribute("userForm", new UserForm());
        model.addAttribute("roles", roleService.doGetAllRole());
        return "user.create";
    }
    
    @PostMapping("create")
    public ModelAndView create(@Valid@ModelAttribute UserForm userForm, BindingResult binder) {
        ModelAndView model = new ModelAndView();
        if(binder.hasErrors()) {
            model.addObject("sessionMessage", "Fails to create user!");
            model.addObject("roles", roleService.doGetAllRole());
            model.setViewName("user.create");
            return model;
        }
        this.userService.doAddUser(userForm);
        model.setViewName("redirect:/user/");
        return model;
    }
}
