package com.aktasci;

import java.util.List;

public class MethodReference {

    public static void main(String[] args) {
        MethodReference methodReference = new MethodReference();

        List<String> nameList = TestObjectFactory.getNameList();
        List<Integer> numberList = TestObjectFactory.getNumberList();

        //calling instance method
        nameList.forEach(methodReference::sayHello);
        numberList.forEach(methodReference::sayHello);

        //with lambda
        nameList.forEach(s -> System.out.println("lamda: Hello " + s));

        //with function
        GreetingService helloService = s -> System.out.println("function: Hello " + s);
        nameList.forEach(helloService::sayHello);
        helloService = s -> System.out.println("function 2 Hello:" + s);
        nameList.forEach(helloService::sayHello);

        //calling static method
        nameList.forEach(MethodReference::staticSayGoodBye);

        nameList.forEach(System.out::println);
    }

    public void sayHello(String name) {
        System.out.println("sayHello(String name): Hello " + name);
    }

    public void sayHello(int number) {
        System.out.println("sayHello(int number): Hello " + number);
    }

    public static void staticSayGoodBye(String name) {
        System.out.println("staticSayGoodBye(String name): Goodbye " + name);
    }
}
