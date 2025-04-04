package Übungsblatt7;

import java.io.*;
import java.util.Date;

import static jdk.internal.org.jline.utils.Colors.s;

public class Aufgabe24 implements Serializable {
    private int nummerDerRabattmarke;
    private String nameDesBesitzers;
    private int kundennummerDesBesitzers;
    private double rabattWertInProzent;
    private Date erstellungsDatum;
    static int anzahl;
    File a = new File("Rabattmarken.txt");

    public Aufgabe24(int nummerDerRabattmarke, String nameDesBesitzers,
                       int kundennummerDesBesitzers, double rabattWertInProzent) {
        this.nummerDerRabattmarke = nummerDerRabattmarke;
        this.nameDesBesitzers = nameDesBesitzers;
        this.kundennummerDesBesitzers = kundennummerDesBesitzers;
        this.rabattWertInProzent = rabattWertInProzent;
        this.erstellungsDatum = new Date();
    }

    public int getKundennummerDesBesitzers() {
        return kundennummerDesBesitzers;
    }

    @Override
    public String toString() {
        return "Rabattmarke:" + "\n" +
                "  Nummer = " + nummerDerRabattmarke + "\n" +
                "  Besitzer = " + nameDesBesitzers + "\n" +
                "  Kundennummer = " + kundennummerDesBesitzers + "\n" +
                "  Rabattwert = " + rabattWertInProzent + "%" + "\n" +
                "  Erstellt am = " + erstellungsDatum;
    }

    public static void schreiben(File a, Aufgabe24[] rabattmarken) throws IOException {
        a.createNewFile();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(a))) {
            for (Aufgabe24 marke : rabattmarken) {
                if (marke != null) {
                    bw.write(marke.toString());
                    bw.newLine();
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}