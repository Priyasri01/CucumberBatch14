package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)//This @Runwith comes from junit , and asking them to runwith cucumber as class by just lable cucumber.class inside ().
@CucumberOptions( //inside the body will provide the feature file which we need to execute.


        features = "src/test/resources/features/",

        glue = "APISteps", // since we are doing Api automation  testing, and all the steps definition  are under APISteps . so we can just change only the glue part to "APISteps"

        dryRun =false,

        tags = "@apiupdate",

        monochrome = true,
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json","rerun:target/failed.txt"}

)

public class APIRunner {



}
