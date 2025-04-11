package Prog2.Übungsblatt1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aufgabe3 extends JFrame {

    JRadioButton redB;
    JRadioButton yellowB;
    JRadioButton greenB;
    JLabel redL;
    JLabel yellowL;
    JLabel greenL;
    ButtonGroup button;

    public Aufgabe3() {
        setTitle("Rechner");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        button = new ButtonGroup();

        redB = new JRadioButton("red");
        redB.setActionCommand("red"); // ActionCommand hinzufügen
        redB.addActionListener(new action()); // Listener hinzufügen
        button.add(redB);

        yellowB = new JRadioButton("yellow");
        yellowB.setActionCommand("yellow");
        yellowB.addActionListener(new action());
        button.add(yellowB);

        greenB = new JRadioButton("green");
        greenB.setActionCommand("green");
        greenB.addActionListener(new action());
        button.add(greenB);

        redL = new JLabel();
        redL.setOpaque(true);
        redL.setBackground(Color.RED);
        redL.setVisible(false);

        yellowL = new JLabel();
        yellowL.setOpaque(true);
        yellowL.setBackground(Color.YELLOW);
        yellowL.setVisible(false);

        greenL = new JLabel();
        greenL.setOpaque(true);
        greenL.setBackground(Color.GREEN);
        greenL.setVisible(false);

        add(redB);
        add(redL);
        add(yellowB);
        add(yellowL);
        add(greenB);
        add(greenL);

        setVisible(true);
    }

    public class action implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                redL.setVisible(false);
                yellowL.setVisible(false);
                greenL.setVisible(false);

                if (e.getActionCommand().equals("red")) {
                    redL.setVisible(true);
                } else if (e.getActionCommand().equals("yellow")) {
                    yellowL.setVisible(true);
                } else if (e.getActionCommand().equals("green")) {
                    greenL.setVisible(true);
                }

                repaint();
                revalidate();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}