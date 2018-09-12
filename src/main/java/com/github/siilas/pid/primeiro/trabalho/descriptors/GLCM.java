package com.github.siilas.pid.primeiro.trabalho.descriptors;

import java.awt.image.BufferedImage;

import com.github.siilas.pid.primeiro.trabalho.enums.Descriptor;

/**
 *  Gray Level Co-occurrence Matrix
 *
 */
public class GLCM implements Descriptible {

    @Override
    public void getTextureDescriptor(BufferedImage image) {
        
    }

    @Override
    public Descriptor getType() {
        return Descriptor.GLCM;
    }

}
