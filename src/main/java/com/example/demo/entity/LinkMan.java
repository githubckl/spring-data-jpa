package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "link_man")
public class LinkMan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lkm_id")
    private Long lkmId;
//在一个实体类指定了一对多的同时,在另一个"多"的实体类上要有多对一,然后JoinColumn跟"一"的那一方的实体类的注解属性值相反
    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "lkm_cust_id", referencedColumnName = "cust_id")
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public Long getLkmId() {
        return lkmId;
    }

    public void setLkmId(Long lkmId) {
        this.lkmId = lkmId;
    }
}
