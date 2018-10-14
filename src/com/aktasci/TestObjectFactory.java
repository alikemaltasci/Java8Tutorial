package com.aktasci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TestObjectFactory {

    static List<String> getNameList() {
        List<String> names = new ArrayList<>();
        names.add("Ali");
        names.add("Osman");
        names.add("Mehmet");
        names.add("Cem");
        names.add("Salih");
        names.add("Ahmet");
        return names;
    }

    static List<Integer> getNumberList() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(5);
        numbers.add(3);
        numbers.add(9);
        numbers.add(1);
        return numbers;
    }

    static List<List<String>> getListOfParticipants() {
        List<List<String>> listOfParticipants = new ArrayList<>();
        listOfParticipants.add(Arrays.asList("Ali", "Osman"));
        listOfParticipants.add(Arrays.asList("Kerem", "Omer", "Hamza"));
        listOfParticipants.add(Arrays.asList("Ramiz", "Salih", "Huseyin"));
        return listOfParticipants;
    }
}