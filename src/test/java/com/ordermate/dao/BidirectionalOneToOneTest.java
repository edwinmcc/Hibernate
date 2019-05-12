package com.ordermate.dao;

import edu.java.hibernate.mapping.onetoone.bidirectional.Husband;
import edu.java.hibernate.mapping.onetoone.bidirectional.Wife;
import org.junit.Test;

public class BidirectionalOneToOneTest extends AbstractTest
{

    @Test
    public void testBidirectionalOneToOne()
    {
        beginTransaction();

        Husband h1 = new Husband();
        h1.setName("Edwin");

        Wife w1 = new Wife();
        w1.setName("Shamini");

        w1.setHusband(h1);
        h1.setWife(w1);

        save(h1);
        save(w1);

        commit();

        Husband h2 = (Husband)session.get(Husband.class, h1.getId());

        System.out.println("Name of wife : "+h2.getWife().getName());
    }
}
