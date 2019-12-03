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
public class FunctionalError extends Exception{
    public FunctionalError(String message) {
        super(message);
    }
}
