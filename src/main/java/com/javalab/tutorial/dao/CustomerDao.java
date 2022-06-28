package com.javalab.tutorial.dao;

import com.javalab.tutorial.model.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> listByName(String customerName);
}
