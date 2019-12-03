/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ruben.solution1;

import com.ruben.solution1.managers.EnrollmentManager;
import com.ruben.solution1.models.*;
import java.util.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author home
 */
@Path("EnrollmentService")
@RequestScoped
public class EnrollmentServiceResource {

    @Context
    private UriInfo context;

    private EnrollmentManager enrollmentManager = new EnrollmentManager();

    /**
     * Creates a new instance of EnrollmentServiceResource
     */
    public EnrollmentServiceResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllClass")
    public ResponseList<com.ruben.solution1.models.Class> getAllClass()  {
        return enrollmentManager.getAllClass();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllStudent")
    public ResponseList<Student> getAllStudent() {
        return enrollmentManager.getAllStudent();
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("CreateStudent")
    public Response CreateStudent(Student student) {
        return enrollmentManager.CreateStudent(student);
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("EditStudent")
    public Response EditStudent(Student student) {
        return enrollmentManager.EditStudent(student);
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("DelStudent")
    public Response DelStudent(Student student) {
        return enrollmentManager.DelStudent(student);
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("CreateClass")
    public Response CreateClass(com.ruben.solution1.models.Class _class) {
        return enrollmentManager.CreateClass(_class);
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("EditClass")
    public Response EditClass(com.ruben.solution1.models.Class _class) {
        return enrollmentManager.EditClass(_class);
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("DelClass")
    public Response DelClass(com.ruben.solution1.models.Class _class) {
        return enrollmentManager.DelClass(_class);
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getStudentsByClass")
    public ResponseList<Student> getStudentsByClass(String code) {
        return enrollmentManager.getStudentsByClass(code);
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getClassByStudent")
    public ResponseList<com.ruben.solution1.models.Class> getClassByStudent(Long studentId){
        return enrollmentManager.getClassByStudent(studentId);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getInfoEnrollment")
    public ResponseList<Enrollment> getInfoEnrollment() {
        return enrollmentManager.getInfoEnrollment();
    }
}
