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
public class RodDireitaSemaforo extends Rodovia {

    private Semaphore mutex = new Semaphore(1);
//    public boolean pontoInicial;

    public RodDireitaSemaforo() {
        super(new ImageIcon("img/rodoviaDireita.png"));
        pontoInicial = false;
    }

    @Override
    public boolean isGrama() {
        return false;
    }

    @Override
    void colocarCarro() throws InterruptedException {
        mutex.acquire();
        setImagem(new ImageIcon("img/carrodireita.png"));
    }

    @Override
    void retirarCarro() {
        setImagem(new ImageIcon("img/rodoviaDireita.png"));
        mutex.release();
    }

//    @Override
//    boolean isDireita() {
//        return true;
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
//        return false;
//    }

}
