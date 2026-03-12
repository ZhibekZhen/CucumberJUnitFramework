package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage;
import pages.ProfilePages;
import utils.Driver;
import utils.ConfigurationReader;

public class ProfileSteps {
    LoginPage loginPage = new LoginPage();
    ProfilePages profilePage = new ProfilePages();

    @Given("user logs in")
    public void user_logs_in() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        loginPage.email.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginButton.click();
    }

    @When("user clicks profile settings")
    public void user_clicks_profile_settings() {

        ProfilePages.profileSettings.click();
    }

    @When("user clicks sign in security")
    public void user_clicks_sign_in_security() {

        profilePage.signInSecurity.click();
    }

    @Then("change password button should be visible")
    public void change_password_button_should_be_visible() {

        Assertions.assertTrue(profilePage.changePassword.isDisplayed());
    }
}

