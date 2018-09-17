package com.github.siilas.pid.primeiro.trabalho.results;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PrecisionRecall {

    private double recall;
    private double precision;
    
}
