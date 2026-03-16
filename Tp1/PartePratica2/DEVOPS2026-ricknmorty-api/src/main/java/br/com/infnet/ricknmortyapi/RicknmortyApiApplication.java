package br.com.infnet.ricknmortyapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** Main Spring Boot application class. */
@SpringBootApplication
public final class RicknmortyApiApplication {

    private RicknmortyApiApplication() {
        // Utility class
    }

    /**
     * Application entry point.
     *
     * @param args startup arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(RicknmortyApiApplication.class, args);
    }
}
