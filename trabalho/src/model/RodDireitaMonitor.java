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
public class RodDireitaMonitor extends Rodovia{
//    public boolean pontoInicial;
    public RodDireitaMonitor() {
        super(new ImageIcon("img/rodoviaDireita.png"));
        pontoInicial = false;
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
        setImagem(new ImageIcon("img/carrodireita.png"));
    }
    
    public synchronized void  retirarCarroS(){
        setImagem(new ImageIcon("img/rodoviaDireita.png"));
    }

}
