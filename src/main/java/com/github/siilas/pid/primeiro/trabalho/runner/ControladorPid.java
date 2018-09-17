package com.github.siilas.pid.primeiro.trabalho.runner;

import java.io.File;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.siilas.pid.primeiro.trabalho.enums.Environment;
import com.github.siilas.pid.primeiro.trabalho.exception.FilesNotFoundException;
import com.github.siilas.pid.primeiro.trabalho.files.FileReader;
import com.github.siilas.pid.primeiro.trabalho.files.FileSpliter;
import com.github.siilas.pid.primeiro.trabalho.model.Texture;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ControladorPid implements CommandLineRunner {

	@Autowired
	private FileReader fileReader;

	@Autowired
	private FileSpliter fileSpliter;
	
	@Autowired
	private ControladorLBP controladorLBP;
	
	@Autowired
	private ControladorGLCM controladorGLCM;
	
	@Autowired
	private ControladorWLD controladorWLD;

	@Override
	public void run(String... args) {
		try {
			if (ArrayUtils.isNotEmpty(args) && Environment.PROD.getValue().equals(args[0])) {
				String lineBreaker = System.getProperty("line.separator");
				log.info(lineBreaker + lineBreaker + lineBreaker);
				executarComandos();
				log.info(lineBreaker + lineBreaker + lineBreaker);
				System.exit(0);
			}
		} catch (FilesNotFoundException e) {
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error("Erro durante a execução", e);
		}
	}

	private void executarComandos() {
		log.info("PPGCC/UNESP - Processamento de Imagens Digitais - 2018 - Primeiro Trabalho");
		log.info("Lendo texturas...");
		List<File> files = fileReader.readAllTextures();
		log.info("Total de arquivos encotrados: " + files.size());
		log.info("Dividindo texturas em 4 partes...");
		List<Texture> texturas = fileSpliter.splitFiles(files);
		log.info("Total de texturas divididas: " + texturas.size());
		double portagemLBP = controladorLBP.executar(texturas);
		double portagemGLCM = controladorGLCM.executar(texturas);
		double portagemWLD = controladorWLD.executar(texturas);
		if (portagemLBP > portagemGLCM && portagemLBP > portagemWLD) {
			log.info("LBP teve o melhor aproveitamento com " + portagemLBP + "% de acerto");
		} else if (portagemGLCM > portagemLBP && portagemGLCM > portagemWLD) {
			log.info("GLCM teve o melhor aproveitamento com " + portagemLBP + "% de acerto");
		} else if (portagemWLD > portagemLBP && portagemWLD > portagemGLCM) {
			log.info("WLD teve o melhor aproveitamento com " + portagemLBP + "% de acerto");
		}
		log.info("Finalizando execução...");
	}

}
