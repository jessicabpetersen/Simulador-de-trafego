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
    int linha, coluna, direcao, linhaAnterior, colunaAnterior; //direcao 1: direita, 2: esquerda, 3:baixo, 4:cima
    Campo[][] malhaRodoviaria;
    Controller c;

    public Carro(Malha malha, Controller c) {
        this.malha = malha;
        this.c = c;
    }

    @Override
    public void run() {
        try {
            System.out.println("Carro entrou na malha");
            iniciar();
            sleep(800);
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
        colunaAnterior = coluna;
        linhaAnterior = linha;
        malhaRodoviaria = malha.getMalhaRodoviaria();
        malhaRodoviaria[coluna][linha].colocarCarro();
        c.notificarMovimento();
    }

    private void andar() throws InterruptedException {
        while (!malhaRodoviaria[coluna][linha].isPontoFinal()) {
            if (malhaRodoviaria[coluna][linha].getClass() == RodBaixoSemaforo.class || malhaRodoviaria[coluna][linha].getClass() == RodBaixoMonitor.class) {
                malhaRodoviaria[coluna][(linha + 1)].colocarCarro();
                malhaRodoviaria[coluna][linha].retirarCarro();
                linhaAnterior = linha;
                direcao = 3;
                linha++;
            } else {
                if (malhaRodoviaria[coluna][linha].getClass() == RodCimaSemaforo.class || malhaRodoviaria[coluna][linha].getClass() == RodCimaMonitor.class) {
                    malhaRodoviaria[coluna][(linha - 1)].colocarCarro();
                    malhaRodoviaria[coluna][linha].retirarCarro();
                    linhaAnterior = linha;
                    direcao = 4;
                    linha--;

                } else {
                    if (malhaRodoviaria[coluna][linha].getClass() == RodDireitaSemaforo.class || malhaRodoviaria[coluna][linha].getClass() == RodDireitaMonitor.class) {
                        malhaRodoviaria[(coluna + 1)][linha].colocarCarro();
                        malhaRodoviaria[coluna][linha].retirarCarro();
                        colunaAnterior = coluna;
                        direcao = 1;
                        coluna++;
                    } else {
                        if (malhaRodoviaria[coluna][linha].getClass() == RodEsquerdaSemaforo.class || malhaRodoviaria[coluna][linha].getClass() == RodEsquerdaMonitor.class) {
                            malhaRodoviaria[(coluna - 1)][linha].colocarCarro();
                            malhaRodoviaria[coluna][linha].retirarCarro();
                            colunaAnterior = coluna;
                            direcao = 2;
                            coluna--;
                        } else {//cruzamento
                            int qntdSaidasPossiveis = 0;
                            int[] direcoes;
                            int sorteado, contador = 0;
                            if (direcao == 1) {//direita
                                qntdSaidasPossiveis += verificarSaidas((coluna + 1), linha, 1);//continuar direita
                                qntdSaidasPossiveis += verificarSaidas(coluna, (linha + 1), 3);//baixo
                                qntdSaidasPossiveis += verificarSaidas(coluna, (linha - 1), 4);//cima
                                direcoes = new int[qntdSaidasPossiveis];
                                sorteado = rand.nextInt(qntdSaidasPossiveis);
                                if (verificarSaidas((coluna + 1), linha, 1) == 1) {
                                        direcoes[contador] = 1;
                                        contador++;
                                    }
                                    if (verificarSaidas(coluna, (linha + 1), 3) == 1) {
                                        direcoes[contador] = 3;
                                        contador++;
                                    }
                                    if (verificarSaidas(coluna, (linha - 1), 4) == 1) {
                                        direcoes[contador] = 4;
                                    }

                            } else {
                                if (direcao == 2) {//esquerda
                                    qntdSaidasPossiveis += verificarSaidas((coluna - 1), linha, 2);//continuar esquerda
                                    qntdSaidasPossiveis += verificarSaidas(coluna, (linha + 1), 3);//baixo
                                    qntdSaidasPossiveis += verificarSaidas(coluna, (linha - 1), 4);//cima
                                    direcoes = new int[qntdSaidasPossiveis];
                                    sorteado = rand.nextInt(qntdSaidasPossiveis);
                                    if (verificarSaidas((coluna - 1), linha, 2) == 1) {
                                        direcoes[contador] = 2;
                                        contador++;
                                    }
                                    if (verificarSaidas(coluna, (linha + 1), 3) == 1) {
                                        direcoes[contador] = 3;
                                        contador++;
                                    }
                                    if (verificarSaidas(coluna, (linha - 1), 4) == 1) {
                                        direcoes[contador] = 4;
                                    }
                                } else {
                                    if (direcao == 3) {//baixo
                                        qntdSaidasPossiveis += verificarSaidas((coluna - 1), linha, 2);//ir p esquerda
                                        qntdSaidasPossiveis += verificarSaidas((coluna + 1), linha, 1);//ir p direita
                                        qntdSaidasPossiveis += verificarSaidas(coluna, (linha + 1), 3);//continuar p baixo
                                        direcoes = new int[qntdSaidasPossiveis];
                                        sorteado = rand.nextInt(qntdSaidasPossiveis);

                                        if (verificarSaidas((coluna - 1), linha, 2) == 1) {
                                            direcoes[contador] = 2;
                                            contador++;
                                        }
                                        if (verificarSaidas((coluna + 1), linha, 1) == 1) {
                                            direcoes[contador] = 1;
                                            contador++;
                                        }
                                        if (verificarSaidas(coluna, (linha + 1), 3) == 1) {
                                            direcoes[contador] = 3;
                                        }
                                    } else {//cima
                                        qntdSaidasPossiveis += verificarSaidas((coluna - 1), linha, 2);//ir p esquerda
                                        qntdSaidasPossiveis += verificarSaidas(coluna, (linha - 1), 3);//continuar cima
                                        qntdSaidasPossiveis += verificarSaidas((coluna + 1), linha, 1);//ir p direita
                                        direcoes = new int[qntdSaidasPossiveis];
                                        sorteado = rand.nextInt(qntdSaidasPossiveis);

                                        if (verificarSaidas((coluna - 1), linha, 2) == 1) {
                                            direcoes[contador] = 2;
                                            contador++;
                                        }
                                        if (verificarSaidas(coluna, (linha - 1), 3) == 1) {
                                            direcoes[contador] = 3;
                                            contador++;
                                        }
                                        if (verificarSaidas((coluna + 1), linha, 1) == 1) {
                                            direcoes[contador] = 1;
                                        }
                                    }
                                }
                            }
                            sorteado(direcoes[sorteado]);
                        }
                    }
                }
            }
            c.notificarMovimento();
            sleep(500);
        }
        malhaRodoviaria[coluna][linha].retirarCarro();
        c.veiculoSaiu();
    }

    public int verificarSaidas(int coluna, int linha, int direcao) {
        if (direcao == 1) {
            if (malhaRodoviaria[coluna][linha].getClass() == RodDireitaMonitor.class || malhaRodoviaria[coluna][linha].getClass() == RodDireitaSemaforo.class) {
                return 1;
            }
        } else {
            if (direcao == 2) {
                if (malhaRodoviaria[coluna][linha].getClass() == RodEsquerdaMonitor.class || malhaRodoviaria[coluna][linha].getClass() == RodEsquerdaSemaforo.class) {
                    return 1;
                }
            } else {
                if (direcao == 3) {
                    if (malhaRodoviaria[coluna][linha].getClass() == RodBaixoMonitor.class || malhaRodoviaria[coluna][linha].getClass() == RodBaixoSemaforo.class) {
                        return 1;
                    }
                } else {
                    if (malhaRodoviaria[coluna][linha].getClass() == RodCimaMonitor.class || malhaRodoviaria[coluna][linha].getClass() == RodCimaSemaforo.class) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    public void sorteado(int sorteado) throws InterruptedException {
        if (sorteado == 1) { //direita
            malhaRodoviaria[(coluna + 1)][linha].colocarCarro();
            malhaRodoviaria[colunaAnterior][linhaAnterior].retirarCarro();
            colunaAnterior = coluna;
            coluna++;
        } else {
            if (sorteado == 2) {//direita
                malhaRodoviaria[(coluna - 1)][linha].colocarCarro();
                malhaRodoviaria[colunaAnterior][linhaAnterior].retirarCarro();
                colunaAnterior = coluna;
                coluna--;
            } else {
                if (sorteado == 3) {//baixo
                    malhaRodoviaria[coluna][(linha + 1)].colocarCarro();
                    malhaRodoviaria[colunaAnterior][linhaAnterior].retirarCarro();
                    linhaAnterior = linha;
                    linha++;
                } else {//cima
                    malhaRodoviaria[coluna][(linha - 1)].colocarCarro();
                    malhaRodoviaria[colunaAnterior][linhaAnterior].retirarCarro();
                    linhaAnterior = linha;
                    linha--;
                }
            }
        }
    }
}
