package org.example.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions
	(
		features = "src/main/resources/features",
		glue = { "org.example.stepDefinitions" },
//		publish = true,
		monochrome = true,
//		plugin = { "pretty",
//					"html:target/cucumber.html",
//					"json:target/cucumber.json",
//					"junit:target/cukes.xml",
//					"rerun:target/rerun.txt"},
		tags = "@group1",
		dryRun = true,
        plugin = {"pretty", "json:target/cucumber.json" }
        //plugin = {"pretty", "junit:target/JunitReport/report.xml" }
     )
public class runners extends AbstractTestNGCucumberTests {

}
