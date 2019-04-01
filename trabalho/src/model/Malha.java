/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Scanner;

/**
 *
 * @author Jessica
 */
public abstract class Malha {
    
    private Campo[][] malhaRodoviaria;
    private int[][] pontosIniciais;
    private int contagemPontosIniciais, coluna, linha;

    public int getContagemPontosIniciais() {
        return contagemPontosIniciais;
    }
    
    public Malha(Campo[][] malha, int contagemPontosIniciais){
        this.malhaRodoviaria = malha;
        this.contagemPontosIniciais = contagemPontosIniciais;
    }
    
    public void carregaMalha(int coluna, int linha) {
        this.coluna = coluna;
        this.linha = linha;
        for (int i = 0; i < coluna; i++) {
            for (int j = 0; j < linha; j++) {
                this.malhaRodoviaria[i][j] = new Grama();
            }
        }
    }
    
    public void carrega(Scanner scanX) {
        int colunaInicial = scanX.nextInt();
        int linhaInicial = scanX.nextInt();
        int colunaFinal = scanX.nextInt();
        int linhaFinal = scanX.nextInt();

        // verifica se ta indo horizontalmente ou verticalmente
        if (linhaInicial == linhaFinal) {  //horizontalmente
            //direita ou esquerda
            if (colunaInicial < colunaFinal) { //direita
                for (int i = colunaInicial; i <= colunaFinal; i++) {
                    if (!cruzamento(linhaInicial, i)) {
                        malhaRodoviaria[i][linhaInicial] = new RodDireita();
                    }
                }
                if (colunaInicial == 0) {
                    contagemPontosIniciais++;
                    malhaRodoviaria[colunaInicial][linhaInicial].tornarPontoInicial();
                }
            } else {//esquerda
                for (int i = colunaInicial; i >= colunaFinal; i--) {
                    if (!cruzamento(linhaInicial, i)) {
                        malhaRodoviaria[i][linhaInicial] = new RodEsquerda();
                    }
                }
                if (colunaInicial == (coluna - 1)) {
                    contagemPontosIniciais++;
                    malhaRodoviaria[colunaInicial][linhaInicial].tornarPontoInicial();
                }
            }
        } else { //verticalmente
            if (linhaInicial < linhaFinal) { //baixo
                for (int i = linhaInicial; i <= linhaFinal; i++) {
                    if (!cruzamento(i, colunaInicial)) {
                        malhaRodoviaria[colunaFinal][i] = new RodBaixo();

                    }
                }
                if (linhaInicial == 0) {
                    contagemPontosIniciais++;
                    malhaRodoviaria[colunaInicial][linhaInicial].tornarPontoInicial();
                }
            } else {// cima
                for (int i = linhaInicial; i >= linhaFinal; i--) {
                    if (!cruzamento(i, colunaInicial)) {
                        malhaRodoviaria[colunaFinal][i] = new RodCima();
                    }
                }
                if (linhaInicial == (linha - 1)) {
                    contagemPontosIniciais++;
                    malhaRodoviaria[colunaInicial][linhaInicial].tornarPontoInicial();
                }
            }
        }
        
    }
    
    public boolean cruzamento(int linha, int coluna) {
        if (!malhaRodoviaria[coluna][linha].isGrama()) {
            malhaRodoviaria[coluna][linha] = new RodCruzamento();
            return true;
        } else {
            return false;
        }
    }
    
