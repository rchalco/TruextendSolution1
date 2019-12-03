/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ruben.solution1.models;

import java.util.*;

/**
 *
 * @author home
 */
public class GlobalData {

    private static List<Class> classData;
    private static List<Student> studentData;
    private static List<Enrollment> enrollmentData;

    /**
     * @return the classData
     */
    public static List<Class> getClassData() {
        if (classData == null) {
            classData = new ArrayList<Class>();
            Class class1 = new Class("MAT001", "Mathematics", "Mathematics");
            classData.add(class1);
            class1 = new Class("PHY001", "Physics", "Physics");
            classData.add(class1);
            class1 = new Class("CHET001", "Chemistry", "Chemistry");
            classData.add(class1);
        }
        return classData;
    }

    /**
     * @return the studentData
     */
    public static List<Student> getStudentData() {
        if (studentData == null) {
            studentData = new ArrayList<Student>();
            Student s1 = new Student(1L, "Ruben", "Chalco");
            studentData.add(s1);
            s1 = new Student(2L, "Carlos", "Collazos");
            studentData.add(s1);
            s1 = new Student(3L, "Sergio", "Caballero");
            studentData.add(s1);
        }
        return studentData;
    }

    /**
     * @return the enrollmentData
     */
    public static List<Enrollment> getEnrollmentData() {
        if (enrollmentData == null) {
            enrollmentData = new ArrayList<Enrollment>();
            Enrollment e1 = new Enrollment(1L, "MAT001", 1L);
            enrollmentData.add(e1);
            e1 = new Enrollment(1L, "PHY001", 1L);
            enrollmentData.add(e1);
            e1 = new Enrollment(1L, "CHET001", 1L);
            enrollmentData.add(e1);
            e1 = new Enrollment(1L, "MAT001", 2L);
            enrollmentData.add(e1);
            e1 = new Enrollment(1L, "CHET001", 2L);
            enrollmentData.add(e1);
            e1 = new Enrollment(1L, "PHY001", 3L);
            enrollmentData.add(e1);

        }
        return enrollmentData;
    }

}
