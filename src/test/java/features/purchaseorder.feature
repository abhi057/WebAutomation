Feature: Place purchase order
  I want to use this template for my feature file

  Background: 
    Given I landed on homepage

  @tag1
  Scenario Outline: Submit order successfully
    Given user is logged in with <username> and <password>
    When user adds <product> to cart
    And checks out the added <product> and submits the order
    Then <confirmation> message is displayed

    Examples: 
      | username       | password   | product     | confirmation           |
      | abhi@yahoo.com | Qwerty@123 | ZARA COAT 3 | THANKYOU FOR THE ORDER |
      | abhi123@yahoo.com | Qwerty2323@123 | ZARA COAT 33 | THANKYOUerer FOR THE ORDER |