    public void pontosIniciais(){
        pontosIniciais = new int[2][contagemPontosIniciais];
            int linhaMatrizPontos = 0;
            int colunaMatrizPontos = 0;
            for (int i = 0; i < linha; i++) {
                for (int j = 0; j < coluna; j++) {
                    if (malhaRodoviaria[j][i].isPontoInicial()) {
                        this.pontosIniciais[colunaMatrizPontos][linhaMatrizPontos] = j;
                        colunaMatrizPontos++;
                        this.pontosIniciais[colunaMatrizPontos][linhaMatrizPontos] = i;
                        colunaMatrizPontos = 0;
                        linhaMatrizPontos++;
                    }
                }
            }
            retirarCruzamentosFalsos();
    }
    public void retirarCruzamentosFalsos() {
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                if (malhaRodoviaria[j][i].getClass() == RodCruzamento.class) {
                    if (malhaRodoviaria[(j - 1)][i].getClass() == RodDireita.class) {

                        if (!((malhaRodoviaria[j][(i - 1)].getClass() == RodCima.class) && ((malhaRodoviaria[(j + 1)][i].getClass() == RodDireita.class) || malhaRodoviaria[j][(i + 1)].getClass() == RodBaixo.class))
                                && !((malhaRodoviaria[(j + 1)][i].getClass() == RodDireita.class) && ((malhaRodoviaria[j][(i - 1)].getClass() == RodCima.class) || (malhaRodoviaria[j][(i + 1)].getClass() == RodBaixo.class)))
                                && !((malhaRodoviaria[j][(i + 1)].getClass() == RodBaixo.class) && ((malhaRodoviaria[(j + 1)][i].getClass() == RodDireita.class) || (malhaRodoviaria[j][(i - 1)].getClass() == RodCima.class)))) {

                            if (malhaRodoviaria[j][(i - 1)].getClass() == RodCima.class) {
                                malhaRodoviaria[j][i] = new RodCima();
                            } else {
                                if (malhaRodoviaria[(j + 1)][i].getClass() == RodDireita.class) {
                                    malhaRodoviaria[j][i] = new RodDireita();
                                } else {
                                    malhaRodoviaria[j][i] = new RodBaixo();
                                }
                            }
                        }
                    } else {
                        if (malhaRodoviaria[(j + 1)][i].getClass() == RodEsquerda.class) {

                            if (!((malhaRodoviaria[(j - 1)][i].getClass() == RodEsquerda.class) && ((malhaRodoviaria[j][(i - 1)].getClass() == RodCima.class) || (malhaRodoviaria[j][(i + 1)].getClass() == RodBaixo.class)))
                                    && !((malhaRodoviaria[j][(i - 1)].getClass() == RodCima.class) && ((malhaRodoviaria[(j - 1)][i].getClass() == RodEsquerda.class) || (malhaRodoviaria[j][(i + 1)].getClass() == RodBaixo.class)))
                                    && !((malhaRodoviaria[j][(i + 1)].getClass() == RodBaixo.class) && ((malhaRodoviaria[j][(i - 1)].getClass() == RodCima.class) || (malhaRodoviaria[(j - 1)][i].getClass() == RodEsquerda.class)))) {

                                if (malhaRodoviaria[(j - 1)][i].getClass() == RodEsquerda.class) {
                                    malhaRodoviaria[j][i] = new RodEsquerda();
                                } else {
                                    if (malhaRodoviaria[j][(i - 1)].getClass() == RodCima.class) {
                                        malhaRodoviaria[j][i] = new RodCima();
                                    } else {
                                        malhaRodoviaria[j][i] = new RodBaixo();
                                    }
                                }
                            }
                        } else {
                            if (malhaRodoviaria[j][(i - 1)].getClass() == RodBaixo.class) {

                                if (!((malhaRodoviaria[(j + 1)][i].getClass() == RodDireita.class) && ((malhaRodoviaria[j][(i + 1)].getClass() == RodBaixo.class) || (malhaRodoviaria[(j - 1)][i].getClass() == RodEsquerda.class)))
                                        && !((malhaRodoviaria[j][(i + 1)].getClass() == RodBaixo.class) && ((malhaRodoviaria[(j + 1)][i].getClass() == RodDireita.class) || (malhaRodoviaria[(j - 1)][i].getClass() == RodEsquerda.class)))
                                        && !((malhaRodoviaria[(j - 1)][i].getClass() == RodEsquerda.class) && ((malhaRodoviaria[j][(i + 1)].getClass() == RodBaixo.class) || (malhaRodoviaria[(j + 1)][i].getClass() == RodDireita.class)))) {

                                    if (malhaRodoviaria[(j - 1)][i].getClass() == RodEsquerda.class) {
                                        malhaRodoviaria[j][i] = new RodEsquerda();
                                    } else {
                                        if (malhaRodoviaria[(j + 1)][i].getClass() == RodDireita.class) {
                                            malhaRodoviaria[j][i] = new RodDireita();

                                        } else {
                                            malhaRodoviaria[j][i] = new RodBaixo();
                                        }
                                    }

                                }
                            } else {
                                if (malhaRodoviaria[j][(i + 1)].getClass() == RodCima.class) {
                                    if (!((malhaRodoviaria[j][(i - 1)].getClass() == RodCima.class) && ((malhaRodoviaria[(j + 1)][i].getClass() == RodDireita.class) || (malhaRodoviaria[(j - 1)][i].getClass() == RodEsquerda.class)))
                                            && !((malhaRodoviaria[(j + 1)][i].getClass() == RodDireita.class) && ((malhaRodoviaria[j][(i - 1)].getClass() == RodCima.class) || (malhaRodoviaria[(j - 1)][i].getClass() == RodEsquerda.class)))
                                            && !((malhaRodoviaria[(j - 1)][i].getClass() == RodEsquerda.class) && ((malhaRodoviaria[(j + 1)][i].getClass() == RodDireita.class) || (malhaRodoviaria[j][(i - 1)].getClass() == RodCima.class)))) {

                                        if (malhaRodoviaria[j][(i - 1)].getClass() == RodCima.class) {
                                            malhaRodoviaria[j][i] = new RodCima();
                                        } else {
                                            if (malhaRodoviaria[(j + 1)][i].getClass() == RodDireita.class) {
                                                malhaRodoviaria[j][i] = new RodDireita();
                                            } else {
                                                malhaRodoviaria[j][i] = new RodEsquerda();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    abstract void andar();
}
