package atmosphere.gui;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Created by Oscar on 6/24/15.
 */
public class ConfigurationWindow {

    private JPanel panel1;
    private JLabel altitudeLabel;
    private JLabel initialAltitudeLabel;
    private JLabel maxAltitudeJLabel;
    private JLabel graphicsColorLabel;
    private JLabel temperatureColorLabel;
    private JComboBox temperatureColorComboBox;
    private JComboBox pressureColorComboBox;
    private JLabel pressureColorLabel;
    private JButton backButton;
    private JButton generateButton;
    private JTextField initialAltitudeJtextField;
    private JTextField topAltitudeJtextField;

    public ConfigurationWindow() {
        this.temperatureColorComboBox.addItem("Blue");
        this.pressureColorComboBox.addItem("Blue");
        generateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                generate();
            }
        });
        generateButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Configuration Window");
        frame.setContentPane(new ConfigurationWindow().panel1);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void generate() {
        ArrayList<Integer> data = new ArrayList<Integer>();
        for (int i = Integer.parseInt(this.initialAltitudeJtextField.getText()); i <= Integer.parseInt(this.topAltitudeJtextField.getText()); i++) {
            data.add(i);
        }
        new Visualizer(data);
    }
}
