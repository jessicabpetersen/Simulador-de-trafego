/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jessica
 */
public class Malha {
    
    protected Campo[][] malhaRodoviaria;
    protected int[][] pontosIniciais;
    protected int contagemPontosIniciais, colunasTotais, linhasTotais, saidaVeiculo;
    protected Random rand = new Random();

    public int getContagemPontosIniciais() {
        return contagemPontosIniciais;
    }
    
    public Malha(Campo[][] malha, int contagemPontosIniciais, int saidaVeiculo){
        this.malhaRodoviaria = malha;
        this.contagemPontosIniciais = contagemPontosIniciais;
        this.saidaVeiculo = saidaVeiculo;
    }
    
    public void carregaMalha(int coluna, int linha) {
        this.colunasTotais = coluna;
        this.linhasTotais = linha;
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
        if(saidaVeiculo == 1){
            carregarSemafoto(colunaInicial, linhaInicial, colunaFinal, linhaFinal);
        }else{
            carregaMonitor(colunaInicial, linhaInicial, colunaFinal, linhaFinal);
        }

       
        
    }
    
    public void carregarSemafoto(int colunaInicial, int linhaInicial, int colunaFinal, int linhaFinal){
         // verifica se ta indo horizontalmente ou verticalmente
        if (linhaInicial == linhaFinal) {  //horizontalmente
            //direita ou esquerda
            if (colunaInicial < colunaFinal) { //direita
                for (int i = colunaInicial; i <= colunaFinal; i++) {
                    if (!cruzamento(linhaInicial, i)) {
                        malhaRodoviaria[i][linhaInicial] = new RodDireitaSemaforo();
                    }
                }
                if (colunaInicial == 0) {
                    contagemPontosIniciais++;
                    malhaRodoviaria[colunaInicial][linhaInicial].tornarPontoInicial();
                }
                if(colunaFinal == (colunasTotais-1)){
                    malhaRodoviaria[colunaFinal][linhaFinal].tornarPontoFinal();
                }
            } else {//esquerda
                for (int i = colunaInicial; i >= colunaFinal; i--) {
                    if (!cruzamento(linhaInicial, i)) {
                        malhaRodoviaria[i][linhaInicial] = new RodEsquerdaSemaforo();
                    }
                }
                if (colunaInicial == (colunasTotais - 1)) {
                    contagemPontosIniciais++;
                    malhaRodoviaria[colunaInicial][linhaInicial].tornarPontoInicial();
                }
                if(colunaFinal == 0){
                    malhaRodoviaria[colunaFinal][linhaFinal].tornarPontoFinal();
                }
            }
        } else { //verticalmente
            if (linhaInicial < linhaFinal) { //baixo
                for (int i = linhaInicial; i <= linhaFinal; i++) {
                    if (!cruzamento(i, colunaInicial)) {
                        malhaRodoviaria[colunaFinal][i] = new RodBaixoSemaforo();

                    }
                }
                if (linhaInicial == 0) {
                    contagemPontosIniciais++;
                    malhaRodoviaria[colunaInicial][linhaInicial].tornarPontoInicial();
                }
                if(linhaFinal == (linhasTotais -1)){
                    malhaRodoviaria[colunaFinal][linhaFinal].tornarPontoFinal();
                }
            } else {// cima
                for (int i = linhaInicial; i >= linhaFinal; i--) {
                    if (!cruzamento(i, colunaInicial)) {
                        malhaRodoviaria[colunaFinal][i] = new RodCimaSemaforo();
                    }
                }
                if (linhaInicial == (linhasTotais - 1)) {
                    contagemPontosIniciais++;
                    malhaRodoviaria[colunaInicial][linhaInicial].tornarPontoInicial();
                }
                if(linhaFinal == 0){
                    malhaRodoviaria[colunaFinal][linhaFinal].tornarPontoFinal();
                }
            }
        }
    }
    
