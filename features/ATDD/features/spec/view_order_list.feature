Feature: View customer's orders
  In order to view order list
  As a customer I want to see my orders

  Scenario Outline: View customer order
    Given I login successfully as <Customer>
    Then I should see display name and total price of <Customer>
    And I should see <Order> of customer <Customer>

  Examples:
    | Customer | Order |
    | Tim      | 0001  |
    | Tim      | 0002  |
    | Tim      | 0003  |
    | John     | 0004  |
    | John     | 0005  |
