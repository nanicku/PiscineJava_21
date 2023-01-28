package ex01;

import java.util.Scanner;

public class Program_ex01 {
    public static void main(String[] args) {
        Scanner myVar = new Scanner(System.in);

        int number = myVar.nextInt();

        if (number <= 0 || number == 1) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }

        int count = 0;

        if (number == 2 || number == 3) {
            count++;
            System.out.println("true " + count);
            System.exit(0);
        }

        if (number % 2 == 0) {
            count++;
            System.out.println("false " + count);
            System.exit(0);
        }

        int d = 3;

        while ((d * d <= number) && (number % d != 0)) {
            count++;
            d += 2;
        }

        if (number % d == 0) {
            count++;
            System.out.println("false " + count);
            System.exit(0);
        }
        count++;
        System.out.println("true " + count);
    }
}
