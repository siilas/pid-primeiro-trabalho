package com.github.siilas.pid.primeiro.trabalho.results;

import java.awt.image.BufferedImage;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LBPResult implements DescriptorResult {

    private int[] histograma;
    private BufferedImage image;
    
}