    public void carregaMonitor(int colunaInicial, int linhaInicial, int colunaFinal, int linhaFinal){
         // verifica se ta indo horizontalmente ou verticalmente
        if (linhaInicial == linhaFinal) {  //horizontalmente
            //direita ou esquerda
            if (colunaInicial < colunaFinal) { //direita
                for (int i = colunaInicial; i <= colunaFinal; i++) {
                    if (!cruzamento(linhaInicial, i)) {
                        malhaRodoviaria[i][linhaInicial] = new RodDireitaMonitor();
                    }
                }
                if (colunaInicial == 0) {
                    contagemPontosIniciais++;
                    malhaRodoviaria[colunaInicial][linhaInicial].tornarPontoInicial();
                }
            } else {//esquerda
                for (int i = colunaInicial; i >= colunaFinal; i--) {
                    if (!cruzamento(linhaInicial, i)) {
                        malhaRodoviaria[i][linhaInicial] = new RodEsquerdaMonitor();
                    }
                }
                if (colunaInicial == (colunasTotais - 1)) {
                    contagemPontosIniciais++;
                    malhaRodoviaria[colunaInicial][linhaInicial].tornarPontoInicial();
                }
            }
        } else { //verticalmente
            if (linhaInicial < linhaFinal) { //baixo
                for (int i = linhaInicial; i <= linhaFinal; i++) {
                    if (!cruzamento(i, colunaInicial)) {
                        malhaRodoviaria[colunaFinal][i] = new RodBaixoMonitor();

                    }
                }
                if (linhaInicial == 0) {
                    contagemPontosIniciais++;
                    malhaRodoviaria[colunaInicial][linhaInicial].tornarPontoInicial();
                }
            } else {// cima
                for (int i = linhaInicial; i >= linhaFinal; i--) {
                    if (!cruzamento(i, colunaInicial)) {
                        malhaRodoviaria[colunaFinal][i] = new RodCimaMonitor();
                    }
                }
                if (linhaInicial == (linhasTotais - 1)) {
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
            for (int i = 0; i < linhasTotais; i++) {
                for (int j = 0; j < colunasTotais; j++) {
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
        for (int i = 0; i < linhasTotais; i++) {
            for (int j = 0; j < colunasTotais; j++) {
                if (malhaRodoviaria[j][i].getClass() == RodCruzamento.class) {
                    if (malhaRodoviaria[(j - 1)][i].getClass() == RodDireitaSemaforo.class) {

                        if (!((malhaRodoviaria[j][(i - 1)].getClass() == RodCimaSemaforo.class) && ((malhaRodoviaria[(j + 1)][i].getClass() == RodDireitaSemaforo.class) || malhaRodoviaria[j][(i + 1)].getClass() == RodBaixoSemaforo.class))
                                && !((malhaRodoviaria[(j + 1)][i].getClass() == RodDireitaSemaforo.class) && ((malhaRodoviaria[j][(i - 1)].getClass() == RodCimaSemaforo.class) || (malhaRodoviaria[j][(i + 1)].getClass() == RodBaixoSemaforo.class)))
                                && !((malhaRodoviaria[j][(i + 1)].getClass() == RodBaixoSemaforo.class) && ((malhaRodoviaria[(j + 1)][i].getClass() == RodDireitaSemaforo.class) || (malhaRodoviaria[j][(i - 1)].getClass() == RodCimaSemaforo.class)))) {

                            if (malhaRodoviaria[j][(i - 1)].getClass() == RodCimaSemaforo.class) {
                                malhaRodoviaria[j][i] = new RodCimaSemaforo();
                            } else {
                                if (malhaRodoviaria[(j + 1)][i].getClass() == RodDireitaSemaforo.class) {
                                    malhaRodoviaria[j][i] = new RodDireitaSemaforo();
                                } else {
                                    malhaRodoviaria[j][i] = new RodBaixoSemaforo();
                                }
                            }
                        }
                    } else {
                        if (malhaRodoviaria[(j + 1)][i].getClass() == RodEsquerdaSemaforo.class) {

                            if (!((malhaRodoviaria[(j - 1)][i].getClass() == RodEsquerdaSemaforo.class) && ((malhaRodoviaria[j][(i - 1)].getClass() == RodCimaSemaforo.class) || (malhaRodoviaria[j][(i + 1)].getClass() == RodBaixoSemaforo.class)))
                                    && !((malhaRodoviaria[j][(i - 1)].getClass() == RodCimaSemaforo.class) && ((malhaRodoviaria[(j - 1)][i].getClass() == RodEsquerdaSemaforo.class) || (malhaRodoviaria[j][(i + 1)].getClass() == RodBaixoSemaforo.class)))
                                    && !((malhaRodoviaria[j][(i + 1)].getClass() == RodBaixoSemaforo.class) && ((malhaRodoviaria[j][(i - 1)].getClass() == RodCimaSemaforo.class) || (malhaRodoviaria[(j - 1)][i].getClass() == RodEsquerdaSemaforo.class)))) {

                                if (malhaRodoviaria[(j - 1)][i].getClass() == RodEsquerdaSemaforo.class) {
                                    malhaRodoviaria[j][i] = new RodEsquerdaSemaforo();
                                } else {
                                    if (malhaRodoviaria[j][(i - 1)].getClass() == RodCimaSemaforo.class) {
                                        malhaRodoviaria[j][i] = new RodCimaSemaforo();
                                    } else {
                                        malhaRodoviaria[j][i] = new RodBaixoSemaforo();
                                    }
                                }
                            }
                        } else {
                            if (malhaRodoviaria[j][(i - 1)].getClass() == RodBaixoSemaforo.class) {

                                if (!((malhaRodoviaria[(j + 1)][i].getClass() == RodDireitaSemaforo.class) && ((malhaRodoviaria[j][(i + 1)].getClass() == RodBaixoSemaforo.class) || (malhaRodoviaria[(j - 1)][i].getClass() == RodEsquerdaSemaforo.class)))
                                        && !((malhaRodoviaria[j][(i + 1)].getClass() == RodBaixoSemaforo.class) && ((malhaRodoviaria[(j + 1)][i].getClass() == RodDireitaSemaforo.class) || (malhaRodoviaria[(j - 1)][i].getClass() == RodEsquerdaSemaforo.class)))
                                        && !((malhaRodoviaria[(j - 1)][i].getClass() == RodEsquerdaSemaforo.class) && ((malhaRodoviaria[j][(i + 1)].getClass() == RodBaixoSemaforo.class) || (malhaRodoviaria[(j + 1)][i].getClass() == RodDireitaSemaforo.class)))) {

                                    if (malhaRodoviaria[(j - 1)][i].getClass() == RodEsquerdaSemaforo.class) {
                                        malhaRodoviaria[j][i] = new RodEsquerdaSemaforo();
                                    } else {
                                        if (malhaRodoviaria[(j + 1)][i].getClass() == RodDireitaSemaforo.class) {
                                            malhaRodoviaria[j][i] = new RodDireitaSemaforo();

                                        } else {
                                            malhaRodoviaria[j][i] = new RodBaixoSemaforo();
                                        }
                                    }

                                }
                            } else {
                                if (malhaRodoviaria[j][(i + 1)].getClass() == RodCimaSemaforo.class) {
                                    if (!((malhaRodoviaria[j][(i - 1)].getClass() == RodCimaSemaforo.class) && ((malhaRodoviaria[(j + 1)][i].getClass() == RodDireitaSemaforo.class) || (malhaRodoviaria[(j - 1)][i].getClass() == RodEsquerdaSemaforo.class)))
                                            && !((malhaRodoviaria[(j + 1)][i].getClass() == RodDireitaSemaforo.class) && ((malhaRodoviaria[j][(i - 1)].getClass() == RodCimaSemaforo.class) || (malhaRodoviaria[(j - 1)][i].getClass() == RodEsquerdaSemaforo.class)))
                                            && !((malhaRodoviaria[(j - 1)][i].getClass() == RodEsquerdaSemaforo.class) && ((malhaRodoviaria[(j + 1)][i].getClass() == RodDireitaSemaforo.class) || (malhaRodoviaria[j][(i - 1)].getClass() == RodCimaSemaforo.class)))) {

                                        if (malhaRodoviaria[j][(i - 1)].getClass() == RodCimaSemaforo.class) {
                                            malhaRodoviaria[j][i] = new RodCimaSemaforo();
                                        } else {
                                            if (malhaRodoviaria[(j + 1)][i].getClass() == RodDireitaSemaforo.class) {
                                                malhaRodoviaria[j][i] = new RodDireitaSemaforo();
                                            } else {
                                                malhaRodoviaria[j][i] = new RodEsquerdaSemaforo();
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

    public Campo[][] getMalhaRodoviaria() {
        return malhaRodoviaria;
    }

    public int[][] getPontosIniciais() {
        return pontosIniciais;
    }

    public int getColunasTotais() {
        return colunasTotais;
    }

    public int getLinhasTotais() {
        return linhasTotais;
    }
    
    
    
}
