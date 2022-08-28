package me.wooksang.java8to11.defaultmethodandstaticmethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("wooksang");
        names.add("today8934");
        names.add("toby");
        names.add("foo");

        names.forEach(s -> {
            System.out.println(s);
        });

        names.forEach(System.out::println);

        Spliterator<String> spliterator = names.spliterator();
        while (spliterator.tryAdvance(System.out::println));

        names.stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("T"))
                .count();

        names.removeIf(s -> s.startsWith("T"));

        names.sort(String::compareToIgnoreCase);

        Stream<String> stringStream = names.stream().map(String::toUpperCase);

        names.stream().map(s -> {
            System.out.println(s);
            return s.toUpperCase();
        });

        List<String> collect = names.parallelStream().map(String::toUpperCase).collect(Collectors.toList());

    }
}
