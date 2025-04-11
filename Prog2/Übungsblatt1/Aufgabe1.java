package Prog2.Übungsblatt1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Aufgabe1 extends JFrame {

    public Aufgabe1() {
        // Frame-Einstellungen
        setTitle("Farbwechsel-Frame");
        setSize(250, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // JButton erstellen und hinzufügen
        JButton button = new JButton("Schwarz");
        add(button, BorderLayout.SOUTH);

        // ActionListener für den Button registrieren
        button.addActionListener(new ButtonBearbeiter());

        // MouseListener für den Frame registrieren
        addMouseListener(new MausBearbeiter());

        setVisible(true);
    }

    // Innere Klasse zur Verarbeitung von Button-Klicks
    private class ButtonBearbeiter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            getContentPane().setBackground(Color.BLACK);
        }
    }

    // Innere Klasse zur Verarbeitung von Mausklicks
    private class MausBearbeiter implements MouseListener {
        @Override
        public void mousePressed(MouseEvent e) {
            getContentPane().setBackground(Color.WHITE);
        }

        @Override
        public void mouseClicked(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
    }
}