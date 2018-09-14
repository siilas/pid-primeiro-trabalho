package com.github.siilas.pid.primeiro.trabalho.runner;

import java.io.File;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.siilas.pid.primeiro.trabalho.descriptors.LBP;
import com.github.siilas.pid.primeiro.trabalho.exception.FilesNotFoundException;
import com.github.siilas.pid.primeiro.trabalho.files.FileReader;
import com.github.siilas.pid.primeiro.trabalho.files.FileSpliter;
import com.github.siilas.pid.primeiro.trabalho.model.Texture;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ControladorPid implements CommandLineRunner {

    @Autowired
    private LBP lbp;
    
    @Autowired
    private FileReader fileReader;

    @Autowired
    private FileSpliter fileSpliter;

    @Override
    public void run(String... args) {
        try {
            if (ArrayUtils.isNotEmpty(args) && "prod".equals(args[0])) {
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
        executarLBP(texturas);
        executarGLCM(texturas);
        executarWLD(texturas);
        log.info("Finalizando execução...");
    }

    private void executarLBP(List<Texture> texturas) {
        log.info("Iniciando LBP");
        for (Texture textura : texturas) {
            lbp.getTextureDescriptor(textura.getImage());
        }
        log.info("Finalizando LBP");
    }

    private void executarGLCM(List<Texture> texturas) {
        log.info("Iniciando GLCM");
        for (Texture textura : texturas) {

        }
        log.info("Finalizando GLCM");
    }

    private void executarWLD(List<Texture> texturas) {
        log.info("Iniciando WLD");
        for (Texture textura : texturas) {

        }
        log.info("Finalizando WLD");
    }

}
