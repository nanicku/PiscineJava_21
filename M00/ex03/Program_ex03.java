package ex03;

import java.util.Scanner;

public class Program_ex03 {
    private static final int MAX_GRADE = 9;
    private static final int MAX_COUNT_GRADE = 5;
    private static final int MAX_COUNT_WEEK = 18;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countWeeks = 0;

        long bufMinGrades = 0;

        while (scanner.hasNext()) {
            String week = scanner.nextLine();
            countWeeks++;
            if (countWeeks <= MAX_COUNT_WEEK) {
                if (week.equals("Week " + countWeeks)) {
                    int minGrade = getMinGrade(scanner);
                    bufMinGrades = packGrade(minGrade, bufMinGrades, countWeeks);
                    if (week.equals("Week " + MAX_COUNT_WEEK)) {
                        countWeeks++;
                        break;
                    }
                } else if (week.equals("42")) {
                    break;
                } else {
                    System.err.println("IllegalArgument");
                    System.exit(-1);
                }
            }
        }

        for (int i = 1; i < countWeeks; i++) {
            System.out.print("Week ");
            System.out.print(i);
            System.out.print(" ");
            putGraph(unpackGrade(i, bufMinGrades));
        }
    }

    public static long packGrade(int minGrade, long bufMinGrades, int countWeeks) {
        long ret;

        long powTen = 1;

        for (int i = 1; i < countWeeks; i++) {
            powTen *= 10;
        }

        ret = bufMinGrades + (minGrade * powTen);
        return ret;
    }

    public static int unpackGrade(int index, long bufMinGrades) {
        int ret;

        for (int i = 1; i < index; i++) {
            bufMinGrades /= 10;
        }
        ret = (int) (bufMinGrades % 10);
        return ret;
    }

    public static void putGraph(int minGrade) {

        for (int i = 0; i < minGrade; i++) {
            System.out.print("=");
        }
        System.out.println(">");
    }


    public static int getMinGrade(Scanner scanner) {
        int min = MAX_GRADE;

        int num;

        int i;

        for (i = 0; i < 5; i++) {
            if (!scanner.hasNextInt()) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            num = scanner.nextInt();
            if (num > MAX_GRADE || num <= 0) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            if (num < min) {
                min = num;
            }
        }

        if (i != MAX_COUNT_GRADE || !"".equals(scanner.nextLine())) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        return min;
    }
}
