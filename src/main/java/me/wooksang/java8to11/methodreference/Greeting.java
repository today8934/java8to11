package me.wooksang.java8to11.methodreference;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Greeting {
    private String name;

    public Greeting() {}

    public Greeting(String name) {
        this.name = name;
    }

    public String hello(String name) {
        return "hello " + name;
    }

    public static String hi(String name) {
        return "hi " + name;
    }

    public static void main(String[] args) {
        UnaryOperator<String> hi = Greeting::hi;
        String hiWooksang = hi("Wooksang");

        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        String helloWookang = hello.apply("Wooksang");

        Supplier<Greeting> supplier = Greeting::new;
        Greeting greetingInstance = supplier.get();

        Function<String, Greeting> function = Greeting::new;
        Greeting greetingInstance2 = function.apply("Wooksang");

        String[] names = {"Wooksang", "today8934", "RyuWooksang"};
        Arrays.sort(names, String::compareToIgnoreCase);
    }
}
