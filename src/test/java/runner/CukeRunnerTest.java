package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * 
 *
 */
@RunWith(Cucumber.class)


@CucumberOptions(
		 plugin = { "progress", "html:target/Cucumber", "json:target/cucumber-report.json",
					"html:target/cucumber-report.html", "junit:target/cucumber-report.xml" },
				 dryRun=false,
		features = "feature/studio", 
			glue = { "com.studio.stepdefinitions"} ,tags = "@Smoke")

public class CukeRunnerTest {

}
