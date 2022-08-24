package me.wooksang.java8to11.functionalinterface;

@FunctionalInterface
public interface RunSomething {
    int doIt(int number);

    static void printName() {
        System.out.println("욱상");
    }

    default void printAge() {
        System.out.println("20");
    }
}
