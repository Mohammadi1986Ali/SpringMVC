package com.javalab.tutorial.web.controller;

import com.javalab.tutorial.model.Customer;
import com.javalab.tutorial.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private static final Logger logger = Logger.getLogger(CustomerController.class.getName());

    @Autowired
    CustomerService service;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(@RequestParam("customerName") String customerName,
                       Model model) {
        logger.info("CustomerController#list");

        List<Customer> customers = service.listByName(customerName);
        model.addAttribute("customers", customers);
        return "customer/list";
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String search() {
        logger.info("CustomerController#search");
        return "customer/search";
    }
}
