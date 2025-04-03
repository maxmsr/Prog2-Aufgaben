package Übungsblatt7;

import java.util.Date;
import java.io.Serializable;

public class Aufgabe24 implements Serializable {
    private int nummerDerRabattmarke;
    private String nameDesBesitzers;
    private int kundennummerDesBesitzers;
    private double rabattWertInProzent;
    private Date erstellungsDatum;

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
}