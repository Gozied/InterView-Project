Feature: Delete Basket
  Scenario: As a user i want to be able to delete item in basket
      Given  i navigate to  home page
      And i click sign in
      And i login successfully
      And i add a dress to my Shopping Cart
     And i confirm that Cart has a delete button
    When i delete dress from Shopping cart
    Then Banner should displays shopping cart is empty