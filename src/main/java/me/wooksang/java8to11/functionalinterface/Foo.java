package me.wooksang.java8to11.functionalinterface;

import java.util.function.*;

public class Foo {
    public static void main(String[] args) {
        int someNumber = 10;

        RunSomething runSomething = (int number) -> {
            return someNumber + number + 10;
        };

        Function<Integer, Integer> plus10 = (i) -> i + 10;
        Function<Integer, Integer> multiply2 = (i) -> i*2;

        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);
        System.out.println(multiply2AndPlus10.apply(10));

        Function<Integer, Integer> plus10AndThenMultiply2 = plus10.andThen(multiply2);
        System.out.println(plus10AndThenMultiply2.apply(10));

        Consumer<Integer> consumer = (i) -> System.out.println(i);
        consumer.accept(10);

        Supplier<Integer> supplier = () -> 10;
        supplier.get();

        Predicate<String> predicate = (s) -> s.equals("wooksang");
        predicate.test("wooksang");
    }

    private void run() {
        int baseNumber = 10;

        class LocalClass {
            public void printBaseNumber() {
                int baseNumber = 11;
                System.out.println(baseNumber);
            }
        }

        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) {
                System.out.println(baseNumber);
            }
        };

        IntConsumer printInt = (i) -> System.out.println(i + baseNumber);
        printInt.accept(10);
    }
}
