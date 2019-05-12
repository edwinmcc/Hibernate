package com.ordermate.dao;

/*
+-------------------------+--------------------------------------------------------------------------------------------------------------------------------------------+------+-----+---------------------+----------------+
        | Field                   | Type                                                                                                                                       | Null | Key | Default             | Extra          |
        +-------------------------+--------------------------------------------------------------------------------------------------------------------------------------------+------+-----+---------------------+----------------+
        | ID                      | bigint(20)                                                                                                                                 | NO   | PRI | NULL                | auto_increment |
        | FK_config_table         | bigint(20)                                                                                                                                 | YES  | MUL | NULL                |                |
        | account_state           | enum('OPEN','CLOSED')                                                                                                                      | NO   | MUL | OPEN                |                |
        | Patrons                 | int(6)                                                                                                                                     | NO   |     | 0                   |                |
        | seats                   | int(11)                                                                                                                                    | YES  |     | NULL                |                |
        | account_type            | enum('TABLE','PHONE','DELIVERY','TAKE_AWAY','DRIVE_THRU','REFUND','BAR_TAB','ONLINE_DELIVERY','ONLINE_PICKUP','ONLINE_TABLE','QS_DINE_IN') | NO   |     | TABLE               |                |
        | acc_class               | enum('TABLE','PHONE','TAKE_AWAY','DRIVE_THRU','BAR_TAB','REFUND','ONLINE')                                                                 | NO   |     | TABLE               |                |
        | Creation_time           | datetime                                                                                                                                   | NO   |     | 2002-02-05 01:09:02 |                |
        | FK_finance_trading_day  | bigint(20)                                                                                                                                 | NO   | MUL | 0                   |                |
        | FK_config_user          | bigint(20)                                                                                                                                 | YES  | MUL | NULL                |                |
        | FK_sales_customer       | bigint(20)                                                                                                                                 | YES  | MUL | NULL                |                |
        | Time_Due                | time                                                                                                                                       | YES  |     | NULL                |                |
        | Date_Due                | date                                                                                                                                       | YES  |     | NULL                |                |
        | FK_sales_delivery       | bigint(20)                                                                                                                                 | YES  | MUL | NULL                |                |
        | delivery_fee            | double                                                                                                                                     | YES  |     | NULL                |                |
        | delivered               | tinyint(1)                                                                                                                                 | NO   |     | 0                   |                |
        | comment                 | text                                                                                                                                       | YES  |     | NULL                |                |
        | external_id             | varchar(50)                                                                                                                                | YES  |     | NULL                |                |
        | receipt_state           | enum('receipt printed','receipt not printed')                                                                                              | NO   |     | receipt not printed |                |
        | deliverable             | tinyint(1)                                                                                                                                 | NO   |     | 0                   |                |
        | FK_finance_shift        | bigint(20)                                                                                                                                 | NO   | MUL | 0                   |                |
        | tab_name                | varchar(100)                                                                                                                               | YES  |     | NULL                |                |
        | credit_limit            | double                                                                                                                                     | YES  |     | NULL                |                |
        | saved_total             | double                                                                                                                                     | NO   |     | 0                   |                |
        | on_hold                 | tinyint(1)                                                                                                                                 | NO   |     | 0                   |                |
        | FK_config_user_closed   | bigint(20)                                                                                                                                 | YES  |     | NULL                |                |
        | FK_config_user_assigned | bigint(20)                                                                                                                                 | YES  |     | NULL                |                |
        | FK_config_user_opened   | bigint(20)                                                                                                                                 | YES  |     | NULL                |                |
        | FK_allowing_user        | bigint(20)                                                                                                                                 | YES  |     | NULL                |                |
        | ext_href                | varchar(100)                                                                                                                               | YES  |     | NULL                |                |
        | ext_order_id            | varchar(100)                                                                                                                               | YES  |     | NULL                |                |
        | ext_order_date_time     | datetime                                                                                                                                   | YES  |     | NULL                |                |
        | source                  | varchar(100)                                                                                                                               | YES  |     | NULL                |                |
        | ext_paid_flag           | tinyint(1)                                                                                                                                 | NO   |     | 0                   |                |
        | ext_docket_href         | varchar(100)                                                                                                                               | YES  |     | NULL                |                |
        | acknowledged_time       | datetime                                                                                                                                   | YES  |     | NULL                |                |
        | deliv_warn_zone         | tinyint(1)                                                                                                                                 | NO   |     | 0                   |                |
        | card_id                 | varchar(64)                                                                                                                                | YES  |     | NULL                |                |
        | FK_config_course        | bigint(20)                                                                                                                                 | YES  |     | NULL                |                |
        | eta                     | datetime                                                                                                                                   | YES  |     | NULL                |                |
        | prep_docket_print_time  | datetime                                                                                                                                   | YES  |     | NULL                |                |
        | closed_time             | datetime                                                                                                                                   | YES  |     | NULL                |                |
        | mod_time                | datetime                                                                                                                                   | YES  |     | NULL                |                |
        | mod_count               | bigint(20)                                                                                                                                 | NO   |     | 0                   |                |
        +-------------------------+--------------------------------------------------------------------------------------------------------------------------------------------+------+-----+---------------------+----------------+

*/

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "sales_account")
public class SalesAccount extends PersistentObject
{
    private AccountStatus accountStatus;
    private int         patrons;
    private int         seats;
    private AccountType  accountType;
    private AccountClass accountClass;
    private Timestamp creationTime;
    private Time      timeDue;
    private Date      dateDue;
    private Double    deliveryFee;
    private Boolean   delivered;
    private String    comment;
    private String    externalId;
    private ReceiptState receiptState;

