package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BaseUI;
import utils.Driver;

import java.util.List;

import static utils.Driver.driver;

public class patientsPage extends BaseUI {

    public patientsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

     public static final String URL = "https://codewise-clinic-portal.lovable.app/patients";
    @FindBy(xpath = "//a[text()='Patient']")
    public WebElement patientButton;

    @FindBy(xpath = "//button[@data-testid='filter-gender']")
    public static WebElement genderDropdown;

    @FindBy(xpath = "//span[text()='Female']")
    public WebElement femaleOption;

    @FindBy(xpath = "//span[text()='Male']")
    public WebElement maleOption;

    @FindBy(xpath = "//span[text()='Others']")
    public WebElement Others;

    @FindBy(xpath = "//tbody[@class='[&_tr:last-child]:border-0']//tr/td[3]")
    public List<WebElement> patientList;

    public static void selectGender(String gender){
        waitAndClick(genderDropdown);
        waitAndClick(Driver.getDriver().findElement(By.xpath("//span[text()='" + gender + "']")));

    }
    @FindBy (xpath = "//button[text()=' New Patient']")
    public static WebElement newPatientButton;

    @FindBy (id = "first_name")
    public static WebElement firstNameInput;

    @FindBy (id = "last_name")
    public static WebElement lastNameInput;

    @FindBy (id = "dob")
    public static WebElement dobInput;

    @FindBy (id = "phone")
    public static WebElement phoneInput;

    @FindBy (xpath = "//button[text()='Create Patient']")
    public static WebElement createPatientButton;

    @FindBy (css = "input[data-testid='patients-search']")
    public static WebElement searchPatientInput;

    public static boolean isNamePresentInTable(String name){
        explicitWait(5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table//td[text()='" + name + "'])[1]")));
        return driver.findElement(By.xpath("(//table//td[text()='" + name + "'])[1]")).getText().contains(name);
    }
}
