package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class QualificationPage extends CommonMethods {

    @FindBy(xpath = "//a[contains(@href,'Qualifications')]")
    public WebElement qualificationsButton;

    @FindBy(id="addWorkExperience")
    public WebElement addWorkExperience;

    @FindBy(id="experience_employer")
    public WebElement companyName;

    @FindBy(id="experience_jobtitle")
    public WebElement jobTitle;

    @FindBy(id="experience_from_date")
    public WebElement experienceDateFrom;

    @FindBy(id="experience_to_date")
    public WebElement experienceDateTo;

    @FindBy(id="experience_comments")
    public WebElement experienceCommentField;

    @FindBy(id="btnWorkExpSave")
    public WebElement experienceSaveButton;

    @FindBy(id="addSkill")
    public WebElement addSkills;

    @FindBy(id="skill_code")
    public WebElement skillOptions;

    @FindBy(id="skill_years_of_exp")
    public WebElement skillExperienceYears;

    @FindBy(id="skill_comments")
    public WebElement skillComments;

    @FindBy(id="btnSkillSave")
    public WebElement skillSaveButton;

    @FindBy(id="addLanguage")
    public WebElement addLanguage;

    @FindBy(id="language_code")
    public WebElement languageOptions;

    @FindBy(xpath = "//select[@id='language_lang_type']")
    public WebElement fluencyOptions;

    @FindBy(xpath = "//select[@id='language_competency']")
    public WebElement competencyOptions;

    @FindBy(xpath ="//textarea[@name='language[comments]']" )
    public WebElement languageComments;

    @FindBy(xpath = "//input[@id='btnLanguageSave']")
    public WebElement languageSaveButton;

    @FindBy(xpath = "//input[@id='addLicense']")
    public WebElement addLicence;

    @FindBy(id="license_code")
    public WebElement licenseTypes;

    @FindBy(id="license_license_no")
    public WebElement licenseNumber;

    @FindBy(id="license_date")
    public WebElement licenseIssuedDate;

    @FindBy(id="license_renewal_date")
    public WebElement licenseExpiryDate;

    @FindBy(id="btnLicenseSave")
    public WebElement licenseSaveButton;

    @FindBy(xpath = "//p[@id='actionLicense']/following-sibling::table/tbody/tr")
    public List<WebElement> lincenseVerficationCheck;
    public QualificationPage() {
        PageFactory.initElements(driver,this);
    }

}
