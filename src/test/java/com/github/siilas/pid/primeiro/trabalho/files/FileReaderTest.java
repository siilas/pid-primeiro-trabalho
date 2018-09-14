package com.github.siilas.pid.primeiro.trabalho.files;

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
public class FileReaderTest {
    
    @Autowired
    private FileReader fileReader;
    
    @Test
    public void deveBuscarTodosAsTexturas() {
        List<File> texturas = fileReader.readAllTextures();
        Assert.assertEquals(FileReader.TOTAL_OF_TEXTURES, texturas.size());
    }

}
