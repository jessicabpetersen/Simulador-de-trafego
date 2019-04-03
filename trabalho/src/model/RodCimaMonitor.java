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
public class RodCimaMonitor extends Rodovia{

    public RodCimaMonitor() {
        super(new ImageIcon("img/rodoviaCima.png"));
    }
    @Override
    public boolean isGrama() {
        return false;
    }

    @Override
    void colocarCarro() throws InterruptedException {
        colocarCarroS();
    }

    @Override
    void retirarCarro() {
        retirarCarroS();
    }
    
    public synchronized void  colocarCarroS(){
        setImagem(new ImageIcon("img/carrocima.png"));
    }
    
    public synchronized void  retirarCarroS(){
        setImagem(new ImageIcon("img/rodoviaCima.png"));
    }

    
}
