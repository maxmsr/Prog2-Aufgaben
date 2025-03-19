package Übungsblatt5;

import javax.swing.*;
import java.awt.*;

public class Aufgabe18 extends JFrame implements Runnable {
        private JButton button1;
        private JButton button2;
        private JComboBox box;
        private JCheckBox check;

        public Aufgabe18(){
            super("Lauf");
            setSize(500, 300);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBackground(new Color(0, 245, 245));
            isOpaque();
            setLayout(new GridLayout(4, 1));

            setVisible(true);
        }

    @Override
    public void run() {

    }
}
