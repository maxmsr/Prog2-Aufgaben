package Übungsblatt7;
import Prog1tools.IOTools;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Aufgabe22 {

    public static void main(String[] args) throws IOException {
        String fileName = IOTools.readLine("Geben Sie den Dateinamen ein: ");
        int lineNumber = IOTools.readInt("In welche Zeile soll Ihr Text geschrieben werden? ");
        String text = IOTools.readLine("Was soll geschrieben werden? ");

        File file = new File(fileName);

        // Falls Datei nicht existiert, erstelle sie
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("Die Datei wurde erstellt.");
        }

        // Dateiinhalt lesen
        List<String> lines = new ArrayList<>();
        if (file.length() > 0) {  // Falls Datei nicht leer ist, lese den Inhalt
            lines = Files.readAllLines(Paths.get(fileName));
        }

        // Falls die gewünschte Zeile noch nicht existiert, fügen wir leere Zeilen hinzu
        while (lines.size() < lineNumber) {
            lines.add(""); // Leere Zeilen hinzufügen, falls nötig
        }

        // Die gewünschte Zeile ersetzen
        lines.set(lineNumber - 1, text);

        // Datei überschreiben
        Files.write(Paths.get(fileName), lines);
        System.out.println("Text erfolgreich in Zeile " + lineNumber + " geschrieben.");
    }
}