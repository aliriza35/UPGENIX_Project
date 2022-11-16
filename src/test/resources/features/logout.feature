@logout
Feature: Upgenix app logout feature

  Background: For the scenarios in the logout feature file, user has logged in
    Given user has logged in

  Scenario: User can logout
    When user clicks the username at the top right of the page
    And user clicks the logout button
    Then user should see at the top left of the page the header is "Best solution for startups"

  Scenario: User can not go to the home page again by clicking the back button
    When user clicks the username at the top right of the page
    And user clicks the logout button
    And user navigates the back
    Then user should see "Odoo Session Expired" message

  Scenario: User must be logged out if the user closes the open tab
    When user opens new tab and closes the previous tab
    And user goes to Upgenix login page
    Then user should not see his or her username at the right of the page



