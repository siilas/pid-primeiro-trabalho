package com.github.siilas.pid.primeiro.trabalho.model;

import java.awt.image.BufferedImage;
import java.util.List;

import com.github.siilas.pid.primeiro.trabalho.results.DescriptorResult;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
public class Texture {
    
    private String id;
    private String clazz;
    private BufferedImage image;
    private List<DescriptorResult> results;

}
