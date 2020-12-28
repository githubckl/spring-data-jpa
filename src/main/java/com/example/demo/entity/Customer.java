package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    @OneToMany(targetEntity = LinkMan.class)
    @JoinColumn(name = "lkm_cust_id", referencedColumnName = "cust_id")
    private Set<LinkMan> linkMEN = new HashSet<>();

    @ManyToMany(targetEntity = Role.class)
    @JoinTable(name = "customer_role",joinColumns = {@JoinColumn(name = "cust_id",referencedColumnName = "cust_id"),

    },inverseJoinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "role_id")})
     private Set<Role>roles=new HashSet<>();

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
}