package me.wooksang.java8to11.defaultmethodandstaticmethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class App {
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("wooksang");
        name.add("today8934");
        name.add("toby");
        name.add("foo");

        name.forEach(s -> {
            System.out.println(s);
        });

        name.forEach(System.out::println);

        Spliterator<String> spliterator = name.spliterator();
        while (spliterator.tryAdvance(System.out::println));

        name.stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("T"))
                .count();

        name.removeIf(s -> s.startsWith("T"));

        name.sort(String::compareToIgnoreCase);
    }
}
