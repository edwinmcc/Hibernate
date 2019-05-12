package edu.java.hibernate;

import edu.java.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.math.BigDecimal;

/**
 * Hello world!
 *
 * /
 /*
public class HibernateApplication
{

    private void init() {
        HibernateUtil.createSessionFactory();
    }

    private void addUser(Session session,String firstName,String lastName,String userName,String email,int houseNumber) {

        User user = new User();
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword("testing!".toCharArray());
        user.setUserName(userName);

        Address address=new Address();
        address.setStreet(houseNumber+"/699-701 Heatherton Road");
        address.setZipCode("3169");
        address.setCountry("Australia");
        address.setUser(user);
        session.save(address);

    }

    private void addAllUsers() {
        Session session=HibernateUtil.getNewSession();
        long startTime=System.currentTimeMillis();
        session.beginTransaction();
        for(int i=1;i<=5;i++) {
            addUser(session,"Edwin-"+i,"Gnanasigamony-"+i,"edwin.g-"+i,"edwin_mony-"+i+"@yahoo.com",i);
        }
        session.getTransaction().commit();
        long endTime=System.currentTimeMillis();
        System.out.println("The total time taken is : "+(endTime-startTime)/1000+" seconds ");
        session.close();
    }

    private void getAllUsers() {
        Session session=HibernateUtil.getNewSession();
        //session.create
    }


    private void compareFloat() {
        BigDecimal b1=new BigDecimal("4.5");
        BigDecimal b2=new BigDecimal("4.5");
        System.out.println("Values are : "+((b1.equals(b2))?" Equal ": " Not Equal "));
    }

    private void closeResources() {
        HibernateUtil.closeSessionFactory();
    }

    public static void main( String[] args )
    {
        HibernateApplication hibernateApplication = new HibernateApplication();
        hibernateApplication.init();
        hibernateApplication.addAllUsers();
        //hibernateApplication.compareFloat();
        hibernateApplication.closeResources();
    }

}
 */
