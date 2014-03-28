Feature: Add  order
  In order to add new order
  As a customer
  I want to add a order with needed information

  Scenario Outline: Add information  of order successfully
    Given I am on order list screen of <Customer>
    And I select add new order
    Then I am on Add Order Screen

    When I input 'order_code' as '00111'
    And I input 'amount' as '20000'
    And I decide to Save this equipment
    Then I should see new equipment with <Field> is <Value>
  Examples:
    | Customer |
    | Tim      |

  Scenario Outline: Add information  of order unsuccessfully
    Given I am on order list screen of <Customer>
    And I select add new order
    Then I am on Add Order Screen

    And I input 'amount' as '20000'
    And I decide to Save this equipment
    Then I should see the error message "order code must not null, please try again"
  Examples:
    | Customer |
    | Tim      |

  Scenario Outline: Add information  of order unsuccessfully
    Given I am on order list screen of <Customer>
    And I select add new order
    Then I am on Add Order Screen

    When I input 'order_code' as '00111'
    And I decide to Save this equipment
    Then I should see the error message "amount must not null, please try again"
  Examples:
    | Customer |
    | Tim      |