@login
Feature: Upgenix app login feature

 # @BRT-714
  Background: For the scenarios in the login feature file, user is expected to be on the login page
    Given user is on the login page

  @BRT-715
  Scenario: Login as SalesManager
    When user enters username "salesmanager11@info.com"
    And  user enters password "salesmanager"
    And  user clicks login button
    Then user should login homepage successfully

  @BRT-716
  Scenario: Login with valid username-invalid password
    When user enters username "salesmanager11@info.com"
    And  user enters invalid password "posmanager"
    And  user clicks login button
    Then wrong login or password should be displayed

  @BRT-717
  Scenario: Login with invalid username-valid password
    When user enters invalid username "posmanager@info.com"
    And  user enters password "salesmanager"
    And  user clicks login button
    Then wrong login or password should be displayed

  @BRT-718
  Scenario: Password or username is empty
    When user clicks login button
    Then Please fill out this field message should display

  @BRT-719
  Scenario: User should see the password in bullet signs
    When user enters username "salesmanager11@info.com"
    And  user enters password "salesmanager"
    Then user should see the password in bullet signs

  @BRT-720
  Scenario: Enter key of the keyboard should be working
    When user enters username "salesmanager11@info.com"
    And  user enters password "salesmanager"
    And  user presses the Enter key
    Then user should login homepage successfully
