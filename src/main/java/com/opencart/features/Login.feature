@login
Feature: Login Flow Test Suite

  Scenario: User is logged in with valid credentials
    Given "/index.php?route=account/login&language=en-gb" is accessed
    And "dennis.johnston@hotmail.com" data is entered in the username input
    And "zvgdcge85s1" data is entered into the password field
    And the "loginButton" from "LoginPage" is clicked
    Then "/index.php?route=account/account" is accessed

  Scenario: Login with invalid credentials displays an error
    Given "/index.php?route=account/login&language=en-gb" is accessed
    When the Login form is populated with the following details:
      | dfsdfsdfs@gmail.com |
      | crtgrtgcrtgrc       |
    And the "loginButton" from "LoginPage" is clicked
    Then the following list of error messages is displayed:
      | No match for E-Mail Address and/or Password. |

  @login1
  Scenario Outline: User is logged in with valid credentials
    Given "/index.php?route=account/login&language=en-gb" is accessed
    When the following form from "LoginPage" is populated as follows:
      | emailInputField    | <username> |
      | passwordInputField | <password> |
    And the "loginButton" from "LoginPage" is clicked
    Then "/index.php?route=account/account" is accessed
    Examples:
      | username                    | password    |
      | qiana.hermann@hotmail.com   | 401sosd4l   |
      | dennis.johnston@hotmail.com | zvgdcge85s1 |
