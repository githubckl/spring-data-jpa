package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Long custId;
    @Column(name = "name")
    private String name;
    @Column(name = "sign_date")
    private Date signDate;
    @Column(name = "address")
    private String address;
    @Column(name = "age")
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
//一对多搭配的是某一列,所以下面出现的是joinColumn
    @OneToMany(targetEntity = LinkMan.class)
    @JoinColumn(referencedColumnName = "cust_id",name = "lkm_cust_id" )
    private Set<LinkMan> linkMEN = new HashSet<>();
//多对多需要一个中间表,所以下面需要一个joinTable,然后中间表的字段名推荐用和主从表一样的主键名,这里不再区分name和referenceColumnName
    @ManyToMany(targetEntity = Role.class)
    @JoinTable(name = "customer_role", joinColumns = {@JoinColumn(name = "cust_id", referencedColumnName = "cust_id"),
    }, inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")})
    private Set<Role> roles = new HashSet<>();

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<LinkMan> getLinkMEN() {
        return linkMEN;
    }

    public void setLinkMEN(Set<LinkMan> linkMEN) {
        this.linkMEN = linkMEN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", name='" + name + '\'' +
                ", linkMEN=" + linkMEN.toString() +
                '}';
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }
}