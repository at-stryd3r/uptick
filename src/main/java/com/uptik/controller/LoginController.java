package com.uptik.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

    private final Log logger = LogFactory.getLog(getClass());

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

}
