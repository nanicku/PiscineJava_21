package edu.school21.printer.app;

import edu.school21.printer.logic.ConvertPixelsToPoints;

import java.io.*;

public class Program {
    public static void main(String[] args) throws IOException {

        if (args.length != 3) {
            System.out.println("Wrong number of args");
            System.exit(-1);
        }
        char whitePoint = args[0].charAt(0);
        char blackPoint = args[1].charAt(0);

        String path = args[2];

        int[][] ar2d = ConvertPixelsToPoints.seeBMPImage(path, blackPoint, whitePoint);

        for (int x = 0; x < ar2d.length; x++) {
            for (int y = 0; y < ar2d[x].length; y++) {
                System.out.print((char) ar2d[y][x]);
            }
            System.out.println();
        }
    }
}
