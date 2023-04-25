package com.est.many.to.manymapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Configuration config = new Configuration();
        config.configure("Hibernate4.xml");
        SessionFactory factory=config.buildSessionFactory();
        
        
         Employee e1 = new Employee();
         Employee e2 = new Employee();
         
         e1.setEid(1);
         e1.setEname("saurabh");
         
         e2.setEid(2);
         e2.setEname("anoop");
         
         Project p1 = new Project();
         Project p2 = new Project();
         
         p1.setPid(5);
         p1.setPname("java project");
         
         p2.setPid(9);
         p2.setPname("python project");
         
         
         List<Employee> list1 = new ArrayList<Employee>();
         List<Project> list2 = new ArrayList<Project>();
         
         list1.add(e1);
         list1.add(e2);
         
         
         
         list2.add(p1);
         list2.add(p2);
         
         
         e1.setProject(list2);
         p1.setEmployee(list1);
         
         
         Session s2=factory.openSession();
         Transaction tx=s2.beginTransaction();
         
         s2.save(e1);
         s2.save(e2);
         s2.save(p1);
         s2.save(p2);
         
         tx.commit();
         s2.close();
         factory.close();
    }
}
