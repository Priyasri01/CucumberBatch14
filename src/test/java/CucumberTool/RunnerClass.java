package CucumberTool;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features = "C:\\Users\\priya\\IdeaProjects\\CucumberBatch14\\src\\test\\java\\CucumberTool\\Login.feature"
        features = "src\\test\\java\\CucumberTool\\Login.feature" //this will also work  and the same path after scr will work everybody in the team.
)



public class RunnerClass {


}
