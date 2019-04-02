/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.concurrent.Semaphore;
import javax.swing.ImageIcon;

/**
 *
 * @author Jessica
 */
public class RodEsquerdaSemaforo extends Rodovia{
    
    private Semaphore mutex = new Semaphore(1);

    public RodEsquerdaSemaforo() {
        super(new ImageIcon("img/rodoviaEsquerda.png"));
    }
    
    @Override
    public boolean isGrama() {
        return false;
    }
    
    @Override
    public void colocarCarro() throws InterruptedException{
        mutex.acquire();
        setImagem(new ImageIcon("img/carroesquerda.png"));
    }
    
    @Override
    public void retirarCarro(){
        setImagem(new ImageIcon("img/rodoviaEsquerda.png"));
        mutex.release();
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
