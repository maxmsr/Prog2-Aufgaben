package Übungsblatt1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aufgabe5 extends JFrame{

    public JComboBox <String> auswahl;
    public JTextField input;
    public JLabel ausgabe;
    public JLabel euro;


    public Aufgabe5() {
        setTitle("Umrechner");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        String[] währung = { "DM", "Schilling", "Dollar"};

        euro = new JLabel("                                      Euro");
        add(euro);
        input = new JTextField();
        add(input);
        auswahl = new JComboBox<String>(währung);
        auswahl.setActionCommand();
        auswahl.setActionListener
        add(auswahl);
        ausgabe = new JLabel();
        add(ausgabe);




        setVisible(true);
    }

    public class action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
