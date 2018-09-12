package com.github.siilas.pid.primeiro.trabalho.descriptors;

import java.awt.image.BufferedImage;

import com.github.siilas.pid.primeiro.trabalho.enums.Descriptor;
import com.github.siilas.pid.primeiro.trabalho.model.Color;
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
                Color cor = ImageUtils.getRBG(image, linha, coluna);
                
            }
        }
        // Comparar pixel com todos pixels em volta dele e montar 
    }

    @Override
    public Descriptor getType() {
        return Descriptor.LBP;
    }

}
