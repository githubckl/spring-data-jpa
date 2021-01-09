package com.example.demo.service;

import com.example.demo.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerService {
    Customer findOne(Long id);

    void save(Customer customer);

    void delete(Long id);

    public Page selectiveSpecification(Long id, String name, String address);

    @Query(value = "select * from customer", nativeQuery = true)
    List customers(List<Long> ids);

    Page findBySpecification();
}
