/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Jessica
 */
public class Inicio extends javax.swing.JFrame {
// Variables declaration - do not modify                     

    private javax.swing.JFileChooser fileChooser;

    // End of variables declaration                   
    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
        escolhaSaida = 1;
        fileChooser = new javax.swing.JFileChooser();
        fileChooser.setDialogTitle("");
        fileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooserActionPerformed(evt);
            }
        });
        mecanismo = 1;
    }

    private void fileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooserActionPerformed
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            malha = new MalhaTela(file, this.qntdMaxVeiculo, this.intervaloInsercao, this.mecanismo, this.escolhaSaida);
            malha.setVisible(true);
            this.dispose();
            // criar o tabuleiro e seus componentes

        } else {
            System.out.println("File access cancelled by user.");
        }

    }//GEN-LAST:event_fileChooserActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        fileChooserActionPerformed(evt);

    }//GEN-LAST:event_jMenuItem1ActionPerformed
    private int qntdMaxVeiculo = 0, intervaloInsercao = 0, escolhaSaida, mecanismo;
    private MalhaTela malha;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        qtdMaxVeiculo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        intervaloInserção = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButtonEncerra = new javax.swing.JRadioButton();
        jRadioButtonEspera = new javax.swing.JRadioButton();
        jbIniciar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trabalho 1 - Aparício e Jéssica ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Configurações:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Trabalho 1 - 65DSD");

        jLabel3.setText("Quantidade máximo de veículos: ");

        qtdMaxVeiculo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                qtdMaxVeiculoFocusLost(evt);
            }
        });

        jLabel4.setText("Intervalo de inserção de veículo:");

        intervaloInserção.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                intervaloInserçãoFocusLost(evt);
            }
        });

        jLabel5.setText("milisegundos");

        jLabel6.setText("Opções de finalização:");

        buttonGroup1.add(jRadioButtonEncerra);
        jRadioButtonEncerra.setText("Para de inserir e encerra imediatamente todos os veículos");
        jRadioButtonEncerra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonEncerraActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonEspera);
        jRadioButtonEspera.setSelected(true);
        jRadioButtonEspera.setText("Encerra e espera todos os veículos sairem da malha");
        jRadioButtonEspera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonEsperaActionPerformed(evt);
            }
        });

        jbIniciar.setText("Carregar malha e Iniciar");
        jbIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbIniciarActionPerformed(evt);
            }
        });

        jLabel7.setText("Mecanismo:");

        buttonGroup2.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Semáforo");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton2);
        jRadioButton2.setText("Monitor");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(intervaloInserção, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5))
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(qtdMaxVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jRadioButtonEspera)
                                            .addComponent(jRadioButtonEncerra))))
                                .addGap(0, 94, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(jbIniciar))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(qtdMaxVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(intervaloInserção, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonEspera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonEncerra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jbIniciar)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonEsperaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonEsperaActionPerformed
        // TODO add your handling code here:
        this.escolhaSaida = 1;
    }//GEN-LAST:event_jRadioButtonEsperaActionPerformed

    private void jbIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIniciarActionPerformed
        // TODO add your handling code here:
        if(habilitarBotao()){
            jMenuItem1ActionPerformed(evt);
        }else{
            JOptionPane.showMessageDialog(null, "O campo Veículos máximos deve estar preenchido");
        }
    }//GEN-LAST:event_jbIniciarActionPerformed

    private void qtdMaxVeiculoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_qtdMaxVeiculoFocusLost
        String a = getQtdMaxVeiculo().getText();
        try {
            this.qntdMaxVeiculo = Integer.parseInt(a);
            if ((this.qntdMaxVeiculo == 0) && qntdMaxVeiculo > 11) {
                getQtdMaxVeiculo().setText("");
                this.qntdMaxVeiculo = 0;
            } 
        } catch (Exception e) {
            this.qntdMaxVeiculo = 0;
            getQtdMaxVeiculo().setText("");
        }
    }//GEN-LAST:event_qtdMaxVeiculoFocusLost

    private void intervaloInserçãoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_intervaloInserçãoFocusLost
        String a = getIntervaloInserção().getText();
        try {
            this.intervaloInsercao = Integer.parseInt(a);
            
        } catch (Exception e) {
            this.intervaloInsercao = 0;
            getIntervaloInserção().setText("");
        }
    }//GEN-LAST:event_intervaloInserçãoFocusLost

    private void jRadioButtonEncerraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonEncerraActionPerformed
       this.escolhaSaida = 2;
    }//GEN-LAST:event_jRadioButtonEncerraActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
       this.mecanismo = 1;
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        this.mecanismo = 2;
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    public boolean habilitarBotao() {
        if (this.qntdMaxVeiculo != 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    public int getEscolhaSaida() {
        return escolhaSaida;
    }

    public JTextField getIntervaloInserção() {
        return intervaloInserção;
    }

    public JButton getJbIniciar() {
        return jbIniciar;
    }

    public JRadioButton getjRadioButtonEncerra() {
        return jRadioButtonEncerra;
    }

    public JRadioButton getjRadioButtonEspera() {
        return jRadioButtonEspera;
    }

    public JTextField getQtdMaxVeiculo() {
        return qtdMaxVeiculo;
    }

    public void setIntervaloInserção(JTextField intervaloInserção) {
        this.intervaloInserção = intervaloInserção;
    }

    public void setQtdMaxVeiculo(JTextField qtdMaxVeiculo) {
        this.qtdMaxVeiculo = qtdMaxVeiculo;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField intervaloInserção;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButtonEncerra;
    private javax.swing.JRadioButton jRadioButtonEspera;
    private javax.swing.JButton jbIniciar;
    private javax.swing.JTextField qtdMaxVeiculo;
    // End of variables declaration//GEN-END:variables
}
