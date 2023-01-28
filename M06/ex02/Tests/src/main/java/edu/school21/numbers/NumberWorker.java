package edu.school21.numbers;

public class NumberWorker {
    public boolean isPrime(int number) {
        if (number <= 0 || number == 1) {
            throw new IllegalNumberException();
        }

        if (number == 2 || number == 3) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }

        int d = 3;

        while ((d * d <= number) && (number % d != 0)) {
            d += 2;
        }
        if (number % d == 0) {
            return false;
        }
        return true;
    }

    public int digitsSum(int number) {
        int result = 0;
        while (number > 0) {
            result += number % 10;
            number /= 10;
        }
        return result;
    }
}

class IllegalNumberException extends RuntimeException {
    public IllegalNumberException() {
        super("Error number");
    }
}