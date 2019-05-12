package edu.java.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

@Entity
@Table(name="computer")
public class Computer
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Type(type="edu.java.hibernate.model.IPAddressType")
    @Column(name="inet", columnDefinition = "varchar")
    private IPAddress ipAddress;

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

    public IPAddress getIpAddress()
    {
        return ipAddress;
    }

    public void setIpAddress(IPAddress ipAddress)
    {
        this.ipAddress = ipAddress;
    }
}
