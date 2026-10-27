package Com.TestRunner;

import static io.cucumber.junit.platform.engine.Constants.FILTER_TAGS_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("Features")
@ConfigurationParameter(
    key = GLUE_PROPERTY_NAME,
    value = "Com.Stepdefinitions,Com.Hooks"
    
)
@ConfigurationParameter(
    key = PLUGIN_PROPERTY_NAME,
    value = "pretty,html:target/CucumberReports.html,io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
   
)
@ConfigurationParameter(
	    key = FILTER_TAGS_PROPERTY_NAME,
	    value = "@login or @home1 or @home2 or @home3 or @home4"
	)
//@ConfigurationParameter(
//	    key = "PARALLEL_EXECUTION_ENABLED",
//	    value = "true"
//	    )

public class TestRunner {
	
	

}
