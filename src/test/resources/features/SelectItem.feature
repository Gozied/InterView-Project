Feature: Select Item
  Background: repeat for both scenarios
    Given  i navigate to  home page
    And i Mouse over Women Menu to reveal options
    When i click summer dresses

  Scenario: As a user i want to select summer dress from
    Navigation Menu
    Then i should only see summer dresses in catalogue

    Scenario: As a user i want to select item by price range
   And i drag slider to set price range to $16-20$
      Then Returned items are within the above price range