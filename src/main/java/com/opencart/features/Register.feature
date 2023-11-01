@run
Feature: Register Flow Test Suite

  Background:
    Given "/index.php?route=account/register&language=en-gb" is accessed

  Scenario: Register Page can be accessed from Home Page
    Given "/" is accessed
    When register link from Header menu is clicked
    Then the current url  contains "register" keyword

  Scenario: The Account Page Url is opened when the registration is successful
    When the Register form is populated with valid random data
    And Continue button is clicked
    Then the current url  contains "route=account/success" keyword

  Scenario: User remains on Register Page when the Continue button is not clicked
    When the Register form is populated with valid random data
    Then the current url  contains "route=account/register" keyword

  @run
  Scenario Outline: An error message is displayed when invalid <tested attribute> is used for Register flow
    When the Register form is populated with the following data:
      | firstName | <firstNameData> |
      | lastName  | <lastNameData>  |
      | email     | <emailData>     |
      | password  | <passwordData>  |
    And Continue button is clicked
    Then the following list of error messages is displayed:
      | <tested attribute> |
    Examples:
      | tested attribute | firstNameData                        | lastNameData                         | emailData | passwordData |
      | First Name       | 122333444455555666666777777788888888 | Random                               | Random    | Random       |
      | Last Name        | Victor                               | 122333444455555666666777777788888888 | Random    | Random       |