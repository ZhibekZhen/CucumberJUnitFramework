@login
Feature: verify user is able to log in

  @successfulLogin
  Scenario: Successful login
    Given user is on login page
    When user enters valid username and password
    And user clicks login button
    Then user should see dashboard


  @failedLogin
  Scenario Outline: failed login
    Given user enters username "<username>" and password "<password>"
    Then verify user stays in login page
    Examples:
      | username                 | password   |
      | testuser1@vaultbank.test | Test2Pass! |
      | testuser1@vaultbank.test |            |
      |                          | Test1Pass! |
      |                          |            |
      | abc                      | efd        |