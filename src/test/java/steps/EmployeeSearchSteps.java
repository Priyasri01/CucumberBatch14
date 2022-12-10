package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.ConfigReader;

public class EmployeeSearchSteps extends CommonMethods {

    @When("user clicks on EmployeeList option")
    public void user_clicks_on_employee_list_option() {
        WebElement empListOption = driver.findElement(By.id("menu_pim_viewEmployeeList"));
        click(empListOption); //in here we are calling click()method from CommonMethod class
    }


    @When("user enter valid employee id")
    public void user_enter_valid_employee_id() {
        WebElement empIdField = driver.findElement(By.id("empsearch_id"));
        sendText(empIdField, "45154A"); //both will work line 22 & 23
        //sendText(empIdField, ConfigReader.getPropertyValue("empID")); // don't add empID Inside the config.properties , the main purpose of the config is for configuration
    }
    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        WebElement searchButton = driver.findElement(By.id("searchBtn"));
        click(searchButton);//in here we are calling click()method from CommonMethod class
    }
    @Then("user see employee information is displayed")
    public void user_see_employee_information_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Employee information can be seen");
    }
    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() {
        WebElement searchNameField = driver.findElement(By.id("empsearch_employee_name_empName"));
        sendText(searchNameField, "dawggy"); //in here we calling senText()method from CommonMethod class

    }
}
