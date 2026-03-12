package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.patientsPage;
import utils.BaseUI;
import utils.Driver;

import java.util.List;
import java.util.Map;

public class PatientSteps extends BaseUI {

    WebDriver driver = Driver.getDriver();
    patientsPage patientPage = new patientsPage();


    @Given("user navigates to Patients page")
    public void user_navigates_to_patients_page() throws InterruptedException {
        Thread.sleep(1000);
        driver.navigate().to(patientsPage.URL);


    }

    @When("user selects {string} in All Gender dropdown")
    public void user_selects_in_all_gender_dropdown(String gender) {
        patientPage.selectGender(gender);

    }

    @Then("verify {string} patients are displayed")
    public void verify_patients_are_displayed(String gender) {
        for (WebElement actualGender : patientPage.patientList) {
            Assertions.assertTrue(actualGender.getText().equalsIgnoreCase(gender));
        }

    }

    @When("user selects gender verify  patients  displayed correct gender")
    public void user_selects_gender_verify_patients_displayed_correct_gender(DataTable dataTable) {
        List<String> genders = dataTable.asList();
        for (String gender : genders) {
            patientPage.selectGender(gender);
            for (WebElement actualGender : patientPage.patientList) {
                Assertions.assertTrue(actualGender.getText().equalsIgnoreCase(gender));
            }


        }


    }

    @When("user clicks on New Patient button")
    public void user_clicks_on() {
        waitAndClick(patientsPage.newPatientButton);
    }

    private Map<String, String> patientInfo;

    @When("user fills the form with following data")
    public void user_fills_the_form_with_following_data(io.cucumber.datatable.DataTable dataTable) {
        this.patientInfo = dataTable.asMap(String.class, String.class);

        waitAndSendKeys(patientsPage.firstNameInput, patientInfo.get("firstName"));
        waitAndSendKeys(patientsPage.lastNameInput, patientInfo.get("lastName"));
        waitAndSendKeys(patientsPage.dobInput, patientInfo.get("dob"));
        patientsPage.selectGender(patientInfo.get("gender"));
        waitAndSendKeys(patientsPage.phoneInput, patientInfo.get("phone"));
    }
    @When("user clicks on Create Patient button")
    public void user_clicks_on_create_patient_button() {
        waitAndClick(patientsPage.createPatientButton);
    }
    @Then("verify new patient was created")
    public void verify_new_patient_was_created() throws InterruptedException {
        String firstName = this.patientInfo.get("firstName");

        Thread.sleep(2000);
        waitAndSendKeys(patientsPage.searchPatientInput, firstName);

        Assertions.assertTrue(patientsPage.isNamePresentInTable(firstName));
    }

        }





