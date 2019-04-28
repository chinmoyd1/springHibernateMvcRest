package com.spring.hibernate.service;

import com.spring.hibernate.model.EmployeeList;
import com.spring.hibernate.repository.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


@Service
public class ManageEmployeeImpl {
    @Autowired
    private EmployeeDAO dao;

    private static final Logger log = Logger.getLogger(ManageEmployeeImpl.class);


    public EmployeeList listAll(){
        EmployeeList employeeList = new EmployeeList();
        employeeList.setEmployeeList(dao.getAll());
        return employeeList;
    }

}
