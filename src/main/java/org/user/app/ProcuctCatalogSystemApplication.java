package org.user.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The entry point for the Spring Boot application.
 * 
 * This class contains the main method that launches the application.
 */
@SpringBootApplication
public class ProcuctCatalogSystemApplication {

    /**
     * The main method that starts the Spring Boot application.
     * 
     * @param args Command line arguments passed to the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(ProcuctCatalogSystemApplication.class, args);
    }
}