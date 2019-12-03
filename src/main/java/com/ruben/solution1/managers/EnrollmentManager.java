/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ruben.solution1.managers;

import com.ruben.solution1.crosscutting.errors.ErrorManager;
import com.ruben.solution1.crosscutting.errors.FunctionalError;
import com.ruben.solution1.crosscutting.errors.TechnicalError;
import com.ruben.solution1.data.Factory;
import com.ruben.solution1.data.IManagerStorageData;
import com.ruben.solution1.models.Enrollment;
import com.ruben.solution1.models.GlobalData;
import com.ruben.solution1.models.Response;
import com.ruben.solution1.models.ResponseList;
import com.ruben.solution1.models.Student;
import com.ruben.solution1.models.state;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 *
 * @author home
 */
public class EnrollmentManager {

    IManagerStorageData managerStorageData = Factory.getManagerData();

    public ResponseList<Student> getAllStudent() {
        ResponseList<Student> resul = new ResponseList<Student>();
        try {
            resul.setData(GlobalData.getStudentData());
        } catch (Exception e) {
            ErrorManager.LogError(e);
        }
        return resul;
    }

    public ResponseList<com.ruben.solution1.models.Class> getAllClass() {
        ResponseList<com.ruben.solution1.models.Class> resul = new ResponseList<com.ruben.solution1.models.Class>();
        try {
            resul.setData(GlobalData.getClassData());
        } catch (Exception e) {
            ErrorManager.LogError(e);
        }
        return resul;
    }

    public Response CreateStudent(Student student) {
        Response resul = new Response();
        try {
            if (student.getFirstname() == null || student.getFirstname().isEmpty()
                    || student.getLastname() == null || student.getLastname().isEmpty()) {
                throw new FunctionalError("Invalid data!");
            }
            if (!managerStorageData.addEntity(student)) {
                throw new TechnicalError("Manager Storage damage!");
            }
            resul.setState(state.success);
            resul.setMessage("Student added");
        } catch (Exception e) {
            resul.setState(state.error);
            resul.setMessage(e.getMessage());
            ErrorManager.LogError(e);
        }
        return resul;
    }

    public Response EditStudent(Student student) {
        Response resul = new Response();
        try {
            if (student.getFirstname() == null || student.getFirstname().isEmpty()
                    || student.getLastname() == null || student.getLastname().isEmpty()) {
                throw new FunctionalError("Invalid data!");
            }
            if (!managerStorageData.modifyEntity(student)) {
                throw new TechnicalError("Manager Storage damage!");
            }
            resul.setState(state.success);
            resul.setMessage("Student added");
        } catch (Exception e) {
            resul.setState(state.error);
            resul.setMessage(e.getMessage());
            ErrorManager.LogError(e);
        }
        return resul;
    }

    public Response DelStudent(Student student) {
        Response resul = new Response();
        try {
            if (student.getStudentid() == 0) {
                throw new FunctionalError("Invalid data!");
            }
            if (!managerStorageData.delEntity(student)) {
                throw new TechnicalError("Manager Storage damage!");
            }
            resul.setState(state.success);
            resul.setMessage("Student added");
        } catch (Exception e) {
            resul.setState(state.error);
            resul.setMessage(e.getMessage());
            ErrorManager.LogError(e);
        }
        return resul;
    }

    public Response CreateClass(com.ruben.solution1.models.Class _class) {
        Response resul = new Response();
        try {
            if (_class.getCode() == null || _class.getCode().isEmpty()
                    || _class.getTitle() == null || _class.getTitle().isEmpty()
                    || _class.getDescription() == null || _class.getDescription().isEmpty()) {
                throw new FunctionalError("Invalid data!");
            }
            if (!managerStorageData.addEntity(_class)) {
                throw new TechnicalError("Manager Storage damage!");
            }
            resul.setState(state.success);
            resul.setMessage("Student added");
        } catch (Exception e) {
            resul.setState(state.error);
            resul.setMessage(e.getMessage());
            ErrorManager.LogError(e);
        }
        return resul;
    }

    public Response EditClass(com.ruben.solution1.models.Class _class) {
        Response resul = new Response();
        try {
            if (_class.getCode() == null || _class.getCode().isEmpty()
                    || _class.getTitle() == null || _class.getTitle().isEmpty()
                    || _class.getDescription() == null || _class.getDescription().isEmpty()) {
                throw new FunctionalError("Invalid data!");
            }
            if (!managerStorageData.modifyEntity(_class)) {
                throw new TechnicalError("Manager Storage damage!");
            }
            resul.setState(state.success);
            resul.setMessage("Student modifyed");
        } catch (Exception e) {
            resul.setState(state.error);
            resul.setMessage(e.getMessage());
            ErrorManager.LogError(e);
        }
        return resul;
    }

    public Response DelClass(com.ruben.solution1.models.Class _class) {
        Response resul = new Response();
        try {
            if (_class.getCode() == null || _class.getCode().isEmpty()) {
                throw new FunctionalError("Invalid data!");
            }
            if (!managerStorageData.delEntity(_class)) {
                throw new TechnicalError("Manager Storage damage!");
            }
            resul.setState(state.success);
            resul.setMessage("Student deleted");
        } catch (Exception e) {
            resul.setState(state.error);
            resul.setMessage(e.getMessage());
            ErrorManager.LogError(e);
        }
        return resul;
    }

    public ResponseList<Student> getStudentsByClass(String code) {
        ResponseList<Student> resul = new ResponseList<>();
        try {
            GlobalData.getEnrollmentData().forEach(enroll -> {
                if (enroll.getCode().equals(code)) {
                    if (resul.getData().stream().filter(y -> Objects.equals(enroll.getStudentid(), y.getStudentid())).count() == 0) {
                        resul.getData().add(GlobalData.getStudentData().stream().filter(z -> Objects.equals(z.getStudentid(), enroll.getStudentid())).findFirst().get());
                    }
                }
            });

        } catch (Exception e) {
            resul.setState(state.error);
            resul.setMessage(e.getMessage());
            ErrorManager.LogError(e);
        }
        return resul;
    }

    public ResponseList<com.ruben.solution1.models.Class> getClassByStudent(Long studentId) {
        ResponseList<com.ruben.solution1.models.Class> resul = new ResponseList<>();
        try {

            GlobalData.getEnrollmentData()
                    .forEach(x -> {
                        if (Objects.equals(x.getStudentid(), studentId)) {
                            if (resul.getData().stream().filter(y -> Objects.equals(x.getCode(), y.getCode())).count() == 0) {
                                resul.getData().add(GlobalData.getClassData().stream().filter(z -> Objects.equals(z.getCode(), x.getCode())).findFirst().get());
                            }
                        }
                    });
        } catch (Exception e) {
            resul.setState(state.error);
            resul.setMessage(e.getMessage());
            ErrorManager.LogError(e);
        }
        return resul;
    }
    
    public ResponseList<Enrollment> getInfoEnrollment() {
    ResponseList<Enrollment> resul = new ResponseList<>();
        try {

            GlobalData.getEnrollmentData()
                    .forEach(x -> {
                        x.setStudent(GlobalData.getStudentData().stream().filter(z -> Objects.equals(z.getStudentid(), x.getStudentid())).findFirst().get());
                        x.set_Class(GlobalData.getClassData().stream().filter(z -> Objects.equals(z.getCode(), x.getCode())).findFirst().get());
                        
                    });
            resul.setData(GlobalData.getEnrollmentData());
        } catch (Exception e) {
            resul.setState(state.error);
            resul.setMessage(e.getMessage());
            ErrorManager.LogError(e);
        }
        return resul;
    }

}
