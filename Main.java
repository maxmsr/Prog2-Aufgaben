import javax.swing.*;

import AlogoUndData.Blatt4.listeF;
import Prog1tools.IOTools;
import Übungsblatt1.*;
//import Übungsblatt2.*;
//import Übungsblatt3.*;
//import Übungsblatt4.*;
import Übungsblatt3.Aufgabe10;
import Übungsblatt5.*;
//import Übungsblatt6.*;
import Übungsblatt7.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // new Aufgabe1();
        // new Aufgabe2();
        // new Aufgabe3();
        // new Aufgabe4();
        // new Aufgabe5();
        // Aufgabe16 thread = new Aufgabe16();
        // thread.start();
        // new Aufgabe17();
        // new Aufgabe18();

        /*
        listeF<Integer> list = new listeF<>(10);
        list.add(5);
        list.add(3);
        list.add(8);
        list.add(1);
        list.loescheMin(); // Löscht das Element 1
        System.out.println(list.get(2)); // Gibt 8 aus (neue Struktur: [5, 3, 8])
         */

        //new Aufgabe22();
        //Aufgabe24 a = new Aufgabe24(123, "Max", 456, 3);
        //System.out.println(a.toString());
        /*
        int anzahl = IOTools.readInt("Wieviele Rabattmarken willst du erzeugen? ");
        Aufgabe24[] rabattmarken = new Aufgabe24[anzahl];

        for(int i = 0; i < anzahl; i++) {
            System.out.println("Daten für Rabatmarke " + (i+1));
            String Name = IOTools.readLine("Name des Rabatmarken-Besitzers: ");
            int Kundenummer = IOTools.readInt("Kundennummer: ");
            double Wert = IOTools.readDouble("Wert der Marke in Prozent: ");

            rabattmarken[i] = new Aufgabe24(i+1, Name, Kundenummer, Wert);
        }

        try {
            Aufgabe24.schreiben(new File("Rabattmarken.txt"), rabattmarken);
            System.out.println(anzahl + " Rabattmarken in Rabattmarken.txt geschrieben.");
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben der Datei: " + e.getMessage());
        }

         */
        //Aufgabe24.print printer = new Aufgabe24.print();
        //printer.read();

        Aufgabe10 a = new Aufgabe10(10, 20);
        System.out.println(a.getX());
        System.out.println(a.getY());
        a.Drehen(3.5);
        System.out.println(a.getX());
        System.out.println(a.getY());
    }
}