package FunktionaleProgrammierung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class privateÜbungen {

    interface Supplier<S> {
        public String get();
    }

    //Aufgabe 1
    public class Aufgabe1{
        Predicate<String> startsWithJ = s -> s.startsWith("J");
    }

    public class Aufgabe2{
        Predicate<int[]> greaterThen10;
    }

    public void main(String[] args) {
        Aufgabe1 a = new Aufgabe1();
        System.out.println(a.startsWithJ.test("Java"));
        System.out.println(a.startsWithJ.test("Python"));

        Aufgabe2 a2 = new Aufgabe2();
        int[] i = {3,7,12,5,20,6,7,8,9,10};
        Arrays.stream(i).filter(x -> x > 10).sorted().forEach(System.out::println);

        List<String> str = Arrays.asList("Java","Python","Apfel","Baum","Auto");
        List<Integer> length = str.stream().map(x -> x.length()).collect(Collectors.toList());
        System.out.println(length);

        List<Integer> zahl = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int g = zahl.stream().reduce(1, (c,b)-> c*b);
        System.out.println(g);

        List<String> str2 = Arrays.asList("Java","Python","Apfel","Baum","Auto");

        List<String> str3 = new ArrayList<String>();
        str3.add("Hund");
        str3.add("Katze");
        str3.add("Maus");

        List<Character> output = str3.stream()
                .map(s -> s.charAt(0))  // Transformiere jeden String zu seinem ersten Char
                .collect(Collectors.toList());  // Sammle in einer neuen Liste
        System.out.println(output);

    }
    }

