package atmosphere.gui;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JComboBox;

public class GraphicsConfiguration extends javax.swing.JFrame {

    public GraphicsConfiguration() {
        Locale.setDefault(new Locale(System.getProperty("user.language"), System.getProperty("user.country")));
        initComponents();
        this.setVisible(true);
        this.getRootPane().setDefaultButton(this.generateButton);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        initialAltitudeTextField = new javax.swing.JTextField();
        finalAltitudeTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        temperatureColorComboBox = new javax.swing.JComboBox();
        pressureColorComboBox = new javax.swing.JComboBox();
        mieColorComboBox = new javax.swing.JComboBox();
        alphaRayleighColorComboBox = new javax.swing.JComboBox();
        betaRayleighColorComboBox = new javax.swing.JComboBox();
        backButton = new javax.swing.JButton();
        generateButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("atmosphere/gui/Bundle"); // NOI18N
        setTitle(bundle.getString("GraphicsConfiguration.title")); // NOI18N
        setResizable(false);

        jLabel1.setText(bundle.getString("GraphicsConfiguration.jLabel1.text")); // NOI18N

        jLabel2.setText(bundle.getString("GraphicsConfiguration.jLabel2.text")); // NOI18N

        jLabel3.setText(bundle.getString("GraphicsConfiguration.jLabel3.text")); // NOI18N

        initialAltitudeTextField.setToolTipText(bundle.getString("GraphicsConfiguration.initialAltitudeTextField.toolTipText")); // NOI18N

        finalAltitudeTextField.setToolTipText(bundle.getString("GraphicsConfiguration.finalAltitudeTextField.toolTipText")); // NOI18N

        jLabel4.setText(bundle.getString("GraphicsConfiguration.jLabel4.text")); // NOI18N

        jLabel5.setText(bundle.getString("GraphicsConfiguration.jLabel5.text")); // NOI18N

        jLabel6.setText(bundle.getString("GraphicsConfiguration.jLabel6.text")); // NOI18N

        jLabel7.setText(bundle.getString("GraphicsConfiguration.jLabel7.text")); // NOI18N

        jLabel8.setText(bundle.getString("GraphicsConfiguration.jLabel8.text")); // NOI18N

        jLabel9.setText(bundle.getString("GraphicsConfiguration.jLabel9.text")); // NOI18N

        temperatureColorComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Red", "Blue", "Black", "Green" }));

        pressureColorComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Red", "Blue", "Black", "Green" }));

        mieColorComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Red", "Blue", "Black", "Green" }));

        alphaRayleighColorComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Red", "Blue", "Black", "Green" }));

        betaRayleighColorComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Red", "Blue", "Black", "Green" }));

        backButton.setText(bundle.getString("GraphicsConfiguration.backButton.text")); // NOI18N

        generateButton.setText(bundle.getString("GraphicsConfiguration.generateButton.text")); // NOI18N
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(generateButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel8))))
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(finalAltitudeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                            .addComponent(initialAltitudeTextField))
                                        .addComponent(pressureColorComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(mieColorComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(alphaRayleighColorComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(betaRayleighColorComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(temperatureColorComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(initialAltitudeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(finalAltitudeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(temperatureColorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(pressureColorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(mieColorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(alphaRayleighColorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(betaRayleighColorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(generateButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButtonActionPerformed
        double initial = Double.parseDouble(this.initialAltitudeTextField.getText());
        double ending = Double.parseDouble(this.finalAltitudeTextField.getText());
        DecimalFormat df = new DecimalFormat("#.000");
        double var = initial;
        ArrayList<Number> data = new ArrayList<Number>();

        while (var <= ending){
            data.add(var);
            var = var + 0.001;
        }

        //for (float i = Float.parseFloat(this.initialAltitudeTextField.getText()); i <= Float.parseFloat(this.finalAltitudeTextField.getText()); i+=0.001) {
          //  data.add(i);
        //}

        colors.add(0, obtainSelectedColor(this.temperatureColorComboBox));
        colors.add(1, obtainSelectedColor(this.pressureColorComboBox));
        colors.add(2, obtainSelectedColor(this.mieColorComboBox));
        colors.add(3, obtainSelectedColor(this.alphaRayleighColorComboBox));
        colors.add(4, obtainSelectedColor(this.betaRayleighColorComboBox));
        this.dispose();
        GraphicsVisualizer graphicsVisualizer = new GraphicsVisualizer(data, colors);
        graphicsVisualizer.setVisible(true);
        
    }//GEN-LAST:event_generateButtonActionPerformed
    private Color obtainSelectedColor(JComboBox colorComboBox){
        int option = colorComboBox.getSelectedIndex();
        Color selectedColor = null;
        switch(option){
            case 0:
                selectedColor = Color.RED;
                break;
            case 1:
                selectedColor = Color.BLUE;
                break;
            case 2:
                selectedColor = Color.BLACK;
                break;
            case 3:
                selectedColor = Color.GREEN;
                break;
        }
        return selectedColor;
    }
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GraphicsConfiguration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraphicsConfiguration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraphicsConfiguration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraphicsConfiguration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraphicsConfiguration().setVisible(true);
            }
        });
    }
    private ArrayList<Color> colors = new ArrayList<Color>();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox alphaRayleighColorComboBox;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox betaRayleighColorComboBox;
    private javax.swing.JTextField finalAltitudeTextField;
    private javax.swing.JButton generateButton;
    private javax.swing.JTextField initialAltitudeTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox mieColorComboBox;
    private javax.swing.JComboBox pressureColorComboBox;
    private javax.swing.JComboBox temperatureColorComboBox;
    // End of variables declaration//GEN-END:variables


}
