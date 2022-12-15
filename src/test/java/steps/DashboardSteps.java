package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

import java.util.ArrayList;
import java.util.List;

public class DashboardSteps extends CommonMethods {

    /* note in Dashboard feature file  we have 5 steps from navigate hrms  to verify dashboard.
     but we have given definition  for only one tag(verify the dashboard page) in here because the speciality of cucumber(code re-usability) in case if you want use the same steps declaration
     form one feature to another ,  we can simply copy and paste the step declaration from one
 feature to another along with the new step. and create step definition class only  for the new one which included in the feature.
 Because all other old steps which are already linked to other class.*/

    //note:when we copy the feature steps, we are  not only copying  the declaration, we are copying step definition also .

    @Then("user verify dashboard page")
    public void user_verify_dashboard_page() {
        System.out.println("Batch 14 is happy now");
    }

    @Then("user verify all the dashboard tabs")
    public void user_verify_all_the_dashboard_tabs(DataTable dataTable) {
        List<String> expectedTabs = dataTable.asList();  /*we are getting the data in list because the  data is coming from feature file carry only the value
       this dataTable contains all the dta from feature files  and we have to confirm the data comes as what. in this scenario the data comes asList.(.asList())*/


        List<String> actualTabs = new ArrayList<>(); /*created this list , to compare the expected  output to actual output for the verification. note we created this as Arraylist.
        because we are just retrieve the data what ever available inside this list(actualTabs) and comparing with expectedTabs.*/

        for (WebElement ele :dashboard.dashboardTabs)//using this loop to retrieve the webelement from dashboard page.
         {
            actualTabs.add(ele.getText());// using this add method to get the text from dashboardTabs and store into actualTabs.
        }

        //printing the text for both feature file and from application, just for our understanding  we are using sout
        System.out.println(expectedTabs);// note: this expectedTabs list comes from feature file
        System.out.println(actualTabs);// and this actualTabs list comes from DashboardPage class. and  we are comparing these both list with the help of Assert for the verification.

        //.equals is the method we use to compare 2 lists together
        //assertTrue is a boolean condition which returns true if condition is satisfy
       // Assert.assertTrue(expectedTabs.equals(actualTabs));
       Assert.assertEquals(expectedTabs,actualTabs); //note both Assert will provide the same output, only the way of approach is different(one is assertTrue & assertEuals)
    }
}
