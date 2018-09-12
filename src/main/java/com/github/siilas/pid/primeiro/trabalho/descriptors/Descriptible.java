package com.github.siilas.pid.primeiro.trabalho.descriptors;

import java.awt.image.BufferedImage;

import com.github.siilas.pid.primeiro.trabalho.enums.Descriptor;

public interface Descriptible {

    void getTextureDescriptor(BufferedImage image);
    
    Descriptor getType();
    
}
