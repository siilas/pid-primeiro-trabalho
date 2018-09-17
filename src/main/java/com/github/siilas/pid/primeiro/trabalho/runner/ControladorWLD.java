package com.github.siilas.pid.primeiro.trabalho.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.siilas.pid.primeiro.trabalho.descriptors.WLD;
import com.github.siilas.pid.primeiro.trabalho.model.Texture;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ControladorWLD {

	@Autowired
	private WLD wld;
	
	public double executar(List<Texture> texturas) {
		log.info("Iniciando WLD");
		for (Texture textura : texturas) {

		}
		log.info("Finalizando WLD");
		return 0.0;
	}
	
}
