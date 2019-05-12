package com.ordermate.dao;

import edu.java.hibernate.util.HibernateUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.junit.Before;

public class AbstractTest
{
    protected Session session;
    protected Logger logger;


    @Before
    public void initDBResources()
    {
        session = HibernateUtil.getNewSession();
        logger = LogManager.getLogger("org.hibernate");
        logger.info("Logging initialized");
    }

    protected void beginTransaction()
    {
        session.getTransaction().begin();
    }

    protected void commit()
    {
        session.getTransaction().commit();

    }

    protected void save(Object obj)
    {
        session.save(obj);
    }

    protected void addToPrint(String attribute, String value, StringBuilder sb)
    {
        sb.append("Attribute : "+attribute);
        sb.append(" Value : "+value);
        sb.append(System.getProperty("line.separator"));
    }

}
