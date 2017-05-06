package com.aktasci;

public interface DefaultMethodInterface {

    default void sayHello(String name) {
        System.out.println("Default Hello " + name);
    }

    static void sayGoodBye(String name) {
        System.out.println("static interface Goodbye " + name);
    }
}
