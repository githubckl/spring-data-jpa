package com.example.demo.dao;

import com.example.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
//JpaRepository是单表增删改查的接口,Specification是可以具备分页和排序功能的接口
public interface CustomerDao extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {
//    想使用原生sql来增删改查时,用nativeQuery=true,然后再value中写下sql语句
    @Query(value = "select * from customer where cust_id in :ids", nativeQuery = true)
    List customers(List<Long> ids);
}
