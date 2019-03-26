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

    public Campo(Icon imagem) {
        this.imagem = imagem;
        pontoInicial = false;
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
}
