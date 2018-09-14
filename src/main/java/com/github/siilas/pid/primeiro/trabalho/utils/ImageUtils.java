package com.github.siilas.pid.primeiro.trabalho.utils;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;

import com.github.siilas.pid.primeiro.trabalho.model.Color;

public final class ImageUtils {
    
    private ImageUtils() {
    }
    
    public static Color getRBG(BufferedImage image, int width, int height) {
        int rgb = image.getRGB(height, width);
        return new Color(rgb);
    }
    
    public static void setRBG(BufferedImage image, int width, int height, Color color) {
        image.setRGB(height, width, color.getRGB());
    }
    
    public static void setRBG(BufferedImage image, int width, int height, int gray) {
        setRBG(image, width, height, getFromGray(gray));
    }
    
    public static int getGray(BufferedImage image, int width, int height) {
        return getRBG(image, width, height).getGray();
    }
    
    public static Color getFromGray(int gray) {
        return new Color(gray, gray, gray);
    }
    
    public static BufferedImage copy(BufferedImage image) {
        ColorModel colorModel = image.getColorModel();
        boolean isAlphaPremultiplied = colorModel.isAlphaPremultiplied();
        WritableRaster raster = image.copyData(image.getRaster().createCompatibleWritableRaster());
        return new BufferedImage(colorModel, raster, isAlphaPremultiplied, null);
    }

}
