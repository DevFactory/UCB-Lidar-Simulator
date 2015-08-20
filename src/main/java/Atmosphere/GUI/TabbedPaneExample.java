package atmosphere.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Oscar on 8/19/15.
 */
public class TabbedPaneExample extends JFrame {

    private JTabbedPane tabbedPane;
    private JPanel panel1;
    private JPanel panel2;


    public TabbedPaneExample() {
        // NOTE: to reduce the amount of code in this example, it uses
        // panels with a NULL layout.  This is NOT suitable for
        // production code since it may not display correctly for
        // a look-and-feel.

        setTitle("Tabbed Pane Application");
        setSize(300, 200);
        setBackground(Color.gray);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        getContentPane().add(topPanel);

        // Create the tab pages
        createPage1();
        createPage2();


        // Create a tabbed pane
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Mie", panel1);
        tabbedPane.addTab("Pressure", panel2);

        topPanel.add(tabbedPane, BorderLayout.CENTER);
    }

    // Main method to get things started
    public static void main(String args[]) {
        // Create an instance of the test application
        TabbedPaneExample mainFrame = new TabbedPaneExample();
        mainFrame.setVisible(true);
    }

    public void createPage1() {

        panel1 =
        panel1 = new JPanel();
        panel1.setLayout(null);

        JLabel label1 = new JLabel("Username:");
        label1.setBounds(10, 15, 150, 20);
        panel1.add(label1);

        JTextField field = new JTextField();
        field.setBounds(10, 35, 150, 20);
        panel1.add(field);

        JLabel label2 = new JLabel("Password:");
        label2.setBounds(10, 60, 150, 20);
        panel1.add(label2);

        JPasswordField fieldPass = new JPasswordField();
        fieldPass.setBounds(10, 80, 150, 20);
        panel1.add(fieldPass);
    }

    public void createPage2() {
        panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());

        panel2.add(new JButton("North"), BorderLayout.NORTH);
        panel2.add(new JButton("South"), BorderLayout.SOUTH);
        panel2.add(new JButton("East"), BorderLayout.EAST);
        panel2.add(new JButton("West"), BorderLayout.WEST);
        panel2.add(new JButton("Center"), BorderLayout.CENTER);
    }
}

