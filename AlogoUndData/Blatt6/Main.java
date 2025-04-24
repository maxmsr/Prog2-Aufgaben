package AlogoUndData.Blatt6;

import java.util.*;


public class Main {

    public static <T> TreeSet<T> duplikat(Collection<T> c) {
        TreeSet<T> treeSet = new TreeSet<>();
        Set<T> duplikate = new HashSet<>();

        for (T element : c) {
            if (!treeSet.add(element)) {
                duplikate.add(element);
            }
        }
        System.out.println("Gefundene Duplikate: " + duplikate);

        return treeSet;
    }

    public static void main(String[] args) {

        // Aufgabe1
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        TreeSet<Integer> result = duplikat(numbers);
        System.out.println("TreeSet ohne Duplikate: " + result);

        //Aufgabe2
        FCFSListe wartezimmer = new FCFSListe();
        System.out.println("Arztpraxis-Wartezimmer-Verwaltung startet...");
        ZArztPraxis.warteZimmer(wartezimmer);
        System.out.println("Programm beendet.");
    }
}

class FCFSListe implements WarteSchlange {
    private ZPatient anfang;
    private ZPatient ende;

    public FCFSListe() {
        anfang = null;
        ende = null;
    }

    @Override
    public void anmelden(ZPatient p) {
        p.next = null;

        if (ende == null) {
            anfang = p;
            ende = p;
        } else {
            ende.next = p;
            ende = p;
        }
    }

    @Override
    public ZPatient derNaechsteBitte() {
        if (anfang == null) {
            return null;
        }

        ZPatient naechster = anfang;
        anfang = anfang.next;

        if (anfang == null) {
            ende = null;
        }

        return naechster;
    }
}
