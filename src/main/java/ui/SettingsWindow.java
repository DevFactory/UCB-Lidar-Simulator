/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import atmosphere.gui.GraphicsConfiguration;
import java.util.Locale;

import atmosphere.gui.GraphicsVisualizer;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import project.SimulationProject;

/**
 *
 * @author oscar_sgc
 */
public class SettingsWindow extends javax.swing.JFrame {

    /**
     * Creates new form SettingsWindow
     */
    SimulationProject simulationProject = SimulationProject.getInstance();

    public SettingsWindow() {
        SimulationProject simulationProject = SimulationProject.getInstance();
        Locale.setDefault(new Locale(System.getProperty("user.language"), System.getProperty("user.country")));
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

        configurationsPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(45, 0), new java.awt.Dimension(50, 0), new java.awt.Dimension(60, 32767));
        jLabel5 = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(60, 0), new java.awt.Dimension(60, 0), new java.awt.Dimension(60, 32767));
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        atmosphereDetailsLabel = new javax.swing.JLabel();
        telescopeDetailsLabel = new javax.swing.JLabel();
        laserDetailsLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        atmosphereConfigurationButton = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(60, 0), new java.awt.Dimension(60, 0), new java.awt.Dimension(32767, 0));
        telescopeSettingsButton = new javax.swing.JButton();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(60, 0), new java.awt.Dimension(60, 0), new java.awt.Dimension(32767, 0));
        laserSettingsButton = new javax.swing.JButton();
        detailsPanel = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        detailsTextPane = new javax.swing.JTextPane();
        actionPanel = new javax.swing.JPanel();
        viewGraphicsButton = new javax.swing.JButton();
        resultsButton = new javax.swing.JButton();
        saveConfigurationsButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        languageMenu = new javax.swing.JMenu();
        englishMenuItem = new javax.swing.JMenuItem();
        spanishMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("UI/Bundle"); // NOI18N
        setTitle(bundle.getString("SettingsWindow.title")); // NOI18N
        setResizable(false);

        configurationsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("SettingsWindow.configurationsPanel.border.title"))); // NOI18N
        configurationsPanel.setLayout(new java.awt.BorderLayout());

        jLabel4.setText(bundle.getString("SettingsWindow.jLabel4.text")); // NOI18N
        jPanel1.add(jLabel4);
        jPanel1.add(filler1);

        jLabel5.setText(bundle.getString("SettingsWindow.jLabel5.text")); // NOI18N
        jPanel1.add(jLabel5);
        jPanel1.add(filler2);

        jLabel6.setText(bundle.getString("SettingsWindow.jLabel6.text")); // NOI18N
        jPanel1.add(jLabel6);

        configurationsPanel.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setPreferredSize(new java.awt.Dimension(404, 40));
        jPanel2.setLayout(null);

        atmosphereDetailsLabel.setForeground(new java.awt.Color(51, 51, 255));
        atmosphereDetailsLabel.setText(bundle.getString("SettingsWindow.atmosphereDetailsLabel.text")); // NOI18N
        atmosphereDetailsLabel.setToolTipText(bundle.getString("SettingsWindow.atmosphereDetailsLabel.toolTipText")); // NOI18N
        atmosphereDetailsLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atmosphereDetailsLabelMouseClicked(evt);
            }
        });
        jPanel2.add(atmosphereDetailsLabel);
        atmosphereDetailsLabel.setBounds(80, 10, 77, 16);

        telescopeDetailsLabel.setForeground(new java.awt.Color(51, 51, 255));
        telescopeDetailsLabel.setText(bundle.getString("SettingsWindow.telescopeDetailsLabel.text")); // NOI18N
        telescopeDetailsLabel.setToolTipText(bundle.getString("SettingsWindow.telescopeDetailsLabel.toolTipText")); // NOI18N
        telescopeDetailsLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                telescopeDetailsLabelMouseClicked(evt);
            }
        });
        jPanel2.add(telescopeDetailsLabel);
        telescopeDetailsLabel.setBounds(210, 10, 77, 16);

        laserDetailsLabel.setForeground(new java.awt.Color(51, 51, 255));
        laserDetailsLabel.setText(bundle.getString("SettingsWindow.laserDetailsLabel.text")); // NOI18N
        laserDetailsLabel.setToolTipText(bundle.getString("SettingsWindow.laserDetailsLabel.toolTipText")); // NOI18N
        laserDetailsLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                laserDetailsLabelMouseClicked(evt);
            }
        });
        jPanel2.add(laserDetailsLabel);
        laserDetailsLabel.setBounds(330, 10, 77, 16);

        configurationsPanel.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setLayout(null);

        atmosphereConfigurationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/atmosphere.png"))); // NOI18N
        atmosphereConfigurationButton.setToolTipText(bundle.getString("SettingsWindow.atmosphereConfigurationButton.toolTipText")); // NOI18N
        atmosphereConfigurationButton.setPreferredSize(new java.awt.Dimension(60, 60));
        atmosphereConfigurationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atmosphereConfigurationButtonActionPerformed(evt);
            }
        });
        jPanel3.add(atmosphereConfigurationButton);
        atmosphereConfigurationButton.setBounds(90, 10, 60, 60);
        jPanel3.add(filler3);
        filler3.setBounds(119, 35, 60, 0);

        telescopeSettingsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/telescope.png"))); // NOI18N
        telescopeSettingsButton.setToolTipText(bundle.getString("SettingsWindow.telescopeSettingsButton.toolTipText")); // NOI18N
        telescopeSettingsButton.setPreferredSize(new java.awt.Dimension(60, 60));
        jPanel3.add(telescopeSettingsButton);
        telescopeSettingsButton.setBounds(220, 10, 60, 60);
        jPanel3.add(filler4);
        filler4.setBounds(249, 35, 60, 0);

        laserSettingsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/laser.png"))); // NOI18N
        laserSettingsButton.setToolTipText(bundle.getString("SettingsWindow.laserSettingsButton.toolTipText")); // NOI18N
        laserSettingsButton.setPreferredSize(new java.awt.Dimension(60, 60));
        jPanel3.add(laserSettingsButton);
        laserSettingsButton.setBounds(340, 10, 60, 60);

        configurationsPanel.add(jPanel3, java.awt.BorderLayout.CENTER);

        detailsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("SettingsWindow.detailsPanel.border.title"))); // NOI18N
        detailsPanel.setToolTipText(bundle.getString("SettingsWindow.detailsPanel.toolTipText")); // NOI18N

        detailsTextPane.setEditable(false);
        detailsTextPane.setToolTipText(bundle.getString("SettingsWindow.detailsTextPane.toolTipText")); // NOI18N
        detailsTextPane.setCaretColor(new java.awt.Color(255, 255, 255));
        jScrollPane.setViewportView(detailsTextPane);

        javax.swing.GroupLayout detailsPanelLayout = new javax.swing.GroupLayout(detailsPanel);
        detailsPanel.setLayout(detailsPanelLayout);
        detailsPanelLayout.setHorizontalGroup(
            detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        detailsPanelLayout.setVerticalGroup(
            detailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailsPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addContainerGap())
        );

        actionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("SettingsWindow.actionPanel.border.title"))); // NOI18N

        viewGraphicsButton.setText(bundle.getString("SettingsWindow.viewGraphicsButton.text")); // NOI18N
        viewGraphicsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewGraphicsButtonActionPerformed(evt);
            }
        });

        resultsButton.setText(bundle.getString("SettingsWindow.resultsButton.text")); // NOI18N

        saveConfigurationsButton.setText(bundle.getString("SettingsWindow.saveConfigurationsButton.text")); // NOI18N
        saveConfigurationsButton.setToolTipText(bundle.getString("SettingsWindow.saveConfigurationsButton.toolTipText")); // NOI18N

        javax.swing.GroupLayout actionPanelLayout = new javax.swing.GroupLayout(actionPanel);
        actionPanel.setLayout(actionPanelLayout);
        actionPanelLayout.setHorizontalGroup(
            actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionPanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewGraphicsButton)
                    .addGroup(actionPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveConfigurationsButton)
                            .addGroup(actionPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(resultsButton)))))
                .addGap(44, 44, 44))
        );
        actionPanelLayout.setVerticalGroup(
            actionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewGraphicsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveConfigurationsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resultsButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fileMenu.setText(bundle.getString("StartWindow.fileMenu.text")); // NOI18N

        saveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMenuItem.setText(bundle.getString("SettingsWindow.saveMenuItem.text")); // NOI18N
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        saveAsMenuItem.setText(bundle.getString("SettingsWindow.saveAsMenuItem.text")); // NOI18N
        saveAsMenuItem.setToolTipText(bundle.getString("SettingsWindow.saveAsMenuItem.toolTipText")); // NOI18N
        saveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exitMenuItem.setText(bundle.getString("StartWindow.exitMenuItem.text")); // NOI18N
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        jMenuBar1.add(fileMenu);

        editMenu.setText(bundle.getString("StartWindow.editMenu.text")); // NOI18N

        languageMenu.setText(bundle.getString("SettingsWindow.languageMenu.text")); // NOI18N
        languageMenu.setLabel(bundle.getString("StartWindow.languageMenu.label")); // NOI18N

        englishMenuItem.setText(bundle.getString("StartWindow.englishMenuItem.text")); // NOI18N
        englishMenuItem.setToolTipText(bundle.getString("StartWindow.englishMenuItem.toolTipText")); // NOI18N
        englishMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                englishMenuItemActionPerformed(evt);
            }
        });
        languageMenu.add(englishMenuItem);

        spanishMenuItem.setText(bundle.getString("StartWindow.spanishMenuItem.text")); // NOI18N
        spanishMenuItem.setToolTipText(bundle.getString("StartWindow.spanishMenuItem.toolTipText")); // NOI18N
        spanishMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spanishMenuItemActionPerformed(evt);
            }
        });
        languageMenu.add(spanishMenuItem);

        editMenu.add(languageMenu);

        jMenuBar1.add(editMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(configurationsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(detailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(actionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(configurationsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(detailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(actionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void englishMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_englishMenuItemActionPerformed
        System.setProperty("user.language", "en");
        System.setProperty("user.country", "US");
        SettingsWindow w = new SettingsWindow();
        w.setVisible(true);
        dispose();
    }//GEN-LAST:event_englishMenuItemActionPerformed

    private void spanishMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spanishMenuItemActionPerformed
        System.setProperty("user.language", "es");
        System.setProperty("user.country", "ES");
        SettingsWindow w = new SettingsWindow();

        w.setVisible(true);
        dispose();
    }//GEN-LAST:event_spanishMenuItemActionPerformed

    private void laserDetailsLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_laserDetailsLabelMouseClicked
        this.detailsTextPane.setText("Laser: \n Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n"
                + "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n"
                + "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n"
                + "consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n"
                + "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n"
                + "proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
    }//GEN-LAST:event_laserDetailsLabelMouseClicked

    private void telescopeDetailsLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_telescopeDetailsLabelMouseClicked
        this.detailsTextPane.setText("Telescopio: \n Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\n"
                + "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\n"
                + "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\n"
                + "consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\n"
                + "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\n"
                + "proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
    }//GEN-LAST:event_telescopeDetailsLabelMouseClicked

    private void atmosphereDetailsLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atmosphereDetailsLabelMouseClicked
        double initialAltitude = 0;
        double finalAltitude = 0;
        if (simulationProject.getData() != null) {
            initialAltitude = this.simulationProject.getData().get(0).doubleValue();
            finalAltitude = this.simulationProject.getData().get(this.simulationProject.getData().size() - 1).doubleValue();
            this.detailsTextPane.setText("ATMOSPHERE DETAILS:\n" + "Initial altitude: " + initialAltitude + "\n" + "Final altitude: " + finalAltitude + "\n");
        } else {
            this.detailsTextPane.setText("ATMOSPHERE DETAILS:\n" + "Initial altitude: Not defined\n" + "Final altitude: Not defined\n");
        }
    }//GEN-LAST:event_atmosphereDetailsLabelMouseClicked

    private void atmosphereConfigurationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atmosphereConfigurationButtonActionPerformed
        GraphicsConfiguration w = new GraphicsConfiguration();
        this.dispose();
        w.setVisible(true);
    }//GEN-LAST:event_atmosphereConfigurationButtonActionPerformed

    private void viewGraphicsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewGraphicsButtonActionPerformed
        if (this.simulationProject.getData() != null) {
            GraphicsVisualizer graphicsVisualizer = new GraphicsVisualizer();
            this.dispose();
            graphicsVisualizer.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Atmosphere Data is empty... please fill data first");
        }
    }//GEN-LAST:event_viewGraphicsButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SettingsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SettingsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SettingsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SettingsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SettingsWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionPanel;
    private javax.swing.JButton atmosphereConfigurationButton;
    private javax.swing.JLabel atmosphereDetailsLabel;
    private javax.swing.JPanel configurationsPanel;
    private javax.swing.JPanel detailsPanel;
    private javax.swing.JTextPane detailsTextPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem englishMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JMenu languageMenu;
    private javax.swing.JLabel laserDetailsLabel;
    private javax.swing.JButton laserSettingsButton;
    private javax.swing.JButton resultsButton;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JButton saveConfigurationsButton;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JMenuItem spanishMenuItem;
    private javax.swing.JLabel telescopeDetailsLabel;
    private javax.swing.JButton telescopeSettingsButton;
    private javax.swing.JButton viewGraphicsButton;
    // End of variables declaration//GEN-END:variables
}
