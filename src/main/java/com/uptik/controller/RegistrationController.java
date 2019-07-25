package com.uptik.controller;

import com.uptik.User.UptickUser;
import com.uptik.model.User;
import com.uptik.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    private final Log logger = LogFactory.getLog(getClass());


    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new UptickUser());
        return "registration";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(
            @Valid @ModelAttribute("crmUser") UptickUser uptickUser,
            BindingResult theBindingResult,
            Model theModel) {

        String userName = uptickUser.getUserName();
        logger.info("Processing registration form for: " + userName);

        // form validation
        if (theBindingResult.hasErrors()){
            return "registration-form";
        }

        // check the database if user already exists
        User existing = userService.findByUserName(userName);
        if (existing != null){
            theModel.addAttribute("crmUser", new UptickUser());
            theModel.addAttribute("registrationError", "User name already exists.");

            logger.warn("User name already exists.");
            return "registration-form";
        }
        // create user account
        userService.save(uptickUser);

        logger.info("Successfully created user: " + userName);

        return "registration-confirmation";
    }
}
