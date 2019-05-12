package com.ordermate.dao;

import edu.java.hibernate.mapping.onetoone.mapsid.Student;
import edu.java.hibernate.mapping.onetoone.mapsid.StudentDetails;
import java.util.Calendar;
import org.junit.Test;

public class OneToOneMapsIdTest extends AbstractTest
{

    @Test
    public void testMapsId()
    {
        beginTransaction();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 7);
        calendar.set(Calendar.MONTH, 04);
        calendar.set(Calendar.YEAR, 1975);

        Student student = new Student();
        student.setName("Edwin");

        StudentDetails studentDetails = new StudentDetails();

        studentDetails.setAddress("95 Harmony Drive");
        studentDetails.setDateOfBirth(calendar.getTime());
        studentDetails.setStudent(student);

        save(student);
        save(studentDetails);

        commit();
        Student s1 = (Student) session.get(Student.class, studentDetails.getStudent().getId());

        System.out.println("THe name of Student : "+s1.getName());
    }

}
