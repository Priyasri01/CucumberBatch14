package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {

    @FindBy(id = "firstName") // creating separate class for each pages(like login page, dashboard page,and so on) and having their locators for all the web element. with the help of find by we are finding the locator and store in instance varaible . and by using the page factory we are intial  the instance varible.
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "middleName")
    public WebElement middleNameField;

    @FindBy(id = "photofile")
    public WebElement photograph;

    @FindBy(id = "chkLogin")
    public WebElement checkBox;

    @FindBy(id = "user_name")
    public WebElement createusernameField;

    @FindBy(id = "user_password")
    public WebElement createpasswordField;

    @FindBy(id = "re_password")
    public WebElement confirmpasswordField;

    @FindBy(id = "employeeId")
    public WebElement empIdLocator;

    @FindBy(id = "btnSave")
    public WebElement saveButton;

    public AddEmployeePage(){
        /*page factory is the concept of selenium which we use to implement page
    object model design patter which is responsible to initialize all the objects
      of the class. In here when we say objects we mean locators what we also call object repository
      if someone ask this to you in the interview you have to write the same thing */
        PageFactory.initElements(driver, this);
    }
}
