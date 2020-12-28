package com.example.demo.service.impl;

import com.example.demo.dao.RoleDao;
import com.example.demo.entity.Role;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleImpl implements RoleService {
    @Autowired
    RoleDao roleDao;
    @Override
    public void save(Role role) {
        roleDao.save(role);
    }
}
