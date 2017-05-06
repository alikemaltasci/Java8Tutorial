package com.aktasci;

import java.util.ArrayList;
import java.util.List;

public class TestObjectFactory {
    public static List<String> getNameList() {
        List<String> names = new ArrayList<>();
        names.add("Ali");
        names.add("Osman");
        names.add("Mehmet");
        names.add("Cem");
        names.add("Salih");
        return names;
    }

    public static List<Integer> getNumberList() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(5);
        numbers.add(3);
        numbers.add(9);
        numbers.add(1);
        return numbers;
    }
}