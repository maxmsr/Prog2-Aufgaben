package FunktionaleProgramnmierung;

import java.util.ArrayList;
import java.util.List;

public class Funktional1 {

        public static void main(String[] args) {
            List<Integer> zahlen = new ArrayList<>();
            zahlen.add(1);zahlen.add(2);zahlen.add(3);zahlen.add(4);zahlen.add(5);zahlen.add(7);zahlen.add(23);

            zahlen.forEach(System.out::println);
            zahlen.replaceAll(s -> s*s);
            zahlen.sort((s1,s2)-> s1.compareTo(s2));
            zahlen.forEach(System.out::println);
            zahlen.removeIf(s -> s>7);
            zahlen.forEach(System.out::println);
        }
}
