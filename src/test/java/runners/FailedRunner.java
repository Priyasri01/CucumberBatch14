package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // note we can run the faied test case through the runner class itself , no need to run on pom.xml
        //this runner class responsible only for the failed test case
        //features we use to provide the path of all the feature files
        features = "@target/failed.txt", // we have execut only failed  test case here , i am refer the tratget/failed.txt where all my failed test cases are listed
        glue = "steps",

        monochrome = true, // this is just optional , if we need it we can have otherwise no

        plugin = {"pretty"} // we are giving second chance  to run the test case so we don't need report & file. because we just re running the scenario
)

public class FailedRunner {


}
