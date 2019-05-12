package edu.java.hibernate.mapping.onetoone.mapsid;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**

 create table student_details
 (
 fk_student bigint,
 date_of_birth DATE,
 address varchar(255),
 foreign key (fk_student) references student(id)
 )

 */

@Entity
@Table(name="student_details")
public class StudentDetails
{
    @Id
    @Column(name="fk_student")
    private long fkStudent;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name="address")
    private String address;


    @MapsId
    @OneToOne
    @JoinColumn(name="fk_student")
    private Student student;

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public Student getStudent()
    {
        return student;
    }

    public void setStudent(Student student)
    {
        this.student = student;
    }
}