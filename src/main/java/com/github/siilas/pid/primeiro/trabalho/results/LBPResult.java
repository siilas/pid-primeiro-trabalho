package com.github.siilas.pid.primeiro.trabalho.results;

import java.awt.image.BufferedImage;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
public class LBPResult {

	private String id;
	private String clazz;
    private double[] histograma;
    private BufferedImage image;
    
}
