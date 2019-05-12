package edu.java.hibernate.mapping.onetoone.bidirectional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 create table husband
 (
 id bigint not null primary key auto_increment,
 name varchar(250)
) auto_increment=1000000;

 */

@Entity
@Table(name="husband")
public class Husband
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="name")
    private String name;

    @OneToOne (mappedBy = "husband", cascade = CascadeType.ALL, orphanRemoval = true)
    private Wife wife;

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

    public Wife getWife()
    {
        return wife;
    }

    public void setWife(Wife wife)
    {
        if(wife==null)
        {
            if(this.wife!=null)
            {
                this.wife.setHusband(null);
            }
        }
        else
        {
            wife.setHusband(this);
        }
        this.wife = wife;
    }
}