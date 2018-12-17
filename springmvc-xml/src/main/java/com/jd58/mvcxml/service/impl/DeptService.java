package com.jd58.mvcxml.service.impl;

import com.jd58.mvcxml.dao.BaseDao;
import com.jd58.mvcxml.model.Dept;
import com.jd58.mvcxml.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService implements IDeptService {

    @Autowired
    private BaseDao baseDao;

    @Override
    public List<Dept> listAll() {
        return (List<Dept>)baseDao.listAll(Dept.class);
    }

    @Override
    public void saveOrUpdate(Dept dept) {
        baseDao.saveOrUpdate(dept);
    }

}
