package edu.java.hibernate.mapping.onetoone.mapsid;

import edu.java.hibernate.util.HibernateUtil;
import org.hibernate.Session;

/**
 * Created by egnanasigamony on 1/06/2017.
 */
public class OneToOneMapsIdDemo {

    private void addUser(Session session, String firstName, String lastName, String userName, String email, int houseNumber) {

        /*
            This is a bi-directional OneToOne relationship where the owner of the relationship is maintained by child Address entity

             This approach is better because it shares the primary key value of its parent entity.

             Here only Address has the addressId column as primary key and the same primary key also acts as the foreign key
             to User entity referencing "userId"

            So always addressId will have the same value as User.userId.


            Key points
            Look at OneToOne mapping of User & Address.

         */




        edu.java.hibernate.mapping.onetoone.mapsid.User user = new edu.java.hibernate.mapping.onetoone.mapsid.User();
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword("testing!".toCharArray());
        user.setUserName(userName);

        edu.java.hibernate.mapping.onetoone.mapsid.Address address=new edu.java.hibernate.mapping.onetoone.mapsid.Address();
        address.setStreet(houseNumber+"/699-701 Heatherton Road");
        address.setZipCode("3169");
        address.setCountry("Australia");
        address.setUser(user);
        session.save(address);

    }

    private void addData() {
        HibernateUtil.createSessionFactory();
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
        HibernateUtil.closeSessionFactory();
    }

    public static void main(String ...args) {
        OneToOneMapsIdDemo d=new OneToOneMapsIdDemo();
        d.addData();
    }

}
