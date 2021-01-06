package com.mapsa.datajpademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author S.Shayan Daneshvar
 * Topics Covered:
 * 1.Spring Data JPA
 * 2.Exception Handling ( todo: ControllerAdvice & RestControllerAdvice )
 * 3.DTOs, Converters And MapStruct
 * 4. CommandLineRunner & Application Runner
 */
@SpringBootApplication
public class DataJpaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataJpaDemoApplication.class, args);
    }

}
