package com.learning.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FunctionalInterfacesExamples {
    public static void main(String[] args) {
               // Predicate examples
        /*
         Predicate takes an argument and returns boolean. Can be chained using operators like 'and', 'or', 'negate'.
         Static isEqual() and not() methods takes in an object and can be passed around to check for equal when required.
         */
        predicateExample();
        predicateIsEqualExample();
        // Bi-predicate example
        /*
        Bi-predicate is similar to predicate but takes in two arguments.
         */
        biPredicateExample();

        // Predicate + Consumer example
        predicateAndConsumerExample();

        // Function example
        simpleFunctionExample();
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

    private static void simpleFunctionExample() {

    }
}
