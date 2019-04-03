package controller;

import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import model.Campo;
import model.Carro;
import model.Grama;
import model.Malha;

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
    int linha, coluna, saidaVeiculo, contagemPontosIniciais, qtddMaximaVeiculo, intervaloInsercao, mecanismo;
    private int[][] pontosIniciais;
    private Malha malha;

    public Controller(int qtddMaxVeiculos, int IntervaloInsercao, int mecanismo, int saidaVeiculo) {
        this.qtddMaximaVeiculo = qtddMaxVeiculos;
        if (IntervaloInsercao > 0) {
            this.intervaloInsercao = IntervaloInsercao;
        } else {
            this.intervaloInsercao = 1000;
        }
        //Mecanismo 1: encerrar e aguardar veículos saírem da malha   2: para de inserir e encerra imediatamente todos os veículos   
        this.mecanismo = mecanismo;
        //SaidaVeiculo: 1: Semáforo  2:Monitor
        this.saidaVeiculo = saidaVeiculo;
    }

    @Override
    public void criarVeiculo() {
        while (qtddMaximaVeiculo > 0) {
            Carro carro = new Carro(malha, this);
            qtddMaximaVeiculo--;
            notificarMovimento();
            carro.start();
            try {
                sleep(intervaloInsercao);
            } catch (InterruptedException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void veiculoSaiu(){
        qtddMaximaVeiculo++;
        criarVeiculo();
    }

    public void terminarCarro() {
        qtddMaximaVeiculo++;
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
            // What to do with the file, e.g. display it in a TextArea
            Scanner scanA = new Scanner(file);
            linha = scanA.nextInt();
            coluna = scanA.nextInt();
            System.out.println("lin: " + linha + " col: " + coluna);
            malhaRodoviaria = new Campo[linha][coluna];

            malha = new Malha(malhaRodoviaria, contagemPontosIniciais, saidaVeiculo);

            passarTamanho();
            malha.carregaMalha(coluna, linha);
            while (scanA.hasNext()) {
                malha.carrega(scanA);
            }
            
            malha.pontosIniciais();
            contagemPontosIniciais = malha.getContagemPontosIniciais();
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

}
