Feature: Login Flow Test Suite

  Scenario: User is logged in with valid credentials
    Given "/index.php?route=account/login&language=en-gb" is accessed
    And "dennis.johnston@hotmail.com" data is entered in the username input
    And "zvgdcge85s1" data is entered into the password field
    And the Login button is clicked
    Then "/index.php?route=account/account" is accessed

  @run
  Scenario: Login with invalid credentials displays an error
    Given "/index.php?route=account/login&language=en-gb" is accessed
    When the Login form is populated with the following details:
      | dfsdfsdfs@gmail.com |
      | crtgrtgcrtgrc       |
    And the Login button is clicked
    Then the following list of error messages is displayed:
      | No match for E-Mail Address and/or Password. |
