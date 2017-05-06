package com.aktasci;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BooleanSupplier;
import java.util.function.Predicate;

public class FunctionalInterfaces {

    public static void main(String[] args) {

        BiConsumer<String, Integer> biConsumer = (s, i) -> System.out.println("String is  " + s + " Integer is " + i);
        biConsumer.accept("Hi", 5);

        BiFunction<String, Integer, String> biFunction = (s, i) -> s + " " + i;
        System.out.println("result is " + biFunction.apply("Hi", 5));

        BiPredicate<String, Integer> biPredicate = (s, i) -> s.length() == i;
        System.out.println("Does \"Hi\" has 2 chararacter? " + biPredicate.test("Hi", 2));

        Predicate<Integer> pred = n -> n % 5 == 0;
        System.out.println("can be divided by 5 :" + pred.test(20));

        List<Integer> numberList = TestObjectFactory.getNumberList();

        System.out.println("All numbers");
        numberList.forEach(n -> System.out.println("number =" + n));

        System.out.println("even numbers:");
        //print even numbers
        printNumbers(numberList, n -> n % 2 == 0);

        System.out.println("odd numbers:");
        //print odd numbers
        printNumbers(numberList, n -> n % 2 != 0);

        System.out.println("numbers can be divided by 3");
        //print numbers that can be divided by 3
        printNumbers(numberList, n -> n % 3 == 0);

    }

    private static void printNumbers(List<Integer> numberList, Predicate<Integer> predicate) {
        for (Integer number : numberList) {
            if (predicate.test(number)) {
                System.out.println("number = " + number);
            }
        }
    }

}
