Feature: Login Flow Test Suite

  Scenario: User is logged in with valid credentials
    Given "/index.php?route=account/login&language=en-gb" is accessed
    And "dennis.johnston@hotmail.com" data is entered in the username input
    And "zvgdcge85s1" data is entered into the password field
    And the Login button is clicked
    Then "/index.php?route=account/account" is accessed