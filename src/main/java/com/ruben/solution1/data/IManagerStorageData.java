/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ruben.solution1.data;

/**
 *
 * @author home
 */
public interface IManagerStorageData {

    <T> Boolean addEntity(T entity);

    <T> Boolean delEntity(T entity);

    <T> Boolean modifyEntity(T entity);

}
