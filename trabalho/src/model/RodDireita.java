/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.ImageIcon;

/**
 *
 * @author Jessica
 */
public class RodDireita extends Rodovia{
//    public boolean pontoInicial;
    public RodDireita() {
        super(new ImageIcon("img/rodoviaDireita.png"));
        pontoInicial = false;
    }
    
    @Override
    public boolean isGrama() {
        return false;
    }

}
