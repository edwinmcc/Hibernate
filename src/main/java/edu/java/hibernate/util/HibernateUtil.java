package edu.java.hibernate.util;

import com.ordermate.dao.PersistentObject;
import com.ordermate.dao.SalesAccount;
import edu.java.hibernate.mapping.manytoone.Post;
import edu.java.hibernate.mapping.manytoone.PostComment;
import edu.java.hibernate.mapping.onetoone.bidirectional.Husband;
import edu.java.hibernate.mapping.onetoone.bidirectional.Wife;
import edu.java.hibernate.mapping.onetoone.mapsid.Student;
import edu.java.hibernate.mapping.onetoone.mapsid.StudentDetails;
import edu.java.hibernate.mapping.onetoone.unidirectional.Address;
import edu.java.hibernate.mapping.onetoone.unidirectional.User;
import edu.java.hibernate.model.Computer;
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
        //configuration.addPackage("edu.java.hibernate.model");
        configuration.addPackage("com.ordermate.dao");
        //configuration.addAnnotatedClass(User.class);
        //configuration.addAnnotatedClass(Address.class);
        configuration.addAnnotatedClass(PersistentObject.class);
        configuration.addAnnotatedClass(SalesAccount.class);
        configuration.addAnnotatedClass(Post.class);
        configuration.addAnnotatedClass(PostComment.class);
        configuration.addAnnotatedClass(Computer.class);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Address.class);
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(StudentDetails.class);
        configuration.addAnnotatedClass(Husband.class);
        configuration.addAnnotatedClass(Wife.class);
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

    public static Session getNewSession()
    {
        if(sessionFactory == null)
        {
            createSessionFactory();
        }
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
