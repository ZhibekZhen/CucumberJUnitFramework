package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.List;

public class DatatableSteps {

    @Given("the following clininc departments exist:")
    public void the_following_clininc_departments_exist(io.cucumber.datatable.DataTable dataTable) {
        List<String> departments = dataTable.asList();
        for (int i = 0; i < departments.size(); i++) {
            System.out.println(departments.get(i));
        }
    }

    @When("patient selects {string} in each department")
    public void patient_selects_in_each_department(String string, io.cucumber.datatable.DataTable dataTable) {

    }

    @When("patient selects {int} appointments or doctor {string} at hospital {string}")
    public void patient_selects_appointments_or_doctor_at_hospital(Integer int1, String string, String string2) {

    }
    @When("patient selects guests list")
    public void patient_selects_guests_list(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> data = dataTable.asLists();

        for (List<String> patientInfo : data){
            for (String str : patientInfo){
                System.out.println(str);
            }
        }


    }
}