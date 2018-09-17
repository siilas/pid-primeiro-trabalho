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
public class GLCMResult {

	private String id;
	private String clazz;
    private double[] histograma;
    private BufferedImage image;	
    double contrast;
	double homogenity;
	double entropy;
	double energy;
	double dissimilarity;
	
}
