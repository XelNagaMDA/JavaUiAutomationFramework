Feature: Register Flow Test Suite

  Scenario: Register Page can be accessed from Home Page
    Given "/" is accessed
    When register link from Header menu is clicked
    Then the current url  contains "register" keyword

  Scenario: The Account Page Url is opened when the registration is successful
    Given "/index.php?route=account/register&language=en-gb" is accessed
    When the Register form is populated with valid random data
    And Continue button is clicked
    Then the current url  contains "route=account/success" keyword

  Scenario: User remains on Register Page when the Continue button is not clicked
    Given "/index.php?route=account/register&language=en-gb" is accessed
    When the Register form is populated with valid random data
    Then the current url  contains "route=account/register" keyword