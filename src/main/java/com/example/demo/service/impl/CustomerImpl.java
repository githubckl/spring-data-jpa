package com.example.demo.service.impl;

import com.example.demo.dao.CustomerDao;
import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CustomerImpl implements CustomerService {
    @Autowired
    CustomerDao customerDao;

    @Override
    public Customer findOne(Long id) {
        return customerDao.getOne(id);
    }

    @Override
    public void save(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public void delete(Long id) {
        customerDao.deleteById(id);
    }

    @Override
    public Page findBySpecification() {
        Specification specification = new Specification() {
            @SneakyThrows
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
                Predicate condition = null;
                Path name = root.get("name");
                Predicate ckl = criteriaBuilder.like(name, "%b%");
                Path signDate = root.get("signDate");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date startTime = sdf.parse("2020-12-28 18:09:55");
                Date endTime = sdf.parse("2020-12-28 18:10:00");
                Predicate between = criteriaBuilder.between(signDate, startTime, endTime);
                condition = criteriaBuilder.or(ckl, between);
                return condition;


            }
        };
        Sort sort = Sort.by(Sort.Direction.DESC, "name");
        Pageable pageable = PageRequest.of(0, 2, sort);
        return customerDao.findAll(specification, pageable);
    }


}
