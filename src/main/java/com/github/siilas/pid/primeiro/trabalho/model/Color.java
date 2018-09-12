package com.github.siilas.pid.primeiro.trabalho.model;

public class Color extends java.awt.Color {

    private static final long serialVersionUID = -2599490781002544571L;

    public Color(int rgb) {
        super(rgb);
    }
    
    public Color(java.awt.Color color) {
        super(color.getRed(), color.getGreen(), color.getBlue());
    }
    
    public Color(int red, int green, int blue) {
        super(red, green, blue);
    }

    public int getGray() {
        return (getRed() + getGreen() + getBlue()) / 3;
    }
    
}
