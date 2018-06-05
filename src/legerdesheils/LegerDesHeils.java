/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legerdesheils;

import legerdesheils.controller.Controller;

/**
 *
 * @author test
 */
public class LegerDesHeils {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controller controller = new Controller("leger des heils", 1020,980);
        controller.start();
    }
    
}
