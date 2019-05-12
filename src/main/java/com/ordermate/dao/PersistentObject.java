package com.ordermate.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table(name="persistent_object")
@Inheritance(strategy = InheritanceType.JOINED)
public class PersistentObject
{
    private Long id;
    private String name;
    private String displayName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name="id", insertable = true, nullable = false, unique = true, updatable = false)
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    @Column (insertable = true, nullable = false, unique = false )
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Column (name="display_name")
    public String getDisplayName()
    {
        return displayName;
    }

    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }
}