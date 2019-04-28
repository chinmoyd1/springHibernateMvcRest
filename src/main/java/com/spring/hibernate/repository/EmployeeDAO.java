package com.spring.hibernate.repository;

import com.spring.hibernate.factory.FactoryUtil;
import com.spring.hibernate.model.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDAO implements Dao<Employee> {

    private static SessionFactory factory;

     public  EmployeeDAO() {
       factory = FactoryUtil.getSessionFactory();
    }

    @Override
    public Employee get(int id) {
        Session session = factory.openSession();
        Transaction tx = null;
        Employee employee = null;

        try {
            tx = session.beginTransaction();
            employee = (Employee)session.get(Employee.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        Session session = factory.openSession();
        Transaction tx = null;
        List employees = null;

        try {
            tx = session.beginTransaction();
            employees = session.createQuery("FROM Employee").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employees;
    }

    @Override
    public long save(Employee employee) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;
        try {
            tx = session.beginTransaction();
            employeeID = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeID;
    }

    @Override
    public void update(Employee employee) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
           // Employee employee = (Employee)session.get(Employee.class, EmployeeID);
           // employee.setSalary( salary );
            session.update(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Employee employee) {
            Session session = factory.openSession();
            Transaction tx = null;

            try {
                tx = session.beginTransaction();
                //Employee employee = (Employee)session.get(Employee.class, employee.getId());
                session.delete(employee);
                tx.commit();
            } catch (HibernateException e) {
                if (tx!=null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }

    }
}
