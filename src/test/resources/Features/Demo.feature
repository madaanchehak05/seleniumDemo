Feature: Adding item in YoKart website

  @demo
  Scenario Outline: Adding item in YoKart website
    Given launch "YoKart" application
    When user click on "Sign In" button
    Then verify user is logged in
    And Navigate to Product Catalog
    And Search "<product>"
#    And verify "Laptop" is present
    Examples:
    |product|
    | product1 |
    | product2 |

