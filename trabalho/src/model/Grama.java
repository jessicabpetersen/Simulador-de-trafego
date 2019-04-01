/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Jessica
 */
public class Grama extends Campo {
    
    
    public Grama() {
        super(new ImageIcon("img/grama.png"));
    }

    @Override
    public boolean isGrama() {
        return true;
    }

   
    
}
