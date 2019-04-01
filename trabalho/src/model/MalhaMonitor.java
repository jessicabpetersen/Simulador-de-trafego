/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;

/**
 *
 * @author Jessica
 */
public class MalhaMonitor extends Malha {
    private Random rand= new Random();
    
    public MalhaMonitor(Campo[][] malha, int contagemPontosIniciais) {
        super(malha, contagemPontosIniciais);
    }

    @Override
    void andar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
}
