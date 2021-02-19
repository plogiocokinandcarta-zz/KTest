Feature: As a Customer when I search for Alexa,

  Scenario: I want to see if the third option on the second page is
  available for purchase and can be added to the cart.
    Given the user navigates to www.amazon.com
    And searches for "Alexa"
    And navigates to the second page
    And selects the third item
    Then the item is available for purchase