package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class LoginPageProject1 {

        public LoginPageProject1(){
            PageFactory.initElements(Driver.getDriver(), this);
        }

        @FindBy(id="email")
        public WebElement email;

        @FindBy(id="password")
        public WebElement password;

        @FindBy(xpath="//button[text()='Login']")
        public WebElement loginButton;

    }

