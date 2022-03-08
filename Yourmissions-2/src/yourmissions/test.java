/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourmissions;

import static javafx.application.Application.launch;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author TOSHIBA
 */
public class test {
     public static void main(String[] args) {
    
   
    
    user u1 = new user();
    u1.setFullname("shahad");
    u1.setNID("987654321");
    u1.setUsername("shahad1");
    u1.setEmail("shahad@gmail.com");
    u1.setPassword("12345");
    u1.setDOB("13/6/1999");
     Session session1 = HibernateUtil.getSessionFactory().openSession();
       Transaction ux = session1.beginTransaction();
      session1.save(u1);
        ux.commit();
        session1.close();
    
    worker w1 = new worker();
    w1.setFullname("deema");
    w1.setW_NID("1234567890");
    w1.setUsername("deema1");
    w1.setEmail("deema@gmail.com");
    w1.setPassword("987");
    w1.setSex("f");
    w1.setJop("maid");
    w1.setDOB("27/9/1999");
    w1.setU_NID("987654321");
    
    Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction wx = session.beginTransaction();
      session.save(w1);
        wx.commit();
        session.close();
        
        
    tasks t1 = new tasks();
    t1.setTasks_no("1");
    t1.setDescription("clean");
    t1.setUs_NID("987654321");
    t1.setWorker_username("deema1");
    
    Session session2 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session2.beginTransaction();
      session2.save(t1);
        tx.commit();
        session2.close();  
        
         
          
          
        
          launch(args);
           
}   
}
