package edu.java.hibernate.mapping.onetoone.bidirectional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**

 create table wife
 (
 id bigint not null primary key auto_increment,
 name varchar(100),
 fk_husband bigint,
 foreign key (fk_husband) references husband(id))
 auto_increment=100000000;

 */


@Entity
@Table(name="wife")
public class Wife
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_husband")
    private Husband husband;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Husband getHusband()
    {
        return husband;
    }

    public void setHusband(Husband husband)
    {
        this.husband = husband;
    }
}
