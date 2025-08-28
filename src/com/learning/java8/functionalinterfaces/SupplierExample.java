package com.learning.java8.functionalinterfaces;

import java.util.Optional;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {

        // Supplier Example
        /*
         Supplier takes no input but gives an object of given type.
         Below example returns random double every time.
         */
        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println(randomSupplier.get());  // Generates a random number

        // Use case in Optional orElseGet takes in a supplier
        Optional<String> optional = Optional.empty();
        System.out.println(optional.orElseGet(() -> "Empty string"));
    }
}
