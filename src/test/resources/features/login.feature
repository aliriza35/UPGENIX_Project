Feature: Upgenix app login feature

  Background: For the scenarios in the feature file, user is expected to be on the login page
    Given user is on the login page

  Scenario: Login as SalesManager
    When user enters username "salesmanager11@info.com"
    And  user enters password "salesmanager"
    And  user clicks login button
    Then user should login homepage successfully

  Scenario: Login with valid username-invalid password
    When user enters username "salesmanager11@info.com"
    And  user enters invalid password "posmanager"
    And  user clicks login button
    Then wrong login or password should be displayed

  Scenario: Login with invalid username-valid password
    When user enters invalid username "posmanager@info.com"
    And  user enters password "salesmanager"
    And  user clicks login button
    Then wrong login or password should be displayed

  Scenario: Password or username is empty
    When user clicks login button
    Then Please fill out this field message should display

  Scenario: User should see the password in bullet signs
    When user enters username "salesmanager11@info.com"
    And  user enters password "salesmanager"
    Then user should see the password in bullet signs

  Scenario: Enter key of the keyboard should be working
    When user enters username "salesmanager11@info.com"
    And  user enters password "salesmanager"
    And  user presses the Enter key
    Then user should login homepage successfully
