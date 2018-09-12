package com.github.siilas.pid.primeiro.trabalho.descriptors;

import java.awt.image.BufferedImage;

import com.github.siilas.pid.primeiro.trabalho.enums.Descriptor;
import com.github.siilas.pid.primeiro.trabalho.utils.ImageUtils;

/**
 *  Local Binary Patterns
 *
 */
public class LBP implements Descriptible {

    @Override
    public void getTextureDescriptor(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        for (int linha = 1; linha < height; linha++) {
            for (int coluna = 1; coluna < width; coluna++) {
                int cor = ImageUtils.getGray(image, linha, coluna);
                
            }
        }
    }

    @Override
    public Descriptor getType() {
        return Descriptor.LBP;
    }

}
