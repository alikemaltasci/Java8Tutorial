package com.aktasci;

public class DefaultMethodInterfaceImpl implements DefaultMethodInterface {
    public static void main(String[] args) {
        DefaultMethodInterface dmi = new DefaultMethodInterfaceImpl();
        dmi.sayHello("Ali");
        DefaultMethodInterface.sayGoodBye("Ali");
    }

    public void sayHello(String name) {
        DefaultMethodInterface.super.sayHello(name);
        System.out.println("Implementation Hello " + name);
    }
}
