package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import utils.CommonMethods;

public class Hooks extends CommonMethods { //note we are creating this class so that we don't have to create steps
    // in feature file for all the scenario. and also we have more functions(generate report, take screenshot and so on) which we can add it here later part

    @Before//note when we take @Before make sure you are taking io.cucumber  not junit
    public void preCondition(){
        openBrowserAndLaunchApplication();
    }

    //here we use special class called scenario class from cucumber
    //this class holds the complete information of your execution
@After
public void postCondition(Scenario scenario){
    byte[] pic;
    if(scenario.isFailed()){
        //failed screenshot will be available inside failed folder
        pic =  takeScreenshot("failed/" + scenario.getName());
    }else {
        pic = takeScreenshot("passed/" + scenario.getName());
    }

    //to attach the screenshot in our report
    scenario.attach(pic, "image/png", scenario.getName());
    closeBrowser();
}
}
