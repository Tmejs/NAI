/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.nai;


/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public class AppModel {

    private final App frame=App.instance();
     
    public AppModel() {
        frame.setModel(this);
    }
    
    public void showFrame(){
        frame.setVisible(true);
    }
    
    
    
    
}
