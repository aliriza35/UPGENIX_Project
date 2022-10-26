package cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "@target/rerun.txt",
            glue = "cydeo/step_definitions"
    )

    public class FailedTestRunner {

    }
