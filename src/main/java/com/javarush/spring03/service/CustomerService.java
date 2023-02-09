package com.javarush.spring03.service;

import com.javarush.spring03.entity.Customer;
import com.javarush.spring03.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private Repo<Customer> customerRepo;

    @Autowired
    public void setCustomerRepo(Repo<Customer> customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Customer get(Long id) {
        return customerRepo.getById(id);
    }

    public void update(Customer customer) {
        customerRepo.update(customer);
    }

}
