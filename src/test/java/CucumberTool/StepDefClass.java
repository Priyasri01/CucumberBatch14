/*package CucumberTool;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StepDefClass {
    WebDriver driver;
    @Given("user is naviagated to HRMS application")
    public void user_is_naviagated_to_hrms_application() {
        WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().window().maximize();
    }

    @When("user enters valid username and valid password")
    public void user_enters_valid_username_and_valid_password() {
        WebElement userName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userName.sendKeys("admin");
//        password
        WebElement password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        password.sendKeys("Hum@nhrm123");

    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
       // login
        WebElement logIn = driver.findElement(By.xpath("//*[@id='btnLogin']"));
        logIn.click();
//        invalid credentials
    }

    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
      WebElement welcomlog  =driver.findElement(By.xpath("//a[@id='welcome']"));
      if(welcomlog.isDisplayed()){

          System.out.println("yes it's diplayed");
      }else{

          System.out.println("it's not displayed");
      }
    }

}
*/

