package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPageProject;
import utils.BaseUI;
import utils.ConfigurationReader;
import utils.Driver;

public class LoginStepProject extends BaseUI {

        LoginPageProject loginPage = new LoginPageProject();

        @Given("user logs in with multiple valid credentials")
        public void successful_login() {
            Driver.getDriver().get(ConfigurationReader.getProperty("url"));
            loginPage.login();

        }

        @Given("user enters username {string} and password {string}")
        public void failed_login(String username, String password) {
            Driver.getDriver().get(ConfigurationReader.getProperty("url"));
            waitAndSendKeys(loginPage.loginInput, username);
            waitAndSendKeys(loginPage.passwordInput,password);
            waitAndClick(loginPage.signInButton);
        }
        @Then("verify user stays in login page")
        public void verify_user_stays_in_login_page() {
            Assertions.assertTrue(Driver.getDriver().getCurrentUrl().contains("login"));
            Driver.quitDriver();
        }
        public void LoginPageProject(){
            PageFactory.initElements(Driver.getDriver(), this);
        }
    }

