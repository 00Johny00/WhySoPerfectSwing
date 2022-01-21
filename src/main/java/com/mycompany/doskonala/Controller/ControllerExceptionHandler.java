/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.doskonala.Controller;

/**
 *
 * @author
 * @version 1
 */
/**
 ControllerExceptionHandler class*/
public class ControllerExceptionHandler extends Exception{
    
    /**
     ControllerExceptionHandler class
     Handle our exception from wrongly typed numbers into compartments.
     */
    public ControllerExceptionHandler() {

        super("Wrong typed compartments. Compartment should be higher then 0, and lower must be lower then higher");
    }
}
