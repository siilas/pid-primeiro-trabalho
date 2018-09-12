package com.github.siilas.pid.primeiro.trabalho.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ColorTest {

    @Test
    public void deveRetornarOValorCorretoDeCinza() {
        Color cor = new Color(Color.WHITE);
        Assert.assertEquals(255, cor.getGray());
    }
    
}
