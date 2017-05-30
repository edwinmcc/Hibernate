package edu.java.hibernate;

import edu.java.hibernate.model.Address;
import edu.java.hibernate.model.User;
import edu.java.hibernate.util.HibernateUtil;
import org.hibernate.Session;

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
        Session session=HibernateUtil.getNewSession();
        session.beginTransaction();
        Address address=new Address();
        address.setStreet("1/699-701 Heatherton Road");
        address.setZipCode("3169");
        address.setCountry("Australia");

        User user = new User();
        user.setAddress(address);
        user.setEmail("edwin_mony@yahoo.com");
        user.setFirstName("EDWIN");
        user.setLastName("Gnanasigamony");
        user.setPassword("testing!".toCharArray());
        user.setUserName("edwin.g");
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }


    public static void main( String[] args )
    {
        HibernateApplication hibernateApplication = new HibernateApplication();
        hibernateApplication.init();
        hibernateApplication.startApplication();
    }

}
