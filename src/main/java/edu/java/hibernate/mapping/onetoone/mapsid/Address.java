package edu.java.hibernate.mapping.onetoone.mapsid;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by egnanasigamony on 30/05/2017.
 */

/*
create table Address
(
    addressId BIGINT PRIMARY KEY,
    street varchar(100),
    zipCode varchar(20),
    country varchar(50),
    foreign key (addressId) references HUser(userId) ON DELETE CASCADE
);
 */

@Entity
@Table(name = "Address")
public class Address implements Serializable {

    @Id
    @GeneratedValue
    private Long addressId;
    @Column(name="street")
    private String street;
    @Column(name="zipCode")
    private String zipCode;
    @Column(name="country")
    private String country;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name="addressId")
    private User user;
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

    public void setUser(User user) {
        this.user=user;
    }

    public User getUser() {
        return user;
    }

    public boolean equals(Object o) {
        if(this==o) {
            return true;
        }
        if(o==null) {
            return false;
        }
        if(!(o instanceof Address)) {
            return false;
        }
        Address address=(Address)o;
        return Objects.equals(getStreet(),address.getStreet())
                && Objects.equals(getZipCode(),address.getZipCode())
                && Objects.equals(getCountry(),address.getCountry());
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
