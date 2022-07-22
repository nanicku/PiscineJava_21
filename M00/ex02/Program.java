package ex02;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner myVar = new Scanner(System.in);

        int count = 0;

        while (myVar.hasNext()) {
            int number = myVar.nextInt();
            if (number == 42) {
                break;
            }
            int sum = getSum(number);
            if (isCheckNumber(sum)) {
                count++;
            }
        }
        System.out.println("Count of coffee - request - " + count);
    }

    public static int getSum(int number) {
        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static boolean isCheckNumber(int number) {
        if (number == 2 || number == 3) {
            return true;
        }

        if (number == 1) {
            return false;
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
}
