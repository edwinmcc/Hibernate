package edu.java.hibernate;

import edu.java.hibernate.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class HibernateApplication
{

    private void init() {
        HibernateUtil.createSessionFactory();
    }

    private void startApplication() {
        
    }


    public static void main( String[] args )
    {
        HibernateApplication hibernateApplication = new HibernateApplication();
        hibernateApplication.init();
        hibernateApplication.startApplication();
    }

}
