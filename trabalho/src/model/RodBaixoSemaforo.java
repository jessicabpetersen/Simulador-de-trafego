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
public class RodBaixoSemaforo extends Rodovia{

    private Semaphore mutex = new Semaphore(1);
    
    public RodBaixoSemaforo() {
        super(new ImageIcon("img/rodoviaBaixo.png"));
    }

    @Override
    public boolean isGrama() {
        return false;
    }
     @Override
    void colocarCarro() throws InterruptedException {
        mutex.acquire();
        setImagem(new ImageIcon("img/carrobaixo.png"));
    }

    @Override
    void retirarCarro() {
        setImagem(new ImageIcon("img/rodoviaBaixo.png"));
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
//        return true;
//    }
//
//    @Override
//    boolean isCima() {
//        return false;
//    }
}
