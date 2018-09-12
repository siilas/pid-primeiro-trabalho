package com.github.siilas.pid.primeiro.trabalho.utils;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.siilas.pid.primeiro.trabalho.model.Color;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ImageUtilsTest {

    @Test
    public void deveBuscarValorCorretamente() {
        BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphic = image.createGraphics();
        graphic.setBackground(Color.WHITE);
        graphic.clearRect(0, 0, 1, 1);

        Color color = ImageUtils.getRBG(image, 0, 0);
        Assert.assertEquals(255, color.getAlpha());
        Assert.assertEquals(255, color.getRed());
        Assert.assertEquals(255, color.getBlue());
        Assert.assertEquals(255, color.getBlue());
    }

    @Test
    public void deveSetarValorCorretamente() {
        BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphic = image.createGraphics();
        graphic.setBackground(Color.RED);
        graphic.clearRect(0, 0, 1, 1);
        
        ImageUtils.setRBG(image, 0, 0, new Color(Color.WHITE));
        
        Color color = ImageUtils.getRBG(image, 0, 0);
        Assert.assertEquals(255, color.getAlpha());
        Assert.assertEquals(255, color.getRed());
        Assert.assertEquals(255, color.getBlue());
        Assert.assertEquals(255, color.getBlue());
    }

}
