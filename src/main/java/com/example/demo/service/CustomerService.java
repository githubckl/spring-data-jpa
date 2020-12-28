package com.example.demo.service;

import com.example.demo.entity.Customer;
import org.springframework.data.domain.Page;

public interface CustomerService {
    Customer findOne(Long id);

    void save(Customer customer);

    void delete(Long id);

    Page findBySpecification();
}
