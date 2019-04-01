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

    public Carro(Malha malha) {
        this.malha = malha;
    }

    @Override
    public void run() {
        malha.andar();
    }

}
