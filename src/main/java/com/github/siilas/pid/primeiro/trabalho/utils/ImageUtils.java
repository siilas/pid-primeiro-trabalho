package com.github.siilas.pid.primeiro.trabalho.utils;

import java.awt.image.BufferedImage;

import com.github.siilas.pid.primeiro.trabalho.model.Color;

public final class ImageUtils {
    
    private ImageUtils() {
    }
    
    public static Color getRBG(BufferedImage image, int width, int height) {
        int rgb = image.getRGB(width, height);
        return new Color(rgb);
    }
    
    public static void setRBG(BufferedImage image, int width, int height, Color color) {
        image.setRGB(width, height, color.getRGB());
    }
    
    public static int getGray(BufferedImage image, int width, int height) {
        return getRBG(image, width, height).getGray();
    }
    
    public static Color getFromGray(int gray) {
        return new Color(gray, gray, gray);
    }

}
