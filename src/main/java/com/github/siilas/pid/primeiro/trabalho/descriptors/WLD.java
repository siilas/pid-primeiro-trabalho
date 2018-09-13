package com.github.siilas.pid.primeiro.trabalho.descriptors;

import java.awt.image.BufferedImage;

import org.springframework.stereotype.Component;

import com.github.siilas.pid.primeiro.trabalho.enums.Descriptor;

/**
 * Weber Local Descriptor 
 *
 */
@Component
public class WLD implements Descriptible {

    @Override
    public void getTextureDescriptor(BufferedImage image) {
        
    }

    @Override
    public Descriptor getType() {
        return Descriptor.WLD;
    }

}
