package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class ConvertPixelsToPoints {

    public static int[][] seeBMPImage(String BMPFileName, char blackPoint, char whitePoint) throws IOException {
        BufferedImage image = ImageIO.read(new FileInputStream(BMPFileName));

        int array2D[][] = new int[image.getWidth()][image.getHeight()];
        for (int xPixel = 0; xPixel < image.getWidth(); xPixel++) {
            for (int yPixel = 0; yPixel < image.getHeight(); yPixel++) {
                int color = image.getRGB(xPixel, yPixel);
                if (color == Color.BLACK.getRGB()) {
                    array2D[xPixel][yPixel] = blackPoint;
                } else if (color == Color.WHITE.getRGB()) {
                    array2D[xPixel][yPixel] = whitePoint;
                }
            }
        }
        return array2D;
    }
}
