/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ruben.solution1.data;

import com.ruben.solution1.models.GlobalData;
import com.ruben.solution1.models.Student;
import java.util.Objects;

/**
 *
 * @author home
 */
public class MSDMockup implements IManagerStorageData {

    @Override
    public <T> Boolean addEntity(T entity) {
        Boolean resul = true;
        if (entity instanceof Student) {
            GlobalData.getStudentData().add((Student) entity);
        } else if (entity instanceof com.ruben.solution1.models.Class) {
            GlobalData.getClassData().add((com.ruben.solution1.models.Class) entity);
        } else {
            resul = false;
        }
        return resul;
    }

    @Override
    public <T> Boolean delEntity(T entity) {
        Boolean resul = true;
        if (entity instanceof Student) {
            Student student = GlobalData.getStudentData().stream()
                    .filter( x -> Objects.equals(x.getStudentid(), ((Student)entity).getStudentid()))
                    .findFirst().get();
            GlobalData.getStudentData().remove(student);
        } else if (entity instanceof com.ruben.solution1.models.Class) {
            com.ruben.solution1.models.Class _class = GlobalData.getClassData().stream()
                    .filter( x -> Objects.equals(x.getCode(), ((com.ruben.solution1.models.Class)entity).getCode()))
                    .findFirst().get();
            GlobalData.getClassData().remove(_class);
        } else {
            resul = false;
        }
        return resul;
    }

    @Override
    public <T> Boolean modifyEntity(T entity) {
        Boolean resul = true;
        if (entity instanceof Student) {
            Student student = GlobalData.getStudentData().stream()
                    .filter( x -> Objects.equals(x.getStudentid(), ((Student)entity).getStudentid()))
                    .findFirst().get();
            student.setFirstname(((Student)entity).getFirstname());
            student.setLastname(((Student)entity).getLastname());
        } else if (entity instanceof com.ruben.solution1.models.Class) {
            com.ruben.solution1.models.Class _class = GlobalData.getClassData().stream()
                    .filter( x -> Objects.equals(x.getCode(), ((com.ruben.solution1.models.Class)entity).getCode()))
                    .findFirst().get();
            _class.setTitle(((com.ruben.solution1.models.Class)entity).getTitle());
            _class.setDescription(((com.ruben.solution1.models.Class)entity).getDescription());
        } else {
            resul = false;
        }
        return resul;
    }

}
