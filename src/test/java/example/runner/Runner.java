package example.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(

        features = {"src/test/java/example/features"}
        , glue = {"example/stepdefs"}

        )
public class Runner extends AbstractTestNGCucumberTests {

}
