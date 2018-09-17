package com.github.siilas.pid.primeiro.trabalho.runner;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.ml.distance.EuclideanDistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.siilas.pid.primeiro.trabalho.calculos.AreaUnderCurve;
import com.github.siilas.pid.primeiro.trabalho.calculos.PrecisionRecallCalculator;
import com.github.siilas.pid.primeiro.trabalho.descriptors.LBP;
import com.github.siilas.pid.primeiro.trabalho.model.Texture;
import com.github.siilas.pid.primeiro.trabalho.results.LBPResult;
import com.github.siilas.pid.primeiro.trabalho.results.PrecisionRecall;
import com.github.siilas.pid.primeiro.trabalho.utils.MathUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ControladorLBP {

	@Autowired
	private LBP lbp;
	
	public double executar(List<Texture> texturas) {
		log.info("Iniciando LBP");
		List<LBPResult> resultados = new ArrayList<>();
		for (Texture textura : texturas) {
			LBPResult lbp = this.lbp.getTextureDescriptor(textura.getImage());
			lbp.setId(textura.getId());
			lbp.setClazz(textura.getClazz());
			resultados.add(lbp);
		}
		log.info("Iniciando comparações");
		AreaUnderCurve auc = new AreaUnderCurve();
		EuclideanDistance euclideanDistance = new EuclideanDistance();
		PrecisionRecallCalculator precisionRecallCalculator = new PrecisionRecallCalculator();
		int corretos = 0;
		int errados = 0;
		for (LBPResult resultado : resultados) {
			double menorDistancia = Double.MAX_VALUE;
			LBPResult menorResultado = null;
			log.info("Imagem: " + resultado.getId() + " - Classe: " + resultado.getClazz());
			for (LBPResult other : resultados) {
				if (!resultado.equals(other)) {
					double distancia = euclideanDistance.compute(resultado.getHistograma(), other.getHistograma());
					if (distancia < menorDistancia) {
						menorDistancia = distancia;
						menorResultado = other;
					}
				}
			}
			log.info("Mais próxima: " + menorResultado.getId() + " - Classe: " + menorResultado.getClazz());
			log.info("Está correto: " + (resultado.getClazz().equals(menorResultado.getClazz()) ? "Sim" : "Não"));
			if (resultado.getClazz().equals(menorResultado.getClazz())) {
				corretos++;
			} else {
				errados++;
			}
		}
		PrecisionRecall precisionRecall = precisionRecallCalculator.calcular(corretos, errados, resultados.size());
		double aucValue = auc.calcular();
		log.info("Precision: " + precisionRecall.getPrecision());
		log.info("Recall: " + precisionRecall.getRecall());
		log.info("AUC: " + aucValue);
		log.info("Acertos: " + corretos);
		log.info("Erros: " + errados);
		log.info("Finalizando LBP");
		return MathUtils.calculatePercetage(corretos, (corretos + errados));
	}
	
}
