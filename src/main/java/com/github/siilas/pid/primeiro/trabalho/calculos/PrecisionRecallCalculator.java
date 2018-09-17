package com.github.siilas.pid.primeiro.trabalho.calculos;

import com.github.siilas.pid.primeiro.trabalho.results.PrecisionRecall;

public class PrecisionRecallCalculator {

    public PrecisionRecall calcular(int acertos, int erros, int total) {
        return PrecisionRecall.builder()
                .precision(acertos / acertos + erros)
                .recall(acertos / total)
                .build();
    }

}
