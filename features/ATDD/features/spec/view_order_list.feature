Feature: View customer's orders
  In order to view order list
  As a customer
  I want to view all my orders
  So that I can see how many order I made and how much money I spent

  Scenario Outline: View customer orders
    Given I login successfully as <Customer>
    Then I should see display name and number of orders
    And I should see <Order> of customer <Customer>

  Examples:
    | Customer | Order |
    | Tim      | 0001  |
    | Tim      | 0002  |
    | Tim      | 0003  |
    | John     | 0004  |
    | John     | 0005  |
