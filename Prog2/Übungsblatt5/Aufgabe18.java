package Übungsblatt5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Klasse zur Steuerung des Button-Verhaltens
class ColorRunButton extends JButton implements Runnable {
    private boolean running = false;
    private boolean zeigtBuchstabe = true;
    private Thread thread;

    // Methode zur Steuerung des Threads
    public void change(boolean zeigtBuchstabe) {
        this.zeigtBuchstabe = zeigtBuchstabe;

        if (running) {
            running = false;  // Thread stoppen
        } else {
            running = true;   // Neuen Thread starten
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void run() {
        while (running) {
            char randomChar;

            if (zeigtBuchstabe) {
                randomChar = (char) ('A' + Math.random() * 10); // Zufallsbuchstabe
            } else {
                randomChar = (char) ('0' + Math.random() * 10); // Zufallszahl
            }

            setText(String.valueOf(randomChar));

            try {
                Thread.sleep(500); // Verzögerung für den Effekt
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

// Klasse zur GUI-Umsetzung
public class Aufgabe18 extends JFrame {
    private ColorRunButton button1, button2;
    private JComboBox<String> box;
    private JCheckBox check;

    public Aufgabe18() {
        super("LaufFrame");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        JPanel panel = new JPanel();
        button1 = new ColorRunButton();
        button2 = new ColorRunButton();

        button1.setPreferredSize(new Dimension(150, 100));
        button2.setPreferredSize(new Dimension(150, 100));

        button1.addActionListener(new KnopfListener(button1));
        button2.addActionListener(new KnopfListener(button2));

        panel.add(button1);
        panel.add(button2);
        add(panel);

        String[] schrift = {"schwarze Schrift", "graue Schrift"};
        box = new JComboBox<>(schrift);
        add(box);

        check = new JCheckBox("Buchstabe");
        check.setSelected(true); // Standardmäßig auf "Buchstabe"
        add(check);

        setVisible(true);
    }

    // Innere Klasse zur Event-Behandlung
    class KnopfListener implements ActionListener {
        private ColorRunButton button;

        public KnopfListener(ColorRunButton button) {
            this.button = button;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // ComboBox-Auswahl prüfen
            int index = box.getSelectedIndex();
            if (index == 0) {
                button.setForeground(Color.BLACK);
            } else {
                button.setForeground(Color.GRAY);
            }

            // Checkbox-Zustand prüfen
            boolean zeigtBuchstabe = check.isSelected();

            // Button-Text ändern und Thread-Status ausgeben
            button.change(zeigtBuchstabe);
            System.out.println("Thread-Zustand: " + Thread.currentThread().getState());
        }
    }

}