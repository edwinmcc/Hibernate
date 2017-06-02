package edu.java.hibernate.mapping.onetoone.joincolumn;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by egnanasigamony on 30/05/2017.
 */

/*
create table Address
(
    addressId BIGINT PRIMARY KEY AUTO_INCREMENT,
    street varchar(100),
    zipCode varchar(20),
    country varchar(50)
) AUTO_INCREMENT=1000000;
 */

@Entity
@Table(name = "Address")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;
    @Column(name="street")
    private String street;
    @Column(name="zipCode")
    private String zipCode;
    @Column(name="country")
    private String country;

    public Address() {

    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
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

}