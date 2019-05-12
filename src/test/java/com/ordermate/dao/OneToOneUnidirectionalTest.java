package com.ordermate.dao;

import edu.java.hibernate.mapping.onetoone.unidirectional.Address;
import edu.java.hibernate.mapping.onetoone.unidirectional.User;
import org.junit.Test;

public class OneToOneUnidirectionalTest extends AbstractTest
{

    @Test
    public void testUnidirectionalMapping()
    {
        beginTransaction();

        User u1=new User();
        u1.setEmail("edwin@ordermate.com.au");
        u1.setFirstName("Edwin");
        u1.setLastName("Gnanasigamony");

        Address address = new Address();
        address.setCountry("Australia");
        address.setStreet("95 Harmony Drive");
        address.setUser(u1);

        save(u1);
        save(address);

        commit();

        User u2 =(User)session.get(User.class, u1.getId());

        System.out.println("Email : "+u2.getEmail());
    }
}
