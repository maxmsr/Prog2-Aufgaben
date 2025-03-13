package Übungsblatt1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Aufgabe2 extends JFrame {

    private JLabel beschriftung;
    private JLabel datumsAnzeige;
    private JComboBox <String> formatAuswahl;
    private Date datum;
    private JButton aktualisieren;
    private static final SimpleDateFormat kurz = new SimpleDateFormat("EEE, MMM d, HH:mm");
    private static final SimpleDateFormat mittel = new SimpleDateFormat("d MMM, HH:mm:ss");
    private static final SimpleDateFormat lang = new SimpleDateFormat("yyyy.MM.dd G HH:mm:ss");
    public SimpleDateFormat gewaehlt = lang;

    public Aufgabe2() {
        formatAuswahl = new JComboBox<>(new String[]{"Lang", "Mittel", "Kurz"});

        beschriftung = new JLabel("Wähle ein Format:      ");
        datumsAnzeige = new JLabel();
        datum = new Date();
        aktualisieren = new JButton("Aktualisieren");

        setTitle("Zeitangabe");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(formatAuswahl, BorderLayout.NORTH);
        add(beschriftung, BorderLayout.WEST);
        add(datumsAnzeige, BorderLayout.CENTER);
        add(aktualisieren, BorderLayout.SOUTH);

        formatAuswahl.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                switch (formatAuswahl.getSelectedIndex()) {
                    case 0 -> gewaehlt = lang;
                    case 1 -> gewaehlt = mittel;
                    case 2 -> gewaehlt = kurz;
                }
                datumsAnzeige.setText(gewaehlt.format(datum));
            }
        });

        aktualisieren.addActionListener(new KnopfHorcher(datumsAnzeige));

        // Initiale Anzeige des Datums
        datumsAnzeige.setText(gewaehlt.format(datum));

        setVisible(true);
    }

    public class KnopfHorcher implements ActionListener {
        private final JLabel datumsAnzeige;

        public KnopfHorcher(JLabel datumsAnzeige) {
            this.datumsAnzeige = datumsAnzeige;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Date neuesDatum = new Date();
            datumsAnzeige.setText(gewaehlt.format(neuesDatum));
        }
    }

}