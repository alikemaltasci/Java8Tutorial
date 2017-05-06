package com.aktasci;

public class Lamda {

    public static void main(String[] args) {

        Lamda examples = new Lamda();

        //with type declaration
        ArithmeticOperation addition = (int a, int b) -> a + b;

        //without type declaration
        ArithmeticOperation subtraction = (a, b) -> a - b;

        //with return statement along with curly braces
        ArithmeticOperation multiplication = (a, b) -> {
            return a * b;
        };

        //without return statement and without curly braces
        ArithmeticOperation division = (a, b) -> a / b;

        System.out.println("add(1,2)=" + examples.operate(1, 2, addition));
        System.out.println("subtract(2,1)=" + examples.operate(2, 1, subtraction));
        System.out.println("multiply(3,2)=" + examples.operate(3, 2, multiplication));
        System.out.println("division(6,2)=" + examples.operate(6, 2, division));

        //with paranthesis
        GreetingService service1 = (name) -> System.out.println("1. Hello " + name);

        //without paranthesis
        GreetingService service2 = name -> System.out.println("2. Hello " + name);

        service1.sayHello("Ali");
        service2.sayHello("Ahmet");
    }

    private int operate(int operand1, int operand2, ArithmeticOperation operation) {
        return operation.operate(operand1, operand2);
    }


}


