package com.github.siilas.pid.primeiro.trabalho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PidPrimeiroTrabalhoApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(PidPrimeiroTrabalhoApplication.class, new String[] { "prod" });
    }
    
}
