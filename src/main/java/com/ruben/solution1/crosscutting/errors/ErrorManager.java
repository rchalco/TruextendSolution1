/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ruben.solution1.crosscutting.errors;

/**
 *
 * @author home
 */
public class ErrorManager {
    public static void LogError(Exception e){
        if (e instanceof FunctionalError) {
            //wirte log, level 1
        }
        else if (e instanceof FunctionalError) {
            //wirte log  and notify, level 2
        }
        else{
            //wirte log  and notify, level 3 (serious)
        }
    }
}
