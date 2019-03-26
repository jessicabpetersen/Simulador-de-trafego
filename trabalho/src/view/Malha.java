/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Observado;
import controller.Observador;
import controller.Controller;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Jessica
 */
public class Malha extends JFrame implements Observador {
    private Observado controller;
    private int linha, coluna;
    private JTable malhaRodoviaria;
    
   
    
    public Malha(File file, int qtddMaxVeiculos, int IntervaloInsercao, int mecanismo, int saidaVeiculo){
        this.controller = new Controller(qtddMaxVeiculos, IntervaloInsercao, mecanismo, saidaVeiculo);
        controller.addObservador(this);
        
        this.controller.montarMalha(file);
        setTitle("Teste");
        setSize(700, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        initComponents();
        pack();
    }

    @Override
    public void tamanho(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }
    private static final long serialVersionUID = 1L;

    class TableModelMalha extends AbstractTableModel {

        private static final long serialVersionUID = 1L;

        @Override
        public int getColumnCount() {
            return coluna;
        }

        @Override
        public int getRowCount() {
            return linha;
        }

        @Override
        public Object getValueAt(int row, int col) {
            try {
                return controller.getPeca(col, row);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
                return null;
            }
        }

    }

    class MalhaRenderer extends DefaultTableCellRenderer {

        private static final long serialVersionUID = 1L;

        public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus, int row,
                int column) {

            setIcon((ImageIcon) value);

            return this;
        }
    }
    
    public void repaint() {
        malhaRodoviaria.repaint();
    }
    
    private void initComponents() {
        
        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        
        JLabel titulo = new JLabel();
        titulo.setText("Título");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Tahoma", Font.BOLD, 26));
        jp.add(titulo, BorderLayout.CENTER);
        
        JLabel qntdMaxV = new JLabel();
        qntdMaxV.setText("Quantidade máxima de veículos ");
        qntdMaxV.setAlignmentX(100);
        qntdMaxV.setAlignmentY(100);
        qntdMaxV.setHorizontalAlignment(SwingConstants.CENTER);
        jp.add(qntdMaxV);
        JTextField qtddMaxVeiculo = new JTextField();
        jp.add(qtddMaxVeiculo);
        
        JButton jbIniciar = new JButton();
        jbIniciar.setText("Iniciar");
        jbIniciar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                controller.criarVeiculo();
            }
            
            }
        );
        
        jp.add(jbIniciar);
        
        
        add(jp, BorderLayout.NORTH);
        
        JPanel jp1 = new JPanel();
        jp1.setLayout(new BorderLayout());
        
        malhaRodoviaria = new JTable();
        malhaRodoviaria.setModel(new Malha.TableModelMalha());
        for (int x = 0; x < malhaRodoviaria.getColumnModel().getColumnCount(); x++) {
            malhaRodoviaria.getColumnModel().getColumn(x).setWidth(28);
            malhaRodoviaria.getColumnModel().getColumn(x).setMinWidth(28);
            malhaRodoviaria.getColumnModel().getColumn(x).setMaxWidth(28);
        }
        malhaRodoviaria.setRowHeight(28);
        malhaRodoviaria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        malhaRodoviaria.setShowGrid(false);
        malhaRodoviaria.setIntercellSpacing(new Dimension(0, 0));
        malhaRodoviaria.setDefaultRenderer(Object.class, new Malha.MalhaRenderer());
        jp1.add(malhaRodoviaria);
        add(jp1, BorderLayout.CENTER);
        
        
    }
}
