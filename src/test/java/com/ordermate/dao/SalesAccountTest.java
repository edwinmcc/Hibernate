package com.ordermate.dao;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SalesAccountTest extends AbstractTest
{

    private void printSalesAccount(SalesAccount account)
    {
        StringBuilder sb = new StringBuilder();
        addToPrint("id", account.getId().toString(), sb);
        addToPrint("name",account.getName(), sb);
        addToPrint("displayName",account.getDisplayName(), sb);
        addToPrint("accountType", account.getAccountStatus().toString(), sb);
        logger.info(sb.toString());
    }

    @Test
    public void testSalesAccountPersist()
    {
        session.getTransaction().begin();
        SalesAccount salesAccount = new SalesAccount();
        salesAccount.setAccountStatus(AccountStatus.OPEN);
        salesAccount.setName("TableAccount1");
        salesAccount.setDisplayName("My Table Account 1");

        salesAccount.setAccountStatus(AccountStatus.OPEN);
        salesAccount.setAccountType(AccountType.TABLE);
        salesAccount.setAccountClass(AccountClass.TABLE);
        salesAccount.setCreationTime(new Timestamp(new Date().getTime()));
        salesAccount.setDelivered(true);
        salesAccount.setReceiptState(ReceiptState.RECEIPT_NOT_PRINTED);

        Long id = (Long)session.save(salesAccount);
        salesAccount.setId(id);
        session.getTransaction().commit();

        SalesAccount retievedAccount = (SalesAccount)session.load(SalesAccount.class,id);
        printSalesAccount(retievedAccount);
    }

    @Test
    public void testEntityManagerPersistence()
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.ordermate.dao");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        SalesAccount salesAccount = entityManager.find(SalesAccount.class,1000004);
        printSalesAccount(salesAccount);
        entityManager.close();
        entityManagerFactory.close();
    }
}
