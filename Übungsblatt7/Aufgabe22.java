package Übungsblatt7;
import Prog1tools.IOTools;
import java.io.*;

public class Aufgabe22 {

    public Aufgabe22(){

    }


    public static void main(String[] args) throws IOException {
        String line = IOTools.readLine("Geben sie den Dateinamen ein: ");
        int n = IOTools.readInt("In welche Zeile soll ihr Text geschrieben werden? ");
        String Text = IOTools.readString("Was soll geschrieben werden? ");


        File s = new File(line);
        if(!s.exists()) {
            s.createNewFile();
        } else {
            System.out.println("Das File gibt es schon.");
        }
    }
}