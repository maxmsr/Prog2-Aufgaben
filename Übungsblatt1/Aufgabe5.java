package Übungsblatt1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aufgabe5 extends JFrame {
    public JComboBox<String> auswahl;
    public JTextField input;
    public JLabel ausgabe;
    public JLabel euro;

    public Aufgabe5() {
        setTitle("Umrechner");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        String[] währung = {"DM", "Schilling", "Dollar"};
        euro = new JLabel("                                      Euro");
        add(euro);

        input = new JTextField();
        add(input);

        auswahl = new JComboBox<String>(währung);
        auswahl.addActionListener(new CurrencyActionListener());
        add(auswahl);

        ausgabe = new JLabel();
        add(ausgabe);

        setVisible(true);
    }

    private class CurrencyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double betrag = Double.parseDouble(input.getText());
                String gewählteWährung = (String) auswahl.getSelectedItem();
                double ergebnis = 0.0;

                switch (gewählteWährung) {
                    case "DM":
                        ergebnis = betrag * 1.95583;
                        ausgabe.setText(String.format("%.2f Euro = %.2f DM", betrag, ergebnis));
                        break;
                    case "Schilling":
                        ergebnis = betrag * 13.7603;
                        ausgabe.setText(String.format("%.2f Euro = %.2f Schilling", betrag, ergebnis));
                        break;
                    case "Dollar":
                        ergebnis = betrag * 1.09;  // Ungefährer Wechselkurs
                        ausgabe.setText(String.format("%.2f Euro = %.2f Dollar", betrag, ergebnis));
                        break;
                }
            } catch (NumberFormatException ex) {
                ausgabe.setText("Bitte geben Sie einen gültigen Betrag ein");
            }
        }
    }
}