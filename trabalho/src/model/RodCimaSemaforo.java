/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.concurrent.Semaphore;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Jessica
 */
public class RodCimaSemaforo extends Rodovia{
    
    private Semaphore mutex = new Semaphore(1);

    public RodCimaSemaforo() {
        super(new ImageIcon("img/rodoviaCima.png"));
    }
    @Override
    public boolean isGrama() {
        return false;
    }

     @Override
    void colocarCarro() throws InterruptedException {
        mutex.acquire();
        setImagem(new ImageIcon("img/carrocima.png"));
    }

    @Override
    void retirarCarro() {
        setImagem(new ImageIcon("img/rodoviaCima.png"));
        mutex.release();
    }

//    @Override
//    boolean isDireita() {
//        return false;
//    }
//
//    @Override
//    boolean isEsquerda() {
//        return false;
//    }
//
//    @Override
//    boolean isBaixo() {
//        return false;
//    }
//
//    @Override
//    boolean isCima() {
//        return true;
//    }
    
}
