package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class AdminPage extends CommonMethods {

    @FindBy(xpath = "//b[text()='Admin']")
    public WebElement AdminOption;

    @FindBy(xpath = "//a[text()='Qualifications']")
    public WebElement QualificationsDropdown;

    //added these locators(line 17 to 21) for selecting the license from the Qualification drop down list for US15
    @FindBy(xpath = "//a[@id='menu_admin_viewLicenses']")
    public WebElement licenses;

    @FindBy(xpath = "//input[@id='btnAdd']")
    public WebElement license_AddBtn;
    @FindBy(xpath = "//input[@id='btnSave']")
    public WebElement license_SaveBtn;

    @FindBy(xpath = "//input[@id='license_name']")
    public WebElement license_NameField;

    @FindBy(xpath = "//h1[text()='Licenses']")
    public WebElement licensePage_Verify;
    @FindBy(xpath = "//a[text()='Memberships']")
    public WebElement MembershipOption;

    @FindBy(xpath = "//table/tbody/tr/td[2]")
    public List<WebElement> license_Table;


    public AdminPage() {
        PageFactory.initElements(driver, this);

    }
}