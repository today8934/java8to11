package me.wooksang.java8to11.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> wooksangEvents = new ArrayList<>();
        wooksangEvents.add(springClasses);
        wooksangEvents.add(javaClasses);

        List<String> startsWithSpring =
                springClasses.stream()
                        .filter(springClass -> springClass.getTitle().startsWith("spring"))
                        .map(springClass -> springClass.getTitle())
                        .collect(Collectors.toList());

        startsWithSpring.forEach(System.out::println);

        List<String> notClosedClass =
                springClasses.stream()
                        .filter(springClass -> !springClass.isClosed())
                        //.filter(Predicate.not(OnlineClass::isClosed))
                        .map(springClass -> springClass.getTitle())
                        .collect(Collectors.toList());

        notClosedClass.forEach(System.out::println);

        wooksangEvents.stream()
                .flatMap(Collection::stream)
                .forEach(onlineClass -> System.out.println(onlineClass.getId()));

        Stream.iterate(10, i -> i + 1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        boolean test = javaClasses.stream()
                .anyMatch(onlineClass -> onlineClass.getTitle().contains("Test"));
        System.out.println(test);
    }
}
