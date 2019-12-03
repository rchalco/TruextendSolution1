/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ruben.solution1.models;

import java.io.Serializable;

/**
 *
 * @author home
 */
public class Response implements Serializable{
    private String message;
    private state state;

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the state
     */
    public state getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(state state) {
        this.state = state;
    }
}
