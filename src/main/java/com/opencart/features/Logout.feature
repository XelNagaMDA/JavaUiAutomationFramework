Feature: Logout flow Test Suite

  Scenario: User is logged out from the account
    Given "/index.php?route=account/login&language=en-gb" is accessed
    And "dennis.johnston@hotmail.com" data is entered in the username input
    And "zvgdcge85s1" data is entered into the password field
    And the Login button is clicked
    When User navigates to MyAccount button from Header menu
    And the Logout button is clicked
    Then the current url  contains "/index.php?route=account/logout" keyword
