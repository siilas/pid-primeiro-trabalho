package com.github.siilas.pid.primeiro.trabalho.descriptors;

import java.awt.image.BufferedImage;

import org.springframework.stereotype.Component;

import com.github.siilas.pid.primeiro.trabalho.enums.Descriptor;
import com.github.siilas.pid.primeiro.trabalho.results.GLCMResult;
import com.github.siilas.pid.primeiro.trabalho.utils.ImageUtils;

/**
 * Gray Level Co-occurrence Matrix
 *
 */
@Component
public class GLCM implements Descriptible {

	public GLCMResult getTextureDescriptor(BufferedImage image) {
		BufferedImage lbpimage = ImageUtils.copy(image);
		double[] histograma = new double[256];

		int[][] m0 = calcularMatriz(0, image);
		double[][] m0N = normalizeMatrix(add(m0, transposeMatrix(m0)));

		int[][] m45 = calcularMatriz(45, image);
		double[][] m45N = normalizeMatrix(add(m45, transposeMatrix(m45)));

		int[][] m90 = calcularMatriz(90, image);
		double[][] m90N = normalizeMatrix(add(m90, transposeMatrix(m90)));

		int[][] m135 = calcularMatriz(135, image);
		double[][] m135N = normalizeMatrix(add(m135, transposeMatrix(m135)));

		double contrast = (contrast(m0N) + contrast(m45N) + contrast(m90N) + contrast(m135N)) / 4;
		double homogenity = (homogenity(m0N) + homogenity(m45N) + homogenity(m90N) + homogenity(m135N)) / 4;
		double entropy = (entropy(m0N) + entropy(m45N) + entropy(m90N) + entropy(m135N)) / 4;
		double energy = (energy(m0N) + energy(m45N) + energy(m90N) + energy(m135N)) / 4;
		double dissimilarity = (dissimilarity(m0N) + dissimilarity(m45N) + dissimilarity(m90N) + dissimilarity(m135N))
				/ 4;
		
		return GLCMResult.builder()
				.contrast(contrast)
				.homogenity(homogenity)
				.entropy(entropy)
				.energy(energy)
				.dissimilarity(dissimilarity)
				.build();
	}

	@Override
	public Descriptor getType() {
		return Descriptor.GLCM;
	}

	private int[][] calcularMatriz(int grau, BufferedImage image) {
		int[][] temp = new int[256][256];
		int startRow = 0;
		int startColumn = 0;
		int endColumn = 0;
		int width = image.getWidth();
		int height = image.getHeight();

		switch (grau) {
		case 0:
			startRow = 0;
			startColumn = 0;
			endColumn = width - 2;
			break;
		case 45:
			startRow = 1;
			startColumn = 0;
			endColumn = width - 2;
			break;
		case 90:
			startRow = 1;
			startColumn = 0;
			endColumn = width - 1;
			break;
		case 135:
			startRow = 1;
			startColumn = 1;
			endColumn = width - 1;
			break;
		}

		for (int i = startRow; i < height; i++) {
			for (int j = startColumn; j <= endColumn; j++) {
				switch (grau) {
				case 0:
					temp[ImageUtils.getGray(image, i, j)][ImageUtils.getGray(image, i, j + 1)]++;
					break;
				case 45:
					temp[ImageUtils.getGray(image, i, j)][ImageUtils.getGray(image, i - 1, j + 1)]++;
					break;
				case 90:
					temp[ImageUtils.getGray(image, i, j)][ImageUtils.getGray(image, i - 1, j)]++;
					break;
				case 135:
					temp[ImageUtils.getGray(image, i, j)][ImageUtils.getGray(image, i - 1, j - 1)]++;
					break;
				}
			}
		}
		return temp;
	}

	private int[][] transposeMatrix(int[][] m) {
		int[][] temp = new int[m[0].length][m.length];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				temp[j][i] = m[i][j];
			}
		}
		return temp;
	}

	private int[][] add(int[][] m2, int[][] m1) {
		int[][] temp = new int[m1[0].length][m1.length];
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m1[0].length; j++) {
				temp[j][i] = m1[i][j] + m2[i][j];
			}
		}
		return temp;
	}

	private int getTotal(int[][] m) {
		int temp = 0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				temp += m[i][j];
			}
		}
		return temp;
	}

	private double[][] normalizeMatrix(int[][] m) {
		double[][] temp = new double[m[0].length][m.length];
		int total = getTotal(m);
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				temp[j][i] = (double) m[i][j] / total;
			}
		}
		return temp;
	}

	private double contrast(double[][] matrix) {
		double temp = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				temp += matrix[i][j] * Math.pow(i - j, 2);
			}
		}
		return temp;
	}

	private double homogenity(double[][] matrix) {
		double temp = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				temp += matrix[i][j] / (1 + Math.pow(i - j, 2));
			}
		}
		return temp;
	}

	private double entropy(double[][] matrix) {
		double temp = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] != 0) {
					temp += (matrix[i][j] * Math.log10(matrix[i][j])) * -1;
				}
			}
		}
		return temp;
	}

	private double energy(double[][] matrix) {
		double temp = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				temp += Math.pow(matrix[i][j], 2);
			}
		}
		return temp;
	}

	private double dissimilarity(double[][] matrix) {
		double temp = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				temp += matrix[i][j] * Math.abs(i - j);
			}
		}
		return temp;
	}

}
