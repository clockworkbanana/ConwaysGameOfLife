package life.ui;

import life.containers.NodesGrid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;


public class UiFrame {

    NodesGrid life;
    boolean stopButtonPressed;

    private JFrame frame;
    private JPanel buttonsPanel;
    private DrawPanel graphicsPanel;
    private JButton nextButton;
    private JButton tenStepsButton;
    private JButton hundredStepsButton;
    private JButton thousandStepsButton;

    public UiFrame(Integer[][] startArray){
        life = new NodesGrid(startArray);

        gui();
        try {
            TimeUnit.MILLISECONDS.sleep(100); //Otherwise first step is not drawn
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        graphicsPanel.refresh();
    }

    public void playNSteps(int n){
        int i = 0;
        while (i<n) {
            life.performStep();
            graphicsPanel.refresh();
            i++;
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }

    }

    private void gui() {
        frame = new JFrame("Life");
        frame.setVisible(true);
        frame.setSize(700,700);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.WHITE);

        graphicsPanel = new DrawPanel(life);

        nextButton = new JButton("Step");
        buttonsPanel.add(nextButton);
        nextButton.addActionListener(e -> {
            life.performStep();
            graphicsPanel.refresh();
        });

        tenStepsButton = new JButton(">");
        buttonsPanel.add(tenStepsButton);
        tenStepsButton.addActionListener(e -> playNSteps(10));

        hundredStepsButton = new JButton(">>");
        buttonsPanel.add(hundredStepsButton);
        hundredStepsButton.addActionListener(e -> playNSteps(100));

        thousandStepsButton = new JButton(">>>");
        buttonsPanel.add(thousandStepsButton);
        thousandStepsButton.addActionListener(e -> playNSteps(1000));



        frame.add(graphicsPanel);
        frame.add(buttonsPanel, BorderLayout.NORTH);
    }
}