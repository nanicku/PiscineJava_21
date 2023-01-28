package edu.school21.printer.logic;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ConvertPixelsToPoints {

    public static int[][] seeBMPImage(String path, char blackPoint, char whitePoint) throws IOException {
        BufferedImage image = ImageIO.read(ConvertPixelsToPoints.class.getResource(path));

        int arrayPoints[][] = new int[image.getWidth()][image.getHeight()];
        for (int xPixel = 0; xPixel < image.getWidth(); xPixel++) {
            for (int yPixel = 0; yPixel < image.getHeight(); yPixel++) {
                int color = image.getRGB(xPixel, yPixel);
                if (color == Color.BLACK.getRGB()) {
                    arrayPoints[xPixel][yPixel] = blackPoint;
                } else if (color == Color.WHITE.getRGB()) {
                    arrayPoints[xPixel][yPixel] = whitePoint;
                }
            }
        }
        return arrayPoints;
    }
}
