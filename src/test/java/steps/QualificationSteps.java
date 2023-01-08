package steps;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.QualificationPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.util.List;

public class QualificationSteps extends CommonMethods {


    @When("user enters vali admin usernam and pass")
    public void user_enters_vali_admin_usernam_and_pass() {

        sendText(login.usernameTextField, ConfigReader.getPropertyValue("username" ));
        sendText(login.passwordTextField,ConfigReader.getPropertyValue("password"));
    }




    @When("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
       click(login.loginButton);
    }
    @When("user clicks on Pim tab from the directory menu")
    public void user_clicks_on_pim_tab_from_the_directory_menu() {
        click(dashboard.pimOption);
    }
    @When("user clicks on Employee list option from the PIM menu")
    public void user_clicks_on_employee_list_option_from_the_pim_menu() {
       click(dashboard.empListOption);
    }
    @When("user clicks on any employee {string}")
    public void user_clicks_on_any_employee(String id_Num) {
        boolean idFound=false;
        do{
            List<WebElement> colum_ID = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
            for(int i=0; i<colum_ID.size();i++){
                String id =colum_ID.get(i).getText();
                if(id.equalsIgnoreCase(id_Num)){

                   WebElement check_Box =driver.findElement(By.xpath("//table/tbody/tr["+(i+1)+"]/td[1]"));
                   check_Box.click();
                   colum_ID.get(i).click();
                   idFound=true;
                   break;
                }
            }
            if(!idFound){
                WebElement nxt_Btn = driver.findElement(By.xpath("//a[text()='Next']")); // to go next page
            }
        }while(!idFound);



    }

    @Then("user should be taken to the personal details page")
    public void user_should_be_taken_to_the_personal_details_page() {
       String expected_page= "Personal Details";
       String actual_page= employeeList.personalDetPageApper.getText();
        Assert.assertEquals(expected_page,actual_page);
    }
    @When("user clicks on Qualifications from the side menu")
    public void user_clicks_on_qualifications_from_the_side_menu() {
      click(qualification.qualificationsButton);
    }
    @Then("user should be able to verify they are on Qualification page")
    public void user_should_be_able_to_verify_they_are_on_qualification_page() {
        String exp_page="Work Experience";
        String act_page=employeeList.qulificationpageApper.getText();
        Assert.assertEquals(exp_page,act_page);
    }

    @When("user clicks on the Add button under the skills Category")
    public void user_clicks_on_the_add_button_under_the_skills_category() {
        click(qualification.addSkills);
    }


    @When("user  checks is the skill dropdown field is displayed or not and selected the skill option from the drop down list {string}")
    public void user_checks_is_the_skill_dropdown_field_is_displayed_or_not_and_selected_the_skill_option_from_the_drop_down_list(String string) {
        boolean skill_dropDisplayed =qualification.skillOptions.isDisplayed();
        Assert.assertTrue(skill_dropDisplayed);
        selectDropdown(qualification.skillOptions,string);
    }

    @When("user checks is the year of experience text-box field is displayed or not  and enters the years of experience on the experience field {string}")
    public void user_checks_is_the_year_of_experience_text_box_field_is_displayed_or_not_and_enters_the_years_of_experience_on_the_experience_field(String experience) {
        boolean experience_textBoxDisplayed = qualification.skillExperienceYears.isDisplayed();
        Assert.assertTrue(experience_textBoxDisplayed);
        sendText(qualification.skillExperienceYears,experience);
    }



    @When("user checks is the comments textbox field is displayed or not and  enter the feedback on the comments box")
    public void user_checks_is_the_comments_textbox_field_is_displayed_or_not_and_enter_the_feedback_on_the_comments_box() {
        boolean comment_box =qualification.skillComments.isDisplayed();
        Assert.assertTrue(comment_box);
        sendText(qualification.skillComments,"Excellent");
    }
    @When("user enter the save button")
    public void user_enter_the_save_button() {
        click(qualification.skillSaveButton);
    }

    @Then("user added employee skills successfully {string} and {string}")
    public void user_added_employee_skills_successfully_and(String empSkill, String experience) {
       List<WebElement> emply_Skill = driver.findElements(By.xpath("//p[@id='actionSkill']/following-sibling::table/tbody/tr"));
        String exp_res = empSkill + " " + experience; //reason i put this expected result outside is because
        String act_res=null;

        for(int i=0; i<emply_Skill.size();i++) {

          act_res = emply_Skill.get(i).getText();

        }
        Assert.assertEquals(exp_res,act_res);

    }

    @When("user clicks on the Add buttton under Add license Category")
    public void user_clicks_on_the_add_buttton_under_add_license_category() {
       click(qualification.addLicence);
    }



    @When("user selected the license type {string} from the License type")
    public void user_selected_the_license_type_from_the_license_type(String string) {
       handleDropdown(qualification.licenseTypes,string);
    }
    @When("user enters the license number {string}")
    public void user_enters_the_license_number(String string) {
        sendText(qualification.licenseNumber,string);
    }
    @When("user selected  license issues data and  expiry data from the calendar")
    public void user_selected_license_issues_data_and_expiry_data_from_the_calendar() {
        click(qualification.licenseIssuedDate);
       chooseDateFromCalendar(qualification.licenseIssuedDate,personalPage.listOfMonth,personalPage.listOfYear,personalPage.daysOfMonth,"Sep","2019","20");
       click(qualification.licenseExpiryDate);
        chooseDateFromCalendar(qualification.licenseIssuedDate,personalPage.listOfMonth,personalPage.listOfYear,personalPage.daysOfMonth,"Sep","2024","27");

    }
    @When("user clicks on the save button")
    public void user_clicks_on_the_save_button() {
       click(qualification.licenseSaveButton);
    }


    @Then("user added the employee License successfully {string} , {string} and {string}")
    public void user_added_the_employee_license_successfully_and(String license_Type, String issued_Date, String expiry_date) {
        List<WebElement> license_table= qualification.lincenseVerficationCheck;
        String exp_result = license_Type + " " + issued_Date + " " + expiry_date;
        String act_result=null;
        for(int i=0; i<license_table.size();i++){

            act_result=license_table.get(i).getText();

        }
        Assert.assertEquals(exp_result,act_result);
    }
    }



