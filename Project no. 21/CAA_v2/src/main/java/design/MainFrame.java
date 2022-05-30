package design;

import javax.swing.*;

import static java.awt.BorderLayout.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    JPanel jPanelWest, jPanelEast;

    public MainFrame() {
        super("Advanced Programming - Final Project");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);

        jPanelWest = new JPanel();
        jPanelEast = new JPanel();

        add(configPanel, CENTER);
        add(controlPanel, SOUTH);
        add(jPanelEast, EAST);
        add(jPanelWest, WEST);

        pack();
    }
}
