package com.jd58.mvcxml.service;


import com.jd58.mvcxml.model.Dept;

import java.util.List;

public interface IDeptService {

    public List<Dept> listAll();

    public void saveOrUpdate(Dept dept);

}
