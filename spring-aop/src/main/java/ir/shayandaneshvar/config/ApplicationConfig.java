package ir.shayandaneshvar.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.Scanner;

@Configuration
public class ApplicationConfig {

    @Bean
//    @Scope(value = "singleton")
    @Lazy
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Scanner getScanner() {
        return new Scanner(System.in);
    }
}
