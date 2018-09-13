package com.github.siilas.pid.primeiro.trabalho.descriptors;

import java.awt.image.BufferedImage;

import com.github.siilas.pid.primeiro.trabalho.enums.Descriptor;
import com.github.siilas.pid.primeiro.trabalho.utils.ImageUtils;

/**
 *  Local Binary Patterns
 *
 */
public class LBP implements Descriptible {

	private static final int[][] PESOS = { 
			{ 1, 2, 4 }, 
			{ 128, 0, 8 },
			{ 64, 32, 16 }
	}; 
	
    @Override
    public void getTextureDescriptor(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        for (int linha = 1; linha < height; linha++) {
            for (int coluna = 1; coluna < width; coluna++) {
            	boolean[][] treeshold = new boolean[3][3];
                int cor = ImageUtils.getGray(image, linha, coluna);
                treeshold[0][0] = verificarPixelsAoRedor(image, cor, linha - 1, coluna - 1);
                treeshold[0][1] = verificarPixelsAoRedor(image, cor, linha - 1, coluna);
                treeshold[0][2] = verificarPixelsAoRedor(image, cor, linha - 1, coluna + 1);
                treeshold[1][0] = verificarPixelsAoRedor(image, cor, linha, coluna - 1);
                treeshold[1][2] = verificarPixelsAoRedor(image, cor, linha, coluna + 1);
                treeshold[2][0] = verificarPixelsAoRedor(image, cor, linha + 1, coluna - 1);
                treeshold[2][1] = verificarPixelsAoRedor(image, cor, linha + 1, coluna);
                treeshold[2][2] = verificarPixelsAoRedor(image, cor, linha + 1, coluna + 1);
                
                int lbpValue = 0;
                for (int i = 0; i < 3; i++) {
                	for (int j = 0; j < 3; j++) {
                		if (treeshold[i][j]) {
                			lbpValue = lbpValue + pesos[i][j];
                		}
                	}
                }
                
                //Verificar pixels ao redor 
                //Calcular valor do pixels com base nos pesos
            }
        }
    }

    @Override
    public Descriptor getType() {
        return Descriptor.LBP;
    }
    
    private boolean verificarPixelsAoRedor(BufferedImage image, int cor, int linha, int coluna) {
    	int corPixelAoRedor = ImageUtils.getGray(image, linha, coluna);
    	return corPixelAoRedor > cor;
    }

}
