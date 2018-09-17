package com.github.siilas.pid.primeiro.trabalho.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.siilas.pid.primeiro.trabalho.descriptors.GLCM;
import com.github.siilas.pid.primeiro.trabalho.model.Texture;
import com.github.siilas.pid.primeiro.trabalho.results.GLCMResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ControladorGLCM {

	@Autowired
	private GLCM glcm;
	
	public double executar(List<Texture> texturas) {
		log.info("Iniciando GLCM");
		for (Texture textura : texturas) {
			GLCMResult result = glcm.getTextureDescriptor(textura.getImage());
		}
		log.info("Finalizando GLCM");
		return 0.0;
	}
	
}
