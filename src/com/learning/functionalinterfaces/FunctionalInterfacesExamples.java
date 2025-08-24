package com.learning.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FunctionalInterfacesExamples {
    public static void main(String[] args) {
        // Consumer examples
        simpleConsumerExample();
        andThenConsumerExample();
        // Bi-consumer examples
        simpleBiConsumerExample();

        // Predicate examples
        predicateExample();
        predicateIsEqualExample();
        // Bi-predicate example
        biPredicateExample();

        // Predicate + Consumer example
        predicateAndConsumerExample();
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

    /** Predicate to check if number is 'not between 2 and 10' */
    private static void predicateExample() {
        Predicate<Integer> greaterThanTwo = (number) -> number > 2;
        Predicate<Integer> lessThanTen = (number) -> number < 10;

        System.out.println(greaterThanTwo.and(lessThanTen).negate().test(17));
    }

    /** An example using Predicate.isEqual() */
    private static void predicateIsEqualExample() {
        Predicate<Integer> isEqualPredicate = Predicate.isEqual(3);
        // isEqual is a static method, which can be moved around and checked for equals whenever required.
        isEqualPredicate.test(3);
    }

    /** Print the result only if the number is between 2 and 10. */
    private static void predicateAndConsumerExample() {
        Predicate<Integer> greaterThanTwo = (number) -> number > 2;
        Predicate<Integer> lessThanTen = (number) -> number < 10;

        Consumer<Integer> printerConsumer = (element) -> {
            if (greaterThanTwo.and(lessThanTen).test(element)) {
                System.out.println(element + " is between 2 and 10.");
            }
        };

        printerConsumer.accept(7);
    }

    /** A bi-predicate example which checks if given two strings are equal. */
    private static void biPredicateExample() {
        BiPredicate<String, String> sameLengthPredicate = (s1, s2) -> s1.length() == s2.length();

        System.out.println(sameLengthPredicate.test("apple", "grape")); // true
        System.out.println(sameLengthPredicate.test("banana", "kiwi"));  // false
    }
}
