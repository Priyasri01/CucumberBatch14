package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.ConfigReader;

import java.util.List;

public class AdminSteps extends CommonMethods {

    @When("admin user enters valid admin username and password")
    public void admin_user_enters_valid_admin_username_and_password() {
        sendText(login.usernameTextField,ConfigReader.getPropertyValue("username"));
        sendText(login.passwordTextField,ConfigReader.getPropertyValue("password"));
    }

    @When("admin user clicks on the login button")
    public void admin_user_clicks_on_the_login_button() {
        click(login.loginButton);
    }

    @Then("admin user is successfully logged in")
    public void admin_user_is_successfully_logged_in() {
        boolean welcom_msg =dashboard.welcomeMessage.isDisplayed();
        Assert.assertTrue(welcom_msg);
    }

    @When("admin user clicks on the Admin button")
    public void admin_user_clicks_on_the_admin_button() {
        click(adminPage.AdminOption);
    }

    @When("admin user clicks on the Qualifications list")
    public void admin_user_clicks_on_the_qualifications_list() {
       click(adminPage.QualificationsDropdown);

    }

    @When("admin user selected the License option  form the list")
    public void
    admin_user_selected_the_license_option_form_the_list() {
        click(adminPage.licenses);
    }
    @When("admin user should be able to verify they are on the {string} List Page")
    public void admin_user_should_be_able_to_verify_they_are_on_the_list_page(String string) {
        String act_result = adminPage.licensePage_Verify.getText();
        String exp_result = string;
        Assert.assertEquals(exp_result,act_result);
    }
    @When("admin user clicks on the add button")
    public void admin_user_clicks_on_the_add_button() {
       click(adminPage.license_AddBtn);
    }

    @When("admin user added the license in the Name feild {string}")
    public void admin_user_added_the_license_in_the_name_feild(String string) {
       sendText(adminPage.license_NameField,string);
    }

    @When("admin user clicks on the save button")
    public void admin_user_clicks_on_the_save_button() {
        click(adminPage.license_SaveBtn);
    }

    @Then("admin user added the  license and verify they added successfully")
    public void admin_user_added_the_license_and_verify_they_added_successfully() {
        List<WebElement> license_table =adminPage.license_Table;
        String expected_result= "Commercial Driver License";
        for(int i=0; i<license_table.size();i++){
            String actual_result = license_table.get(i).getText();
            if(actual_result.equalsIgnoreCase(expected_result)){

                WebElement check_Box = driver.findElement(By.xpath("//table/tbody/tr["+(i+1)+"]/td[1]"));
                check_Box.click();
                license_table.get(i).click();

            }
        }
    }

}
