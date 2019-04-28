package com.spring.hibernate.service;

import com.spring.hibernate.model.Employee;
import com.spring.hibernate.repository.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageEmployeeImpl {
    @Autowired
    private EmployeeDAO dao;

    private static final Logger log = Logger.getLogger(ManageEmployeeImpl.class);


    public String listAll(String message){

        String s = "";
        List<Employee> l2 = dao.getAll();
        System.out.println("---------------"+message+" Listing----------------");
        for(Employee e : l2){
            System.out.println(e.getFirstName()+"\t"+e.getLastName()+"\t"+e.getSalary());
            s +=e.getFirstName()+"\t"+e.getLastName()+"\t"+e.getSalary();
        }
        return s;
    }

}
