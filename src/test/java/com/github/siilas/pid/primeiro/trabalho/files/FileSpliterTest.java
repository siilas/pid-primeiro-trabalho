package com.github.siilas.pid.primeiro.trabalho.files;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FileSpliterTest {
    
    @Autowired
    private FileReader fileReader;
    
    @Autowired
    private FileSpliter fileSpliter;
    
    @Test
    public void deveDividirTodasAsTexturas() {
        List<File> texturas = fileReader.readAllTextures();
        List<BufferedImage> texturasDivididas = fileSpliter.splitFiles(texturas);
        Assert.assertEquals((FileReader.TOTAL_OF_TEXTURES * 4), texturasDivididas.size());
    }

}
