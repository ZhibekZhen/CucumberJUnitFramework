package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class ProfilePages {
    public ProfilePages(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="//a[text()='Profile & settings']")
    public static WebElement profileSettings;

    @FindBy(xpath="//a[text()='Sign-in & security']")
    public WebElement signInSecurity;

    @FindBy(xpath="//button[text()='Change Password']")
    public WebElement changePassword;
}

