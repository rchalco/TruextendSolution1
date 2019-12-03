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
public class Factory {

    public static IManagerStorageData getManagerData() {
        return new MSDMockup();
    }
}
