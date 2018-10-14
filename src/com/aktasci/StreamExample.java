package com.aktasci;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExample {

    public static void main(String[] args) {

        //forEach
        Random random = new Random();
        System.out.println("10 random numbers:");
        random.ints().limit(10).forEach(System.out::println);
        System.out.println("10 random numbers:");
        random.ints().limit(10).forEach((number) -> System.out.println("number = " + number));

        List<Integer> numberList = TestObjectFactory.getNumberList();

        //map
        System.out.println("numberList:");
        numberList.forEach(System.out::println);
        System.out.println("numberList mapped with their squares:");
        numberList.stream().map(number -> number * number).collect(Collectors.toList()).forEach(System.out::println);

        List<String> nameList = TestObjectFactory.getNameList();
        System.out.println("name list:");
        nameList.forEach(System.out::println);

        System.out.println("name list mapped with uppercase:");
        nameList.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);

        int factor = 2;
        System.out.println("numbers multiplied with a variable outside of lambda expression(it is not alllowed to "
                + "change the variable inside the lambda expression, tough)");
        numberList.stream().map(number -> number * factor).collect(Collectors.toList()).forEach(System.out::println);

        //flatMap
        List<List<String>> listOfParticipants = TestObjectFactory.getListOfParticipants();
        System.out.println("listOfParticipants = " + listOfParticipants);
        System.out.println("list of groups that has 3 participants");
        listOfParticipants.stream().filter(list -> list.size() == 3).collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("listOfParticipants with stream and flatMap");
        listOfParticipants.stream().flatMap(List::stream)
                .collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("List of participants with name that are three characters long");
        listOfParticipants.stream().flatMap(List::stream).filter(name -> name.length() == 3)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        //reduce
        Integer totalNumbers = numberList.stream().reduce((sum, number) -> sum + number).get();
        System.out.println("totalNumbers = " + totalNumbers);

        //filter
        System.out.println("list of names that are three characters long");
        nameList.stream().filter(name -> name.length() == 3).forEach(System.out::println);

        Predicate<String> predHasThreeChars = (name) -> name.length() == 3;
        Predicate<String> predStartsWithA = (name) -> name.startsWith("A");
        System.out.println("Names that are 3 characters long or start with character 'A' ");
        nameList.stream().filter(predHasThreeChars.or(predStartsWithA)).collect(Collectors.toList())
                .forEach(System.out::println);

        //limit
        System.out.println("first 2 names:");
        nameList.stream().limit(2).forEach(System.out::println);

        //sorted
        System.out.println("number list sorted as ascending(default): ");
        numberList.stream().sorted().collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("number list sorted as descending: ");
        numberList.stream()
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("name list sorted as ascending(default):");
        nameList.stream().sorted().collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("name list sorted as descending:");
        nameList.stream()
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList())
                .forEach(System.out::println);

        //collector
        Map<String, Integer> nameNumberMap = nameList.stream()
                .collect(Collectors.toMap(name -> name, String::length));
        System.out.println("nameNumberMap = " + nameNumberMap);

        String joined = nameList.stream().collect(Collectors.joining());
        System.out.println("joined = " + joined);

        String joinedWithDelimeter = nameList.stream().collect(Collectors.joining("#"));
        System.out.println("joinedWithDelimeter = " + joinedWithDelimeter);

        //statistics
        IntSummaryStatistics summaryStatistics = numberList.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("summaryStatistics = " + summaryStatistics);
    }
}
