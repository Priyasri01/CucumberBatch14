package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class PersonalPage extends CommonMethods {

    @FindBy(id="btnSave") //--->input[id='btnSave']
    public WebElement Edit_BtnFeild;

    @FindBy(xpath="//input[@id='personal_txtEmpFirstName']") //--->//input[@id='personal_txtEmpFirstName']
    public WebElement firstNameField;

    @FindBy(id="personal_txtEmpMiddleName") //-->input[id='personal_txtEmpMiddleName']
    public WebElement middleNameField;

    @FindBy(id="personal_txtEmpLastName") //-->input[id='personal_txtEmpLastName']
    public WebElement lastNameField;

    @FindBy(id="personal_txtEmployeeId") //--->input[id='personal_txtEmployeeId']
    public WebElement emply_IDField;

    @FindBy(xpath="//input[@id='personal_txtOtherID']") //--->//input[@id='personal_txtOtherID']
    public WebElement other_IdField;

    @FindBy(xpath ="//input[@id='personal_txtLicenNo']" )     //--->//input[@id='personal_txtLicenNo']
    public WebElement driver_licNumField;

    @FindBy(id="personal_txtNICNo")  //--->input[id='personal_txtNICNo']
    public WebElement ssn_NumField;

    @FindBy(id="personal_txtSINNo") //--->input[id='personal_txtSINNo']
    public WebElement sin_NumField;

    @FindBy(id="personal_optGender_1") //--->input[id='personal_optGender_1']
    public WebElement malGender_BtnField;

    @FindBy(id="personal_optGender_2") //--->input[id='personal_optGender_2']
    public WebElement  femaleGender_BtnField;

    @FindBy(id="personal_txtEmpNickName") //-->input[id='personal_txtEmpNickName']
    public WebElement  nickName_Field;

    @FindBy(id="personal_chkSmokeFlag")     //--->input[id='personal_chkSmokeFlag']
    public WebElement smokerField;

    @FindBy(id="personal_txtMilitarySer") //--->input[id='personal_txtMilitarySer']
    public WebElement miltry_SerField;

    @FindBy(id="btnSave")  //--->input[id='btnSave']
    public WebElement sav_BtnField;

    //from line 53 to 71 all are for "Add Attachment" area
    @FindBy(id="btnAddAttachment") //--->input[id='btnAddAttachment']
    public WebElement add_BtnField;

    @FindBy(xpath="//input[@id='ufile']") //--->//input[@id='ufile']
    public WebElement choose_FileField;

    @FindBy(id="txtAttDesc") //--->textarea[id='txtAttDesc']
    public WebElement comment_Box;

    @FindBy(id="btnSaveAttachment") //--->input[id='btnSaveAttachment']
    public WebElement upload_Btn;

    @FindBy(id="cancelButton") //--->input[id="cancelButton"]
    public WebElement cancel_Btn;

    //all the below listed are link's locator's
    @FindBy(xpath="//a[text()='Personal Details']") //--->//a[text()='Personal Details']
    public WebElement personal_DetailsLink;

    @FindBy(xpath="//a[text()='Contact Details']") //--->//a[text()='Contact Details']
    public WebElement contact_DetailsLink;

    @FindBy(xpath="//a[text()='Emergency Contacts']") //--->//a[text()='Emergency Contacts']
    public WebElement emerg_ContactLink;

    @FindBy(xpath="//a[text()='Dependents']") //-->//a[text()='Dependents']
    public WebElement dependents_Link;

    @FindBy(xpath="//a[text()='Immigration']") //--->//a[text()='"Immigration']
    public WebElement immigration_Link;

    @FindBy(xpath="//a[contains(@href,'Job')]") //--->//a[text()='Job']
    public WebElement Job_Link;

    @FindBy(xpath ="//a[text()='Salary']" ) //--->////a[text()='Salary']
    public WebElement salary_Link;

    @FindBy(xpath="//a[text()='Tax Exemptions']") //--->//a[text()='Tax Exemptions']
    public WebElement tax_ExepLink;

    @FindBy(xpath="//a[text()='Report-to']") //--->//a[text()='Report-to']
    public WebElement report_toLink;

    @FindBy(xpath = "//a[contains(@href,'Qualifications')]")
    public WebElement qualificationsButton;

    @FindBy(xpath="//a[text()='Memberships']") //---//a[text()='Memberships']
    public WebElement memberships_Link;

    //Maritial Status drop down list
    @FindBy(xpath="//select[@id='personal_cmbMarital']") //--->//select[@id='personal_cmbMarital']
    public WebElement maritalStatus_DropDownList;

    //Nationality status drop down list
    @FindBy(xpath="//select[@id='personal_cmbNation']") //--->//select[@id='personal_cmbNation']
    public WebElement nationality_DropDownList;

    //First Calendar(License Expiry date)
    @FindBy(xpath="//input[@id='personal_txtLicExpDate']/following-sibling::img") //--->//input[@id='personal_txtLicExpDate']/following-sibling::img
    public WebElement licenseCalendar;

    @FindBy(xpath = "//select[@class='ui-datepicker-month']") //---->//select[@class='ui-datepicker-month']
    public WebElement listOfMonth;

    @FindBy(xpath = "//select[@class='ui-datepicker-year']") //---->//select[@class='ui-datepicker-year']
    public WebElement listOfYear;

    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody/tr/td") //----> //table[@class='ui-datepicker-calendar']/tbody/tr/td
    public List<WebElement> daysOfMonth;

    //second Calendar(Data of Brith)
    @FindBy(xpath="//input[@id='personal_DOB']/following-sibling::img")
    public WebElement dateOfBrith_Calender;

    @FindBy(xpath = "//h1[text()='Personal Details']")
    public WebElement personalDetailsText;

    public PersonalPage(){ //creating this constructor to intialize all the element
        //calling this Selenium PageFactory class, because all the above variables are created for locator's. so we have to call this class to initialize the variable
        PageFactory.initElements(driver,this); //this---> refer to the current class obj, we can also call it as pointer
    }

}
