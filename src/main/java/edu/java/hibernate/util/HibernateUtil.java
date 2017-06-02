package edu.java.hibernate.util;

import edu.java.hibernate.mapping.onetoone.joincolumn.Address;
import edu.java.hibernate.mapping.onetoone.joincolumn.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Address.class);
    }

    public static SessionFactory createSessionFactory() {
        /*
        XML Configuration. */
        if(sessionFactory==null) {
            Configuration configuration=new Configuration();
            configuration.configure();
            addClasses(configuration);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        /* Annotation Configuration
        if(sessionFactory==null) {
            AnnotationConfiguration annotationConfiguration= new AnnotationConfiguration();
            addClasses(annotationConfiguration);
            sessionFactory = annotationConfiguration.buildSessionFactory();
        } */
        return sessionFactory;
    }

    public static Session getNewSession() {
        return sessionFactory.openSession();
    }

    public static void closeSessionFactory() {
        if(sessionFactory==null) {
            return;
        }
        if(!sessionFactory.isClosed()) {
            try {
                sessionFactory.close();
            }
            catch (HibernateException he) {
                //COMMENT: Log this error
                he.printStackTrace();
            }
        }
    }

}
