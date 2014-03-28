@customer_order
Feature: Add  order
  In order to add new order
  As a customer
  I want to create new order

  Scenario: dummy

  Scenario Outline: Add information  of order successfully
    Given I am on order list screen of <Customer>
    And I select add new order
    Then I am on Add Order Screen

    When I input field 'order_code' as '00111'
    And I input field 'amount' as '20000'
    And I decide to Save this equipment
    Then I should see new order in my order list
  Examples:
    | Customer |
    | tim      |

  Scenario Outline: Add information  of order unsuccessfully
    Given I am on order list screen of <Customer>
    And I select add new order
    Then I am on Add Order Screen

    And I input 'amount' as '20000'
    And I decide to Save this equipment
    Then I should see the error message "order code must not null, please try again"
  Examples:
    | Customer |
    | tim      |

  Scenario Outline: Add information  of order unsuccessfully
    Given I am on order list screen of <Customer>
    And I select add new order
    Then I am on Add Order Screen

    When I input 'order_code' as '00111'
    And I decide to Save this equipment
    Then I should see the error message "amount must not null, please try again"
  Examples:
    | Customer |
    | tim      |