package org.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.employee.Employee;

import java.util.List;


public class Main {
    public static void main(String[] args){
        //creating a config file connection
//        Configuration is class so we can use new keyword
        Configuration config = new Configuration();
//        we need to mention which file to be configure
//        (addAnnotatedClass)Tell Hibernate that this class is an Entity and must be mapped to a database table.
        config.configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class);

        //creating a sessionfactory
        SessionFactory factory = config.buildSessionFactory();

        //create a session;
        Session session = factory.openSession();

        //start the transaction
//        Transaction transaction = session.beginTransaction();
//
//        //create operation
//        //creation of object
//        Employee emp = new Employee(101L,"sinchana",42000L);
//
//        //save object
//        session.persist(emp);
//
//        //commit transaction
//        transaction.commit();
//
//        //closing session and factory
//       session.close();
//       factory.close();

//       //reading data from table
//        //no transaction required only for adding and updating and deleting its required
//        Employee employee = session.find(Employee.class,101);
//        System.out.println("name: "+employee.getName()+" salary: "+employee.getSalary());

        //update
//        Employee emp = new Employee(102L,"varsha",42000L);
//        Transaction transaction = session.beginTransaction();
////        if the data found it will update not found it will create one
//        session.merge(emp);
//        transaction.commit();

        //delete
        Transaction transaction = session.beginTransaction();
        Employee employee = session.find(Employee.class,102);
        session.remove(employee);
        transaction.commit();
    }
}