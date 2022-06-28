package com.javalab.tutorial.service;

import com.javalab.tutorial.dao.CustomerDao;
import com.javalab.tutorial.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;


    @Override
    @Transactional
    public List<Customer> listByName(String customerName) {
        return customerDao.listByName(customerName);
    }
}
