/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiktaktoe;

/**
 *
 * @author aqibj
 */
public class main {
    
    public static void main(String args[])
    {
        tictaktoemodel model = new tictaktoemodel();
        tictak_gui gui = new tictak_gui();
        tiktakcontroller controller = new tiktakcontroller(model, gui);
        controller.initview();
        controller.play();
        
    }
    
}
