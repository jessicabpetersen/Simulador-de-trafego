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
public class RodEsquerdaMonitor extends Rodovia{

    public RodEsquerdaMonitor() {
        super(new ImageIcon("img/rodoviaEsquerda.png"));
    }
    
    @Override
    public boolean isGrama() {
        return false;
    }

    @Override
    void colocarCarro() throws InterruptedException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void retirarCarro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    boolean isDireita() {
//        return false;
//    }
//
//    @Override
//    boolean isEsquerda() {
//        return true;
//    }
//
//    @Override
//    boolean isBaixo() {
//        return false;
//    }
//
//    @Override
//    boolean isCima() {
//        return false;
//    }

    

}
