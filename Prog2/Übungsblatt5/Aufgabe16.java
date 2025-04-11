package Übungsblatt5;
import java.io.IOException;
import java.util.Scanner;

public class Aufgabe16 extends Thread {

    public Aufgabe16() {
        // Leerer Konstruktor
    }

    @Override
    public void run() {
        // Warte auf Enter-Eingabe bevor der Timer startet
        System.out.print("To Start the timer, press enter: ");
        Scanner scan = new Scanner(System.in);

        // Blockiere bis Enter gedrückt wird
        scan.nextLine();  // Diese Zeile wartet auf Enter

        System.out.println("Timer started!");

        // Timer-Logik
        int seconds = 0;
        try {
            while (true) {
                // Warten und hochzählen
                Thread.sleep(1000);
                seconds++;
                System.out.println("Timer: " + seconds + " seconds");

                // Prüfen, ob Enter gedrückt wurde
                if (System.in.available() > 0) {
                    scan.nextLine(); // Eingabe (Enter) auslesen
                    System.out.println("Der Timer lief " + Thread.activeCount() + " Sekunden lang.");
                    break;
                }
            }
        } catch (InterruptedException | IOException e) {
            System.out.println("Timer interrupted");
        } finally {
            scan.close();
        }
    }
}