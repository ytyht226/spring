package com.jd58.mvcxml.service.impl;

import com.jd58.mvcxml.dao.IBaseDao;
import com.jd58.mvcxml.model.Employee;
import com.jd58.mvcxml.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IBaseDao baseDao;

    @Override
    public Employee getById(Integer id) {
        return (Employee)baseDao.getById(id, Employee.class);
    }

    @Override
    public void saveOrUpdate(Employee employee) {
        baseDao.saveOrUpdate(employee);
    }

    @Override
    public void delete(Employee user) {
        baseDao.delete(user);
    }

    @Override
    public void delete(Integer id) {
        baseDao.delete(baseDao.getById(id, Employee.class));
    }

    @Override
    public List<Employee> list() {
        return (List<Employee>)baseDao.list(Employee.class);
    }
}
