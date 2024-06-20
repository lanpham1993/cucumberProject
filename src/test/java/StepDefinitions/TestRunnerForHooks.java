package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/HookDemo/HookDemo.feature", glue= {"StepForHooks"},
monochrome = true,
plugin= {"pretty","html:target/HtmlReports/HtmlReports"}

)
public class TestRunnerForHooks {

}
