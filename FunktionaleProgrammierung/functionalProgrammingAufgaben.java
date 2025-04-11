package FunktionaleProgrammierung;

import java.util.function.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Aufgabe 1
interface addition {
    double calculate(double x);
}

interface abfrage {
    boolean istGroesserNull(double x);
}

// Aufgabe 2
interface funktion<VON, ZU> {
    ZU apply(VON v);
}

public class functionalProgrammingAufgaben {

    // Aufgabe 1.1a
    public static void aufgabe1a() {
        addition f = x -> Math.pow(x, 3) + 2*x + (100/x);
        System.out.println("Aufgabe 1a - f(25) = " + f.calculate(25));
        System.out.println("Aufgabe 1a - f(-25) = " + f.calculate(-25));
    }

    // Aufgabe 1.1b
    public static void aufgabe1b() {
        Function<Double, Double> f = x -> Math.pow(x, 3) + 2*x + (100/x);
        System.out.println("Aufgabe 1b - f(25) = " + f.apply(25.0));
        System.out.println("Aufgabe 1b - f(-25) = " + f.apply(-25.0));
    }

    // Aufgabe 1.2a
    public static void aufgabe2a() {
        abfrage g = x -> (x + 2) > 0;
        System.out.println("Aufgabe 2a - g(5) > 0? " + g.istGroesserNull(5));
        System.out.println("Aufgabe 2a - g(-5) > 0? " + g.istGroesserNull(-5));
    }

    // Aufgabe 1.2b
    public static void aufgabe2b() {
        Predicate<Double> g = x -> (x + 2) > 0;
        System.out.println("Aufgabe 2b - g(5) > 0? " + g.test(5.0));
        System.out.println("Aufgabe 2b - g(-5) > 0? " + g.test(-5.0));
    }

    // Aufgabe 2.1
    public static void aufgabe2_1() {
        funktion<String, Integer> f = new funktion<>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        System.out.println("Aufgabe 2.1 - Länge Nachname: " + f.apply("Mustermann"));
    }

    // Aufgabe 2.2
    public static void aufgabe2_2() {
        funktion<String, Integer> f = s -> s.length();
        System.out.println("Aufgabe 2.2 - Länge Nachname: " + f.apply("Mustermann"));
    }

    // Aufgabe 2.3-4
    public static void aufgabe2_3_4() {
        Consumer<Double> printer = d -> System.out.println(d);
        printer.accept(new Random().nextDouble());

        Consumer<Double> printer2 = System.out::println;
        printer2.accept(new Random().nextDouble());

        List<String> freunde = new ArrayList<>(List.of("Brian", "Nate", "Neal", "Raju", "Lea", "Sara", "Scotty", "Max"));
        freunde.forEach(s -> System.out.println(s.toUpperCase()));
    }

    // Aufgabe 3
    interface Bedingung {
        boolean trifftZuAuf(String s);
    }

    public static String erstesWort(String[] str, Bedingung bedingung) {
        for (String s : str) {
            if (bedingung.trifftZuAuf(s)) {
                return s;
            }
        }
        return "";
    }

    public static void aufgabe3() {
        String[] woerter = {
                "Alle", "lieben", "den", "Kuchen", "der", "Oma", "Hilde", "und", "auch", "die",
                "Linsensuppe", "von", "Opa", "Hans"
        };

        System.out.println("1. Wort mit A: " + erstesWort(woerter, s -> s.startsWith("A")));
        System.out.println("1. Wort mit 'au': " + erstesWort(woerter, s -> s.contains("au")));
        System.out.println("1. Wort mit 'suppe': " + erstesWort(woerter, s -> s.endsWith("suppe")));
        System.out.println("1. Wort mit 5 Zeichen: " + erstesWort(woerter, s -> s.length() == 5));
    }

    public static void main(String[] args) {
        aufgabe1a();
        aufgabe1b();
        aufgabe2a();
        aufgabe2b();
        aufgabe2_1();
        aufgabe2_2();
        aufgabe2_3_4();
        aufgabe3();
    }
}