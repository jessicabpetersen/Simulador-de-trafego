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
    void  colocarCarro() throws InterruptedException {
        colocarCarroS();
    }

    @Override
    void retirarCarro() {
        retirarCarroS();
    }
    public synchronized void  colocarCarroS(){
        setImagem(new ImageIcon("img/carroesquerda.png"));
    }
    
    public synchronized void  retirarCarroS(){
        setImagem(new ImageIcon("img/rodoviaEsquerda.png"));
    }

}
