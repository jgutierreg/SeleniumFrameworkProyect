package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@testactual",
        features = "src/test/resources/Features",
        glue = "steps"
)

public class Runner {
    
}