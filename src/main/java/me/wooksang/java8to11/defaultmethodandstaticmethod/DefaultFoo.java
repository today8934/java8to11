package me.wooksang.java8to11.defaultmethodandstaticmethod;

public class DefaultFoo implements Foo {

    private String name;

    @Override
    public void printName() {
        System.out.println("DefaultFoo");
    }

    @Override
    public String getName() {
        return this.name;
    }
}
