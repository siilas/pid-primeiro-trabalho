package com.github.siilas.pid.primeiro.trabalho.descriptors;

import java.awt.image.BufferedImage;

import org.springframework.stereotype.Component;

import com.github.siilas.pid.primeiro.trabalho.enums.Descriptor;

/**
 *  Gray Level Co-occurrence Matrix
 *
 */
@Component
public class GLCM implements Descriptible {

    @Override
    public void getTextureDescriptor(BufferedImage image) {
        
    }

    @Override
    public Descriptor getType() {
        return Descriptor.GLCM;
    }

}
