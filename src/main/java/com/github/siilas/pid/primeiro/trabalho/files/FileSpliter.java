package com.github.siilas.pid.primeiro.trabalho.files;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;

import com.github.siilas.pid.primeiro.trabalho.model.Texture;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FileSpliter {
    
    public List<Texture> splitFiles(List<File> images) {
        List<Texture> splitedImages = new ArrayList<>();
        images.forEach(file -> {
            try {
                BufferedImage image = ImageIO.read(file);
                int width = image.getWidth();
                int height = image.getHeight();
                int halfWidth = width / 2;
                int halfHeight = height / 2;
                splitedImages.add(Texture.builder()
                        .id(file.getName() + "1")
                        .clazz(file.getName())
                        .image(image.getSubimage(0, 0, halfWidth, halfHeight))
                        .build());
                splitedImages.add(Texture.builder()
                        .id(file.getName() + "2")
                        .clazz(file.getName())
                        .image(image.getSubimage(halfWidth, 0, halfWidth, halfHeight))
                        .build());
                splitedImages.add(Texture.builder()
                        .id(file.getName() + "3")
                        .clazz(file.getName())
                        .image(image.getSubimage(0, halfHeight, halfWidth, halfHeight))
                        .build());
                splitedImages.add(Texture.builder()
                        .id(file.getName() + "4")
                        .clazz(file.getName())
                        .image(image.getSubimage(halfWidth, halfHeight, halfWidth, halfHeight))
                        .build());
            } catch (Exception e) {
                log.error("Erro ao dividir as texturas", e);
            }
        });
        return splitedImages;
    }

}
