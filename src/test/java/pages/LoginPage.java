package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {  // we can achieve this concept(POM) with the help of page factory

    @FindBy(xpath ="//input[@id='txtUsername']") // to create the object repository we have to use @find by
    public WebElement usernameTextField;

    @FindBy(id="txtPassword")
    public WebElement passwordTextField; //created variable name for this locator(id="txtPassword")

    @FindBy(xpath="//input[@id='btnLogin']")
    public WebElement loginButton;


    public LoginPage(){ //created this constructor to initialize all the element
        //call selenium page factory ,because all the above variables are created for locator. so we have to call this class to  initialize the variable
        PageFactory.initElements(driver, this); //this -->refers to current class obj, you can also call it as pointer

    }



    }

