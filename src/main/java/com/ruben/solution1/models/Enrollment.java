/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ruben.solution1.models;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author home
 */
@XmlRootElement
public class Enrollment implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long enrollmentid;
    private String code;
    private Long studentid;
    private Student student;
    private Class _class;

    public Enrollment() {
    }

    public Enrollment(Long enrollmentId, String _code, Long _Studentid) {
        this.enrollmentid = enrollmentId;
        this.code = _code;
        this.studentid = _Studentid;
    }

    public Long getEnrollmentid() {
        return enrollmentid;
    }

    public void setEnrollmentid(Long enrollmentid) {
        this.enrollmentid = enrollmentid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }

    /**
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * @return the _class
     */
    public Class get_Class() {
        return _class;
    }

    /**
     * @param _class the _class to set
     */
    public void set_Class(Class _class) {
        this._class = _class;
    }

}
