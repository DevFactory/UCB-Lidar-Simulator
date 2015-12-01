/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import helpers.SimulationController;
import project.SimulationProject;

import javax.swing.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author oscar_sgc
 */
public class CompleteSimulationSettingsWindow extends javax.swing.JFrame {

    private SimulationProject simulationProject = SimulationProject.getInstance();

    /**
     * Creates new form CompleteSimulationSettingsWindow
     */
    public CompleteSimulationSettingsWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        hoursLabel = new javax.swing.JLabel();
        hoursRangeLabel = new javax.swing.JLabel();
        startHourLabel = new javax.swing.JLabel();
        endLabel = new javax.swing.JLabel();
        samplesLabel = new javax.swing.JLabel();
        hoursQtyTextField = new javax.swing.JTextField();
        startHourTextField = new javax.swing.JTextField();
        endHourTextField = new javax.swing.JTextField();
        samplesTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(backButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                                .addComponent(saveButton)
                                .addGap(57, 57, 57))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(backButton)
                                        .addComponent(saveButton))
                                .addGap(25, 25, 25))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Ranges:"));

        hoursLabel.setText("Hours Qty.:");

        hoursRangeLabel.setText("Hours Range:");

        startHourLabel.setText("Start (hh:mm):");

        endLabel.setText("End (hh:mm):");

        samplesLabel.setText("Samples Per Hour:");

        startHourTextField.setText(":");

        endHourTextField.setText(":");

        jLabel1.setText("Max. 5");

        jLabel2.setText("Max. 6");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(samplesLabel)
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(endLabel)
                                                                .addComponent(startHourLabel)))
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(samplesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(36, 36, 36)
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(hoursQtyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(startHourTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(endHourTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2)))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addComponent(hoursRangeLabel))
                                        .addComponent(hoursLabel))
                                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(hoursLabel)
                                        .addComponent(hoursQtyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(hoursRangeLabel)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(startHourLabel)
                                        .addComponent(startHourTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(endLabel)
                                        .addComponent(endHourTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(samplesLabel)
                                        .addComponent(samplesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addContainerGap(25, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        SettingsWindow w = new SettingsWindow();
        this.dispose();
        w.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        SimulationController simulationController = new SimulationController();
        this.simulationProject.setSimulationController(simulationController);
        this.simulationProject.getSimulationController().setPixelsQty(this.getWidth() - 101);
        if (this.hoursQtyTextField.getText().isEmpty() || Integer.parseInt(this.hoursQtyTextField.getText()) > 5 || Integer.parseInt(this.hoursQtyTextField.getText()) == 0) {
            JOptionPane.showMessageDialog(null, "Please Insert a valid hours qty.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            if (this.startHourTextField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please Insert a valid start hour.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                if (this.endHourTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Insert a valid end hour.", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (this.samplesTextField.getText().isEmpty() || Integer.parseInt(this.samplesTextField.getText()) > 6 || Integer.parseInt(this.samplesTextField.getText()) == 0) {
                        JOptionPane.showMessageDialog(null, "Please Insert a valid samples value.", "Warning", JOptionPane.WARNING_MESSAGE);
                    } else {
                        this.simulationProject.getSimulationController().setHoursQty(Integer.parseInt(this.hoursQtyTextField.getText()));
                        this.simulationProject.getSimulationController().setSimulationsPerHour(Integer.parseInt(this.samplesTextField.getText()));
                        try {
                            String str = this.startHourTextField.getText();
                            DateFormat formatter = new SimpleDateFormat("hh:mm");
                            Date date = formatter.parse(str);
                            this.simulationProject.getSimulationController().setStartingTime(date);
                            str = this.endHourTextField.getText();
                            date = formatter.parse(str);
                            this.simulationProject.getSimulationController().setEndingTime(date);
                            this.simulationProject.getSimulationController().obtainSimulationsQty();
                        } catch (ParseException e) {
                            JOptionPane.showMessageDialog(null, "Please Insert valid hours for the range.", "Warning", JOptionPane.WARNING_MESSAGE);
                            e.printStackTrace();
                        }
                        if ((this.simulationProject.getSimulationController().getEndingTime().getHours() - this.simulationProject.getSimulationController().getStartingTime().getHours()) != this.simulationProject.getSimulationController().getHoursQty()) {
                            JOptionPane.showMessageDialog(null, "Please insert the correct range interval.", "Warning", JOptionPane.WARNING_MESSAGE);
                        } else {
                            this.simulationProject.saveProject();
                            JOptionPane.showMessageDialog(null, "Simulation Values Established");
                            SettingsWindow w = new SettingsWindow();
                            w.setVisible(true);
                            this.dispose();
                        }
                    }
                }
            }

        }

    }//GEN-LAST:event_saveButtonActionPerformed

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
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            System.setProperty("com.apple.mrj.application.apple.menu.about.name", "WikiTeX");
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CompleteSimulationSettingsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompleteSimulationSettingsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompleteSimulationSettingsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompleteSimulationSettingsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompleteSimulationSettingsWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTextField endHourTextField;
    private javax.swing.JLabel endLabel;
    private javax.swing.JLabel hoursLabel;
    private javax.swing.JTextField hoursQtyTextField;
    private javax.swing.JLabel hoursRangeLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel samplesLabel;
    private javax.swing.JTextField samplesTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel startHourLabel;
    private javax.swing.JTextField startHourTextField;
    // End of variables declaration//GEN-END:variables
}
