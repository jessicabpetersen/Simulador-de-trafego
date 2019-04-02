/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.Icon;

/**
 *
 * @author Jessica
 */
public abstract class Campo {
    private Icon imagem;
    boolean pontoInicial;
    boolean carro;

    public Campo(Icon imagem) {
        this.imagem = imagem;
        pontoInicial = false;
        carro = false;
    }

    public boolean isCarro() {
        return carro;
    }

    public void setCarro(boolean carro) {
        this.carro = carro;
    }
    
    

    public void setImagem(Icon imagem) {
        this.imagem = imagem;
    }

    public Icon getImagem() {
        return imagem;
    }
    
    public abstract boolean isGrama();
    
    public boolean isPontoInicial(){
        return pontoInicial;
    }
    
    public void tornarPontoInicial(){
        this.pontoInicial = true;
    }
    
    abstract void colocarCarro() throws InterruptedException;
    
    abstract void retirarCarro();
    
//    abstract boolean isDireita();
//    
//    abstract boolean isEsquerda();
//    
//    abstract boolean isBaixo();
//    
//    abstract boolean isCima();
    
   
}
