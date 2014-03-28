@customer_order
Feature: View customer's orders
  In order to view order list
  As a customer
  I want to view all my orders
  So that I can see how many order I made and how much money I spent

  Scenario: dummy

  Scenario : View customer orders
    Given I login successfully as 'Tim'
    Then I should see display name and number of orders
    And I should see order price of customer
      | order  |
      | Order1 |
      | Order2 |
      | Order3 |
