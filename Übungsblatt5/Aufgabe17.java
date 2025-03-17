package Übungsblatt5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aufgabe17 extends JFrame implements Runnable {

    private JButton redB;
    private JButton yellowB;
    private JButton greenB;

    public Aufgabe17() {
        setTitle("Spielautomat");
        setSize(750, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 3));

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };

        JPanel redSection = new JPanel(new BorderLayout());
        redB = new JButton("Start");
        redB.addActionListener(new action());
        JPanel redP = new JPanel();
        redP.setBackground(Color.RED);
        redSection.add(redB, BorderLayout.SOUTH);
        redSection.add(redP, BorderLayout.CENTER);

        JPanel yellowSection = new JPanel(new BorderLayout());
        yellowB = new JButton("Start");
        JPanel yellowP = new JPanel();
        yellowP.setBackground(Color.YELLOW);
        yellowSection.add(yellowB, BorderLayout.SOUTH);
        yellowSection.add(yellowP, BorderLayout.CENTER);

        JPanel greenSection = new JPanel(new BorderLayout());
        greenB = new JButton("Start");
        JPanel greenP = new JPanel();
        greenP.setBackground(Color.GREEN);
        greenSection.add(greenB, BorderLayout.SOUTH);
        greenSection.add(greenP, BorderLayout.CENTER);

        // Die Sektionen zum Haupt-Frame hinzufügen
        add(redSection);
        add(yellowSection);
        add(greenSection);

        setVisible(true);
    }

    @Override
    public void run() {
        // Hier kann deine Logik für die Buttons eingefügt werden
    }

}