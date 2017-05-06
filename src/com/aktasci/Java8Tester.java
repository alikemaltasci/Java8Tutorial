package com.aktasci;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Java8Tester {

    public static void main(String[] args) {
        List<String> names = TestObjectFactory.getNameList();

        Java8Tester java8Tester = new Java8Tester();

        java8Tester.sortWithJava7(names);
        System.out.println("names = " + names);
        java8Tester.sortwithJava8(names);
        System.out.println("names = " + names);
    }

    private void sortwithJava8(List<String> names) {
        Collections.sort(names, (o1, o2) -> o1.compareTo(o2));
    }

    private void sortWithJava7(List<String> names) {
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }
}
