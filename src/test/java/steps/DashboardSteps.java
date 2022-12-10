package steps;

import io.cucumber.java.en.Then;

public class DashboardSteps {

    /* note in Dashboard feature file  we have 5 steps from navigate hrms  to verify dashboard).
     but we have given definition  for only one tag in here because the speciality of cucumber(code re-usability) in case if you want use the same steps declaration
     form one feature to another ,  we can simply copy and paste the step declaration from one
 feature to another along with the new step. and create step definition class only  for the new one which included in the feature.
 Because all other old steps which are already linked to other class.*/

    //note: not only we are copy the declaration

    @Then("user verify dashboard page")
    public void user_verify_dashboard_page() {
        System.out.println("Batch 14 is happy now");
    }
}
