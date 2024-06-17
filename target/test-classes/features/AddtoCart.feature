
@tag
Feature: Add an item to cart

  @smo
  Scenario: User add an item to cart   
    Given user launch applicaton url
    When user enter user name
    And user enter password
    And user clicks Login button
    Then item will be added to cart
    