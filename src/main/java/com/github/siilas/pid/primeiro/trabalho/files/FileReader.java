package com.github.siilas.pid.primeiro.trabalho.files;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.github.siilas.pid.primeiro.trabalho.exception.FilesNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FileReader {

    public static final int TOTAL_OF_TEXTURES = 112;
    
    public List<File> readAllTextures() {
        try {
            String path = getClass().getResource("/brodatz-textures/").getPath();
            return Files.walk(Paths.get(path))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Erro ao buscar texturas", e);
            throw new FilesNotFoundException(); 
        }
    }

}
