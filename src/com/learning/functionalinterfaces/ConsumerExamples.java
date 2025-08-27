package com.learning.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerExamples {
    public static void main(String[] args) {
        // Consumer examples
        /*
         Consumer takes an argument and applies some side effect. It does not return anything.
         andThen() method takes consumers and chain them.
         */
        simpleConsumerExample();
        andThenConsumerExample();
        // Bi-consumer examples
        /*
         Bi-consumer takes two arguments and does not return anything.
         andThen() method takes bi-consumers and chain them.
         */
        simpleBiConsumerExample();
    }

    /** A simple consumer that takes in an object of any type and applies some operations. */
    private static void simpleConsumerExample() {
        Consumer<String> stringUpperConsumer = (str) -> System.out.println(str.toUpperCase());
        stringUpperConsumer.accept("hello");
    }

    /** Using andThen in consumers to print lower and upper with space in between. */
    private static void andThenConsumerExample() {
        List<String> list = Arrays.asList("abc", "dEf", "ghi");

        Consumer<String> lowerConsumer = (str) -> System.out.print(str.toLowerCase());
        Consumer<String> spaceConcat = (str) -> System.out.print(" ");
        Consumer<String> upperConsumer = (str) -> System.out.print(str.toUpperCase());
        Consumer<String> newLine = (str) -> System.out.println();

        list.forEach((element) -> lowerConsumer
                .andThen(spaceConcat)
                .andThen(upperConsumer)
                .andThen(newLine)
                .accept(element));
    }

    /** A simple bi-consumer chaining example. */
    private static void simpleBiConsumerExample() {
        BiConsumer<Integer, Integer> multiplyBiConsumer = (a, b) -> System.out.println("Multiplication: " + a * b);
        BiConsumer<Integer, Integer> divideBiConsumer = (a, b) -> System.out.println("Division: " + a / b);

        multiplyBiConsumer.andThen(divideBiConsumer).accept(50, 5);
    }
}
