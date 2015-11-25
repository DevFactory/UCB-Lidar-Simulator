/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import project.SimulationProject;

/**
 * @author oscar_sgc
 */
public class SimulationWindow extends javax.swing.JFrame {

    private SimulationProject simulationProject = SimulationProject.getInstance();

    /**
     * Creates new form SimulationWindow
     */
    public SimulationWindow() {
        initComponents();
        makeFrameFullSize();
        createSimulationTab();
    }

    private void createSimulationTab() {
        this.completeSimulationPanel = new PlotPanel();
        this.graphicsTabbedPane.add(this.completeSimulationPanel, 0);
    }

    private void makeFrameFullSize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        buttonPanel = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        graphicsTabbedPane = new javax.swing.JTabbedPane();
        completeSimulationPanel = new javax.swing.JPanel();
        optionsMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        languageMenu = new javax.swing.JMenu();
        englishMenuItem = new javax.swing.JMenuItem();
        spanishMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("atmosphere/gui/Bundle"); // NOI18N
        backButton.setText(bundle.getString("GraphicsVisualizer.backButton.text")); // NOI18N
        backButton.setToolTipText(bundle.getString("GraphicsVisualizer.backButton.toolTipText")); // NOI18N
        backButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(backButton);

        getContentPane().add(buttonPanel, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout completeSimulationPanelLayout = new javax.swing.GroupLayout(completeSimulationPanel);
        completeSimulationPanel.setLayout(completeSimulationPanelLayout);
        completeSimulationPanelLayout.setHorizontalGroup(
                completeSimulationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 569, Short.MAX_VALUE)
        );
        completeSimulationPanelLayout.setVerticalGroup(
                completeSimulationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 307, Short.MAX_VALUE)
        );

        graphicsTabbedPane.addTab("Complete Simulation", completeSimulationPanel);

        getContentPane().add(graphicsTabbedPane, java.awt.BorderLayout.CENTER);

        fileMenu.setText(bundle.getString("GraphicsVisualizer.fileMenu.text")); // NOI18N

        saveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMenuItem.setText(bundle.getString("GraphicsVisualizer.saveMenuItem.text")); // NOI18N
        saveMenuItem.setToolTipText(bundle.getString("GraphicsVisualizer.saveMenuItem.toolTipText")); // NOI18N
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        saveAsMenuItem.setText(bundle.getString("GraphicsVisualizer.saveAsMenuItem.text")); // NOI18N
        saveAsMenuItem.setToolTipText(bundle.getString("GraphicsVisualizer.saveAsMenuItem.toolTipText")); // NOI18N
        saveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveAsMenuItem);
        fileMenu.add(jSeparator2);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exitMenuItem.setText(bundle.getString("GraphicsVisualizer.exitMenuItem.text")); // NOI18N
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        optionsMenuBar.add(fileMenu);

        editMenu.setText(bundle.getString("GraphicsVisualizer.editMenu.text")); // NOI18N

        languageMenu.setLabel(bundle.getString("GraphicsVisualizer.languageMenu.label")); // NOI18N

        englishMenuItem.setText(bundle.getString("GraphicsVisualizer.englishMenuItem.text")); // NOI18N
        englishMenuItem.setToolTipText(bundle.getString("GraphicsVisualizer.englishMenuItem.toolTipText")); // NOI18N
        englishMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                englishMenuItemActionPerformed(evt);
            }
        });
        languageMenu.add(englishMenuItem);

        spanishMenuItem.setText(bundle.getString("GraphicsVisualizer.spanishMenuItem.text")); // NOI18N
        spanishMenuItem.setToolTipText(bundle.getString("GraphicsVisualizer.spanishMenuItem.toolTipText")); // NOI18N
        spanishMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spanishMenuItemActionPerformed(evt);
            }
        });
        languageMenu.add(spanishMenuItem);

        editMenu.add(languageMenu);

        optionsMenuBar.add(editMenu);

        setJMenuBar(optionsMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        this.simulationProject.saveProject();
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuItemActionPerformed
        JFileChooser fileSaver = new JFileChooser();
        fileSaver.setDialogTitle("Select Storing Directory");
        fileSaver.setAcceptAllFileFilterUsed(false);
        if (fileSaver.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            this.simulationProject.setProjectName(fileSaver.getSelectedFile().getName());
            this.simulationProject.setProjectLocation(fileSaver.getCurrentDirectory() + "/");
            this.simulationProject.saveProject();
        } else {
            JOptionPane.showMessageDialog(null, "File not saved, please try again");
        }
    }//GEN-LAST:event_saveAsMenuItemActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void englishMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_englishMenuItemActionPerformed
        System.setProperty("user.language", "en");
        System.setProperty("user.country", "US");


        this.dispose();
    }//GEN-LAST:event_englishMenuItemActionPerformed

    private void spanishMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spanishMenuItemActionPerformed
        System.setProperty("user.language", "es");
        System.setProperty("user.country", "ES");

        this.dispose();
    }//GEN-LAST:event_spanishMenuItemActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.dispose();
        new SettingsWindow().setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SimulationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimulationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimulationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimulationWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimulationWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JPanel completeSimulationPanel;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem englishMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JTabbedPane graphicsTabbedPane;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenu languageMenu;
    private javax.swing.JMenuBar optionsMenuBar;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JMenuItem spanishMenuItem;
    // End of variables declaration//GEN-END:variables
}
