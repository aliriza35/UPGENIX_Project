@sales
  Feature: Upgenix app sales functionality feature

    Background: For the scenarios in the sales feature file, user has logged in
      Given user has logged in

    Scenario: User can reach new customer form
      When user click the sales button
      And user click the customers button
      Then user click the create button

    Scenario: Verify that if customer name field leaves blank, an error message is appeared
      Given user is on the new customer form page
      When user doesn't type anything into name box and click the save button
      Then user should see an error message

    Scenario: Verify that after creating a new customer, the page title includes the customer name
      Given user is on the new customer form page
      When user