    @Column(name="patrons")
    public int getPatrons()
    {
        return patrons;
    }

    public void setPatrons(int patrons)
    {
        this.patrons = patrons;
    }

    @Column(name="seats")
    public int getSeats()
    {
        return seats;
    }

    public void setSeats(int seats)
    {
        this.seats = seats;
    }

    @Column(name="account_class")
    @Enumerated(EnumType.STRING)
    public AccountClass getAccountClass()
    {
        return accountClass;
    }

    public void setAccountClass(AccountClass accountClass)
    {
        this.accountClass = accountClass;
    }

    @Column(name="creation_time")
    @CreationTimestamp
    public Timestamp getCreationTime()
    {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime)
    {
        this.creationTime = creationTime;
    }

    @Column(name="time_due")
    public Time getTimeDue()
    {
        return timeDue;
    }

    public void setTimeDue(Time timeDue)
    {
        this.timeDue = timeDue;
    }

    @Column(name="date_due")
    public Date getDateDue()
    {
        return dateDue;
    }

    public void setDateDue(Date dateDue)
    {
        this.dateDue = dateDue;
    }

    @Column(name="delivery_fee")
    public Double getDeliveryFee()
    {
        return deliveryFee;
    }

    public void setDeliveryFee(Double deliveryFee)
    {
        this.deliveryFee = deliveryFee;
    }

    @Column(name="delivered")
    public Boolean getDelivered()
    {
        return delivered;
    }

    public void setDelivered(Boolean delivered)
    {
        this.delivered = delivered;
    }

    @Column(name="comment")
    @Type(type="text")
    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    @Column(name="external_id")
    public String getExternalId()
    {
        return externalId;
    }

    public void setExternalId(String externalId)
    {
        this.externalId = externalId;
    }

    @Column(name="receipt_state")
    @Enumerated(EnumType.STRING)
    public ReceiptState getReceiptState()
    {
        return receiptState;
    }

    public void setReceiptState(ReceiptState receiptState)
    {
        this.receiptState = receiptState;
    }

    @Enumerated (EnumType.STRING)
    @Column(name="account_status")
    public AccountStatus getAccountStatus()
    {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus)
    {
        this.accountStatus = accountStatus;
    }

    @Column(name="account_type")
    @Enumerated(EnumType.STRING)
    public AccountType getAccountType()
    {
        return accountType;
    }

    public void setAccountType(AccountType accountType)
    {
        this.accountType = accountType;
    }
}
