package FunktionaleProgrammierung;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.*;

public class Aufgabe4 {

    public static void main(String[] args) throws IOException {
        // Aufgabe 4b
        ArrayList<String> personData = Hilfsklasse.readTXT(new File("/Users/maxmoser/Proog2 Aufgaben/FunktionaleProgrammierung/Personensatz.txt"));

        // Aufgabe 4c
        System.out.println("=== Aufgabe 4c ===");
        personData.stream().limit(15).forEach(System.out::println);

        // Aufgabe 4d
        System.out.println("\n=== Aufgabe 4d ===");
        personData.stream().skip(1).limit(5).forEach(System.out::println);

        // Aufgabe 4f
        LinkedList<Person> daten2 = personData.stream()
                .skip(1)
                .map(Hilfsklasse::ausString)
                .filter(Objects::nonNull)
                .collect(Collectors.toCollection(LinkedList::new));

        // Aufgabe 4g
        System.out.println("\n=== Aufgabe 4g ===");
        daten2.stream()
                .filter(p -> p.bundesland.equals("Rheinland-Pfalz"))
                .forEach(System.out::println);

        // Aufgabe 4h
        System.out.println("\n=== Aufgabe 4h ===");
        long count50Plus = daten2.stream().filter(p -> p.alter > 50).count();
        System.out.println(count50Plus);

        // Aufgabe 4i
        System.out.println("\n=== Aufgabe 4i ===");
        daten2.stream()
                .sorted(Comparator.comparing(p -> p.alter))
                .map(p -> p.alter + " Jahre")
                .forEach(System.out::println);

        // Aufgabe 4j
        System.out.println("\n=== Aufgabe 4j ===");
        daten2.stream()
                .filter(p -> p.name.contains("nn"))
                .distinct()
                .forEach(System.out::println);

        // Aufgabe 4k
        System.out.println("\n=== Aufgabe 4k ===");
        double avgNameLength = daten2.stream()
                .mapToInt(p -> p.name.length())
                .average()
                .orElse(0);
        System.out.println(avgNameLength);

        // Aufgabe 4l
        System.out.println("\n=== Aufgabe 4l ===");
        daten2.forEach(p -> p.bundesland = p.bundesland.substring(0, 3));
        daten2.stream().limit(20).forEach(System.out::println);

        // Aufgabe 4m
        System.out.println("\n=== Aufgabe 4m ===");
        boolean hasDoubleVowels = daten2.stream()
                .anyMatch(p -> p.vorname.matches(".*([aeiou])\\1.*"));
        System.out.println(hasDoubleVowels);

        // Aufgabe 4n
        System.out.println("\n=== Aufgabe 4n ===");
        long noTitleCount = daten2.stream()
                .filter(p -> !p.anrede.matches("Frau|Herr"))
                .count();
        double percent = (double) noTitleCount / daten2.size() * 100;
        System.out.println(percent + "%");

        // Aufgabe 4o
        System.out.println("\n=== Aufgabe 4o ===");
        long adultCount = daten2.stream().filter(p -> p.alter >= 18).count();
        System.out.println(adultCount > 2500 ? "Volljährig" : "Nicht volljährig");

        // Aufgabe 4p
        System.out.println("\n=== Aufgabe 4p ===");
        int product = IntStream.rangeClosed(1, 38)
                .filter(n -> n % 2 != 0)
                .reduce(1, (a, b) -> a * b);
        System.out.println(product);

        // Aufgabe 4q
        System.out.println("\n=== Aufgabe 4q ===");
        Random random = new Random();
        int birthMonth = 6; // Beispiel: Juni
        long monthCount = random.ints(1, 13)
                .limit(20)
                .filter(n -> n == birthMonth)
                .count();
        System.out.println(monthCount);

        // Aufgabe 4r
        System.out.println("\n=== Aufgabe 4r ===");
        ArrayList<Integer> numbers = IntStream.rangeClosed(1, 100_000)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        // Fall 1: For-Schleife
        long start = System.currentTimeMillis();
        long primeCount1 = 0;
        for (int n : numbers) {
            if (isPrime(n)) primeCount1++;
        }
        long time1 = System.currentTimeMillis() - start;

        // Fall 2: Stream
        start = System.currentTimeMillis();
        long primeCount2 = numbers.stream().filter(Aufgabe4::isPrime).count();
        long time2 = System.currentTimeMillis() - start;

        // Fall 3: Parallel Stream
        start = System.currentTimeMillis();
        long primeCount3 = numbers.parallelStream().filter(Aufgabe4::isPrime).count();
        long time3 = System.currentTimeMillis() - start;

        System.out.println("For-Schleife: " + time1 + "ms, Count: " + primeCount1);
        System.out.println("Stream: " + time2 + "ms, Count: " + primeCount2);
        System.out.println("Parallel Stream: " + time3 + "ms, Count: " + primeCount3);

        // Aufgabe 4t
        System.out.println("\n=== Aufgabe 4t ===");
        List<BigInteger> fibNumbers = generateFibonacci(20);
        BigInteger sum = fibNumbers.stream()
                .reduce(BigInteger.ZERO, BigInteger::add);
        System.out.println("Summe der ersten 20 Fibonacci-Zahlen: " + sum);
    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number == 2 || number == 3) return true;
        if (number % 2 == 0) return false;
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 3; i < sqrt; i += 2)
            if (number % i == 0) return false;
        return true;
    }

    public static List<BigInteger> generateFibonacci(int n) {
        List<BigInteger> fib = new ArrayList<>();
        fib.add(BigInteger.ONE);
        fib.add(BigInteger.ONE);
        for (int i = 2; i < n; i++) {
            fib.add(fib.get(i-1).add(fib.get(i-2)));
        }
        return fib;
    }
}