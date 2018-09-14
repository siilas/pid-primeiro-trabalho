package com.github.siilas.pid.primeiro.trabalho.calculos;

import java.util.List;

import com.github.siilas.pid.primeiro.trabalho.results.PrecisionRecallResult;

/**
 * Precisão x Revocação
 *
 */
public class PrecisionRecall {

    /**
     * Número de acertos em relação ao total de ítens
     */
    private int retrievedInClass;

    /**
     * Total de ítens
     */
    private int totalInClass;

    /**
     * Total de tentativas
     */
    private int totalRetrieved;

    public PrecisionRecall(int totalInClass) {
        this.totalInClass = totalInClass;
    }

    public void correct() {
        retrievedInClass += 1;
        totalRetrieved += 1;
    }

    public void wrong() {
        totalRetrieved += 1;
    }

    public PrecisionRecallResult calcular() {
        return PrecisionRecallResult.builder()
                .precision(retrievedInClass / totalInClass)
                .recall(retrievedInClass / totalRetrieved)
                .build();
    }

    public void calcularMedia(List<PrecisionRecallResult> resultados) {
        // Olhar
        // - https://github.com/rap1ds/information-retrieval/blob/master/src/ir_course/PrecisionRecallCalculator.java
        // - https://introcs.cs.princeton.edu/java/32class/Histogram.java.html
    }

}
