package atmosphere.gui;

import atmosphere.Mie;
import atmosphere.Pressure;
import atmosphere.Temperature;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Oscar on 8/19/15.
 */
public class Visualizer extends JFrame {

    private JPanel mainPanel;
    private JTabbedPane tabbedPane;
    private JPanel temperaturePanel;
    private JPanel miePanel;
    private JPanel pressurePanel;

    public Visualizer() {
    }


    public Visualizer(ArrayList<Integer> data) {

        this.mainPanel = new JPanel();
        this.mainPanel.setLayout(new BorderLayout());
        getContentPane().add(this.mainPanel);
        createMieTab(data);
        createPressureTab(data);
        createTemperatureTab(data);

        this.tabbedPane = new JTabbedPane();
        this.tabbedPane.addTab("Temperature", this.temperaturePanel);
        this.tabbedPane.addTab("Pressure", this.pressurePanel);
        this.tabbedPane.addTab("Mie", this.miePanel);


        this.mainPanel.add(this.tabbedPane, BorderLayout.CENTER);


        setTitle("Visualizer");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        Toolkit tk = Toolkit.getDefaultToolkit();
        setSize(((int) tk.getScreenSize().getWidth()), ((int) tk.getScreenSize().getHeight()));
        setVisible(true);
    }

    private void createTemperatureTab(ArrayList<Integer> data) {
        Temperature temperature = new Temperature(data);
        temperature.generate();
        this.temperaturePanel = temperature.getPanel();
    }

    private void createPressureTab(ArrayList<Integer> data) {
        Pressure pressure = new Pressure(data);
        pressure.generate();
        this.pressurePanel = pressure.getPanel();
    }

    private void createMieTab(ArrayList<Integer> data) {
        Mie mie = new Mie();
        this.miePanel = mie.getPanel();
    }
}
