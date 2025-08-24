package com.learning.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class DeclarativeProgramming {
    public static void main(String[] args) {
        example1();
        example2();

        // Lambdas
        runnableLambdaExample();
    }

    /** A simple summation example to show the simplicity of functional programming. */
    private static void example1() {
        // Imperative Programming - Traditional summation
        // imperativeSum is mutable and difficult to run it in multithreaded environment
        int imperativeSum = 0;
        for (int i=0; i<=100; i++) {
            imperativeSum += i;
        }
        System.out.println(imperativeSum);

        // Declarative Programming - Easy to read and the implementation is abstracted
        int functionalSum = IntStream.rangeClosed(0, 100)
                //.parallel() -> Adding parallel splits and runs the summation
                .sum();
        System.out.println(functionalSum);
    }

    /** Another example to illustrate the simplicity of using streams. */
    private static void example2() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 3, 3, 4, 5, 5, 5, 6, 7);

        // A simple code to get the distinct values
        List<Integer> distinctListValues = integerList.stream().distinct().toList();
        System.out.println(distinctListValues);
    }

    /** Difference between the traditional and lambda execution of Runnable */
    private static void runnableLambdaExample() {
        // Creating an anonymous class to implement runnable and pass it to thread.
        Runnable oldRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world from old runnable");
            }
        };
        new Thread(oldRunnable).start();

        // Creating a lambda while starting a thread
        new Thread(() -> System.out.println("Hello world using lambda")).start();
    }
}