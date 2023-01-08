package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class EmployeeListPage extends CommonMethods {

    @FindBy(id="empsearch_id")
    public WebElement empSearchIdField;

    @FindBy(id="empsearch_employee_name_empName")
    public WebElement empSearchNameField;

    @FindBy(id="searchBtn")
    public WebElement searchButton;

    @FindBy(xpath="//a[text()='33196337']") //this supposes to be on personal detail page, just for practice i put here
    public WebElement emp_id;

    @FindBy(xpath="//h1[text()='Personal Details']")
    public WebElement personalDetPageApper;

    @FindBy(xpath = "//h1[text()='Work Experience']")
    public WebElement qulificationpageApper;

    @FindBy(xpath="//a[text()='soccer']")
    public WebElement AddSkill;

    @FindBy(xpath = "//p[@id='actionSkill']/following-sibling::table/tbody/tr")
    public List<WebElement> skill_Table;

    public EmployeeListPage(){
        PageFactory.initElements(driver,this);
    }

}
