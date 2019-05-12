package edu.java.hibernate.mapping.onetoone.unidirectional;


/**
 * Created by egnanasigamony on 29/05/2017.
 */


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
create table user
(
    id bigint primary key auto_increment,
    first_name varchar(100),
    last_name  varchar(100),
    name  varchar(100),
    password  varchar(100),
    email     varchar(150)
) auto_increment=1000000;
*/


@Entity
@Table(name="user")
public class User implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="name")
    private String name;
    @Column(name="password")
    private char[] password;
    @Column(name="email")
    private String email;

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}