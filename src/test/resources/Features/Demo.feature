Feature: Adding item in YoKart website

  @demo
  Scenario Outline: Adding item in YoKart website
    Given launch "YoKart" application
    When user click on "Sign In"
    Then verify user is logged in
    And Navigate to Product Catalog
    And Search "<product>"
    Then user should be logout




#    And verify "Laptop" is present
#    When user selects the "Apple iPhone 14 Pro Max(256 GB) - Deep Purple" checkbox


    Examples:
    |product|
    | product1 |
    | product2 |

