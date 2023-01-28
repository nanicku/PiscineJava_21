package edu.school21.printer.app;

import edu.school21.printer.logic.ConvertPixelsToPoints;

import java.io.*;

public class Program {
    public static String path = "/resources/image.bmp";

    public static void main(String[] args) throws IOException {

        if (args.length != 2) {
            System.out.println("Wrong number of args");
            System.exit(-1);
        }
        char whitePoint = args[0].charAt(0);
        char blackPoint = args[1].charAt(0);

        int[][] arrayPoints = ConvertPixelsToPoints.seeBMPImage(path, blackPoint, whitePoint);

        for (int x = 0; x < arrayPoints.length; x++) {
            for (int y = 0; y < arrayPoints[x].length; y++) {
                System.out.print((char) arrayPoints[y][x]);
            }
            System.out.println();
        }
    }
}
