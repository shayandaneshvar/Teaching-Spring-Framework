package com.shayandaneshvar.cucumberdemo.cucumber.config.integration;

import com.shayandaneshvar.cucumberdemo.CucumberDemoApplication;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberContextConfiguration
@SpringBootTest(classes = { CucumberDemoApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberOptions(features = "src/test/resources/features/integration", plugin = {"pretty"})
public class CucumberIntegrationTests {
}
