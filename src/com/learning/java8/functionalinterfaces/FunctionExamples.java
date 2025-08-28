package com.learning.java8.functionalinterfaces;

import java.util.function.*;

public class FunctionExamples {
    public static void main(String[] args) {
        // Function example
        /*
         Function<T,R> takes one argument<T> and returns an object<S>.
         Functions can be chained together using compose() and andThen().
         compose() runs the function before another function.
         andThen() runs the function after another function.
         Function.identity(T) returns the input as it is. Useful in some cases like toMap() in streams.
         */
        simpleFunctionExample();

        // Bi-Function Example
        /*
         Same as function but takes two inputs and returns an object.
         BiFunction has only andThen.
         */
        biFunctionExample();

        // UnaryOperator Example
        /*
         Unary operator extends Function with the only difference as input and output are of same type.
         */
        unaryOperator();

        // BinaryOperator Example
        /*
         Binary operator extends BiFunction where both the inputs and output are of same type.
         BinaryOperator also has minBy() and maxBy() static methods which takes in a Comparator and return min and max of two numbers respectively.
         */
        simpleBinaryOperator();
    }

    /** Two functions - uppercase and string appender */
    private static void simpleFunctionExample() {
        Function<String, String> upperCaseFunction = (str) -> str.toUpperCase(); // Input and output are of same type. So they can be UnaryOperator.
        Function<String, String> stringAppender = (str) -> str + " world";

        System.out.println(stringAppender.andThen(upperCaseFunction).apply("hello"));

        // The below two produce the same results.
        System.out.println(stringAppender.compose(upperCaseFunction).apply("hello"));
        System.out.println(upperCaseFunction.andThen(stringAppender).apply("hello"));
    }

    /** Bi-function takes a number and a predicate and returns num + 10 if the predicate condition satisfies */
    private static void biFunctionExample() {
        BiFunction<Integer, Predicate<Integer>, Integer> biFunction =
                (number, predicate) -> predicate.test(number) ? Integer.valueOf(number + 10) : number;

        Predicate<Integer> betweenPredicate = (num) -> num > 0 && num <= 10;

        System.out.println(biFunction.apply(7, betweenPredicate));
    }

    /** The functions in the above simpleFunctionExample can be written as UnaryOperator */
    private static void unaryOperator() {
        UnaryOperator<String> upperCaseFunction = (str) -> str.toUpperCase();
        UnaryOperator<String> stringAppender = (str) -> str + " world";

        System.out.println(stringAppender.andThen(upperCaseFunction).apply("hello"));
    }

    private static void simpleBinaryOperator() {
        BinaryOperator<String> stringConcatOperator = (str1, str2) -> str1 + str2;

        System.out.println(stringConcatOperator.apply("hello ", "world"));
    }
}
