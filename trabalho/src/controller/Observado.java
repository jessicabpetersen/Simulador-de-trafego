package controller;

import java.io.File;
import javax.swing.Icon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jessica
 */
public interface Observado {
    
     void addObservador(Observador obs);
     
     void montarMalha( File file);
     
     Icon getPeca(int col, int row);
     
     void criarVeiculo();
}
