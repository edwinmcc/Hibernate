package edu.java.hibernate.mapping.onetoone.joincolumn;

import edu.java.hibernate.util.HibernateUtil;
import org.hibernate.Session;

/**
 * Created by egnanasigamony on 1/06/2017.
 */
public class OneToOneJoinColumnDemo {

    /*
        UNI-DIRECTIIONAL Join Column method of One To One relationship.

        In a Join Column method two sets of primary keys are generated thereby resulting in an overhead in the creation and updation of respective table indices.
        The MapsId approach is a better one because, it shares the same Index and it reduces the index create and update overload by half.


        In JoinColumn the the owner of the relationship here User informs hibernate that it is mapped to Address class and it is related by the column "addressId"
        User table has userId as primary key and addressId column in User table having a foreign key relationship with Address(addressId).
        Address is an independent table with just addressId as primary Key column

        This is a uni-directional relationship.

     */


    private void addUser(Session session,String firstName,String lastName,String userName,String email,int houseNumber) {

        Address address=new Address();
        address.setStreet(houseNumber+"/699-701 Heatherton Road");
        address.setZipCode("3169");
        address.setCountry("Australia");

        User user = new User();
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword("testing!".toCharArray());
        user.setUserName(userName);
        user.setAddress(address);
        session.save(user);

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
        OneToOneJoinColumnDemo d=new OneToOneJoinColumnDemo();
        d.addData();
    }

}
