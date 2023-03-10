Feature: Add Random Product
  The user can add any random products to the card from any category
  Scenario Outline: Add Random Product to cart from category
    Given the user in the home page
    When the user goes to "<category>" category
    And choose "<product>"
    And Add the product to Cart
    Then The "<product>" product displayed successfully in cart

    Examples:
    | category | product |
    | Phones | Nexus 6 |
    | Laptops | MacBook air |
    | Monitors | Apple monitor 24 |
