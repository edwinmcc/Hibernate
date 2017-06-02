package edu.java.hibernate.mapping.onetoone.joincolumn;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by egnanasigamony on 29/05/2017.
 */

/*
create table HUser
(
    userId bigint primary key auto_increment,
    firstName varchar(100),
    lastName  varchar(100),
    userName  varchar(100),
    password  varchar(100),
    email     varchar(150),
    addressId bigint,
    foreign key (addressId) references Address(addressId) ON DELETE CASCADE
) auto_increment=1000000;
*/

@Entity
@Table(name="HUser")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="userName")
    private String userName;
    @Column(name="password")
    private char[] password;
    @Column(name="email")
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="addressId")
    private Address address;

    public User() {

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}