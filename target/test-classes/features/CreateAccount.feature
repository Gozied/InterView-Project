Feature: Create Account
  Scenario: As a user i want to create account
    Successfully
    Given  i navigate to  home page
    And i click sign in
    And i type email address in other to register
    And i click create account button
    And i Enter Personal Information
    And i Enter Address and Contact details
    When i click register button to complete registration
    Then i verify account name to confirm Account has been created