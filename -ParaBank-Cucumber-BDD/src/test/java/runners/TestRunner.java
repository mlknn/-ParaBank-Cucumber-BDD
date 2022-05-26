package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", //need to give a path for our feature file

        glue = "StepDefinitions" //we need to glue our step definitions -implementation

        ,dryRun =false
        ,tags = "@Smoke"
        ,plugin ={"pretty","html:target/cucumber-default-reports.html",
        "rerun:target/failed-test","json:target/cucumber.json",

"rerun:target/failed-test","json:target/cucumber.xlm"}




   )


public class TestRunner {
}
