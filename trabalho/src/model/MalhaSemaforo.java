/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author Jessica
 */
public class MalhaSemaforo extends Malha {

    private Random rand = new Random();

    public MalhaSemaforo(Campo[][] malha, int contagemPontosIniciais) {
        super(malha, contagemPontosIniciais);
    }

    @Override
    void andar() {
        iniciar();

    }

    public void iniciar() {
        int sorteado = rand.nextInt(qtddPontosIniciais);
        int colunaAtual = this.pontosIniciais[0][sorteado];
        int linhaAtual = pontosIniciais[1][sorteado];
       
    }


}
