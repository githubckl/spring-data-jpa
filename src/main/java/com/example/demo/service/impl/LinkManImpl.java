package com.example.demo.service.impl;

import com.example.demo.dao.LinkManDao;
import com.example.demo.entity.LinkMan;
import com.example.demo.service.LinkManService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkManImpl implements LinkManService {
    @Autowired
    LinkManDao linkManDao;

    @Override
    public void save(LinkMan linkMan) {
        linkManDao.save(linkMan);
    }
}
