package edu.java.hibernate.mapping.onetoone.mapsid;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**

 create table student
 (
 id bigint primary key auto_increment,
 name varchar(100)
 ) auto_increment=1000000;

 */


@Entity
@Table(name="student")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="name")
    private String name;

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
}
