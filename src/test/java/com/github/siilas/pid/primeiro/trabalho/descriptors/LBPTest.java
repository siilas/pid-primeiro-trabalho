package com.github.siilas.pid.primeiro.trabalho.descriptors;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.siilas.pid.primeiro.trabalho.model.Color;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LBPTest {
    
    @Autowired
    private LBP lbp;
    
    @Test
    public void deveValidarPixelAoRedor() {
        BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphic = image.createGraphics();
        graphic.setBackground(Color.RED);
        graphic.clearRect(0, 0, 1, 1);
        
        boolean result = lbp.verificarPixel(image, new Color(Color.WHITE).getGray(), 0, 0);
        Assert.assertFalse(result);
    }
    
    @Test
    public void deveValidarPixelsAoRedor() {
        BufferedImage image = new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphic = image.createGraphics();
        graphic.setBackground(Color.WHITE);
        graphic.drawImage(image, 0, 0, 1, 3, Color.WHITE, null);
        graphic.drawImage(image, 0, 0, 2, 3, Color.MAGENTA, null);
        graphic.drawImage(image, 0, 0, 3, 3, Color.DARK_GRAY, null);
        
        boolean[][] treeshold = lbp.verificarPixelsAoRedor(image, new Color(Color.RED).getGray(), 1, 1);
        Assert.assertEquals(true, treeshold[0][0]);
        Assert.assertEquals(true, treeshold[0][1]);
        Assert.assertEquals(false, treeshold[0][2]);
        Assert.assertEquals(true, treeshold[1][0]);
        Assert.assertEquals(false, treeshold[1][1]);
        Assert.assertEquals(false, treeshold[1][2]);
        Assert.assertEquals(true, treeshold[2][0]);
        Assert.assertEquals(true, treeshold[2][1]);
        Assert.assertEquals(false, treeshold[2][2]);
    }
    
    @Test
    public void deveValidarOCalculaDoValorLBP() {
        boolean[][] treeshold = new boolean[3][3];
        treeshold[0][0] = true;
        treeshold[0][1] = false;
        treeshold[0][2] = false;
        treeshold[1][0] = true;
        treeshold[1][1] = false;
        treeshold[1][2] = false;
        treeshold[2][0] = true;
        treeshold[2][1] = true;
        treeshold[2][2] = true;
        
        int result = lbp.getLBPValue(treeshold);
        Assert.assertEquals(241, result);
    }

}
