package atmosphere.gui;

import com.xeiam.xchart.Chart;
import com.xeiam.xchart.XChartPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GraphPanel {

    private String windowTitle;
    private JFrame frame;
    private ArrayList<Chart> charts = new ArrayList<Chart>();
    private int numRows;
    private int numColumns;

    /**
     * Constructor
     *
     * @param chart
     */
    public GraphPanel(Chart chart) {
        this.charts.add(chart);
    }

    /**
     * Constructor - The number of rows and columns will be calculated automatically Constructor
     *
     * @param charts
     */
    public GraphPanel(ArrayList<Chart> charts) {
        this.charts = charts;
        this.numRows = (int) (Math.sqrt(charts.size()) + .5);
        this.numColumns = (int) ((double) charts.size() / this.numRows + 1);

    }

    /**
     * Constructor
     *
     * @param charts
     * @param numRows    - the number of rows
     * @param numColumns - the number of columns
     */
    public GraphPanel(ArrayList<Chart> charts, int numRows, int numColumns) {

        this.charts = charts;
        this.numRows = numRows;
        this.numColumns = numColumns;
    }

    /**
     * Display the chart in a Swing JFrame
     *
     * @param windowTitle the title of the window
     */
    public JFrame displayChart(String windowTitle) {
        frame = new JFrame(windowTitle);
        this.windowTitle = windowTitle;
        return displayChart();
    }

    /**
     * Display the chart in a Swing JFrame
     */
    public JFrame displayChart() {

        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's gui.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JPanel chartPanel = new XChartPanel(charts.get(0));
                frame.add(chartPanel);

                // Display the window.

                frame.pack();
                frame.setVisible(true);
                Toolkit tk = Toolkit.getDefaultToolkit();
                frame.setSize(((int) tk.getScreenSize().getWidth()), ((int) tk.getScreenSize().getHeight()));

            }
        });

        return frame;
    }

    /**
     * Display the charts in a Swing JFrame
     *
     * @param windowTitle the title of the window
     * @return the JFrame
     */
    public JFrame displayChartMatrix(String windowTitle) {
        this.windowTitle = windowTitle;
        return displayChartMatrix();
    }

    /**
     * Display the chart in a Swing JFrame
     */
    public JFrame displayChartMatrix() {

        // Create and set up the window.
        final JFrame frame = new JFrame(windowTitle);

        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's gui.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().setLayout(new GridLayout(numRows, numColumns));

                for (Chart chart : charts) {
                    if (chart != null) {
                        JPanel chartPanel = new XChartPanel(chart);
                        frame.add(chartPanel);
                    } else {
                        JPanel chartPanel = new JPanel();
                        frame.getContentPane().add(chartPanel);
                    }

                }

                // Display the window.
                Toolkit tk = Toolkit.getDefaultToolkit();
                frame.setSize(((int) tk.getScreenSize().getWidth()), ((int) tk.getScreenSize().getHeight()));

                frame.pack();
                frame.setVisible(true);
            }
        });

        return frame;
    }

}
