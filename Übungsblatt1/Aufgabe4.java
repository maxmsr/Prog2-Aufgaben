package Übungsblatt1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aufgabe4 extends JFrame {

    // Felder für Eingabe und Ausgabe
    private JTextField text1;
    private JTextField text2;
    private JTextField symbol;
    private JLabel ergebnis;

    public Aufgabe4() {
        setTitle("Rechner");
        setSize(1000, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 5));

        // GUI-Komponenten erstellen
        JLabel gleich = new JLabel("                        =");
        ergebnis = new JLabel();
        text1 = new JTextField();
        text2 = new JTextField();
        symbol = new JTextField();
        symbol.setEditable(false);  // Symbolfeld nicht editierbar

        // Buttons erstellen
        JButton addi = new JButton("+");
        JButton sub = new JButton("-");
        JButton multi = new JButton("*");
        JButton div = new JButton("/");
        JButton del = new JButton("Löschen");

        // Komponenten zum Frame hinzufügen
        add(text1);
        add(symbol);
        add(text2);
        add(gleich);
        add(ergebnis);
        add(addi);
        add(sub);
        add(multi);
        add(div);
        add(del);

        // Listener hinzufügen
        CalculationListener listener = new CalculationListener();
        addi.addActionListener(listener);
        sub.addActionListener(listener);
        multi.addActionListener(listener);
        div.addActionListener(listener);
        del.addActionListener(listener);

        setVisible(true);
    }

    // Innere Klasse für die Berechnung
    private class CalculationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double a = Double.parseDouble(text1.getText());
                double b = Double.parseDouble(text2.getText());
                double result = 0;

                if (e.getActionCommand().equals("+")) {
                    result = a + b;
                    symbol.setText("                        +");
                } else if (e.getActionCommand().equals("-")) {
                    result = a - b;
                    symbol.setText("                        -");
                } else if (e.getActionCommand().equals("*")) {
                    result = a * b;
                    symbol.setText("                        *");
                } else if (e.getActionCommand().equals("/")) {
                    if (b != 0) {
                        result = a / b;
                        symbol.setText("                        /");
                    } else {
                        ergebnis.setText("Fehler: Division durch 0");
                        return;
                    }
                } else if (e.getActionCommand().equals("Löschen")) {
                    text1.setText("");
                    text2.setText("");
                    symbol.setText("");
                    ergebnis.setText("");
                    return;
                }

                ergebnis.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                ergebnis.setText("Fehler: Ungültige Zahl");
            }
        }
    }
}