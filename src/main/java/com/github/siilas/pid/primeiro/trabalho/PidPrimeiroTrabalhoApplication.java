package com.github.siilas.pid.primeiro.trabalho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.siilas.pid.primeiro.trabalho.enums.Environment;

@SpringBootApplication
public class PidPrimeiroTrabalhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PidPrimeiroTrabalhoApplication.class, new String[] { Environment.PROD.getValue() });
	}

}
