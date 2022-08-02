package ir.shayandaneshvar.cucumberjunit5demo.cucumber;

import io.cucumber.junit.platform.engine.Cucumber;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.context.SpringBootTest;

import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.core.options.Constants.PLUGIN_PUBLISH_QUIET_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;


@Suite
@IncludeEngines("cucumber")
@CucumberContextConfiguration
@SelectClasspathResource("ir/shayandaneshvar/cucumberjunit5demo/feature")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "ir.shayandaneshvar.cucumberjunit5demo.cucumber")
public class CucumberIntegrationTest {
}
