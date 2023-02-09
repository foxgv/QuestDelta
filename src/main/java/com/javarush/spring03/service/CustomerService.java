package com.javarush.spring03.service;

import com.javarush.spring03.entity.Customer;
import com.javarush.spring03.processors.Benchmark;
import com.javarush.spring03.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomerService {

    private final Map<Long, Customer> cache = new HashMap<>();
    private Repo<Customer> personRepo;

    @Autowired
    public void setPersonRepo(Repo<Customer> personRepo) {
        this.personRepo = personRepo;
    }

    @Benchmark
    public Customer getById(Long id) {
        return cache.computeIfAbsent(id, personRepo::getById);
    }


    @Benchmark
    public void setPasswordFirst(Long id, String password) {
        Customer customer = personRepo.getById(id);
        customer.setPassword(password);
        cache.put(id, customer);
        personRepo.update(customer);
    }

    @PostConstruct
    void init(){
        System.out.println("init bean");
    }
}
