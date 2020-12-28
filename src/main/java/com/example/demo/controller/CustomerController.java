package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.entity.LinkMan;
import com.example.demo.service.CustomerService;
import com.example.demo.service.impl.CustomerImpl;
import com.example.demo.service.impl.LinkManImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    CustomerImpl customerImpl;
    @Autowired
    LinkManImpl linkManImpl;

    @Transactional
    @Rollback(value = false)
    @RequestMapping("save")
    void save(String name, Long id) {
        Customer customer = new Customer();
        customer.setCustId(id);
        customer.setName(name);
        customerImpl.save(customer);
    }

    @RequestMapping("getOne")
    Customer getOne(Long id) {
        return customerImpl.findOne(id);
    }

    @Transactional
    @Rollback(value = false)
    @RequestMapping("delete")
    void delete(Long id) {
        customerImpl.delete(id);
    }

    @Transactional
    @Rollback(value = false)
    @RequestMapping("oneToManySave")
    void oneToManySave() {
        Customer customer = new Customer();
        LinkMan linkMan = new LinkMan();
        customer.setCustId(1l);
        customer.setName("ckl");
        linkMan.setLkmId(1l);
        customer.getLinkMEN().add(linkMan);
        linkManImpl.save(linkMan);
        customerImpl.save(customer);

    }

    @Transactional
    @Rollback(value = false)
    @RequestMapping("oneToManyFind")
    void oneToManyFind() {
        Customer customer = customerImpl.findOne(2l);
        Set<LinkMan> set = customer.getLinkMEN();
        System.out.println(set.toArray());
    }

    @Transactional
    @Rollback(value = false)
    @RequestMapping("queryBySpecification")
    Page queryBySpecification() {
        return customerImpl.findBySpecification();
    }

}
