/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Controller;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Jessica
 */
public class Carro extends Thread {

    private Malha malha;
    private Random rand = new Random();
    int linha, coluna, direcao;
    Campo[][] malhaRodoviaria;
    Controller c;

    public Carro(Malha malha, Controller c) {
        this.malha = malha;
        this.c = c;
    }

    @Override
    public void run() {
        try {
            iniciar();
            sleep(2000);
            c.notificarMovimento();
            andar();
        } catch (InterruptedException ex) {
            Logger.getLogger(Carro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void iniciar() throws InterruptedException {
        int iniciar = rand.nextInt(malha.getContagemPontosIniciais());
        int pontos[][] = malha.getPontosIniciais();
        coluna = pontos[0][iniciar];
        linha = pontos[1][iniciar];
        malhaRodoviaria = malha.getMalhaRodoviaria();
        malhaRodoviaria[coluna][linha].colocarCarro();

    }

    private void andar() throws InterruptedException {
        while (linha < malha.getLinhasTotais() || coluna < malha.getColunasTotais()) {
            if (malhaRodoviaria[coluna][linha].getClass() == RodBaixoSemaforo.class) {
                malhaRodoviaria[coluna][(linha + 1)].colocarCarro();
                malhaRodoviaria[coluna][linha].retirarCarro();
                linha++;
            } else {
                if (malhaRodoviaria[coluna][linha].getClass() == RodCimaSemaforo.class) {
                    malhaRodoviaria[coluna][(linha - 1)].colocarCarro();
                    malhaRodoviaria[coluna][linha].retirarCarro();
                    linha--;

                } else {
                    if (malhaRodoviaria[coluna][linha].getClass() == RodDireitaSemaforo.class) {
                        malhaRodoviaria[(coluna + 1)][linha].colocarCarro();
                        malhaRodoviaria[coluna][linha].retirarCarro();
                        coluna++;
                    } else {
                        if (malhaRodoviaria[coluna][linha].getClass() == RodEsquerdaSemaforo.class) {
                            malhaRodoviaria[(coluna - 1)][linha].colocarCarro();
                            malhaRodoviaria[coluna][linha].retirarCarro();
                            coluna--;
                        } else {//cruzamento

                        }
                    }
                }
            }
            c.notificarMovimento();
            sleep(800);
        }
    }

}
