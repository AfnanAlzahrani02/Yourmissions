
package yourmissions;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
             // loads configuration and mappings
            Configuration configuration = new Configuration().configure("/yourmissions/hibernate.cfg.xml");
            ServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
             configuration.addAnnotatedClass(worker.class);
             configuration.addAnnotatedClass(user.class);
             configuration.addAnnotatedClass(tasks.class);
            
            // builds a session factory from the service registry
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);  
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
