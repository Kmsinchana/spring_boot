package org.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.employee.Employee;

//this explains about first level caching, also about the dirty checking
public class Main2 {
    public static void main(String[] args){
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee emp = new Employee(106L,"Bhavyatha",33000L);
        session.persist(emp); //hits the DB to save data
        session.persist(emp); //doesn't hit the DB fetch from first level caching
        transaction.commit();

        Employee gotEmployee = session.find(Employee.class,106L);//this data also will be fetch from the first level caching if they are of same object
        System.out.println("name: "+gotEmployee.getName()+" salary: "+gotEmployee.getSalary());

//        closing the old session
        session.close();

//        new session creation
        Session session2 = factory.openSession();
        System.out.println("this should give the new query because the session got closed");
        Employee gotEmployee2 = session2.find(Employee.class,106L);


//        dirty checking
//        Hibernate automatically detects changes made to a managed entity and synchronizes those changes with the database when the transaction is committed.
//        it only works if the entity is in persistence state
        Transaction transaction2 = session2.beginTransaction();
        gotEmployee2.setName("dirty checking");
        transaction2.commit();
//         got o/p as
//        Hibernate: update Employee set name=?,salary=? where id=?(but not called update hibernate only compare the snapshot and give the result
    }
}
