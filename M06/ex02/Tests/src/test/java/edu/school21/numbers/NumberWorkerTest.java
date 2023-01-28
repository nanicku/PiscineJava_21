package edu.school21.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberWorkerTest {
    NumberWorker numberWorker;

    @BeforeEach
    void crateNumberWorker() {
        numberWorker = new NumberWorker();
    }

    @ParameterizedTest
    @ValueSource(ints = {401, 3, 23, 907, 175993})
    void isPrimeForPrimes(int argument) {
        Assertions.assertTrue(numberWorker.isPrime(argument));
    }

    @ParameterizedTest
    @ValueSource(ints = {6, 24, 990, 9, 176064})
    void isPrimeForNotPrimes(int argument) {
        Assertions.assertFalse(numberWorker.isPrime(argument));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, -3, -149, -176063})
    void isPrimeForIncorrectNumbers(int argument) {
        Assertions.assertThrows(IllegalNumberException.class, () -> numberWorker.isPrime(argument));
    }

    @ParameterizedTest
    @CsvFileSource(resources = {"/data.csv"}, delimiter = ',')
    void digitsSum(int number, int result) {
        Assertions.assertEquals(numberWorker.digitsSum(number), result);
    }
}
