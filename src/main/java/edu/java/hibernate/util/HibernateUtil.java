package edu.java.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by egnanasigamony on 29/05/2017.
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory=null;

    private static void addClasses(Configuration configuration) {
        //configuration.addAnnotatedClass(edu.java.hibernate.model.Contact.class);
        configuration.addPackage("edu.java.hibernate.model");
    }

    public static SessionFactory createSessionFactory() {
        if(sessionFactory==null) {
            Configuration configuration=new Configuration();
            configuration.configure();
            addClasses(configuration);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }

}
