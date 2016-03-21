package nz.co.maveros.auto.ghost.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:target/report.html"},
		features = {"src/nz/co/maveros/auto/ghost/features"}
)

public class CucumberRunner {

}
