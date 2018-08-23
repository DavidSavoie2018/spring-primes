package com.gimelle.primes.service;

import java.util.function.Predicate;
import java.util.stream.IntStream;

//TODO Some other Algos to check if a number is a prime that could be intected in a smart way
public class PrimesAlgosUtils {


    public Predicate<Integer> isAPrimeSq(){
        return number -> IntStream
                .rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(i -> number%i == 0);
    }
    public Predicate<Integer> isAPrimeOld() {

        return n -> {
            int temp;
            boolean isPrime = true;
            for (int i = 2; i <= n / 2; i++) {
                temp = n % i;
                if (temp == 0) {
                    isPrime = false;
                    break;
                }
            }
            return isPrime;
        };
    }
}
