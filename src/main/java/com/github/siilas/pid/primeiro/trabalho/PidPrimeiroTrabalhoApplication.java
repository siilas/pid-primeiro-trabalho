package com.github.siilas.pid.primeiro.trabalho;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PidPrimeiroTrabalhoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PidPrimeiroTrabalhoApplication.class, args);
        SpringApplication app = new SpringApplication(PidPrimeiroTrabalhoApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        
    }
    
}
