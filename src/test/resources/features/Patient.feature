@regression @many @smoke
Feature: patient page related test cases

  Background:
    Given user goes to sign in page
    And user enters username "nurse.garcia@mediflow.com"
    And user enters password "Test@1234"
    And user click on sign in button


    @newPatient
  Scenario Outline: verify user cam create a new patient
    When user navigates to Patients page
    And user clicks on New Patient button
    And user fills the form with following data
      | first name | <first name> |
      | last name  | <last name>  |
      | dob        | <dob>        |
      | gender     | <gender>     |
      | phone      | <phone>      |
    And user clicks on Create Patient button
    Then  verify new patient was created
    Examples:
      | first name | last name   | dob        | gender | phone     |
      | Donald     | Trump       | 12/15/1955 | Male   | 123456432 |
      | Anna       | Kim         | 11/23/1995 | Female | 234535643 |
      | Lena       | Smith       | 1/22/2011  | Female | 345325353 |
      | Askar      | Tentimishov | 2/12/2002  | Male   | 324532453 |






  @genderTest @smoke @otherTag
  Scenario: verify gender filter in patients list: female, male, and other
    And user navigates to Patients page
    When user selects gender verify  patients  displayed correct gender
      | Female |
      | Male   |
      | Other  |


    #  Scenario: verify gender filter in patients list: female, male, and other
#    And user navigates to Patients page
#    When user selects "Female" in All Gender dropdown
#    Then verify "Female" patients are displayed



