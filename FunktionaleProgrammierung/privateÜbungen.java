package FunktionaleProgrammierung;

import java.io.Serializable;
import java.util.*;
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

    public class Person{
        String name;
        int age;

        public Person(String name, int i) {
            this.name = name;
            this.age = i;
        }

        @Override
        public String toString() {
            return super.toString();
        }

        public int getAge() {
            return age;
        }
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


        List<Integer> AL = Arrays.asList(3, 7, 12, 5, 20);
        List<Integer> AL2 = AL.stream().filter(n -> n>10).collect(Collectors.toList());
        System.out.println(AL2);

        List<String> Auf2 = Arrays.asList("Java","Python","Apfel","Baum","Auto");
        List<Integer> Auf2Lö = Auf2.stream().map(x -> x.length()).filter(x -> x>4).collect(Collectors.toList());
        System.out.println(Auf2Lö);

        List<Integer> Auf3 = Arrays.asList(3,7,12,5,20,6,7,8,9,10);
        List<Integer> Auf3Lö = Collections.singletonList(Auf3.stream().reduce(0, Integer::sum));
        System.out.println(Auf3Lö);

        List<Person> personenListe = new ArrayList<>();

        // Personen zur Liste hinzufügen
        personenListe.add(new Person("Emma Schmidt", 32));
        personenListe.add(new Person("Thomas Müller", 45));
        personenListe.add(new Person("Sophie Weber", 28));
        personenListe.add(new Person("Michael Fischer", 51));
        personenListe.add(new Person("Laura Wagner", 36));
        System.out.println(personenListe);

        List<Person> sortierteListe = personenListe.stream().sorted(Comparator.comparingInt(Person::getAge)).collect(Collectors.toList());

        System.out.println(sortierteListe);

    }
    }

