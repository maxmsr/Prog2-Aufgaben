import javax.swing.*;

import AlogoUndData.Blatt4.listeF;
import Übungsblatt1.*;
import Übungsblatt5.*;

public class Main {
    public static void main(String[] args) {
        // new Aufgabe1();
        // new Aufgabe2();
        // new Aufgabe3();
        // new Aufgabe4();
        // new Aufgabe5();
        // Aufgabe16 thread = new Aufgabe16();
        // thread.start();
        // new Aufgabe17();
        // new Aufgabe18();
        listeF<Integer> list = new listeF<>(10);
        list.add(5);
        list.add(3);
        list.add(8);
        list.add(1);

        list.loescheMin(); // Löscht das Element 1
        System.out.println(list.get(2)); // Gibt 8 aus (neue Struktur: [5, 3, 8])
    }
}