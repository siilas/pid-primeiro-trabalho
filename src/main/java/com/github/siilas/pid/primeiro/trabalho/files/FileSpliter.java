package com.github.siilas.pid.primeiro.trabalho.files;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FileSpliter {
    
    public List<BufferedImage> splitFiles(List<File> images) {
        List<BufferedImage> splitedImages = new ArrayList<>();
        images.forEach(image -> {
            try {
                BufferedImage originalImage = ImageIO.read(image);
                int width = originalImage.getWidth();
                int height = originalImage.getHeight();
                int halfWidth = width / 2;
                int halfHeight = height / 2;
                splitedImages.add(originalImage.getSubimage(0, 0, halfWidth, halfHeight));
                splitedImages.add(originalImage.getSubimage(0, halfHeight, halfWidth, halfHeight));
                splitedImages.add(originalImage.getSubimage(halfWidth, 0, halfWidth, halfHeight));
                splitedImages.add(originalImage.getSubimage(halfWidth, halfHeight, halfWidth, halfHeight));
            } catch (Exception e) {
                log.error("Erro ao dividir as texturas", e);
            }
        });
        return splitedImages;
    }

}
