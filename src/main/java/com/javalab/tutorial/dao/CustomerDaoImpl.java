package com.javalab.tutorial.dao;

import com.javalab.tutorial.model.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class CustomerDaoImpl implements CustomerDao{

    private static final Logger logger = Logger.getLogger(CustomerDaoImpl.class.getName());

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> listByName(String customerName) {
        logger.info("CustomerDaoImpl#listByName");
        TypedQuery<Customer> query = sessionFactory.getCurrentSession().createQuery(
                "from Customer AS c where c.name = :customerName");
        query.setParameter("customerName", customerName);
        return query.getResultList();
    }
}
