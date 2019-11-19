package com.uptik.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;


@SuppressWarnings("unused")
@Controller
public class ErrorController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /*
    private static final String PATH = "/error";

    public static String getErrorPath() {
        return PATH;
    }

    @RequestMapping("/error")
    protected String error(final RedirectAttributes redirectAttributes) throws IOException {
        logger.error("Handling error");
        redirectAttributes.addFlashAttribute("error", true);
        return "redirect:/login";
    }
    */


}

