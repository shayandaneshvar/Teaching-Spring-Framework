package com.shayandaneshvar.cucumberdemo.cucumber.config.unit;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/unit", plugin = {"pretty"})
public class CucumberUnitTests {
}
