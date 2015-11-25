package atmosphere.gui;

import atmosphere.functions.plotter.FunctionPlotter;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Locale;
import javax.swing.*;

import helpers.GraphicsController;
import project.SimulationProject;
import ui.SettingsWindow;

/**
 * @author Oscar
 */
public class GraphicsVisualizer extends javax.swing.JFrame {

    /**
     * Creates new form GraphicsVisualizer
     */
    SimulationProject simulationProject = SimulationProject.getInstance();

    public GraphicsVisualizer() {
        Locale.setDefault(new Locale(System.getProperty("user.language"), System.getProperty("user.country")));
        GraphicsController graphicsController = new GraphicsController();
        this.functionPlotter = new FunctionPlotter();
        initComponents();
        makeFrameFullSize();
        createTemperatureTab(graphicsController.getChartPanels().get(0));
        createPressureTab(graphicsController.getChartPanels().get(1));
        createMieTab(graphicsController.getChartPanels().get(2));
        createRayleighTabs(graphicsController.getChartPanels().get(3), graphicsController.getChartPanels().get(4));
        createAtmosphereTab(graphicsController.getChartPanels().get(5));
        //createSNRTab(graphicsController.getChartPanels().get(6));
    }

    private void createTemperatureTab(JPanel panel) {
        this.temperaturePanel = panel;
        graphicsTabbedPane.setComponentAt(0, this.temperaturePanel);
    }

    private void createPressureTab(JPanel panel) {
        this.pressurePanel = panel;
        graphicsTabbedPane.setComponentAt(1, this.pressurePanel);
    }

    private void createMieTab(JPanel panel) {
        this.miePanel = panel;
        graphicsTabbedPane.setComponentAt(2, this.miePanel);

    }

    private void createRayleighTabs(JPanel panelA, JPanel panelB) {
        this.alphaRayleighPanel = panelA;
        this.betaRayleighPanel = panelB;
        graphicsTabbedPane.setComponentAt(3, this.alphaRayleighPanel);
        graphicsTabbedPane.setComponentAt(4, this.betaRayleighPanel);
    }

    private void createAtmosphereTab(JPanel panel) {
        this.atmospherePanel = panel;
        graphicsTabbedPane.setComponentAt(5, this.atmospherePanel);

    }

    /*private void createSNRTab(JPanel panel) {
        this.snrPanel = panel;
        graphicsTabbedPane.setComponentAt(6, this.snrPanel);
    }*/

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

        buttonPanel = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        graphicsTabbedPane = new javax.swing.JTabbedPane();
        temperaturePanel = new javax.swing.JPanel();
        pressurePanel = new javax.swing.JPanel();
        miePanel = new javax.swing.JPanel();
        alphaRayleighPanel = new javax.swing.JPanel();
        betaRayleighPanel = new javax.swing.JPanel();
        atmospherePanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
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
        setTitle(bundle.getString("GraphicsVisualizer.title")); // NOI18N

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

        jPanel2.setLayout(new java.awt.BorderLayout());

        graphicsTabbedPane.addTab(bundle.getString("GraphicsVisualizer.temperaturePanel.TabConstraints.tabTitle"), null, temperaturePanel, bundle.getString("GraphicsVisualizer.temperaturePanel.TabConstraints.tabToolTip")); // NOI18N
        graphicsTabbedPane.addTab(bundle.getString("GraphicsVisualizer.pressurePanel.TabConstraints.tabTitle"), null, pressurePanel, bundle.getString("GraphicsVisualizer.pressurePanel.TabConstraints.tabToolTip")); // NOI18N
        graphicsTabbedPane.addTab(bundle.getString("GraphicsVisualizer.miePanel.TabConstraints.tabTitle"), null, miePanel, bundle.getString("GraphicsVisualizer.miePanel.TabConstraints.tabToolTip")); // NOI18N
        graphicsTabbedPane.addTab(bundle.getString("GraphicsVisualizer.alphaRayleighPanel.TabConstraints.tabTitle"), null, alphaRayleighPanel, bundle.getString("GraphicsVisualizer.alphaRayleighPanel.TabConstraints.tabToolTip")); // NOI18N
        graphicsTabbedPane.addTab(bundle.getString("GraphicsVisualizer.betaRayleighPanel.TabConstraints.tabTitle"), null, betaRayleighPanel, bundle.getString("GraphicsVisualizer.betaRayleighPanel.TabConstraints.tabToolTip")); // NOI18N
        graphicsTabbedPane.addTab(bundle.getString("GraphicsVisualizer.atmospherePanel.TabConstraints.tabTitle"), null, atmospherePanel, bundle.getString("GraphicsVisualizer.atmospherePanel.TabConstraints.tabToolTip")); // NOI18N

        jPanel2.add(graphicsTabbedPane, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

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

        jMenuBar1.add(fileMenu);

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

        jMenuBar1.add(editMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.dispose();
        new SettingsWindow().setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void englishMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_englishMenuItemActionPerformed
        System.setProperty("user.language", "en");
        System.setProperty("user.country", "US");
        GraphicsVisualizer graphicsVisualizer = new GraphicsVisualizer();
        this.dispose();
        graphicsVisualizer.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_englishMenuItemActionPerformed

    private void spanishMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spanishMenuItemActionPerformed
        System.setProperty("user.language", "es");
        System.setProperty("user.country", "ES");
        GraphicsVisualizer graphicsVisualizer = new GraphicsVisualizer();
        this.dispose();
        graphicsVisualizer.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_spanishMenuItemActionPerformed

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
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            System.setProperty("com.apple.mrj.application.apple.menu.about.name", "WikiTeX");
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GraphicsVisualizer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraphicsVisualizer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraphicsVisualizer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraphicsVisualizer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraphicsVisualizer().setVisible(true);
            }
        });
    }

    private FunctionPlotter functionPlotter = new FunctionPlotter();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel alphaRayleighPanel;
    private javax.swing.JPanel atmospherePanel;
    private javax.swing.JButton backButton;
    private javax.swing.JPanel betaRayleighPanel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem englishMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JTabbedPane graphicsTabbedPane;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenu languageMenu;
    private javax.swing.JPanel miePanel;
    private javax.swing.JPanel pressurePanel;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JMenuItem spanishMenuItem;
    private javax.swing.JPanel temperaturePanel;
    // End of variables declaration//GEN-END:variables
}
