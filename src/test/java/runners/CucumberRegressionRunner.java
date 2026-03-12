package runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

    @Suite
    @SelectPackages("features")
    @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps")
    @ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-report.html")
    @ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@regression")
    public class CucumberRegressionRunner {
    }

