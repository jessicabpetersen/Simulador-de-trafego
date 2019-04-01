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
public class RodCruzamento extends Rodovia{

    public RodCruzamento() {
        super(new ImageIcon("img/cruzamento.png"));
    }
    @Override
    public boolean isGrama() {
        return false;
    }

   
}
