package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.Icon;
import model.Campo;
import model.Carro;
import model.Grama;
import model.RodBaixo;
import model.RodCima;
import model.RodCruzamento;
import model.RodDireita;
import model.RodEsquerda;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jessica
 */
public class Controller implements Observado {

    private List<Observador> observadores = new ArrayList<>();
    private Campo[][] malhaRodoviaria;
    private Object fileChooser;
    int linha, coluna, contagemPontosIniciais, qtddMaximaVeiculo, intervaloInsercao, mecanismo, saidaVeiculo;
    private int[][] pontosIniciais;
    
    
    public Controller(int qtddMaxVeiculos, int IntervaloInsercao, int mecanismo, int saidaVeiculo){
        this.qtddMaximaVeiculo = qtddMaxVeiculos; 
        if(IntervaloInsercao > 0){
            this.intervaloInsercao = IntervaloInsercao;
        }else{
            this.intervaloInsercao = 5000;
        }
        //Mecanismo 1: encerrar e aguardar veículos saírem da malha   2: para de inserir e encerra imediatamente todos os veículos   
        this.mecanismo = mecanismo;
        //SaidaVeiculo: 1: Semáforo  2:Monitor
        this.saidaVeiculo = saidaVeiculo;
    }
    
    public void criarVeiculo(){
        for (int i = 0; i < qtddMaximaVeiculo; i++) {
            Carro carro = new Carro();
        }
    }

    @Override
    public void addObservador(Observador obs) {
        observadores.add(obs);
    }

    public void carregaMalha() {
        for (int i = 0; i < coluna; i++) {
            for (int j = 0; j < linha; j++) {
                this.malhaRodoviaria[i][j] = new Grama();
            }
        }
    }

    public void montarMalha(File file) {
        try {
            contagemPontosIniciais = 0;
            // What to do with the file, e.g. display it in a TextArea
            Scanner scanA = new Scanner(file);
            linha = scanA.nextInt();
            coluna = scanA.nextInt();
            passarTamanho();
            System.out.println("lin: " + linha + " col: " + coluna);
            malhaRodoviaria = new Campo[linha][coluna];
            carregaMalha();
            while (scanA.hasNext()) {
                carrega(scanA);

            }
            pontosIniciais = new int[2][contagemPontosIniciais];
            int linhaMatrizPontos = 0;
            int colunaMatrizPontos = 0;
            for (int i = 0; i < linha; i++) {
                for (int j = 0; j < coluna; j++) {
                    if (malhaRodoviaria[j][i].isPontoInicial()) {
                        pontosIniciais[colunaMatrizPontos][linhaMatrizPontos] = j;
                        colunaMatrizPontos++;
                        pontosIniciais[colunaMatrizPontos][linhaMatrizPontos] = i;
                        colunaMatrizPontos = 0;
                        linhaMatrizPontos++;
                    }
                }
            }
//
//            String colunmNames[] = new String[coluna];
//            for (int i = 0; i < colunmNames.length; i++) {
//                colunmNames[i] = String.valueOf(i);
//
//            }
//
//            runTable(A, colunmNames);
            scanA.close();
        } catch (IOException ex) {
            System.out.println("problem accessing file" + file.getAbsolutePath());
        }
    }

    public void notificarMovimento() {
        for (Observador observador : observadores) {
            observador.repaint();
        }
    }

    public Icon getPeca(int col, int row) {
        return (this.malhaRodoviaria[col][row] == null ? null : this.malhaRodoviaria[col][row].getImagem());
    }

    public void passarTamanho() {
        for (Observador observador : observadores) {
            observador.tamanho(linha, coluna);
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
}
