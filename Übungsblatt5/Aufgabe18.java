package Übungsblatt5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aufgabe18 extends JFrame implements Runnable, ActionListener {
        JButton button1;
        JButton button2;
        JComboBox box;
        JCheckBox check;
        JPanel panel;

        public Aufgabe18(){
            super("Lauf");
            setSize(550, 350);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);
            setLocationRelativeTo(null);
            setLayout(new GridLayout(3,1));

            panel = new JPanel(new FlowLayout());
            button1 = new JButton("");
            button1.addActionListener((ActionListener) this);
            button2 = new JButton("");
            button2.addActionListener((ActionListener) this);
            button1.setPreferredSize(new Dimension(250, 100));
            button2.setPreferredSize(new Dimension(250, 100));
            panel.add(button1);
            panel.add(button2);
            add(panel);

            String[] schrift = {"schwarze Schrift", "graue Schrift"};
            box = new JComboBox<String>(schrift);
            add(box);

            check = new JCheckBox("Buchstabe");
            check.setHorizontalAlignment(SwingConstants.CENTER);
            add(check);

            setVisible(true);
        }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            button1.setText(String.valueOf((int) (Math.random() * 10)));
        } else if (e.getSource() == button2) {
            button2.setText(String.valueOf((int) (Math.random() * 10)));
        }
    }

    @Override
    public void run() {

    }
}
