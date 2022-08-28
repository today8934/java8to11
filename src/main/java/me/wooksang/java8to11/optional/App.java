package me.wooksang.java8to11.optional;

import me.wooksang.java8to11.stream.OnlineClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        Optional<OnlineClass> spring =
                springClasses.stream()
                        .filter(onlineClass -> onlineClass.getTitle().startsWith("spring"))
                        .findFirst();

        spring.isPresent();
        spring.ifPresent(onlineClass -> {
            System.out.println(onlineClass.getId());
        });

        OnlineClass onlineClass = spring.orElse(createNewClass());
        OnlineClass onlineClass1 = spring.orElseGet(() -> createNewClass());
        spring.orElseThrow(() -> new IllegalArgumentException());

        Optional<OnlineClass> onlineClass3 = spring.filter(oc -> oc.isClosed());
        Optional<Integer> integer = spring.map(oc -> oc.getId());
        Optional<Progress> progress = spring.flatMap(oc -> oc.getProgress());
    }

    private static OnlineClass createNewClass() {
        return new OnlineClass(10, "New Class", false);
    }
}
