package com.javalab.tutorial.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;
import java.util.logging.Logger;

@Controller
public class HomeController {

    @Autowired
    MessageSource messageSource;

    private final static String customerName = "DEFAULT_CUSTOMER";
    private final static Logger logger = Logger.getLogger(HomeController.class.getName());

    @RequestMapping("/")
    public String home(Model model) {
        logger.info("HomeController#home");

        String welcomeCustomer = messageSource.getMessage("home.page.welcome.customer", new String[]{customerName}, new Locale("fa"));
        model.addAttribute("welcomeCustomer", welcomeCustomer);
        return "home";
    }

}
