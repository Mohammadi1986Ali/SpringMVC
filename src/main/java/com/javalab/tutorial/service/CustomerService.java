package com.javalab.tutorial.service;

import com.javalab.tutorial.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> listByName(String customerName);
}
