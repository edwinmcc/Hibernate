package edu.java.hibernate.mapping.onetoone.unidirectional;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by egnanasigamony on 30/05/2017.
 */

/*
create table address (
id BIGINT PRIMARY KEY AUTO_INCREMENT,
street varchar(100),
zipCode varchar(20),
country varchar(50),
fk_user bigint,
foreign key (fk_user) references user(id)
) AUTO_INCREMENT=1000000;

 */


@Entity
@Table(name = "address")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="street")
    private String street;
    @Column(name="zip_code")
    private String zipCode;
    @Column(name="country")
    private String country;

    @OneToOne
    @JoinColumn(name="fk_user")
    User user;



    public Address() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

}