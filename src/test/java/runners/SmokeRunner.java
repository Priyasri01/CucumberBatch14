package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)//This @Runwith comes from junit , and asking them to runwith cucumber as class by just lable cucumber.class inside ().
@CucumberOptions( //inside the body will provide the feature file which we need to execute.

       // to run the feature file , we provided a  path of its repository(directory)
        features = "src/test/resources/features/",/*note we are providing the features package path along with  "/" at the end ,
        so that we don't want  to hard code the path for each and every feature file.  it will automatically will execute all the files available under features directory. */

        glue = "steps",/*this cucumber option "glue" will provide the path of the steps definition package
        // which carry all steps definition data .it's basically  connects the step declaration and steps definition together.*/

        //note: when you put two cucumberOptions , make sure to put comma in between. features is one cucumberOptions and glue is another cucumberOption

        dryRun =false,  /*by default dryRun =true , once we add step declaration in feature file , we will come to runner class and will we set  dryRun =true.
         so that it will stop actual execution and scans all the steps Quick and provide us missing step definition in the console. copy the steps definition and create class for it.
        please not once we created class for the step definition , ensure that we changed back the dryRun = false , so that it will execute the code.  */

       tags = "@US15Priyasri", /*using "tags" to group the scenario for specific type of execution,
       note we are running two test cases by proving the same tag name in the feature file.*/

        monochrome = true, //to remove irrelavant information from console, you need to set monochrome to true
// to generate report  we need plugin of ruuner class, when we generate any report the report should be in target folder
     plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json","rerun:target/failed.txt"}//pretty keywords prints lthe steps in the console to increase readability
        // to excute our testyesye
        //note: this failed.txt file holds all the scenarios which are failed during execution.
)

public class SmokeRunner {

}
